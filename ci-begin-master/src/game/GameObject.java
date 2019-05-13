package game;

import game.player.Player;
import game.player.PlayerBullet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject  {
    // quan li doi tuong (static)
    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static <E extends GameObject> E recycle(Class<E> cls) {
        // 1. tim phan tu bi deactive >> reset phan tu  >> tra ve
        // 2. neu khong tim thay phan tu deactive >> tao moi >> tra ve
        E object = findInactive(cls);
        if(object != null) {
            object.reset();
            return object;
        }
        try {
            object = cls.getConstructor().newInstance();
            return object;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static <E extends  GameObject> E findInactive(Class<E> cls){
        //cls ~ Player.class || //Background.class
        // E ~ Player || Background..
        for(int i = 0; i < objects.size(); i++){
            GameObject object = objects.get(i);
            // object ~ cls
            // object.active == false
            if(cls.isAssignableFrom(object.getClass()) && !object.active) {
                return (E)object;
            }
        }
        return null;
    }

    //Dinh nghia doi tuong
    public BufferedImage image;
    public Vector2D position;
    public boolean active;

    public GameObject(){
        objects.add(this);
        position = new Vector2D(); //(0,0)
        active = true;
    }

    public void render(Graphics g) {
        if(image != null) {
            g.drawImage(image, (int) position.x, (int) position.y, null);
        }
    }

    public void run() {
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }

}
