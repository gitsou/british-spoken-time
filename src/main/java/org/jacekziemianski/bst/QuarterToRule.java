package org.jacekziemianski.bst;

public class QuarterToRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public QuarterToRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() == 45;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return "quarter to " + numbersToWords.getHour(spokenTime.getHour(1) % 12);
    }
}
