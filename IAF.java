package IAF;
import robocode.*;
import java.awt.Color;


// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Space - a robot by (your name here)
 */
public class IAF extends AdvancedRobot
{
    boolean movingForward;
	int direcao = 1;

    /**
     */
    public void run() {
   	 
   	 while(true) {
   		 // loop fugir e sobreviver
   		 setAhead(40000);  // anda para frente distancia grande
   		 movingForward = true; 
   		 setTurnRight(80); // gira p direita e espera terminar o giro
   		 waitFor(new TurnCompleteCondition(this));
   		 setTurnLeft(90); //  gira p esquerda
   		 turnGunRight(90); // gira canhão
   		 waitFor(new TurnCompleteCondition(this)); 
   		 setTurnRight(90); // gira p direita
   		 turnGunRight(90); // canhao gira
   		 
   	 }
    	}
	
	public void onScannedRobot(ScannedRobotEvent e) { // ver inimigo 
    // gira perpendicular ao inimigo (90°)
    setTurnRight(e.getBearing() + 90);  // anda lateralmente (strafe)
    setAhead(120 * direcao);

    // troca direção aleatória
    if (Math.random() > 0.85) {
        direcao *= -1;
    } // fecha onscanner
} // fecha classe
}
 
   public void onHitWall(HitWallEvent e) { //quando bate na parede
   
   	 // 
   	 reverseDirection();
    }    
   	 public void reverseDirection() { // trocar de direçao o robo
   	   if (movingForward) {
        setBack(3000);
        setTurnRight(Math.random() > 0.5 ? 30 : -30);
        movingForward = false;
    } else {
        setAhead(3000);
        movingForward = true;
    }
}
   	 public void onHitRobot(HitRobotEvent e) { // quando bate em outro robo - girar e fugir  
       if (e.isMyFault()) {
        setTurnRight(90);
        reverseDirection();
    }
}