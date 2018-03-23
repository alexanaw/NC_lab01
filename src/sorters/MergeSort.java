package sorters;
       /** @author Bojchenko
        * @version 9
        * This is class merge that sort int d array with current length.
        */
public class MergeSort extends Sort  {
    public MergeSort(){

    }
    /**
     * This method have int d with current length.
     * This is method that print sorted array on the screen.
     * This method call the other method mergesort of this class with params.
     * {@link MergeSort#mergesort(int[], int[], int, int)}
     */
   public void mergeSort(int a[]) {
        mergesort(a, new int[a.length],0,a.length-1);
   }
    /**
     * Method merge with params.
     * @param a is the int array with current length.
     * Method merge sort with params.
     * @param templist is the temporary array.
     * @param leftStart is the first point inside the array that mean the first int that will compare with another int.
     * @param rightEnd is the last point inside the array that mean the last int that will compare with another int.
* This method provide check if the array is already sorted.
* If it is not, provides the method merge. The array divert on two arrays.
* Method determine the middle int of an array.
* {@link MergeSort#merge(int[], int[], int, int)}
     */
    private int[] mergesort(int[] a, int[] templist, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
           return a;
        } else {
            int midIndex = (leftStart + rightEnd) / 2;
            mergesort(a, templist, leftStart, midIndex);
            mergesort(a, templist, midIndex + 1, rightEnd);
            merge(a, templist, leftStart, rightEnd);
        }
        return a;
    }
           /**emplist is the temporary array.
            * @param leftStart is the first point inside the array that mean the first int that will compare with another int.
            * @param rightEnd is the last point inside the array that mean the last int that will compare with another int.
            * This method provide sorting of an array that compare two different values and if the value that is in the left
            * side is more than the int in the right side, they swap.
            * Comparing starts from the first int of the array and the last int from the array.
            * Checking int values occurs inside the int array c.
            */
           private void merge(int[] d, int[] templist, int leftStart, int rightEnd) {
               int leftEnd = (rightEnd + leftStart) / 2;
               int rightStart = leftEnd + 1;
               int size = rightEnd - leftStart + 1;

               int left = leftStart;
               int right = rightStart;
               int index = leftStart;

               while (left <= leftEnd && right <= rightEnd) {
                   if (d[left] <= d[right]) {
                       templist[index] = d[left];
                       left++;
                   } else {
                       templist[index] = d[right];
                       right++;
                   }
                   index++;
               }
               System.arraycopy(d, left, templist, index, leftEnd - left + 1);
               System.arraycopy(d, right, templist, index, rightEnd - right + 1);
               System.arraycopy(templist, leftStart, d, leftStart, size);
           }
       }