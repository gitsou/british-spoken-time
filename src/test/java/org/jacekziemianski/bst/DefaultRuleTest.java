package org.jacekziemianski.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultRuleTest {
    private DefaultRule defaultRule;

    @BeforeEach
    void setUp() {
        defaultRule = new DefaultRule(new BritishDictionaries());
    }

    @Test
    void appliesToTrue() {
        assertTrue(defaultRule.appliesTo(new Time(11, 30)));
    }

    @Test
    void generate() {
        assertEquals("ten thirty", defaultRule.generate(new Time(10, 30)));
    }
}