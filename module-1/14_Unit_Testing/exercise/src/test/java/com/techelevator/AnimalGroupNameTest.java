package com.techelevator;

import org.junit.*;

public class AnimalGroupNameTest {
    AnimalGroupName animalgroupname = new AnimalGroupName();

    @Test
    public void test_getHerd_send_in_mixed_case_key_return_correct_value() {
        //Arrange: what would I put here for when everything is basically already set up in the method?
        String expectedCrow = "Murder";
        String expectedDeer = "Herd";
        String expectedRhino = "Crash";
        //Act
        String actualCrow = animalgroupname.getHerd("cRoW");
        String actualDeer = animalgroupname.getHerd("dEEr");
        String actualRhino = animalgroupname.getHerd("RhINo");
        //Assert
        Assert.assertEquals(expectedCrow, actualCrow);
        Assert.assertEquals(expectedDeer, actualDeer);
        Assert.assertEquals(expectedRhino, actualRhino);
    }

    @Test
    public void test_getHerd_send_in_empty_string_return_unknown() {
        //Arrange
        String expectedEmpty = "unknown";
        //Act
        String actualEmpty = animalgroupname.getHerd("");
        //Assert
        Assert.assertEquals(expectedEmpty, actualEmpty);
    }

    @Test
    public void test_getHerd_send_in_plural_key_return_unknown() {
        //Arrange
        String expectedPlural = "unknown";
        //Act
        String actualPlural = animalgroupname.getHerd("dogs");
        //Assert
        Assert.assertEquals(expectedPlural, actualPlural);
    }

    @Test
    public void test_getHerd_send_in_null_return_unknown() {
        //Arrange
        String expectedNull = "unknown";
        //Act...is this bad naming for my variables? Should it just be actual and expected?
        String actualNull = animalgroupname.getHerd(null);
        //Assert
        Assert.assertEquals(expectedNull, actualNull);
    }

    @Test
    public void test_getHerd_send_in_correct_case_key_return_correct_value() {
        //Arrange
        String expected = "Tower";
        //Act
        String actual = animalgroupname.getHerd("giraffe");
        //Assert
        Assert.assertEquals(expected, actual);

    }
}
