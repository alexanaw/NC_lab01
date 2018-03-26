package sorters;

/**
 * @author Bojchenko
 * @version 9
 * This is class that sort int e array with current length.
 * This class extends from class sort.
 * @see Sort
 * {@link Sort#swap(int[], int, int)}
 */
public class HoareSort extends Sort{
    public HoareSort(){

    }
    /**
     * This method have int e with current length.
     * This is method that print sorted array on the screen.
     * This method call the other method sort of this class with params.
     * {@link HoareSort#sort(int[], int, int)}
     */
   public static int[] hoareSort(int[] a) {
        sort(a, 0, a.length-1);
       return a;
   }
    /**
     * Method exchange sort with params.
     * @param a is the int array with current length.
     * @param aStart is the start point inside the array that mean the start int that will compare with another int.
     * @param aEnd is the last point inside the array that mean the last int that will compare with another int.
     * This method provide sorting of an array that compare two different values and if the value that is in the left
     * side is less than the int in the right side, they swap. Before comparing the array determine the average int of array.
     * Comparing starts from the first int of the array and the average int.
     * Checking int values occurs inside the int array e.
     * @link Sort#swap(int[], int, int)
     */
    private static int[] sort(int[] a, int aStart, int aEnd){

        int half = aStart+(aEnd - aStart)/2;
        int basis = a[half];
        int i = aStart;
        int j = aEnd;

        while (i<=j){
            while (a[i]<basis){
                i++;
            }
            while (a[j]>basis){
                j--;
            }

            if(i<=j){
                swap(a, i,j);
                i++;
                j--;
            }
        }
        if (aStart<j){
            sort(a, aStart, j);
        }
        if (aEnd>i){
            sort(a, i, aEnd);
        }
            return a;
    }
}