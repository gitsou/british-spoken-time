package org.jacekziemianski.bst;

public class DefaultRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public DefaultRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return true;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return britishDictionaries.getHour(spokenTime.getHour()) + " " + britishDictionaries.getMinute(spokenTime.getMinute());
    }
}
