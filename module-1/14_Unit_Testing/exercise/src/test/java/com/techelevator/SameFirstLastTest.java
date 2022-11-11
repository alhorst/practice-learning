package com.techelevator;

import org.junit.*;

public class SameFirstLastTest {

    SameFirstLast sameFirstLast = new SameFirstLast();

    //happy path 1, 2, 3 false
    @Test
    public void test_isItTheSame_happy_path_return_false() {
        boolean expected = false;
        int [] test = {1, 2, 3};

        boolean actual = sameFirstLast.isItTheSame(test);

        Assert.assertEquals(expected, actual);
    }
    //null false
    @Test
    public void test_isItTheSame_null_return_false() {
        boolean expected = false;
        int [] test = null;

        boolean actual = sameFirstLast.isItTheSame(test);

        Assert.assertEquals(expected, actual);
    }
    //long array 1, 2, 4, 3, 2, 5, 10, 6, 10, 15, 24, 1 true
    @Test
    public void test_isItTheSame_long_array_first_last_same_return_true() {
        boolean expected = true;
        int [] test = {1, 2, 4, 3, 2, 5, 10, 6, 10, 15, 24, 1};

        boolean actual = sameFirstLast.isItTheSame(test);

        Assert.assertEquals(expected, actual);
    }
    //0 in returns true...shouldn't it return something else, like an error? "please enter more numbers"
        //the instructions say "return true if array is length 1 or more AND the first element..."
    @Test
    public void test_isItTheSame_zero_in_return_false() {
        boolean expected = false;
        int [] test = {0};

        boolean actual = sameFirstLast.isItTheSame(test);

        Assert.assertEquals(expected, actual);
    }
    //I can't think of another test that would be good for this...

}
