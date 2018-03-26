package test.sorters;

import fillers.ArrayFiller;
import org.junit.Test;
import sorters.ArraySort;
import sorters.BubbleSortDown;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortDownTest {

    @Test
    public void bubbleSortDownTest() {
        int[] random = ArrayFiller.randomized(100);
        int[] sortedRandom = Arrays.copyOf(random, random.length);
        Arrays.sort(sortedRandom);
        int[] sorted = BubbleSortDown.bubbleSortDown(random);
        assertArrayEquals(sortedRandom, sorted);
    }
}
