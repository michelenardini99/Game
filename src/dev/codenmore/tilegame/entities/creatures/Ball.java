package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Assets;

public class Ball extends Creature{
    
    private Game game;
    public boolean isMove;
    public float directMove;
    private int color;

    public Ball(Game game, float x, float y, int width, int height, int color) {
        super(x, y, width, height);
        this.game=game;
        this.isMove=false;
        this.directMove=0;
        this.color=color;
    }


    public void tick() {
        if(isMove) {
            if(this.x < 500|| this.x > 950)
                this.xMove*=-1;
            move();
            destroy();
        }
    }
    
    public void direct() {
        this.setxMove(Math.cos(Math.toRadians(directMove))*this.speed);
        this.setyMove(Math.sin(Math.toRadians(directMove))*this.speed);
    }
    
    private void destroy() {
        if(this.y <= 0) {
            this.isMove=false;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.ballGroup[color], (int)x, (int)y, width, height, null);
    }

}
