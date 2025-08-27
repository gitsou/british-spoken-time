package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialHourRuleTest {
    private SpecialHourRule specialHourRule;

    @BeforeEach
    void setUp() {
        specialHourRule = new SpecialHourRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(specialHourRule.appliesTo(new Time(12, 0)));
    }

    @Test
    void appliesToFalse() {
        assertFalse(specialHourRule.appliesTo(new Time(11, 0)));
    }

    @Test
    void generate() {
        assertEquals("noon", specialHourRule.generate(new Time(12, 0)));
    }

    @Test
    void generateNull() {
        assertNull(specialHourRule.generate(new Time(11, 0)));
    }
}