package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Vector2D;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    public int hp;

    public Player(){
        this.position.set(180,500);
        this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        hitBox = new BoxCollider(this, 40, 48);
        hp = 1000;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            this.deactive();
        }
    }

    
    int count = 0;
    @Override
    public void run() {
        this.move();
        this.limitPosition();
        this.fire();
        //System.out.println(objects.size());
    }


    private void fire() {
        count++;
        if(KeyEventPress.isFirePress && count > 19) {
            //PlayerBullet bullet = new PlayerBullet();
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(Math.toRadians(-90));

            PlayerBullet bullet2 = GameObject.recycle(PlayerBullet.class);
            bullet2.position.set(this.position.x-10, this.position.y);
            bullet2.velocity.setAngle(Math.toRadians(-135));

            PlayerBullet bullet3 = GameObject.recycle(PlayerBullet.class);
            bullet3.position.set(this.position.x+10, this.position.y);
            bullet3.velocity.setAngle(Math.toRadians(-45));
            count = 0;
        }
    }

    private void limitPosition() {
        this.position.x = Mathx.clamp(this.position.x, -5, 359);
        this.position.y = Mathx.clamp(this.position.y, 0, 552);
    }

    private void move() {
        if (KeyEventPress.isUpPress) {
            this.position.y--;
        }
        if (KeyEventPress.isLeftPress) {
            this.position.x--;
        }
        if (KeyEventPress.isDownPress) {
            this.position.y++;
        }
        if (KeyEventPress.isRightPress) {
            this.position.x++;
        }
    }
}
