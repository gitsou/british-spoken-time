package org.jacekziemianski.bst;

/**
 * Represents a rule to generate a spoken form.
 */
public interface OutputRule {
    boolean appliesTo(Time time);

    String generate(Time time);
}
