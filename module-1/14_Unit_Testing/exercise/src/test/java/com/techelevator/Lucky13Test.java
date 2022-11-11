package com.techelevator;

import org.junit.*;

public class Lucky13Test {

    Lucky13 lucky13 = new Lucky13();

    //null
    @Test
    public void test_getLucky_null_return_true() {
        boolean expected = true;

        boolean actual = lucky13.getLucky(null);

        Assert.assertEquals(expected, actual);
    }

    //no 1s and no 3s
    @Test
    public void test_getLucky_no_1s_or_3s() {
        boolean expected = true;
        int [] test = {0, 6, 9};

        boolean actual = lucky13.getLucky(test);

        Assert.assertEquals(expected, actual);
    }

    //both 1 and 3
    @Test
    public void test_getLucky_1s_and_3s() {
        boolean expected = false;
        int [] test = {1, 4, 3};

        boolean actual = lucky13.getLucky(test);

        Assert.assertEquals(expected, actual);
    }

    //all 1s
    @Test
    public void test_getLucky_all_1s() {
        boolean expected = false;
        int [] test = {1, 1, 1};

        boolean actual = lucky13.getLucky(test);

        Assert.assertEquals(expected, actual);
    }

    //1 but no 3
    @Test
    public void test_getLucky_3_no_1s() {
        boolean expected = false;
        int [] test = {3, 3, 2};

        boolean actual = lucky13.getLucky(test);

        Assert.assertEquals(expected, actual);
    }
}
