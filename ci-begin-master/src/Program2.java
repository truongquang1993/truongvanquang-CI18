import java.util.Scanner;

/**
 * Created by huynq on 7/4/17.
 */
public class Program2 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        Human person1 = new Human(); //Da khoi tao

        Human person2 = new Human("Quang", 26, "male");
        person1.eat();
        person2.eat();
    }
}
