/**
 * Created by Sadat Msi on 1/28/2017.
 */
public class Test {
    public static void main( String [] args){
        int [] array = new int [10];
        int counter = array.length;
        for (int i = 0; i < array.length; i++) {
            array[i] = counter;
            counter++;
        }
    }
}
