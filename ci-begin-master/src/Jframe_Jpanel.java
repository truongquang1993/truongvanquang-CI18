import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Jframe_Jpanel {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setTitle("Game");
        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        window.add(panel);
        panel.setBackground(Color.CYAN);

//        tklibs.SpriteUtils.loadImage("D:\\C4E26\\Project C4E\\Flower.jpg");
//        tklibs.SpriteUtils.renderAtCenter();


    }

}
