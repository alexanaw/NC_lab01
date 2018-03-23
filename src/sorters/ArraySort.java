package sorters;


import java.util.Arrays;
/**
 * @author Bojchenko
 * @version 9
 * This is class ArraySort that sort int e array with current length.
 */
public class ArraySort extends Sort{
    public ArraySort(){
    }

    /** Method print sort the array from the first int of array to the last one int.
     * Checking int values occurs inside the int array a.
     * This method print sorted array on the screen.
     */
    public void arraySort(int a[]){
        Arrays.sort(a);
    }
    }