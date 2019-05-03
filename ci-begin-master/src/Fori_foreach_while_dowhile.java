public class Fori_foreach_while_dowhile {
    static void print(String message) {
        System.out.println("Message: " + message);
    }

    static void print(char c) {
        System.out.println("Character: " + c);
    }

    public static void main(String[] args) {
        String message = "Hello world";
        char[] characters = {'a', 'b', 'c'};
        int i = 0;

//        for(char i = 0; i < message.length(); i++) {
//            print(message.charAt(i));
//        }

//        for(char character : characters) {
//            print(character);
//        }
        while (i < message.length()) {
            print(message.charAt(i));
            i++;
        }
    }
}