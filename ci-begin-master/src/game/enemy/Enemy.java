package game.enemy;

import game.GameObject;
import game.KeyEventPress;
import game.physics.BoxCollider;
import game.player.Player;
import game.player.PlayerBullet;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public int hp;
    public int damage;

    public Enemy(){
        this.position.set(0,-50);
        velocity.set(0,1.5);
        velocity.setAngle(Math.toRadians(25));
        this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\0.png");
        hitBox = new BoxCollider(this, 28, 28);
        hp = 3;
        damage = 2;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            this.deactive();
        }
    }

    private void checkPlayer(){
        Player player = GameObject.findIntersects(Player.class,hitBox);
        if(player != null){
            player.takeDamage(damage);
            this.deactive();
        }
    }

    @Override
    public void run(){
        super.run();
        if(this.onGoingRight() && this.outOfBoundRight()){
            this.reverseVelocityX();
        }
        if(this.onGoingLeft() && this.outOfBoundLeft()){
            this.reverseVelocityX();
        }
        this.deactiveIfNeeded();
        this.fire();
        this.checkPlayer();
    }

    int count = 0;
    private void fire() {
        count++;
        if(count > 60) {
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(Math.toRadians(90));
            count = 0;
        }
    }


    @Override
    public void reset(){
        super.reset();
        this.position.set(0,-50);
        velocity.set(0,1.5);
        velocity.setAngle(Math.toRadians(25));
        hp = 3;
    }

    private void deactiveIfNeeded() {
        if(position.y > 600){
            this.deactive();
        }
    }

    private boolean outOfBoundLeft() {
        return position.x <0;
    }

    private boolean onGoingLeft() {
        return velocity.x < 0;
    }

    private void reverseVelocityX() {
        velocity.x = -velocity.x;
    }

    private boolean outOfBoundRight() {
        return position.x > 384 - 32;
    }

    private boolean onGoingRight() {
        return velocity.x > 0;
    }

}
