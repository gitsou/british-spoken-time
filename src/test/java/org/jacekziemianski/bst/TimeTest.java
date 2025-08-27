package org.jacekziemianski.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void testTimeConstructor() {
        Time time = new Time(5, 32);
        assertEquals(5, time.getHour());
        assertEquals(32, time.getMinute());
    }

    @Test
    void testTimeConstructorWrongMinute() {
        assertThrows(IllegalArgumentException.class, () -> new Time(5, 72));
    }

    @Test
    void testTimeCreateWrongHour() {
        assertThrows(IllegalArgumentException.class, () -> new Time(30, 0));
    }

    @Test
    void testGetAdjustedHour() {
        assertEquals(10, new Time(10, 16).getHour());
    }

    @Test
    void testGetAdjustedHourPlus1() {
        assertEquals(11, new Time(10, 16).getAdjustedHour(1));
    }

    @Test
    void testGetAdjustedHourMinus2() {
        assertEquals(23, new Time(1, 16).getAdjustedHour(-2));
    }

    @Test
    void testGetAdjustedHourMinus27() {
        assertEquals(22, new Time(1, 16).getAdjustedHour(-27));
    }

    @Test
    void testGetAdjustedHourMinus23() {
        assertEquals(0, new Time(23, 16).getAdjustedHour(-23));
    }

    @Test
    void testGetAdjustedMinute() {
        assertEquals(16, new Time(10, 16).getMinute());
    }

    @Test
    void testGetAdjustedMinutePlus1() {
        assertEquals(17, new Time(10, 16).getAdjustedMinute(1));
    }

    @Test
    void testGetAdjustedMinutePlus5() {
        assertEquals(3, new Time(10, 58).getAdjustedMinute(5));
    }

    @Test
    void testGetAdjustedMinuteMinus7() {
        assertEquals(58, new Time(10, 5).getAdjustedMinute(-7));
    }

    @Test
    void testGetAdjustedMinuteMinus77() {
        assertEquals(48, new Time(10, 5).getAdjustedMinute(-77));
    }

    @Test
    void testGetAdjustedMinuteMinus30() {
        assertEquals(25, new Time(10, 55).getAdjustedMinute(-30));
    }

    @Test
    void getTime() {
        assertEquals("10:16", new Time(10, 16).getTime());
    }
}