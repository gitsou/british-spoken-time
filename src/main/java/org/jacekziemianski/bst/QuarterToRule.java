package org.jacekziemianski.bst;

public class QuarterToRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return bst.getMinute() == 45;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return "quarter to " + bst.getHourWords()[(bst.getHour() + 1) % 12];
    }
}
