package IAF;
import robocode.*;
import java.awt.geom.Point2D;
import robocode.util.Utils;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * SudoKill - a robot by (Fabliny, Alyne e Isabelle)
 */
public class SudoKill extends AdvancedRobot
{
	//distância máxima para atirar
    final double DISTANCIA_MAXIMA_TIRO = 300;

    //alvo atual
    String alvoAtual = null;

    //distância do alvo atual
    double distanciaAlvo = Double.MAX_VALUE;

	/**
	 * run: SudoKill's default behavior
	 */
	public void run() {
		// Customização de cores
		setBodyColor(Color.red); // Corpo
		setGunColor(Color.black); // Arma
		setRadarColor(Color.black); // Radar
		setScanColor(Color.red); // Scanner localizado
		setBulletColor(Color.orange); // Bala
		
		// Desacopla o movimento do radar e da arma (permite girar os 3 de forma independente)
		setAdjustRadarForRobotTurn(true);
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		
		while(true) {
			movimentacaoPadrao();
			escanearInimigo();
			// O execute() limpa a fila de comandos a cada turno do jogo
			execute();
		}
	}
	
	// MOVIMENTAÇÃO (ALYNE)
	// TODO: IMPLEMENTAR
	private void movimentacaoPadrao() {
		// Exemplo provisório:
		setAhead(100);
		setTurnRadarRight(360); // Mantém o radar girando para procurar inimigos
	}
	
	/**
     * Evento disparado quando o radar encontra um robô inimigo
     */
	public void onScannedRobot(ScannedRobotEvent e) {
        //decide se troca alvo
        escolherAlvo(e);

        //ignora inimigos que não são o alvo atual
        if (!e.getName().equals(alvoAtual)) {
            return;
        }

        //segue o alvo atual 
        seguirAlvo(e);

        //trava radar no inimigo
        travarRadar(e);

        //verifica se deve atirar
        if (!deveAtirar(e)) {
            return;
        }

        //calcula força da bala
        double poder = calcularPoderBala(e);

        //usa mira preditiva
        miraPreditiva(e, poder);
	}

	/**
     * Evento disparado quando o seu robô leva um tiro
     */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
     * Evento disparado quando o seu robô bate na parede
     */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}

	//ATACAR (ISABELLE)
    /*
    ESCOLHA DE ALVO. (ISABELLE)
    */
    public void escolherAlvo(ScannedRobotEvent e) {

        double distancia = e.getDistance();

        //sem alvo atual
        if (alvoAtual == null) {
            //pega o nome do alvo atual
            alvoAtual = e.getName();
            //distancia do alvo atual é a distância do robo escaneado
            distanciaAlvo = distancia;

            return;
        }

        //atualiza distância do alvo atual
        if (e.getName().equals(alvoAtual)) {
            //distancia do alvo atual é a distância do robo escaneado
            distanciaAlvo = distancia;

            return;
        }

        //troca de alvo se o novo inimigo for MUITO mais perto
        if (distancia < distanciaAlvo - 100) {

            alvoAtual = e.getName();
            distanciaAlvo = distancia;
        }
    }

    /*
    MIRA PREDITIVA. (ISABELLE)
    */
    public void miraPreditiva(ScannedRobotEvent e, double poder) {
        //velocidade da bala
        double velocidadeBala = 20 - (3 * poder);

        //posição do nosso robô
        double meuX = getX();
        double meuY = getY();

        //ângulo absoluto do inimigo
        double anguloAbsoluto = getHeadingRadians() + e.getBearingRadians();

        //posição atual do inimigo
        double inimigoX = meuX + Math.sin(anguloAbsoluto) * e.getDistance();

        double inimigoY = meuY + Math.cos(anguloAbsoluto) * e.getDistance();

        //movimento do inimigo
        double headingInimigo = e.getHeadingRadians();

        double velocidadeInimigo = e.getVelocity();

        //tempo que a bala demora
        double tempo = e.getDistance() / velocidadeBala;

        //posição futura prevista
        double futuroX = inimigoX + Math.sin(headingInimigo) * velocidadeInimigo * tempo;

        double futuroY = inimigoY + Math.cos(headingInimigo) * velocidadeInimigo * tempo;

        //impede mirar fora da arena
        futuroX = Math.max(18, Math.min(getBattleFieldWidth() - 18, futuroX)
        );

        futuroY = Math.max(18, Math.min(getBattleFieldHeight() - 18, futuroY)
        );

        //ângulo da mira
        double anguloCanhao = Math.atan2(futuroX - meuX, futuroY - meuY);

        //gira canhão
        setTurnGunRightRadians(Utils.normalRelativeAngle(anguloCanhao - getGunHeadingRadians()));

        //atira quando alinhado
        if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10) {
            fire(poder);
        }
    }

    /*
    DECIDE SE DEVE ATIRAR. (ISABELLE)
    */
    public boolean deveAtirar(ScannedRobotEvent e) {
        //atira tanto longe quanto perto caso seja um 1v1 
        if (e.getDistance() > DISTANCIA_MAXIMA_TIRO && getOthers() == 1) {
            return true;
        }

        //não atira se estiver longe
        if (e.getDistance() > DISTANCIA_MAXIMA_TIRO) {
            return false;
        }

        //não atira sem energia
        if (getEnergy() < 10) {
            return false;
        }
        //retorna verdadeiro para atirar
        return true;
    }

    /*
    CALCULA FORÇA DA BALA. (ISABELLE)
    */
    public double calcularPoderBala(ScannedRobotEvent e) {
        //distancia inimigo
        double distancia = e.getDistance();

        //se a distância for menor que 100. A potência da bala é a máxima do jogo
        if (distancia < 100) {
            return Rules.MAX_BULLET_POWER;
        }

        //se a distância for menor que 180. A potência da bala é 50% a máxima do jogo 
        if (distancia < 200) {
            return Rules.MAX_BULLET_POWER * 0.50;
        }
        //se a distância for maior que 180. A potência da bala é a minima do jogo
        return Rules.MIN_BULLET_POWER;
    }

    /*
    TRAVA O RADAR. (ISABELLE)
    */
    public void travarRadar(ScannedRobotEvent e) {
        //angulo absoluto = direção do nosso robô + ângulo entre nosso robô e o inimigo
        double anguloAbsoluto = getHeadingRadians() + e.getBearingRadians();
        //vira o nosso radar para a direita 
        setTurnRadarRightRadians(Utils.normalRelativeAngle(anguloAbsoluto - getRadarHeadingRadians()) * 2);
    }

    /*
    QUANDO ALVO MORRE. (ISABELLE)
    */
    public void onRobotDeath(RobotDeathEvent e) {
        //se o robô que escaneamos morrer, ele limpa o nome do alvo atual (null) e coloca a distância do alvo no máximo para acharmos outro algo.
        if (e.getName().equals(alvoAtual)) {

            alvoAtual = null;
            distanciaAlvo = Double.MAX_VALUE;
        }
    }

    /*
    PROCURA INIMIGOS. (ISABELLE)
    */
    public void escanearInimigo() {
        //vira o radar em 360
        turnRadarRight(360);
    }

    /*
    SEGUE O ALVO. (ISABELLE)
    */
    public void seguirAlvo(ScannedRobotEvent e) {
        // vira perpendicular ao inimigo
        setTurnRight(e.getBearing() + 90);

        // movimento constante
        setAhead(120);
    }
}
