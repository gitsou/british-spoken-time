package org.jacekziemianski.bst;

public class HourRule implements OutputRule {
    private final BritishDictionaries britishDictionaries;

    public HourRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 0;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return britishDictionaries.getHour(spokenTime.getHour()) + " o'clock";
    }
}
