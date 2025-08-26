package org.jacekziemianski.bst;

public class MinutePastRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public MinutePastRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() % 5 == 0 && spokenTime.getMinute() < 30;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return numbersToWords.getMinute(spokenTime.getMinute()) + " past " + numbersToWords.getHour(spokenTime.getHour());
    }
}
