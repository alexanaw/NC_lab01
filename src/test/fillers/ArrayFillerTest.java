package test.fillers;

import fillers.ArrayFiller;
import org.junit.Assert;
import org.junit.Test;


public class ArrayFillerTest {

    @Test
    public void randomizedTest(){
    }

    @Test
    public void sortedArrayTest() {
        int[] sortedArray = ArrayFiller.sortedArray(100);
        for (int i = 0; i < sortedArray.length-1; i++) {
            if (sortedArray[i] < sortedArray[i+1]){
                return;
            }
        }
    }

    @Test
    public void sortedArrayPlusXTest() {
    }

    @Test
    public void inverseSortedArray(){
        int[] sortedArray = ArrayFiller.inverseSortedArray(100);
        for (int i = 0; i < sortedArray.length-1; i++) {
            if (sortedArray[i] < sortedArray[i+1]){
                return;
            }
        }
    }

}
