package sorters;
/**
 * @author Bojchenko
 * @version 9
 * This is class exchange that sort int c array with current length.
 * This class extends from class sort.
 * @see Sort
 */
public class ExchangeSort extends Sort {
    public ExchangeSort() {

    }

    /**
     * This method create randomize array with current length.
     * This is method that print sorted array on the screen.
     * This method call the other method exchange of this class with params.
     * {@link ExchangeSort#exchange(int[], int, int)}
     */
    public void exchangeSort(int[] a) {
        exchange(a, 0, a.length - 1);
    }

      private int[] exchange(int[] a, int begin, int end) {
          int i = begin;
          int j = end;
          int average = (i - (i - j) / 2);
          if (i < j) {
              while ((i < average) && (a[i] <= a[average])) i++;
              while ((j > average) && (a[j] >= a[average])) j--;

              if (i > j) {
                  swap(a, i, j);
              }
              if (i == average) {
                  average = j;
              } else if (j == average) {
                  average = i;
              }
              if (i >= j) {
                  return exchange(a, 0, average);
              }
              if (i <= j) {
                  return exchange(a, average + 1, a.length - 1);
              }
          }
              return a;
          }
}