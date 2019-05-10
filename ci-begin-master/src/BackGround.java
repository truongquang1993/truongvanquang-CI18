import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage background;
    Vector2D position;

    public Background(){
        this.position = new Vector2D();
        this.background = SpriteUtils.loadImage("D:\\CI18\\ci-begin-master\\assets\\images\\background\\0.png");
    }

    public void render(Graphics g){
        g.drawImage(background, (int)this.position.x, (int)this.position.y, null);
    }

    public void run(){
        // BackGround Run
        this.position.y++;
        if (this.position.y > 0) {
            this.position.y = -2509;
        }
    }
}
