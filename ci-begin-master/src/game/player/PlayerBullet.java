package game.player;

import game.GameObject;
import game.Vector2D;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    public int damage;

    public PlayerBullet(){
        this.position = new Vector2D();
        //this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png");
        renderer = new Renderer("D:\\CI18\\ci-begin-master\\assets\\images\\player-bullets\\a");
        this.velocity.set(0,-3);
        hitBox = new BoxCollider(this, 24, 24);
        damage =1;
    }



    @Override
    public void run() {
//        this.position.y -= 2;
        super.run();// posotion.add(velocity.x, velocity.y);
        this.deactiveIfNeeded();
        this.checkEnemy();
    }

    private void checkEnemy(){
        Enemy enemy = GameObject.findIntersects(Enemy.class,hitBox);
        if(enemy != null){
            //enemy.deactive();
            enemy.takeDamage(damage);
            this.deactive();
        }
    }

    private void deactiveIfNeeded() {
        if(position.y < -30){
            this.deactive();
        }
    }
}
