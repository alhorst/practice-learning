package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureTest {

    Lecture exercises = new Lecture();

    @Test
    public void testReturnArray() {
        assertArrayEquals(new int[] { 80, 8080, 443 }, exercises.returnArray());
    }

    @Test
    public void testReturnFirstElement() {
        assertEquals("That's not the first element in that array", 80, exercises.returnFirstElement());
    }

    @Test
    public void testReturnLastElement() {
        assertEquals("That's not the last element", 443, exercises.returnLastElement());
    }

    @Test
    public void testReturnFirstElementOfParam() {
        assertEquals("That's not the first element from {5, 10, 15}", 5,
                exercises.returnFirstElementOfParam(new int[] { 5, 10, 15 }));
        assertEquals("That's not the first element from {10, 20, 30, 40, 50}", 10,
                exercises.returnFirstElementOfParam(new int[] { 10, 20, 30, 40, 50 }));
    }

    @Test
    public void testReturnLastElementOfParam() {
        assertEquals("That's not the last element from {5, 10, 15}", 15,
                exercises.returnLastElementOfParam(new int[] { 5, 10, 15 }));
        assertEquals("That's not the last element from {10, 20, 30, 40, 50}", 50,
                exercises.returnLastElementOfParam(new int[] { 10, 20, 30, 40, 50 }));
    }

    @Test
    public void testReturnVariableFromBlock() {
        assertEquals(15, exercises.returnVariableFromBlock(3));
    }

    @Test
    public void testReturnOperationInBlock() {
        assertTrue("Not true yet!", exercises.returnOperationInBlock());
    }

    @Test
    public void testReturnVariableInScope() {
        assertEquals("Not that one, try again.", 5.0, exercises.returnInScopeVariable(), 0.001);
    }

    @Test
    public void testReturnCounterFromLoop() {
        assertTrue("Not true yet!", exercises.returnCounterFromLoop());
    }

    @Test
    public void testReturnCorrectCount() {
        assertTrue("Not Correct Yet!", exercises.returnCorrectCount());
    }

    @Test
    public void testReturnCorrectCountTimes() {
        assertTrue("Not Correct Yet!", exercises.returnCountCorrectTimes());
    }

    @Test
    public void testReturnSumEveryOtherNumber() {
        assertTrue("Not Correct Yet!", exercises.returnSumEveryOtherNumber());
    }

    @Test
    public void testReturnPopularSquirrelSnack(){
        assertEquals(12, exercises.returnPopularSquirrelSnack(new int[] {4, 12, 3, 5}));
        assertEquals(5, exercises.returnPopularSquirrelSnack(new int[] {5, 3, 1, 0}));
    }

    @Test
    public void testReturnTotalDrinks(){
        assertArrayEquals(new int[] {2, 3},
                exercises.returnTotalDrinks(new char[]{'p', 'p', 'w', 'w', 'w'}));
        assertArrayEquals(new int[] {0, 4}, exercises.returnTotalDrinks(new char[]{'w', 'w', 'w', 'w'}));
    }

    @Test
    public void testAverageCigarUsage(){
        assertEquals(3.75, exercises.averageCigarUsage(new int[] {5, 4, 3, 5, 5, 7, 1, 0}), 0.0001);
        assertEquals(1.857, exercises.averageCigarUsage(new int[] {2, 2, 1, 2, 3, 2, 1}), 0.001);

    }
}
