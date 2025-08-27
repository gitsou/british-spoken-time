package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BritishDictionariesTest {
    private BritishDictionaries britishDictionaries;

    @BeforeEach
    void setUp() {
        britishDictionaries = new BritishDictionaries();
    }

    @Test
    void getHourMidnight() {
        assertEquals("midnight", britishDictionaries.getHour(0));
    }

    @Test
    void getHour1() {
        assertEquals("one", britishDictionaries.getHour(1));
    }

    @Test
    void getHour12() {
        assertEquals("twelve", britishDictionaries.getHour(12));
    }

    @Test
    void getHour23() {
        assertEquals("eleven", britishDictionaries.getHour(23));
    }

    @Test
    void getHour25() {
        assertEquals("one", britishDictionaries.getHour(25));
    }

    @Test
    void getHourNegativeNumber() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> britishDictionaries.getHour(-1));
    }

    @Test
    void getMinute0() {
        assertEquals("zero", britishDictionaries.getMinute(0));
    }

    @Test
    void getMinute1() {
        assertEquals("one", britishDictionaries.getMinute(1));
    }

    @Test
    void getMinute12() {
        assertEquals("twelve", britishDictionaries.getMinute(12));
    }

    @Test
    void getMinute23() {
        assertEquals("twenty-three", britishDictionaries.getMinute(23));
    }

    @Test
    void getMinute25() {
        assertEquals("twenty-five", britishDictionaries.getMinute(25));
    }

    @Test
    void getMinute59() {
        assertEquals("fifty-nine", britishDictionaries.getMinute(59));
    }

    @Test
    void getMinuteNegativeNumber() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> britishDictionaries.getMinute(-1));
    }

    @Test
    void getMinuteToBigNumber() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> britishDictionaries.getMinute(70));
    }

    @Test
    void getSpecialWord() {
        assertEquals("midnight", britishDictionaries.getSpecialWord("00:00"));
    }

    @Test
    void getSpecialWordNotExists() {
        assertNull(britishDictionaries.getSpecialWord("bla"));
    }
}