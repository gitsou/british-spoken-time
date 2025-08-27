package org.jacekziemianski.bst;

/**
 * Rule for times with minutes less the 30 (e.g., 10:16).
 */
public class MinutePastRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public MinutePastRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return time.getMinute() % 5 == 0 && time.getMinute() < 30;
    }

    @Override
    public String generate(Time time) {
        return britishDictionaries.getMinuteWord(time.getMinute()) + " past " + britishDictionaries.getHourWord(time.getHour());
    }
}
