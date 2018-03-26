package sorters;
/**
 * @author Bojchenko
 * @version 9
 * This is final class bubble sort of int array b with current length.
 * This class extends from class sort.
 * @see Sort
 */
public class BubbleSortDown extends Sort{
    public BubbleSortDown(){

    }
    /**
     * Method goDown sort the array from the last int of array to the first.
     * Checking int values occurs inside the int array b.
     * {@link Sort#swap(int[], int, int)}
     */
     public static int[] bubbleSortDown(int[] a) {
            for (int i = a.length - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (a[j] > a[i]) {
                        swap(a, j, i);
                    }
                }
            }
         return a;
     }
    }