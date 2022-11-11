package com.techelevator;

import org.junit.*;

public class Less20Test {

    Less20 less20 = new Less20();
    //happy path for n%20 == 18
    @Test
    public void test_isLessThanMultipleOf20_send_in_18_return_true() {
        boolean expected = true;

        boolean actual = less20.isLessThanMultipleOf20(18);

        Assert.assertEquals(expected, actual);
    }
    //big int n%20 == 18
    @Test
    public void test_isLessThanMultipleOf20_send_in_138_return_true() {
        boolean expected = true;

        boolean actual = less20.isLessThanMultipleOf20(138);

        Assert.assertEquals(expected, actual);
    }

    //happy path for n%20 == 19
    @Test
    public void test_isLessThanMultipleOf20_send_in_19_return_true() {
        boolean expected = true;

        boolean actual = less20.isLessThanMultipleOf20(19);

        Assert.assertEquals(expected, actual);
    }

    //big int for n%20 == 19
    @Test
    public void test_isLessThanMultipleOf20_send_in_517_return_false() {
        boolean expected = false;

        boolean actual = less20.isLessThanMultipleOf20(517);

        Assert.assertEquals(expected, actual);
    }

    //false
    @Test
    public void test_isLessThanMultipleOf20_send_in_1_return_false() {
        boolean expected = false;

        boolean actual = less20.isLessThanMultipleOf20(1);

        Assert.assertEquals(expected, actual);
    }
}
