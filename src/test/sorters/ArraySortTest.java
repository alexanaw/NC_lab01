package test.sorters;

import fillers.ArrayFiller;
import org.junit.Test;
import sorters.ArraySort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;


public class ArraySortTest {

    @Test
    public void arraySortTest() {
        int[] random = ArrayFiller.randomized(100);
        int[] sortedRandom = Arrays.copyOf(random, random.length);
        Arrays.sort(sortedRandom);
        int[] sorted = ArraySort.arraySort(random);
        assertArrayEquals(sortedRandom, sorted);
    }
}
