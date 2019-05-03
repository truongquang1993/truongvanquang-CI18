public class If_else_Switch_case {
    static void print(String message) {
        System.out.println("Message: " + message);
    }

    static void print(int number) {
        System.out.println("Number: " + number);
    }

    public static void main(String[] args) {
        String message = "Hello world";
        int x = 1;

        if (x > 1) {
            print("x greater than 1");
        } else if (x == 1) {
            print("x equals 1");
        } else {
            print("x smaller than 1");
        }

    }
}