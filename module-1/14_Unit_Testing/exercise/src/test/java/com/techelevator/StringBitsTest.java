package com.techelevator;

import org.junit.*;

public class StringBitsTest {

    StringBits stringBits = new StringBits();

    //happy path hello
    @Test
    public void test_getBits_happy_path_hello_return_hlo(){
        String expected = "Hlo";

        String actual = stringBits.getBits("Hello");

        Assert.assertEquals(expected, actual);
    }
    //happy path supercalifragalisticexpialidocious
    @Test
    public void test_getBits_long_supercalifragilisticexpialidocious_return_sprairglsiepaioiu() {
        String expected = "Sprairglsiepaioiu";

        String actual = stringBits.getBits("Supercalifragilisticexpialidocious");

        Assert.assertEquals(expected, actual);
    }
    //null
    @Test
    public void test_getBits_null_in_return_empty() {
        String expected = "";

        String actual = stringBits.getBits(null);

        Assert.assertEquals(expected, actual);
    }
    //""
    @Test
    public void test_getBits_empty_string_in_return_empty_string() {
        String expected = "";

        String actual = stringBits.getBits("");

        Assert.assertEquals(expected, actual);
    }
    //short word po
    @Test
    public void test_getBits_po_in_return_p() {
        String expected = "P";

        String actual = stringBits.getBits("Po");

        Assert.assertEquals(expected, actual);
    }

}
