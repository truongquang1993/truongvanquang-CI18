import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet {
    public Vector2D position, position2, position3;
    public BufferedImage image, image2, image3;

    public PlayerBullet(){
        this.position = new Vector2D();
        this.position2 = new Vector2D();
        this.position3 = new Vector2D();
        this.image = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png");
        this.image2 = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png");
        this.image3 = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\player-bullets\\a\\2.png");

    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
        g.drawImage(this.image2, (int)this.position2.x, (int)this.position2.y, null);
        g.drawImage(this.image3, (int)this.position3.x, (int)this.position3.y, null);
    }

    public void run() {
        this.position.y -= 2;
        this.position2.y -= 2*Math.cos(0.436332313); //2*Math.cos(5/36*Math.PI)
        this.position2.x -= 2*Math.sin(0.436332313); //2*Math.sin(5/36*Math.PI)
        this.position3.y -= 2*Math.cos(0.436332313); //2*Math.cos(5/36*Math.PI)
        this.position3.x += 2*Math.sin(0.436332313); //2*Math.sin(5/36*Math.PI)
    }
}
