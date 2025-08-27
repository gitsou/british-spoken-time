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
    void testGetHour() {
        assertEquals(10, new Time(10, 16).getHour());
    }

    @Test
    void testGetHourPlus1() {
        assertEquals(11, new Time(10, 16).getHour(1));
    }

    @Test
    void testGetHourMinus2() {
        assertEquals(23, new Time(1, 16).getHour(-2));
    }

    @Test
    void testGetHourMinus27() {
        assertEquals(22, new Time(1, 16).getHour(-27));
    }

    @Test
    void testGetHourMinus23() {
        assertEquals(0, new Time(23, 16).getHour(-23));
    }

    @Test
    void testGetMinute() {
        assertEquals(16, new Time(10, 16).getMinute());
    }

    @Test
    void testGetMinutePlus1() {
        assertEquals(17, new Time(10, 16).getMinute(1));
    }

    @Test
    void testGetMinutePlus5() {
        assertEquals(3, new Time(10, 58).getMinute(5));
    }

    @Test
    void testGetMinuteMinus7() {
        assertEquals(58, new Time(10, 5).getMinute(-7));
    }

    @Test
    void testGetMinuteMinus77() {
        assertEquals(48, new Time(10, 5).getMinute(-77));
    }

    @Test
    void testGetMinuteMinus30() {
        assertEquals(25, new Time(10, 55).getMinute(-30));
    }

    @Test
    void getTime() {
        assertEquals("10:16", new Time(10, 16).getTime());
    }
}