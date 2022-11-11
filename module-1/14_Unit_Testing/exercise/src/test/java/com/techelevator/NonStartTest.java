package com.techelevator;

import org.junit.*;

public class NonStartTest {

    NonStart nonStart = new NonStart();

    //hello there because obi-wan
    @Test
    public void test_getPartialString_a_and_b_greater_than_0_return_concat() {
        String expected = "ellohere";

        String actual = nonStart.getPartialString("Hello", "There");

        Assert.assertEquals(expected, actual);
    }

    //short string with 1 char
    @Test
    public void test_getPartialString_1_char_return_empty() {
        String expected = ""; //what would this return? it's not empty, the length is 1, but looking at
        //substring index 1...wouldn't it skip over 1 char? Should this give a StringIndexOutOfBoundsException(beginIndex)? Or just return empty string?

        String actual = nonStart.getPartialString("a", "a");

        Assert.assertEquals(expected, actual);
    }
    //a null
    @Test
    public void test_getPartialString_null_a_return_empty() {
        String expected = "ee";

        String actual = nonStart.getPartialString(null, "bee");

        Assert.assertEquals(expected, actual);
    }
    //1 char string with long string
    @Test
    public void test_getPartialString_1_char_a_with_long_b_return_empty_and_concat() {
        String expected = "ear"; //or should this also return StringIndexOutOfBounds?

        String actual = nonStart.getPartialString("a", "bear");

        Assert.assertEquals(expected, actual);
    }
    //""
    @Test
    public void test_getPartialString_empty_string_return_empty() {
        String expected = "";

        String actual = nonStart.getPartialString("", "");

        Assert.assertEquals(expected, actual);
    }
    //looooong words
    @Test
    public void test_getPartialString_a_long_word_b_long_word_return_concat() {
        String expected = "erisimilitudeebauchery";

        String actual = nonStart.getPartialString("Verisimilitude", "Debauchery");

        Assert.assertEquals(expected, actual);
    }

}
