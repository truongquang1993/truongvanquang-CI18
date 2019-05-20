package game.item;

import game.GameObject;
import game.Vector2D;
import game.enemy.Enemy;
import game.enemy.EnemyBullet;
import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;

public class Item extends GameObject {
    public int addHp;

    public Item(){
        this.position.set(388,-12);
        velocity.set(0,3);
        velocity.setAngle(Math.toRadians(135));
        //this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\enemies\\bullets\\yellow.png");
        renderer = new Renderer("D:\\CI18\\ci-begin-master\\assets\\images\\items");
        hitBox = new BoxCollider(this, 12, 12);
        addHp = 10;
    }

    @Override
    public void run() {
        super.run();// posotion.add(velocity.x, velocity.y);
        this.move();
        this.deactiveIfNeeded();
        this.checkPlayer();
    }


    private void checkPlayer(){
        Player player = GameObject.findIntersects(Player.class,hitBox);
        if(player != null){
            player.takeHp(addHp);
            this.deactive();
        }
    }

    private void deactiveIfNeeded() {
        if(position.y > 600){
            this.deactive();
        }
    }


    private void move() {
        if(this.onGoingRight() && this.outOfBoundRight()){
            this.reverseVelocityX();
        }
        if(this.onGoingLeft() && this.outOfBoundLeft()){
            this.reverseVelocityX();
        }
    }


    @Override
    public void reset(){
        super.reset();
        this.position.set(388,-12);
        velocity.set(0,3);
        velocity.setAngle(Math.toRadians(135));
        addHp = 10;
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
        return position.x > 384 - 12;
    }

    private boolean onGoingRight() {
        return velocity.x > 0;
    }

}
