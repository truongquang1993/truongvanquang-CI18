package game.enemy;

import game.GameObject;
import game.Vector2D;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public int damage;

    public EnemyBullet(){
        this.position = new Vector2D();
        this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\enemies\\bullets\\yellow.png");
        this.velocity.set(0,2);
        hitBox = new BoxCollider(this, 16, 16);
        damage =1;
    }
    @Override
    public void run() {
        super.run();// posotion.add(velocity.x, velocity.y);
        this.deactiveIfNeeded();
        this.checkPlayer();
    }


    private void checkPlayer(){
        Player player = GameObject.findIntersects(Player.class,hitBox);
        if(player != null){
            player.takeDamage(damage);
            this.deactive();
        }
    }

    private void deactiveIfNeeded() {
        if(position.y > 600){
            this.deactive();
        }
    }

}
