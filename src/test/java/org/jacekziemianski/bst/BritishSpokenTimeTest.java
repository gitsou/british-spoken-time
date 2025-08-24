package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BritishSpokenTimeTest {
    private List<OutputRule> outputRules;

    @BeforeEach
    void setUp() {
        outputRules = List.of(
                new SpecialHourRule(),
                new HourRule(),
                new QuarterPastRule(),
                new QuarterToRule(),
                new HalfHourRule(),
                new MinutePastRule(),
                new MinuteToRule(),
                new DefaultRule()
        );
    }

    @org.junit.jupiter.api.Test
    void testToString0100() {
        assertEquals("one o'clock", new BritishSpokenTime(outputRules, 1, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0205() {
        assertEquals("five past two", new BritishSpokenTime(outputRules, 2, 5).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0310() {
        assertEquals("ten past three", new BritishSpokenTime(outputRules, 3, 10).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0415() {
        assertEquals("quarter past four", new BritishSpokenTime(outputRules, 4, 15).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0520() {
        assertEquals("twenty past five", new BritishSpokenTime(outputRules, 5, 20).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0625() {
        assertEquals("twenty-five past six", new BritishSpokenTime(outputRules, 6, 25).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0632() {
        assertEquals("six thirty-two", new BritishSpokenTime(outputRules, 6, 32).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0730() {
        assertEquals("half past seven", new BritishSpokenTime(outputRules, 7, 30).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0735() {
        assertEquals("twenty-five to eight", new BritishSpokenTime(outputRules, 7, 35).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0840() {
        assertEquals("twenty to nine", new BritishSpokenTime(outputRules, 8, 40).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0945() {
        assertEquals("quarter to ten", new BritishSpokenTime(outputRules, 9, 45).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1050() {
        assertEquals("ten to eleven", new BritishSpokenTime(outputRules, 10, 50).toString());
    }

//    @org.junit.jupiter.api.Test
//    void testToString1155() {
//        assertEquals("five to twelve", new BritishSpokenTime(outputRules,11, 55).toString());
//    }

    @org.junit.jupiter.api.Test
    void testToString0000() {
        assertEquals("midnight", new BritishSpokenTime(outputRules, 0, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1200() {
        assertEquals("noon", new BritishSpokenTime(outputRules, 12, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1245() {
        assertEquals("quarter to one", new BritishSpokenTime(outputRules, 12, 45).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0015() {
        assertEquals("quarter past midnight", new BritishSpokenTime(outputRules, 0, 15).toString());
    }
}