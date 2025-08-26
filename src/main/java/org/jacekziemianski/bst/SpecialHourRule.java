package org.jacekziemianski.bst;

public class SpecialHourRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public SpecialHourRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return (spokenTime.getMinute() == 0 && spokenTime.getHour() == 0) || (spokenTime.getMinute() == 0 && spokenTime.getHour() == 12);
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return numbersToWords.getSpecialWord(spokenTime.getTime());
    }
}
