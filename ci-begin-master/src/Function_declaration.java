public class Function_declaration {
    static void print(String message) {
        System.out.println("Message: " + message);
    }

    static void print(int number) {
        System.out.println("Number: " + number);
    }

    public static void main(String[] args) {
        String message = "Hello world";
        int x = 1;
        print(message);
        print(x);
    }
}
