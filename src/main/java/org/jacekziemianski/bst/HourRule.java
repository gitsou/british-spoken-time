package org.jacekziemianski.bst;

public class HourRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return bst.getMinute() == 0;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return bst.getHourWords()[bst.getHour()] + " o'clock";
    }
}
