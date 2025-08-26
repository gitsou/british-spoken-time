package org.jacekziemianski.bst;

public class HalfHourRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public HalfHourRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 30;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return "half past " + numbersToWords.getHour(spokenTime.getHour());
    }
}
