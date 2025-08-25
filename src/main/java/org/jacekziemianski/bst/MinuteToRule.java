package org.jacekziemianski.bst;

public class MinuteToRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return bst.getMinute() % 5 == 0 && bst.getMinute() > 30;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return NumbersToWords.getMinuteToWord(bst.getMinute()) + " to " + NumbersToWords.getNextHourWord(bst.getHour());
    }
}
