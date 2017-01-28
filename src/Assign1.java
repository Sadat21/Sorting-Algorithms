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
    public void bubbleSort( int [] array)
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
    public void insertionSort( int [] arr)
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
    public void mergeSort( int [] arr, int first, int last)
    {
        if(first < last)
        {
            int mid = (first + last) / 2;
            mergeSort( arr, first, mid);
            mergeSort( arr, mid + 1, last);
            merge( arr, first, mid, mid + 1, last);
        }
    }

    /**
     *  Merges two arrays together
     * @param arr
     * @param first
     * @param second
     * @param third
     * @param last
     */
    private void merge( int [] arr, int first, int second, int third, int last )
    {
        for( int i = first; i <= second; i++)
        {
           // tbc
        }
    }

    /**
     * Sorts an array into accending order
     * @param arr
     * @param first
     * @param last
     */
    public void quickSort( int arr[], int first, int last)
    {

    }


    /**
     * Runs the program
     * @param args
     */
    public void main( String [] args)
    {

        /**
         *  args[0] is order
         *  args[1] is size of array
         *  args[2] is algorithm
         *  args[3] is output file name
         */

        // Creates an array of the chosen size
        if( Integer.parseInt(args[1]) < 0)
        {
            System.out.println("Negative value for size.")
            System.exit(1);
        }

        int [] array = new int [Integer.parseInt(args[1])];


        //Fills that array in the chosen fashion
        int counter;
        if( args[0] == "ascending")
        {
            counter = 0;
            for (int i = 0; i < array.length; i++) {
                array[i] = counter;
                counter++;
            }
        }
        else if( args[0] == "desending")
        {
            counter = array.length;
            for(int i = 0; i < array.length; i++)
            {
                array[i] = counter;
                counter--;
            }
        }
        else if( args[0] == "random")
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
            System.out.println("Error: Cannot understand array order, please choose, ascending, desending, or random.");
            System.exit(1);
        }

        //Check to see output file exists
        /**
         *
         *
         *
         */

        //Chooses which algorithm to use

        long start, end;

        if ( args[2] == "bubble")
        {
            start = System.nanoTime();
            bubbleSort( array );
            end = System.nanoTime();
        }
        else if ( args[2] == "insertion")
        {
            start = System.nanoTime();
            insertionSort( array );
            end = System.nanoTime();
        }
        else if ( args[2] == "merge")
        {
            start = System.nanoTime();
            mergeSort( array, 0, array.length - 1 );
            end = System.nanoTime();
        }
        else if ( args[2] == "quick")
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












    }
}
