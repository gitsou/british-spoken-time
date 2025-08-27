package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SpokenTimeTest {
    private List<OutputRule> outputRules;
    private TimeArgumentsParser timeArgumentsParser;

    @BeforeEach
    void setUp() {
        final Map<String, String> specialWords = Map.of(
                "00:00", "midnight",
                "12:00", "noon"
        );
        final String[] hourWords = {
                "midnight",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty-one",
                "twenty-two",
                "twenty-three"
        };
        final String[] minuteWords = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty-one",
                "twenty-two",
                "twenty-three",
                "twenty-four",
                "twenty-five",
                "twenty-six",
                "twenty-seven",
                "twenty-eight",
                "twenty-nine",
                "thirty",
                "thirty-one",
                "thirty-two",
                "thirty-three",
                "thirty-four",
                "thirty-five",
                "thirty-six",
                "thirty-seven",
                "thirty-eight",
                "thirty-nine",
                "forty",
                "forty-one",
                "forty-two",
                "forty-three",
                "forty-four",
                "forty-five",
                "forty-six",
                "forty-seven",
                "forty-eight",
                "forty-nine",
                "fifty",
                "fifty-one",
                "fifty-two",
                "fifty-three",
                "fifty-four",
                "fifty-five",
                "fifty-six",
                "fifty-seven",
                "fifty-eight",
                "fifty-nine"
        };
        BritishDictionaries britishDictionaries = new BritishDictionaries(specialWords, hourWords, minuteWords);
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
    void testToString0100() {
        String[] args = {"1:00"};
        assertEquals("one o'clock", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0205() {
        String[] args = {"02:05"};
        assertEquals("five past two", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0310() {
        String[] args = {"3:10"};
        assertEquals("ten past three", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0415() {
        String[] args = {"4:15"};
        assertEquals("quarter past four", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0520() {
        String[] args = {"05:20"};
        assertEquals("twenty past five", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0625() {
        String[] args = {"06:25"};
        assertEquals("twenty-five past six", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0632() {
        String[] args = {"6:32"};
        assertEquals("six thirty-two", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0730() {
        String[] args = {"07:30"};
        assertEquals("half past seven", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0735() {
        String[] args = {"07:35"};
        assertEquals("twenty-five to eight", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0840() {
        String[] args = {"8:40"};
        assertEquals("twenty to nine", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0945() {
        String[] args = {"9:45"};
        assertEquals("quarter to ten", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString1050() {
        String[] args = {"10:50"};
        assertEquals("ten to eleven", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString1155() {
        String[] args = {"11:55"};
        assertEquals("five to twelve", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0000() {
        String[] args = {"00:00"};
        assertEquals("midnight", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString1200() {
        String[] args = {"12:00"};
        assertEquals("noon", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString1245() {
        String[] args = {"12:45"};
        assertEquals("quarter to one", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }

    @org.junit.jupiter.api.Test
    void testToString0015() {
        String[] args = {"0:15"};
        assertEquals("quarter past midnight", new SpokenTime(outputRules, timeArgumentsParser).getSpokenTime(args));
    }
}