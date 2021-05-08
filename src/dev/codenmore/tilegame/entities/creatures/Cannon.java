package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Assets;

public class Cannon extends Creature{
    
    private Game game;
    private Balls balls;
    private Ball ball;
    private boolean ballPos;
    private Random rand = new Random();
    
    private int angle=0;
    private int i=0;

    public Cannon(Game game, float x, float y, int width, int height, Balls b) {
        super(x, y, width, height);
        this.game=game;
        this.balls=b;
        this.setSpeed(5);
        this.ballPos=true;
        ball=new Ball(game,720,715,47,47,getColor());
        balls.addBall(ball);
    }
    
    public void tick() {
        getInput();
        shot();
        newBall();
    }
    
    public void newBall() {
       if(!ball.isMove && !ballPos) {
           ball=new Ball(game,720,715,47,47,getColor());
           balls.addBall(ball);
           i++;
           ballPos=true;
       }
    }
    
   private int getColor() {
       return rand.nextInt(4);
   }
    
    private void shot() {
        if(ballPos && game.getkeyManager().enter) {
            ball.directMove=(float) Math.toDegrees(Math.toRadians(angle-90));
            ball.direct();
            ball.isMove=true;
            ballPos=false;
        }
    }

    private void getInput() {
        if(game.getkeyManager().right && this.angle<60)
            angle += (int) speed;
        if(game.getkeyManager().left && this.angle>-60)
            angle += (int)-speed;
    }

    public void render(Graphics g) {
        AffineTransform at = AffineTransform.getTranslateInstance(709,673);
        at.rotate(Math.toRadians(angle),Assets.arrow.getWidth()/2,Assets.arrow.getHeight()/2);
        at.scale(1,1);
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(Assets.cannon,600,700, Assets.cannon.getWidth(), Assets.cannon.getHeight(), null);
        g2.drawImage(Assets.arrow, at, null);
    }

}
