package sorters;
/**
 * @author Bojchenko
 * @version 9
 * This is class exchange that sort int c array with current length.
 * This class extends from class sort.
 * @see Sort
 */
public final class ExchangeSort extends Sort {

    public ExchangeSort() {

    }

    /**
     * This method create randomize array with current length.
     * This is method that print sorted array on the screen.
     * This method call the other method exchange of this class with params.
     * {@link ExchangeSort#exchange(int[],int, int)}
     */
    public static int[] exchangeSort(int[] a) {
            exchange(a, 0, a.length - 1);
            return a;
    }

    private static void exchange(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int S = i - (i - j) / 2;
        while (i < j) {
            while (array[i] <= array[S] && i < S) i++;
            while (array[j] >= array[S] && j > S) j--;
            if (i < j) {
                swap(array, i, j);
                if (i == S) {
                    S = j;
                } else if (j == S) {
                    S = i;
                }
            }
        }
        exchange(array,left, S);
        exchange(array,S + 1, right);
    }
}