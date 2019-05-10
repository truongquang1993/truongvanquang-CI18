import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    // Vector2D
    Player player;
    Background background;



    public GamePanel() {
        this.player = new Player();
        this.player.position.set(180,500);
        this.background = new Background();
        this.background.position.set(0,-2509);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.background.render(g);
        this.player.render(g);
//        for(PlayerBullet bullet: Player.playerBullets){
//            bullet.render(g);
//        }
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis(); // Cái này tùy từng máy
//            long currentTime = System.nanoTime(); //Nếu là nano s thì là 10^9
            if (currentTime - lastTime > 1000 / 600) {
                // run logic
                this.runAll();
            }
            //render
//            System.out.println(currentTime - lastTime);
            this.repaint();
            lastTime = currentTime;
        }
    }
    public void runAll(){
        //Player run
        // if (isUpPress)
        this.player.run();
        // BackGround Run
        this.background.run();
        // Collision

    }
}
