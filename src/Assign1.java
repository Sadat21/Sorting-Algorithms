import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * This class tests 4 different algorithms (bubble, insertion, merge, and quick) using variable array lengths, order
 * within the array, and outputs it to an textfile.
 *
 * @author Sadat Islam
 * @version 1.0
 *
 * Created by Sadat Msi on 1/27/2017.
 */
public class Assign1 {


    // Algorithms

    /**
     * Sorts an array into ascending order
     *
     * Code got from Dr. Manzara's lectures
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
     * Sorts an array into ascending order
     *
     * Code copied from Dr. Manzara's lectures
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
     * Sorts an array into ascending order
     *
     * Code copied from Dr. Manzara's lectures
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
     *  Code received from Drozdek- Data Structures and Algorithms in Java 2nd Edition
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
        if( i2 == mid + 1)
            while( i1 < temp.length)
                temp[i1++] = arr[i3++];
        else
            while( i1 < temp.length)
                temp[i1++] = arr[i2++];
        System.arraycopy( temp, 0, arr, first, temp.length);
    }

    /**
     * Sorts an array into ascending order
     *
     * Code received from Drozdek- Data Structures and Algorithms in Java 2nd Edition
     * @param arr master array
     * @param first index of first element of sub array
     * @param last index of last element of sub array
     */
    private static void quickSort( int arr[], int first, int last)
    {
        int lower = first + 1, upper = last;
        swap( arr, first, (first + last) / 2);

        // How we chose the pivot (mid point)
        int pivot = arr[first];

        while( lower <= upper)
        {
            while( arr[lower] <= pivot)
                lower++;
            while( arr[upper] > pivot)
                upper--;
            if( lower < upper)
                swap( arr, lower++, upper--);
            else
                lower++;
        }
        swap( arr, upper, first);
        if( first < upper - 1)
            quickSort( arr, first, upper - 1);
        if( upper + 1 < last)
            quickSort( arr, upper + 1, last);

    }

    /**
     * Finds the largest value in the array and moves it to the correct spot, this is to
     * solve out of bound errors.
     *
     * Code received from Drozdek- Data Structures and Algorithms in Java 2nd Edition
     * @param arr array to be sorted
     */
    private static void quickSort( int [] arr)
    {
        if( arr.length < 2)
            return;
        int max = 0;
        for(int i = 1; i < arr.length; i++)
            if( arr[i] > arr[max])
                max = i;
        swap(arr, arr.length - 1, max);
        quickSort( arr, 0, arr.length - 2);


    }

    /**
     * Swaps values in index a and b
     * @param arr master array
     * @param a index contents in a will be swaped with index contents of b
     * @param b index contents in b will be swapped with index contents of a
     */
    private static void swap( int [] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    /**
     * Runs the program
     * First checks to make sure all commandline arguments are suitable. Runs the chosen algorithm and times it. Outputs
     * the time on the console and prints the array into a text file.
     * @param args command line will supply values for the order, size, algorithm, and output file name
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
            quickSort( array);
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
