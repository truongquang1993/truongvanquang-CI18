import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage playerImage;
    // Vector2D
    Vector2D playerPosition;
    BufferedImage bulletImage;
    Vector2D bulletPosition;
    BufferedImage backgroundImage;
    Vector2D backgroundPosition;
    static int countCollision;


    public GamePanel() {
        playerImage = SpriteUtils.loadImage("D:\\CI18\\01 Bai 01\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
//        playerX = 180;
//        playerY = 500;
        playerPosition = new Vector2D(180,500);
        bulletImage = SpriteUtils.loadImage("D:\\CI18\\01 Bai 01\\ci-begin-master\\assets\\images\\sphere-bullets\\0.png");
        bulletPosition = new Vector2D(180,100);
        backgroundImage = SpriteUtils.loadImage("D:\\CI18\\01 Bai 01\\ci-begin-master\\assets\\images\\background\\0.png");
        backgroundPosition = new Vector2D(0,-2509);
        countCollision = 0;
//        backgroundImage.getHeight();
//        backgroundImage.getWidth();
    }

    @Override
    public void paint(Graphics g) {
//        System.out.println("paint");
        super.paint(g);
        g.drawImage(backgroundImage, (int)backgroundPosition.x, (int)backgroundPosition.y, null);
        g.drawImage(playerImage, (int)playerPosition.x, (int)playerPosition.y, null);
        g.drawImage(bulletImage, (int)bulletPosition.x, (int)bulletPosition.y, null);
//        g.setColor(Color.ORANGE);
//        g.drawRect(100,100,200,200);
//        g.setColor(Color.green);
//        g.fillRect(400,100,200,200);
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
//            long currentTime = System.currentTimeMillis(); // Cái này tùy từng máy
            long currentTime = System.nanoTime(); //Nếu là nano s thì là 10^9
            if (currentTime - lastTime > 1000000000 / 60000) {
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
        if(KeyEventPress.isUpPress) {
            playerPosition.y--;
        }
        if(KeyEventPress.isLeftPress) {
            playerPosition.x--;
        }
        if(KeyEventPress.isDownPress) {
            playerPosition.y++;
        }
        if(KeyEventPress.isRightPress) {
            playerPosition.x++;
        }
        // Gan max
        playerPosition.x = Mathx.clamp(playerPosition.x, -5, 359);
        playerPosition.y = Mathx.clamp(playerPosition.y, 0, 552);
        // BackGround Run
        backgroundPosition.y++;
        if (backgroundPosition.y > 0) {
            backgroundPosition.y = -2509;
        }
        // Collision
        if(bulletPosition.x+24 >= playerPosition.x+8 && bulletPosition.x <= playerPosition.x+24 && bulletPosition.y+24 >=playerPosition.y+5 && bulletPosition.y <= playerPosition.y +8) {
            countCollision++;
            System.out.println(countCollision);
        }
    }
}
