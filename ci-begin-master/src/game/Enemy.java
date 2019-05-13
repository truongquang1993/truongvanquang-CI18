package game;

import tklibs.SpriteUtils;

public class Enemy extends GameObject{
    public Enemy(){
        this.position.set(180,150);
        this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\enemies\\level0\\blue\\0.png");
    }


    @Override
    public void run(){
        this.move();
    }
    double count1 = 0;
    private void move() {
        this.position.x = 180 + 80*Math.sin(count1/6);
        this.position.y = 200 + 50*Math.cos(count1/6);
    }
}
