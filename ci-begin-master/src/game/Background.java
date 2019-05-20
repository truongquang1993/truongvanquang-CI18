package game;

import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background(){
        position.set(0, 600 -3109);
        // image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\background\\0.png");
        renderer = new Renderer("D:\\CI18\\ci-begin-master\\assets\\images\\background\\0.png");
    }

    @Override
    public void run(){
        // BackGround Run
        this.position.y++;
        if (this.position.y > 0) {
            this.position.y = -2509;
        }
    }
}
