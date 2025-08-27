package org.jacekziemianski.bst;

public class HalfHourRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public HalfHourRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 30;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return "half past " + britishDictionaries.getHour(spokenTime.getHour());
    }
}
