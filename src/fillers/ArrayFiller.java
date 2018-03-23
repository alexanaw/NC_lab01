package fillers;

import java.util.Arrays;


/**
 * @author Bojchenko
 * @version 9
 * This class complete different types of arrays
 */
public class ArrayFiller {

    public ArrayFiller(){

    }

    /**
     * This method create randomized array with a current length.
     */
    @Filler
    public static int[] randomized(int capacity) {
        int[]a = new int[capacity];
            for (Integer i = 0; i < capacity; i++) {
                a[i] = (int) Math.round(Math.random() * 100);
            }
            return a;
    }


    /**
     * This method create randomized array with a current length, than sort it.
     */
    @Filler
    public static int[] sortedArray(int capacity) {
                int a[] = new int[capacity];
                for (Integer i = 0; i < capacity; i++) {
                    a[i] = (int) Math.round(Math.random() * 100);
                    Arrays.sort(a);
                }
                return a;
            }

    /**
     * This method create randomized array with a current length, than sort it and add the last random number.
     */
    @Filler
    public static int[] sortedArrayPlusX(int capacity) {
        int X[] = new int[1];
        for (Integer i = 0; i < X.length; i++) {
            X[i] = (int) Math.round(Math.random());
        }
        int array[] = new int[capacity-1];
        for (Integer i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * 100);
            Arrays.sort(array);
        }
        return new int[array.length + X.length];
    }
/**
 * Generate array sorted by descending.
 */
    @Filler
    public static int[] inverseSortedArray(int capacity) {
        int a[] = new int[capacity];
        for (int i = capacity - 2; i >= 0; i--) {
            a[i] = (int) Math.round(Math.random() * 100);
            Arrays.sort(a);
        }
        return a;
    }
}