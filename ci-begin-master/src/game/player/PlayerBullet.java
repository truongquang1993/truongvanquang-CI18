package game.player;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {

    public PlayerBullet(){
        this.position = new Vector2D();
        this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png");
    }

    @Override
    public void run() {
        this.position.y -= 2;
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(position.y < -30){
            this.deactive();
        }
    }
}
