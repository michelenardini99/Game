package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    
    private final static int width = 566;

    private final static int height = 538;
    
    public static BufferedImage  cannon, arrow, background, wall;
    public static BufferedImage[] redDisappear, ballGroup;
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite_bobble_red.png"));
        redDisappear = new BufferedImage[5];
        redDisappear[0]=sheet.crop(width*2, 0, width, height);
        redDisappear[1]=sheet.crop(width*2, height, width, height);
        redDisappear[2]=sheet.crop(width, height, width, height);
        redDisappear[3]=sheet.crop(width*2, height*2, width, height);
        redDisappear[4]=sheet.crop(width, height*3, width, height);
        cannon=ImageLoader.loadImage("/textures/cannon.png");
        arrow=ImageLoader.loadImage("/textures/freccia.png");
        wall=ImageLoader.loadImage("/textures/Wall.png");
        background=ImageLoader.loadImage("/textures/dark_background.jpg");
        ballGroup = new BufferedImage[4];
        ballGroup[0] = ImageLoader.loadImage("/textures/staticRedBall.png");
        ballGroup[1] = ImageLoader.loadImage("/textures/staticBlueBall.png");
        ballGroup[2] = ImageLoader.loadImage("/textures/staticGreenBall.png");
        ballGroup[3] = ImageLoader.loadImage("/textures/staticYellowBall.png");
    }

}
