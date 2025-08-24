package org.jacekziemianski.bst;

public class MinutePastRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return bst.getMinute() % 5 == 0 && bst.getMinute() < 30;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return bst.getMinuteWords()[bst.getMinute()] + " past " + bst.getHourWords()[bst.getHour()];
    }
}
