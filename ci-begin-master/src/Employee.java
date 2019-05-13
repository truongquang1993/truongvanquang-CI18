import game.Vector2D;

import javax.management.ValueExp;
import java.util.ArrayList;

public class Employee {
    public static void main(String[] args){
        ArrayList<Vector2D> vectors = new ArrayList<>();
        // add(), remove(), size(), get()
        vectors.add(new Vector2D(1, 2));
        vectors.add(new Vector2D(3,5));
        vectors.add(new Vector2D(8,8));

        double maxTotal = 0;
        int indexMax = 0;
        for(int i =0; i < vectors.size(); i++){
            Vector2D vector = vectors.get(i);
            if(vector.x + vector.y >= maxTotal){
                maxTotal = vector.x + vector.y;
                indexMax = i;
            }
        }
        System.out.println(vectors.get(indexMax).x + " " + vectors.get(indexMax).y);

        for(Vector2D vector : vectors) {
            System.out.println(vector.x + " " + vector.y);
        }
    }
//    public static void doSomeThing() throws Exception {
//        int a = 1/0;
//    }
//    public static void doSomeThing() {
//        int a = 1/0;
//    }
//    try {
//        doSomeThing();
//    } catch (Exception ex){
//        ex.printStackTrace();
//    } finally {
//        System.out.println("");
//        }
//

    public static void doSomeThing(int input) throws Exception {
        if(input > 0) {
            System.out.println("Okay");
        } else if(input == 0){
            throw new Exception("Not okay");
        } else {
            System.out.println("okay");
        }
    }

}
