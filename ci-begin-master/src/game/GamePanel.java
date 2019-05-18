package game;

import game.enemy.Enemy;
import game.enemy.EnemySummoner;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    //Enemy enemy;



    public GamePanel() {
        this.background = new Background();
        this.player = new Player();
        EnemySummoner es = new EnemySummoner();
//        this.background.position.set(0,-2509);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i < GameObject.objects.size(); i++){
           GameObject object = GameObject.objects.get(i);
           if(object.active){
               object.render(g);
           }
        }
        // TODO: Continue editing
        g.setColor(Color.CYAN);
        g.fillRect(385,0,416,600);

    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis(); // Cái này tùy từng máy
            //long currentTime = System.nanoTime(); //Nếu là nano s thì là 10^9
            if (currentTime - lastTime > 1000/1001) {
                // run logic
                this.runAll();
            }
            //render
            this.repaint();
            lastTime = currentTime;
        }
    }
    public void runAll(){
        for(int i = 0; i < GameObject.objects.size(); i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.run();
            }
        }

    }
}
