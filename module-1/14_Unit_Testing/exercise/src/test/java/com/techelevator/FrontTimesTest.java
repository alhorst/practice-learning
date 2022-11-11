package com.techelevator;

import org.junit.*;

public class FrontTimesTest {

    FrontTimes frontTimes = new FrontTimes();
    //less than 3
    @Test
    public void test_generateString_less_than_three_int3() {
        String expected = "MeMeMe";

        String actual = frontTimes.generateString("Me", 3);

        Assert.assertEquals(expected, actual);
    }
    //long word
    @ Test
    public void test_generateString_long_word_int2() {
        String expected = "SupSup";

        String actual = frontTimes.generateString("Supercalifragilisticexpialidocious", 2);

        Assert.assertEquals(expected, actual);
    }
    //null, will return ""
    @Test
    public void test_generateString_null() {
        String expected = "";

        String actual = frontTimes.generateString(null, 0);

        Assert.assertEquals(expected, actual);
    }
    //""
    @Test
    public void test_generateString_empty_string() {
        String expected = "";

        String actual = frontTimes.generateString("", 3);

        Assert.assertEquals(expected, actual);
    }
    //3 exactly with big int
    @Test
    public void test_generateString_threechar_bigint() {
        String expected = "CatCatCatCatCatCatCatCatCatCat";

        String actual = frontTimes.generateString("Cat", 10);

        Assert.assertEquals(expected, actual);
    }

}
