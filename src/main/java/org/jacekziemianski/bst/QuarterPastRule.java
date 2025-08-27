package org.jacekziemianski.bst;

/**
 * Rule for times that are 15 minutes after the full hour (e.g., 10:15).
 */
public class QuarterPastRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public QuarterPastRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return time.getMinute() == 15;
    }

    @Override
    public String generate(Time time) {
        return "quarter past " + britishDictionaries.getHourWord(time.getHour());
    }
}
