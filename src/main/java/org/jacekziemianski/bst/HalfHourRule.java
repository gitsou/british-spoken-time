package org.jacekziemianski.bst;

public class HalfHourRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return bst.getMinute() == 30;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return "half past " + bst.getHourWords()[bst.getHour()];
    }
}
