import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround extends JPanel {
    BufferedImage backgroundImage;
    int backgroundX;
    int backgroundY;

    public BackGround() {
        backgroundImage = SpriteUtils.loadImage("D:\\CI18\\01 Bai 01\\ci-begin-master\\assets\\images\\background\\0.png");
        backgroundX = 50;
        backgroundY = -2509;
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        super.paint(g);
        g.drawImage(backgroundImage, backgroundX, backgroundY, null);
//        g.setColor(Color.ORANGE);
//        g.drawRect(100,100,200,200);
//        g.setColor(Color.green);
//        g.fillRect(400,100,200,200);
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis(); // Cái này tùy từng máy
//            long currentTime = System.nanoTime(); //Nếu là nano s thì là 10^9
            if (currentTime - lastTime > 1000 / 120) {
                // run logic
                backgroundY++;
                if (backgroundY > 0) {
                    backgroundY = -2509;
                }

                //render
                System.out.println(currentTime - lastTime);
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
}
