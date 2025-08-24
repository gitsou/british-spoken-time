package org.jacekziemianski.bst;

public interface OutputRule {
    boolean appliesTo(BritishSpokenTime bst);

    String generate(BritishSpokenTime bst);
}
