package org.jacekziemianski.bst;

/**
 * Fallback rule that applies when no other rules match.
 */
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
        return britishDictionaries.getHourWord(time.getHour()) + " " + britishDictionaries.getMinuteWord(time.getMinute());
    }
}
