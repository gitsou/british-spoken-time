package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuarterToRuleTest {
    private QuarterToRule quarterToRule;

    @BeforeEach
    void setUp() {
        quarterToRule = new QuarterToRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(quarterToRule.appliesTo(new Time(11, 45)));
    }

    @Test
    void appliesToFalse() {
        assertFalse(quarterToRule.appliesTo(new Time(11, 46)));
    }

    @Test
    void generate() {
        assertEquals("quarter to twelve", quarterToRule.generate(new Time(11, 45)));
    }
}