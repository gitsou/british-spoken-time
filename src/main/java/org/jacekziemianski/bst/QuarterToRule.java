package org.jacekziemianski.bst;

public class QuarterToRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public QuarterToRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return time.getMinute() == 45;
    }

    @Override
    public String generate(Time time) {
        return "quarter to " + britishDictionaries.getHourWord(time.getAdjustedHour(1));
    }
}
