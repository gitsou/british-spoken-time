package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SpokenTimeTest {
    private List<OutputRule> outputRules;

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
    }

    @org.junit.jupiter.api.Test
    void testToString0100() {
        assertEquals("one o'clock", new SpokenTime(outputRules, 1, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0205() {
        assertEquals("five past two", new SpokenTime(outputRules, 2, 5).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0310() {
        assertEquals("ten past three", new SpokenTime(outputRules, 3, 10).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0415() {
        assertEquals("quarter past four", new SpokenTime(outputRules, 4, 15).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0520() {
        assertEquals("twenty past five", new SpokenTime(outputRules, 5, 20).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0625() {
        assertEquals("twenty-five past six", new SpokenTime(outputRules, 6, 25).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0632() {
        assertEquals("six thirty-two", new SpokenTime(outputRules, 6, 32).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0730() {
        assertEquals("half past seven", new SpokenTime(outputRules, 7, 30).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0735() {
        assertEquals("twenty-five to eight", new SpokenTime(outputRules, 7, 35).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0840() {
        assertEquals("twenty to nine", new SpokenTime(outputRules, 8, 40).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0945() {
        assertEquals("quarter to ten", new SpokenTime(outputRules, 9, 45).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1050() {
        assertEquals("ten to eleven", new SpokenTime(outputRules, 10, 50).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1155() {
        assertEquals("five to twelve", new SpokenTime(outputRules, 11, 55).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0000() {
        assertEquals("midnight", new SpokenTime(outputRules, 0, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1200() {
        assertEquals("noon", new SpokenTime(outputRules, 12, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1245() {
        assertEquals("quarter to one", new SpokenTime(outputRules, 12, 45).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0015() {
        assertEquals("quarter past midnight", new SpokenTime(outputRules, 0, 15).toString());
    }
}