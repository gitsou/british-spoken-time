package org.jacekziemianski.bst;

public class QuarterPastRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public QuarterPastRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return time.getMinute() == 15;
    }

    @Override
    public String generate(Time time) {
        return "quarter past " + britishDictionaries.getHour(time.getHour());
    }
}
