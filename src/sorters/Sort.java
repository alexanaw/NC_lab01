package sorters;

/**
 *@author Bojchenko
 *@version 9
 *This is main class where all methods of other classes will carried out.
 */
public class Sort {
      /**
     * This is a method swap with params.
     * @param a     some int array`s value.
     * @param left  some int value from array.
     * @param right another int value from array.
     */
      static void swap(int[] a, int left, int right) {
        if (left != right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
    }
}