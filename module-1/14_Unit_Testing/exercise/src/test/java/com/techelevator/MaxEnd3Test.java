package com.techelevator;

import org.junit.*;

import static org.junit.Assert.*;

public class MaxEnd3Test {

    MaxEnd3 maxEnd3 = new MaxEnd3();

    //all same num
    @Test
    public void test_makeArray_all_same_num() {
        int [] expected = {9, 9, 9};
        int [] test = {9, 9, 9};

        int [] actual = maxEnd3.makeArray(test);

        Assert.assertArrayEquals(expected, actual);
    }

    //small int big int small int
    @Test
    public void test_makeArray_small_int_big_int_small_int() {
        int [] expected = {2, 2, 2};
        int [] test = {1, 100, 2};

        int [] actual = maxEnd3.makeArray(test);

        Assert.assertArrayEquals(expected, actual);
    }

    //big int bigger int
    @Test
    public void test_makeArray_big_int_bigger_int() {
        int [] expected = {25, 25, 25};
        int [] test = {10, 20, 25};

        int [] actual = maxEnd3.makeArray(test);

        Assert.assertArrayEquals(expected, actual);
    }

    //outofbounds
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_makeArray_four_nums() {
        //Is this test helpful? It would look at 1 and 4 but there should only be 3 allowed
        int [] expected = {3, 3, 3};
        int [] test = {1, 2, 3, 4};
    }

    //big first
    @Test()

}
