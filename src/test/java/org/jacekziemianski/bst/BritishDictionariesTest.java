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
    void getHour() {
        assertEquals("midnight", britishDictionaries.getHour(0));
        assertEquals("one", britishDictionaries.getHour(1));
        assertEquals("twelve", britishDictionaries.getHour(12));
        assertEquals("eleven", britishDictionaries.getHour(23));

        assertEquals("one", britishDictionaries.getHour(25));
    }

    @Test
    void getHourNegativeCases() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            britishDictionaries.getHour(-1);
        });
    }

    @Test
    void getMinute() {
        assertEquals("zero", britishDictionaries.getMinute(0));
        assertEquals("one", britishDictionaries.getMinute(1));
        assertEquals("twelve", britishDictionaries.getMinute(12));
        assertEquals("twenty-three", britishDictionaries.getMinute(23));

        assertEquals("twenty-five", britishDictionaries.getMinute(25));
        assertEquals("fifty-nine", britishDictionaries.getMinute(59));
    }

    @Test
    void getMinuteNegativeCases() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            britishDictionaries.getMinute(-1);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            britishDictionaries.getMinute(70);
        });
    }

    @Test
    void getSpecialWord() {
    }
}