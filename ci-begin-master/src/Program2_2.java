import java.util.Scanner;

/**
 * Created by huynq on 7/4/17.
 */
public class Program2_2 {
    public static double[] equation2(double a, double b, double c) {
        double[] result = new double[2];
        if (a == 0) {
            if (b == 0) {
                result = null;
            } else {
                result[0] = -c / b;
                result[1] = -c / b;
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                result = null;
            } else {
                result[0] = (-b + Math.sqrt(delta)) / (2 * a);
                result[1] = (-b - Math.sqrt(delta)) / (2 * a);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a: ");
        double[] result = equation2(0, 2, 1);
        if (result == null) {
            System.out.println("Can not resolve equation!");
        } else {
            System.out.println("x1: " + result[0] + ", x2: " + result[1]);
        }
//        System.out.println(result[0] + " " + result[1]);
//        int x = 1;
//        if (x >1) {
//            System.out.println("x > 1");
//        }

    }
}
