package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Vector2D;
import game.physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    public int hp;
    public boolean immune;

    public Player(){
        this.position.set(180,500);
        //this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        renderer = new Renderer("D:\\CI18\\ci-begin-master\\assets\\images\\players\\straight");
        hitBox = new BoxCollider(this, 40, 48);
        hp = 3;
        immune = false;
    }

    public void takeDamage(int damage) {
        if (!immune) {
            hp -= damage;
            if (hp <= 0) {
                hp = 0;
                this.deactive();
            } else {
                // Roi vao trang thai bat tu
                immune = true;
            }
        }
    }

    public void takeHp (int addHp){
        hp += addHp;
    }

    int immuneCount = 0;
    private void checkImmune() {
        if(immune){
            immuneCount++;
            if(immuneCount > 120) {
                immune = false;
            }
        } else {
            immuneCount = 0;
        }
    }

    int renderCount = 0;
    @Override
    public void render(Graphics g) {
        if(immune){
            renderCount++;
            if(renderCount % 3 == 0){
                super.render(g);
            }
        } else {
            super.render(g);
        }
    }

    int count = 0;
    @Override
    public void run() {
        this.move();
        this.limitPosition();
        this.fire();
        this.checkImmune();
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
            bullet2.velocity.setAngle(Math.toRadians(-115));

            PlayerBullet bullet3 = GameObject.recycle(PlayerBullet.class);
            bullet3.position.set(this.position.x+10, this.position.y);
            bullet3.velocity.setAngle(Math.toRadians(-65));
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
