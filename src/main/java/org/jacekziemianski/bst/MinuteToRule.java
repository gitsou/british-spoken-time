package org.jacekziemianski.bst;

public class MinuteToRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public MinuteToRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return time.getMinute() % 5 == 0 && time.getMinute() > 30;
    }

    @Override
    public String generate(Time time) {
        return britishDictionaries.getMinute(30 - time.getMinute(-30)) + " to " + britishDictionaries.getHour(time.getHour(+1));
    }
}
