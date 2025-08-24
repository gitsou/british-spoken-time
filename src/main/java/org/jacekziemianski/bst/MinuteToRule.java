package org.jacekziemianski.bst;

public class MinuteToRule implements OutputRule {
    @Override
    public boolean appliesTo(BritishSpokenTime bst) {
        return bst.getMinute() % 5 == 0 && bst.getMinute() > 30;
    }

    @Override
    public String generate(BritishSpokenTime bst) {
        return bst.getMinuteWords()[(30 - (bst.getMinute() - 30)) % 60] + " to " + bst.getHourWords()[(bst.getHour() + 1) % 12];
    }
}
