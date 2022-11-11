package com.techelevator;

import org.junit.*;
import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    WordCount wordCount = new WordCount();

    //happy path hello hello hello is there anybody in there
    @Test
    public void test_getCount_hello_there_repeat_return_hello_there_2_all_else_1() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Hello", 3);
        expected.put("is", 1);
        expected.put("there", 2);
        expected.put("anybody", 1);
        expected.put("in", 1);

        String [] test = {"Hello", "hello", "hello", "is", "there", "anybody", "in", "there"};

        Map<String, Integer> actual = wordCount.getCount(test);
        Integer actualHello = actual.get("Hello");
        Integer actualIs = actual.get("is");
        Integer actualThere = actual.get("there");
        Integer actualAnybody = actual.get("anybody");
        Integer actualIn = actual.get("in");
        Integer expectedHello = actual.get("Hello");
        Integer expectedIs = actual.get("is");
        Integer expectedThere = actual.get("there");
        Integer expectedAnybody = actual.get("anybody");
        Integer expectedIn = actual.get("in");

        Assert.assertEquals(expectedHello, actualHello);
        Assert.assertEquals(expectedIs, actualIs);
        Assert.assertEquals(expectedThere, actualThere);
        Assert.assertEquals(expectedAnybody, actualAnybody);
        Assert.assertEquals(expectedIn, actualIn);
    }
    //empty return empty
    @Test
    public void test_getCount_empty_in_return_empty() {
        int expectedSize = 0;

        String[] test = {};

        //System.out.println(wordCount.getCount(test).toString());
        Assert.assertEquals(expectedSize, wordCount.getCount(test).size());
    }
    //no repeats the fox wants grapes
    @Test
    public void test_getCount_no_repeats_return_1() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("The", 1);
        expected.put("fox", 1);
        expected.put("wants", 1);
        expected.put("grapes", 1);

        String [] test = {"The", "fox", "wants", "grapes"};

        Map<String, Integer> actual = wordCount.getCount(test);
        Integer actualThe = actual.get("The");
        Integer actualFox = actual.get("fox");
        Integer actualWants = actual.get("wants");
        Integer actualGrapes = actual.get("grapes");
        Integer expectedThe = actual.get("The");
        Integer expectedFox = actual.get("fox");
        Integer expectedWants = actual.get("wants");
        Integer expectedGrapes = actual.get("grapes");

        Assert.assertEquals(expectedThe, actualThe);
        Assert.assertEquals(expectedFox, actualFox);
        Assert.assertEquals(expectedWants, actualWants);
        Assert.assertEquals(expectedGrapes, actualGrapes);

    }
    //choo choo choo choo choo
    @Test
    public void test_getCount_choo_repeat_return_5() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Choo", 5);

        String[] test = {"Choo", "choo", "choo", "choo", "choo"};

        Map<String, Integer> actual = wordCount.getCount(test);
        Integer actualChoo = actual.get("Choo");
        Integer expectedChoo = actual.get("Choo");

        Assert.assertEquals(expectedChoo, actualChoo);

    }
    //null
    @Test
    public void test_getCount_null_return_empty() {
        int expectedSize = 0;

        String[] test = null;

        Assert.assertEquals(expectedSize, wordCount.getCount(test).size());
    }

}
