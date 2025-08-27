package org.jacekziemianski.bst;

public class DefaultRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public DefaultRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return true;
    }

    @Override
    public String generate(Time time) {
        return britishDictionaries.getHour(time.getHour()) + " " + britishDictionaries.getMinute(time.getMinute());
    }
}
