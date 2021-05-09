package com.netteans.toin.agr.test;

import com.netteans.toin.agr.BubbleSort;
import com.netteans.toin.agr.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestCase {

    @Test
    public void test() {
        for (int ix = 0; ix < 100; ix++) {
            int s = 10 * ix;
            Integer[] rand = new Integer[s];
            for (int i = 0; i < rand.length; i++) {
                rand[i] = new Random().nextInt(rand.length);
            }
            final long l1 = System.nanoTime();
            final Integer[] sort = new BubbleSort<Integer>().sort(rand, true);
            final long l2 = System.nanoTime();

            final long l3 = System.nanoTime();
            final Integer[] rsort = new QuickSort<Integer>().sort(rand, true);
            final long l4 = System.nanoTime();
            System.out.println(String.format("Sort[%s] cost: Bubble[%s]", s, (l2 - l1)));
            System.out.println(String.format("Sort[%s] cost: Quick [%s]", s, (l4 - l3)));
        }
    }
}
