package org.jacekziemianski.bst;

/**
 * Rule for times when the minute is exactly 30 (e.g., 10:30).
 */
public class HalfHourRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public HalfHourRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return time.getMinute() == 30;
    }

    @Override
    public String generate(Time time) {
        return "half past " + britishDictionaries.getHourWord(time.getHour());
    }
}
