package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinuteToRuleTest {
    private MinuteToRule minuteToRule;

    @BeforeEach
    void setUp() {
        minuteToRule = new MinuteToRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(minuteToRule.appliesTo(new Time(11, 50)));
    }

    @Test
    void appliesToFalse() {
        assertFalse(minuteToRule.appliesTo(new Time(11, 10)));
    }

    @Test
    void generate() {
        assertEquals("ten to twelve", minuteToRule.generate(new Time(11, 50)));
    }
}