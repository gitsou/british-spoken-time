package org.jacekziemianski.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeArgumentsParserTest {

    @Test
    void parse1134() {
        TimeArgumentsParser timeArgumentsParser = new TimeArgumentsParser();
        Time time = timeArgumentsParser.parse(new String[]{"11:34"});
        assertEquals(11, time.getHour());
        assertEquals(34, time.getMinute());
    }

    @Test
    void parse0000() {
        TimeArgumentsParser timeArgumentsParser = new TimeArgumentsParser();
        Time time = timeArgumentsParser.parse(new String[]{"00:00"});
        assertEquals(0, time.getHour());
        assertEquals(0, time.getMinute());
    }

    @Test
    void parse2359() {
        TimeArgumentsParser timeArgumentsParser = new TimeArgumentsParser();
        Time time = timeArgumentsParser.parse(new String[]{"23:59"});
        assertEquals(23, time.getHour());
        assertEquals(59, time.getMinute());
    }

    @Test
    void parse1200() {
        TimeArgumentsParser timeArgumentsParser = new TimeArgumentsParser();
        Time time = timeArgumentsParser.parse(new String[]{"12:00"});
        assertEquals(12, time.getHour());
        assertEquals(0, time.getMinute());
    }

    @Test
    void parseText() {
        TimeArgumentsParser timeArgumentsParser = new TimeArgumentsParser();
        assertThrows(IllegalArgumentException.class, () -> timeArgumentsParser.parse(new String[]{"aaaaaaaaaaaaaaaa"}));
    }

    @Test
    void parseWrongValue() {
        TimeArgumentsParser timeArgumentsParser = new TimeArgumentsParser();
        assertThrows(IllegalArgumentException.class, () -> timeArgumentsParser.parse(new String[]{"30:99"}));
    }

    @Test
    void parseNull() {
        TimeArgumentsParser timeArgumentsParser = new TimeArgumentsParser();
        assertThrows(IllegalArgumentException.class, () -> timeArgumentsParser.parse(null));
    }
}