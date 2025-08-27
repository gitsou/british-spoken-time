package org.jacekziemianski.bst;

public class MinuteToRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public MinuteToRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() % 5 == 0 && spokenTime.getMinute() > 30;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return britishDictionaries.getMinute(30 - spokenTime.getMinute(-30)) + " to " + britishDictionaries.getHour(spokenTime.getHour(+1) % 12);
    }
}
