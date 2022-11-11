package com.techelevator;

import org.junit.*;

public class DateFashionTest {

    DateFashion dateFashion = new DateFashion();

    @Test
    public void test_getATable_send_in_two_low_values_return_0() {
    //Arrange
        int expected = 0;
    //Assert
        int actual = dateFashion.getATable(1, 2);
    //Act
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getATable_send_in_low_and_high_return_0() {
        int expected = 0;

        int actual = dateFashion.getATable(2, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getATable_send_in_out_of_range_and_return_error() {
        //this method currently allows inputs out of the range specified
            //the instructions say 0<int<10 but in the else if, it says int >=8 ...
            //so could a tester write something like this to let the developer know
            //that needs to be fixed in the code?
        int expected = 2;

        int actual = dateFashion.getATable(11, 10);

        Assert.fail("Please only enter numbers between 1 and 10.");
    }

    @Test
    public void test_getATable_send_in_middle_values_return_1() {
        int expected = 1;

        int actual = dateFashion.getATable(5, 5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getATable_send_in_edge_values_return_2() {
        int expected = 2;

        int actual = dateFashion.getATable(3, 8);

        Assert.assertEquals(expected, actual);
    }
}
