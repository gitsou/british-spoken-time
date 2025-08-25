package org.jacekziemianski.bst;

public class SpecialHourRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return (bst.getMinute() == 0 && bst.getHour() == 0)
                || (bst.getMinute() == 0 && bst.getHour() == 12);
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return NumbersToWords.getHourWord(bst.getHour());
    }
}
