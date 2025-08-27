package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HalfHourRuleTest {
    private HalfHourRule halfHourRule;

    @BeforeEach
    void setUp() {
        halfHourRule = new HalfHourRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(halfHourRule.appliesTo(new Time(11, 30)));
    }

    @Test
    void appliesToFalse() {
        assertFalse(halfHourRule.appliesTo(new Time(11, 1)));
    }

    @Test
    void generate() {
        assertEquals("half past ten", halfHourRule.generate(new Time(10, 30)));
    }
}