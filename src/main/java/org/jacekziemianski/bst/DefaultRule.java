package org.jacekziemianski.bst;

public class DefaultRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public DefaultRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return true;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return numbersToWords.getHour(spokenTime.getHour()) + " " + numbersToWords.getMinute(spokenTime.getMinute());
    }
}
