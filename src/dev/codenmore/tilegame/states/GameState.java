package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.creatures.Ball;
import dev.codenmore.tilegame.entities.creatures.Balls;
import dev.codenmore.tilegame.entities.creatures.Cannon;
import dev.codenmore.tilegame.gfx.Assets;

public class GameState extends State{
    
    private Cannon cannon;
    private Balls balle;
    
    public GameState(Game game) {
        super(game);
        balle=new Balls();
        cannon=new Cannon(game, 500, 300, 100, 100, balle);
    }
    
    public void tick() {
        cannon.tick();
        balle.tick();
    }

    public void render(Graphics g) {
        cannon.render(g);
        balle.render(g);
    }

}
