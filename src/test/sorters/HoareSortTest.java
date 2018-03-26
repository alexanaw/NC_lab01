package test.sorters;

import fillers.ArrayFiller;
import org.junit.Test;
import sorters.Bubble;
import sorters.HoareSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class HoareSortTest {

    @Test
    public void hoareSortTest(){
            int[] random = ArrayFiller.randomized(100);
            int[] sortedRandom = Arrays.copyOf(random, random.length);
            Arrays.sort(sortedRandom);
            int[] sorted = HoareSort.hoareSort(random);
            assertArrayEquals(sortedRandom, sorted);
    }
}
