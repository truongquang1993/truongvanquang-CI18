import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    public Vector2D position;
    public BufferedImage image;
    public static ArrayList<PlayerBullet> playerBullets = new ArrayList<>();

    public Player(){
        this.position = new Vector2D();
        this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
    }

    public void render(Graphics g) {

        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
        for (int i = 0; i < playerBullets.size(); i++){
            PlayerBullet bullet = playerBullets.get(i);
            bullet.render(g);
        }
    }
    int count = 0;
    public void run() {
        //Player shoot
//        this.shoot();

        //Player run
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
        // Gan max
        this.position.x = Mathx.clamp(this.position.x, -5, 359);
        this.position.y = Mathx.clamp(this.position.y, 0, 552);
        // playerBullets run()
        count++;
        if(KeyEventPress.isFirePress && count > 19) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            bullet.position2.set(this.position.x-10, this.position.y);
            bullet.position3.set(this.position.x+10, this.position.y);
            playerBullets.add(bullet);
            count = 0;
        }
        for(int i = 0; i < playerBullets.size(); i++){
            PlayerBullet bullet = playerBullets.get(i);
            bullet.run();
        }
    }

//    private void shoot() {
//        if(KeyEventPress.isFirePress){
//            PlayerBullet newBullet = new PlayerBullet();
//            Player.playerBullets.add(newBullet);
//            newBullet.position.set(this.position);
//        }
//    }
}
