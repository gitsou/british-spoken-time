package org.jacekziemianski.bst;

public interface OutputRule {
    boolean appliesTo(SpokenTime bst);

    String generate(SpokenTime bst);
}
