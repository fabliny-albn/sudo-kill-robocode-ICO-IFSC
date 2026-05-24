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
	/**
	 * run: SudoKill's default behavior
	 */
	public void run() {
		// Customização de cores
		setBodyColor(Color.black); // Corpo
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

	// TIROS E ATAQUES (ISABELLE)
	// TODO IMPLEMENTAR
	private void mirarEAtirar(ScannedRobotEvent e) {
	
		// Exemplo provisório:
		// 1. Calcula o ângulo absoluto do inimigo baseado na nossa posição atual
		double anguloInimigo = getHeading() + e.getBearing();
	}
	
	/**
     * Evento disparado quando o radar encontra um robô inimigo
     */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
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
}
