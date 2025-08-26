package org.jacekziemianski.bst;

public class QuarterPastRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public QuarterPastRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 15;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return "quarter past " + numbersToWords.getHour(spokenTime.getHour());
    }
}
