package org.jacekziemianski.bst;

public class MinutePastRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public MinutePastRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() % 5 == 0 && spokenTime.getMinute() < 30;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return britishDictionaries.getMinute(spokenTime.getMinute()) + " past " + britishDictionaries.getHour(spokenTime.getHour());
    }
}
