package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourRuleTest {
    private HourRule hourRule;

    @BeforeEach
    void setUp() {
        hourRule = new HourRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(hourRule.appliesTo(new Time(11, 0)));
    }

    @Test
    void appliesToFalse() {
        assertFalse(hourRule.appliesTo(new Time(11, 1)));
    }

    @Test
    void generate() {
        assertEquals("ten o'clock", hourRule.generate(new Time(10, 0)));
    }
}