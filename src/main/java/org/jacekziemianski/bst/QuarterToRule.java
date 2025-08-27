package org.jacekziemianski.bst;

public class QuarterToRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public QuarterToRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 45;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return "quarter to " + britishDictionaries.getHour(spokenTime.getHour(1));
    }
}
