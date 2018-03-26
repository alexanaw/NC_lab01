package test.sorters;

import fillers.ArrayFiller;
import org.junit.Test;
import sorters.Bubble;
import sorters.BubbleSortDown;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BubbleTest {

    @Test
    public void bubbleTest(){
        int[] random = ArrayFiller.randomized(100);
        int[] sortedRandom = Arrays.copyOf(random, random.length);
        Arrays.sort(sortedRandom);
        int[] sorted = Bubble.bubble(random);
        assertArrayEquals(sortedRandom, sorted);
    }
}
