package org.jacekziemianski.bst;

public class HourRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public HourRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return time.getMinute() == 0;
    }

    @Override
    public String generate(Time time) {
        return britishDictionaries.getHour(time.getHour()) + " o'clock";
    }
}
