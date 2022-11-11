package com.techelevator;

import org.junit.*;

public class CigarPartyTest {

    CigarParty cigarParty = new CigarParty();
    @Test
    public void test_cigarParty_send_in_40_and_false_return_true() {
    //Arrange
        boolean expected = true;
    //Act
        boolean actual = cigarParty.haveParty(40, false);
    //Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_cigarParty_send_in_under_min_and_true_return_false() {
    //Arrange
        boolean expected = false;
        boolean expected1 = false;
    //Act
        boolean actual = cigarParty.haveParty(39, true);
        boolean actual1 = cigarParty.haveParty(1, true);
    //Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);
    }
    @Test
    public void test_cigarParty_send_in_100_and_false_return_false() {
    //Arrange
        boolean expected = false;
    //Act
        boolean actual = cigarParty.haveParty(100, false);
    //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_cigarParty_send_in_59_and_false_return_true() {
    //Arrange
        boolean expected = true;
    //Act
        boolean actual = cigarParty.haveParty(59, false);
    //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_cigarParty_send_in_500_and_true_return_true() {
    //Arrange
        boolean expected = true;
    //Act
        boolean actual = cigarParty.haveParty(500, true);
    //Assert
        Assert.assertEquals(expected, actual);
    }

}
