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
    void getHourWordMidnight() {
        assertEquals("midnight", britishDictionaries.getHourWord(0));
    }

    @Test
    void getHourWord1() {
        assertEquals("one", britishDictionaries.getHourWord(1));
    }

    @Test
    void getHourWord12() {
        assertEquals("twelve", britishDictionaries.getHourWord(12));
    }

    @Test
    void getHourWord23() {
        assertEquals("eleven", britishDictionaries.getHourWord(23));
    }

    @Test
    void getHourWord25() {
        assertEquals("one", britishDictionaries.getHourWord(25));
    }

    @Test
    void getHourWordNegativeNumber() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> britishDictionaries.getHourWord(-1));
    }

    @Test
    void getMinuteWord0() {
        assertEquals("zero", britishDictionaries.getMinuteWord(0));
    }

    @Test
    void getMinuteWord1() {
        assertEquals("one", britishDictionaries.getMinuteWord(1));
    }

    @Test
    void getMinuteWord12() {
        assertEquals("twelve", britishDictionaries.getMinuteWord(12));
    }

    @Test
    void getMinuteWord23() {
        assertEquals("twenty-three", britishDictionaries.getMinuteWord(23));
    }

    @Test
    void getMinuteWord25() {
        assertEquals("twenty-five", britishDictionaries.getMinuteWord(25));
    }

    @Test
    void getMinuteWord59() {
        assertEquals("fifty-nine", britishDictionaries.getMinuteWord(59));
    }

    @Test
    void getMinuteWordNegativeNumber() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> britishDictionaries.getMinuteWord(-1));
    }

    @Test
    void getMinuteWordToBigNumber() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> britishDictionaries.getMinuteWord(70));
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