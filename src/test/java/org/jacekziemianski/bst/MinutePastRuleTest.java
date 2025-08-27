package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinutePastRuleTest {
    private MinutePastRule minutePastRule;

    @BeforeEach
    void setUp() {
        minutePastRule = new MinutePastRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(minutePastRule.appliesTo(new Time(11, 5)));
    }

    @Test
    void appliesToFalse() {
        assertFalse(minutePastRule.appliesTo(new Time(11, 6)));
    }

    @Test
    void generate() {
        assertEquals("ten past eleven", minutePastRule.generate(new Time(11, 10)));
    }
}