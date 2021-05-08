package dev.codenmore.tilegame;

import dev.codenmore.tilegame.gfx.Assets;

public class Launcher {

    public static void main(String[] args) {
        Game game=new Game("GameTest",853*2,480*2);
        game.start();
        
    }

}
