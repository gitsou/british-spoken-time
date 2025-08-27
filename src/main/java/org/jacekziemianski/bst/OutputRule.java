package org.jacekziemianski.bst;

public interface OutputRule {
    boolean appliesTo(Time time);

    String generate(Time time);
}
