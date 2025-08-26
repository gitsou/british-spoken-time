package org.jacekziemianski.bst;

public class HourRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public HourRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 0;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return numbersToWords.getHour(spokenTime.getHour()) + " o'clock";
    }
}
