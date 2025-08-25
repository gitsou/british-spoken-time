package org.jacekziemianski.bst;

public class DefaultRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return true;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return NumbersToWords.getHourWord(bst.getHour()) + " " + NumbersToWords.getMinuteWord(bst.getMinute());
    }
}
