import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Sadat Islam
 * @version 1.0
 *
 * Created by Sadat Msi on 1/27/2017.
 */
public class Assign1 {


    // Algorithms

    /**
     * Sorts an array into accending order
     * @param array array to be sorted
     */
    private static void bubbleSort( int [] array)
    {
        for(int i = 0; i < array.length - 1; i++)
            for(int j = array.length - 1; j > i; j--)
                if( array[j] < array[j - 1])
                {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
    }


    /**
     * Sorts an array into accending order
     * @param arr array to be sorted
     */
    private static void insertionSort( int [] arr)
    {
        for( int i = 1, j; i < arr.length; i++)
        {
            int temp = arr[i];
            for( j = i; j > 0 && temp < arr[j - 1]; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    /**
     * Sorts an array into accending order
     * @param arr array to be sorted
     * @param first index of first element
     * @param last index of last element
     */
    private static void mergeSort( int [] arr, int first, int last)
    {
        if(first < last)
        {
            int mid = (first + last) / 2;
            //System.out.println("Called left");
            mergeSort( arr, first, mid);
            //System.out.println("Called right");
            mergeSort( arr, mid + 1, last);
            merge( arr, first,last);
        }
    }

    /**
     *  Merges two arrays together
     *  Code recieved from Drozdek- Data Structures and Algorithms in Java 2nd Edition
     * @param arr master array
     * @param first first index of the  left sub array
     * @param last last index of the right sub array
     */
    private static void merge( int [] arr, int first, int last )
    {
        //System.out.println("Called");
        int [] temp = new int [last - first + 1];
        int mid = (first + last) / 2;
        int i1 = 0, i2 = first, i3 = mid + 1;
        while( i2 <= mid && i3 <= last)
        {
            if( arr[i2] < arr[i3])
                temp[i1++] = arr[i2++];
            else
                temp[i1++] = arr[i3++];
        }
        if( i2 == mid)
            while( i1 < temp.length)
                temp[i1++] = arr[i3++];
        else
            while( i1 < temp.length)
                temp[i1++] = arr[i2++];
        System.arraycopy( temp, 0, arr, 0, temp.length);
    }

    /**
     * Sorts an array into accending order
     * @param arr master array
     * @param first index of first element of sub array
     * @param last index of last element of sub array
     */
    private static void quickSort( int arr[], int first, int last)
    {


    }


    /**
     * Runs the program
     * @param args command line will supply values for the order, size, algorthim, and output file name
     */
    public static void main( String [] args)
    {

        /*
         *  args[0] is order
         *  args[1] is size of array
         *  args[2] is algorithm
         *  args[3] is output file name
         */

        // Creates an array of the chosen size
        if( Integer.parseInt(args[1]) < 0)
        {
            System.out.println("Negative value for size.");
            System.exit(0);
        }

        int [] array = new int [Integer.parseInt(args[1])];
        System.out.printf("Array created with %d elements.\n", array.length);


        //Fills that array in the chosen fashion
        int counter;
        if( args[0].equals("ascending") )
        {
            counter = 0;
            for (int i = 0; i < array.length; i++) {
                array[i] = counter;
                counter++;
            }
        }
        else if( args[0].equals("descending"))
        {
            counter = array.length;
            for(int i = 0; i < array.length; i++)
            {
                array[i] = counter;
                counter--;
            }
        }
        else if( args[0].equals("random"))
        {
            Random rand = new Random();


            for(int i = 0; i < array.length; i++)
            {
                counter = rand.nextInt(array.length);
                array[i] = counter;
            }
        }
        else
        {
            System.out.println("Error: Cannot understand array order, please choose, ascending, descending, or random.");
            System.exit(1);
        }
        System.out.printf("Array sorted in %s order.\n", args[0]);


        //Chooses which algorithm to use

        System.out.printf("Algorithm selected is %s.\n", args[2]);

        long start = 0, end = 0;

        if ( args[2].equals("bubble"))
        {
            start = System.nanoTime();
            bubbleSort( array );
            end = System.nanoTime();
        }
        else if ( args[2].equals("insertion"))
        {
            start = System.nanoTime();
            insertionSort( array );
            end = System.nanoTime();
        }
        else if ( args[2].equals("merge"))
        {
            start = System.nanoTime();
            mergeSort( array, 0, array.length - 1 );
            end = System.nanoTime();
        }
        else if ( args[2].equals("quick"))
        {
            start = System.nanoTime();
            quickSort( array, 0, array.length);
            end = System.nanoTime();
        }
        else
        {
            System.out.println("Incorrect algorithm, please choose bubble, insertion, merge, or quick");
            System.exit(0);
        }

        long time_elapsed = end - start;


        //To test
        System.out.println("Time taken is: " + (time_elapsed * 1E-9) + " seconds");
        System.out.println("Done");



        //Output to file
        try
        {
            FileWriter writer = new FileWriter(args[3]);
            for( int i = 0; i < array.length; i++)
            {
                writer.write( Integer.toString(array[i]));
                writer.write("\r\n");

            }

            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.printf("Output found in %s\n", args[3]);













    }
}
