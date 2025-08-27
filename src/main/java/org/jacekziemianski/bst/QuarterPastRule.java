package org.jacekziemianski.bst;

public class QuarterPastRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public QuarterPastRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 15;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return "quarter past " + britishDictionaries.getHour(spokenTime.getHour());
    }
}
