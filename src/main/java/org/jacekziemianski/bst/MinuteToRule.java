package org.jacekziemianski.bst;

public class MinuteToRule implements OutputRule {
    private final NumbersToWords numbersToWords;

    public MinuteToRule(NumbersToWords numbersToWords) {
        this.numbersToWords = numbersToWords;
    }

    @Override
    public boolean appliesTo(SpokenTime spokenTime) {
        return spokenTime.getMinute() % 5 == 0 && spokenTime.getMinute() > 30;
    }

    @Override
    public String generate(SpokenTime spokenTime) {
        return numbersToWords.getMinute(30 - spokenTime.getMinute(-30)) + " to " + numbersToWords.getHour(spokenTime.getHour(+1) % 12);
    }
}
