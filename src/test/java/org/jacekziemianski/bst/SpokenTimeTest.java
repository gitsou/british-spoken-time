package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpokenTimeTest {
    private List<OutputRule> outputRules;
    private TimeArgumentsParser timeArgumentsParser;

    @BeforeEach
    void setUp() {
        BritishDictionaries britishDictionaries = new BritishDictionaries();
        outputRules = List.of(
                new SpecialHourRule(britishDictionaries),
                new HourRule(britishDictionaries),
                new QuarterPastRule(britishDictionaries),
                new QuarterToRule(britishDictionaries),
                new HalfHourRule(britishDictionaries),
                new MinutePastRule(britishDictionaries),
                new MinuteToRule(britishDictionaries),
                new DefaultRule(britishDictionaries)
        );
        timeArgumentsParser = new TimeArgumentsParser();
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0100() {
        String[] args = {"1:00"};
        assertEquals("one o'clock", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0205() {
        String[] args = {"02:05"};
        assertEquals("five past two", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0310() {
        String[] args = {"3:10"};
        assertEquals("ten past three", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0415() {
        String[] args = {"4:15"};
        assertEquals("quarter past four", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0520() {
        String[] args = {"05:20"};
        assertEquals("twenty past five", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0625() {
        String[] args = {"06:25"};
        assertEquals("twenty-five past six", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0632() {
        String[] args = {"6:32"};
        assertEquals("six thirty-two", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0730() {
        String[] args = {"07:30"};
        assertEquals("half past seven", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0735() {
        String[] args = {"07:35"};
        assertEquals("twenty-five to eight", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0840() {
        String[] args = {"8:40"};
        assertEquals("twenty to nine", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0945() {
        String[] args = {"9:45"};
        assertEquals("quarter to ten", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime1050() {
        String[] args = {"10:50"};
        assertEquals("ten to eleven", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime1155() {
        String[] args = {"11:55"};
        assertEquals("five to twelve", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0000() {
        String[] args = {"00:00"};
        assertEquals("midnight", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime1200() {
        String[] args = {"12:00"};
        assertEquals("noon", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime1245() {
        String[] args = {"12:45"};
        assertEquals("quarter to one", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0015() {
        String[] args = {"0:15"};
        assertEquals("quarter past midnight", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime1427() {
        String[] args = {"14:27"};
        assertEquals("two twenty-seven", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime2015() {
        String[] args = {"20:15"};
        assertEquals("quarter past eight", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime2355() {
        String[] args = {"23:55"};
        assertEquals("five to midnight", new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime2500() {
        String[] args = {"25:00"};
        assertThrows(IllegalArgumentException.class, () -> {
            new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args);
        });
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTimeAabb() {
        String[] args = {"aabbccdd"};
        assertThrows(IllegalArgumentException.class, () -> {
            new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args);
        });
    }

    @org.junit.jupiter.api.Test
    void testgenerateSpokenTime0000_() {
        String[] args = {"0000:"};
        assertThrows(IllegalArgumentException.class, () -> {
            new SpokenTime(outputRules, timeArgumentsParser).generateSpokenTime(args);
        });
    }
}