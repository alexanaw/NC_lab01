package test.sorters;

import fillers.ArrayFiller;
import org.junit.Test;
import sorters.ExchangeSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ExchangeSortTest {

    @Test
    public void exchangeSortTest() {
            int[] random = ArrayFiller.randomized(100);
            int[] sortedRandom = Arrays.copyOf(random, random.length);
            Arrays.sort(sortedRandom);
            int[] sorted = ExchangeSort.exchangeSort(random);
            assertArrayEquals(sortedRandom, sorted);
    }
}
