package game.item;

import game.GameObject;
import game.enemy.Enemy;

public class ItemSummoner extends GameObject {

    public ItemSummoner(){

    }

    int count = 0;
    @Override
    public void run(){
        count++;
        if (count >120){
            Item item = GameObject.recycle(Item.class);
            count = 0;
            System.out.println(GameObject.objects.size());
        }
    }
}
