import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        window.setTitle("Game touhou");
//        window.setSize(800, 600);
        panel.setPreferredSize(new Dimension(800,600));
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = false;
                }
            }
        };
        window.addKeyListener(keyHandler);

        panel.setBackground(new Color(255, 255, 255));
        window.add(panel);
        window.pack();

        window.setVisible(true);
        panel.gameLoop();

    }
}
