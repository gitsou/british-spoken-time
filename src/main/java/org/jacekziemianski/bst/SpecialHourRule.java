package org.jacekziemianski.bst;

public class SpecialHourRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public SpecialHourRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return (spokenTime.getMinute() == 0 && spokenTime.getHour() == 0) || (spokenTime.getMinute() == 0 && spokenTime.getHour() == 12);
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return britishDictionaries.getSpecialWord(spokenTime.getTime());
    }
}
