package org.jacekziemianski.bst;

public class QuarterPastRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return bst.getMinute() == 15;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return "quarter past " + bst.getHourWords()[bst.getHour()];
    }
}
