package test.sorters;

import fillers.ArrayFiller;
import org.junit.Test;
import sorters.Bubble;
import sorters.MergeSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void mergeSortTest() {
            int[] random = ArrayFiller.randomized(100);
            int[] sortedRandom = Arrays.copyOf(random, random.length);
            Arrays.sort(sortedRandom);
            int[] sorted = MergeSort.mergeSort(random);
            assertArrayEquals(sortedRandom, sorted);
    }
}
