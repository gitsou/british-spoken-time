package org.jacekziemianski.bst;

import static org.junit.jupiter.api.Assertions.*;

class BritishSpokenTimeTest {

    @org.junit.jupiter.api.Test
    void testToString0100() {
        assertEquals("one o'clock", new BritishSpokenTime(1, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0205() {
        assertEquals("five past two", new BritishSpokenTime(2, 5).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0310() {
        assertEquals("ten past three", new BritishSpokenTime(3, 10).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0415() {
        assertEquals("quarter past four", new BritishSpokenTime(4, 15).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0520() {
        assertEquals("twenty past five", new BritishSpokenTime(5, 20).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0625() {
        assertEquals("twenty-five past six", new BritishSpokenTime(6, 25).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0632() {
        assertEquals("six thirty-two", new BritishSpokenTime(6, 32).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0730() {
        assertEquals("half past seven", new BritishSpokenTime(7, 30).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0735() {
        assertEquals("twenty-five to eight", new BritishSpokenTime(7, 35).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0840() {
        assertEquals("twenty to nine", new BritishSpokenTime(8, 40).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0945() {
        assertEquals("quarter to ten", new BritishSpokenTime(9, 45).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1050() {
        assertEquals("ten to eleven", new BritishSpokenTime(10, 50).toString());
    }

//    @org.junit.jupiter.api.Test
//    void testToString1155() {
//        assertEquals("five to twelve", new BritishSpokenTime(11, 55).toString());
//    }

    @org.junit.jupiter.api.Test
    void testToString0000() {
        assertEquals("midnight", new BritishSpokenTime(0, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1200() {
        assertEquals("noon", new BritishSpokenTime(12, 0).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString1245() {
        assertEquals("quarter to one", new BritishSpokenTime(12, 45).toString());
    }

    @org.junit.jupiter.api.Test
    void testToString0015() {
        assertEquals("quarter past midnight", new BritishSpokenTime(0, 15).toString());
    }
}