package org.jacekziemianski.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void testTimeCreate() {
        Time time = new Time(5, 32);
        assertEquals(5, time.getHour());
        assertEquals(32, time.getMinute());
    }

    @Test
    void testTimeCreateWrongMinute() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Time(5, 72);
        });
    }

    @Test
    void testTimeCreateWrongHour() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Time(30, 0);
        });
    }

    @Test
    void testGetHour() {
        assertEquals(10, new Time(10, 16).getHour());
    }

    @Test
    void testGetHourAdd1() {
        assertEquals(11, new Time(10, 16).getHour(1));
    }

    @Test
    void testGetHourSubLess0() {
        assertEquals(23, new Time(1, 16).getHour(-2));
    }

    @Test
    void testGetHourSub27() {
        assertEquals(22, new Time(1, 16).getHour(-27));
    }

    @Test
    void testGetMinute() {
        assertEquals(16, new Time(10, 16).getMinute());
    }

    @Test
    void testGetMinuteAdd1() {
        assertEquals(17, new Time(10, 16).getMinute(1));
    }

    @Test
    void testGetMinuteAddOver60() {
        assertEquals(3, new Time(10, 58).getMinute(5));
    }

    @Test
    void testGetMinuteSubLess0() {
        assertEquals(58, new Time(10, 5).getMinute(-7));
    }

    @Test
    void testGetMinuteSub7() {
        assertEquals(58, new Time(10, 5).getMinute(-7));
    }

    @Test
    void testGetMinuteSub77() {
        assertEquals(48, new Time(10, 5).getMinute(-77));
    }

    @Test
    void getTime() {
        assertEquals("10:16", new Time(10, 16).getTime());
    }
}