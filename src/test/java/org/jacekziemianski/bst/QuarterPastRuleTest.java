package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuarterPastRuleTest {
    private QuarterPastRule quarterPastRule;

    @BeforeEach
    void setUp() {
        quarterPastRule = new QuarterPastRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(quarterPastRule.appliesTo(new Time(11, 15)));
    }

    @Test
    void appliesToFalse() {
        assertFalse(quarterPastRule.appliesTo(new Time(11, 16)));
    }

    @Test
    void generate() {
        assertEquals("quarter past eleven", quarterPastRule.generate(new Time(11, 15)));
    }
}