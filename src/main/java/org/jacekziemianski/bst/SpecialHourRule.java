package org.jacekziemianski.bst;

/**
 * Rule to match special cases like "midnight" or "noon"
 */
public class SpecialHourRule implements OutputRule {
    private final Dictionaries britishDictionaries;

    public SpecialHourRule(BritishDictionaries britishDictionaries) {
        this.britishDictionaries = britishDictionaries;
    }

    @Override
    public boolean appliesTo(Time time) {
        return (time.getMinute() == 0 && time.getHour() == 0) || (time.getMinute() == 0 && time.getHour() == 12);
    }

    @Override
    public String generate(Time time) {
        return britishDictionaries.getSpecialWord(time.getTime());
    }
}
