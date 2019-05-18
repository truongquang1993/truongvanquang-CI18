public class GenericMethodTest {
    // generic method printArray
    public <T> void printArray(T[] inputArray) {
        // Display array elements
        for ( T element : inputArray ){
            System.out.print(element);
        }
        //System.out.println();
    }
    public static void main( String args[] ){
        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        // Create object
        GenericMethodTest gmt = new GenericMethodTest();
        System.out.println( "Array integerArray contains:" );
        gmt.printArray( intArray ); // pass an Integer array
        System.out.println( "\nArray doubleArray contains:" );
        gmt.printArray( doubleArray ); // pass a Double array
        System.out.println( "\nArray characterArray contains:" );
        gmt.printArray( charArray ); // pass a Character array
    }
}

