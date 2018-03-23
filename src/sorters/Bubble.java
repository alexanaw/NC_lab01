package sorters;
/**
 * @author Bojchenko
 * @version 9
 * This is final class bubble sort of int array a with current length.
 * This class extends from class sort.
 * @see Sort
 */
public class Bubble extends Sort {
    public Bubble(){

    }
    /**
     * Method goUp sort the array from the first int of array to the last one int.
     * Checking int values occurs inside the int array a.
     *{@link Sort#swap(int[], int, int)}
     */
  public void bubble(int a[]) {
          for (int i = 0; i < a.length; i++) {
              for (int j = i - 1; j >= 0; j--) {
                  if (a[j] > a[j + 1]) {
                      swap(a, j, j + 1);
                  }
              }
          }
      }
}