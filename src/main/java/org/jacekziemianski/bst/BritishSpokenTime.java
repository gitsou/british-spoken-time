package org.jacekziemianski.bst;

import java.util.List;

public class BritishSpokenTime {
    private final int hour;
    private final int minute;
    private final String output;
    private final List<OutputRule> outputRules;
    private final String[] hourWords = {
            "midnight",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "noon"
    };
    private final String[] minuteWords = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty-one",
            "twenty-two",
            "twenty-three",
            "twenty-four",
            "twenty-five",
            "twenty-six",
            "twenty-seven",
            "twenty-eight",
            "twenty-nine",
            "thirty",
            "thirty-one",
            "thirty-two",
            "thirty-three",
            "thirty-four",
            "thirty-five",
            "thirty-six",
            "thirty-seven",
            "thirty-eight",
            "thirty-nine",
            "forty",
            "forty-one",
            "forty-two",
            "forty-three",
            "forty-four",
            "forty-five",
            "forty-six",
            "forty-seven",
            "forty-eight",
            "forty-nine",
            "fifty",
            "fifty-one",
            "fifty-two",
            "fifty-three",
            "fifty-four",
            "fifty-five",
            "fifty-six",
            "fifty-seven",
            "fifty-eight",
            "fifty-nine"
    };

    public BritishSpokenTime(List<OutputRule> outputRules, int hour, int minute) {
        this.outputRules = outputRules;
        this.hour = hour;
        this.minute = minute;
        this.output = generateOutput();
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String[] getHourWords() {
        return hourWords;
    }

    public String[] getMinuteWords() {
        return minuteWords;
    }


    public String generateOutput() {
        return outputRules.stream()
                .filter(s -> s.appliesTo(this))
                .findFirst()
                .map(s -> s.generate(this))
                .orElse("Default output");
    }

    @Override
    public String toString() {
        return output;
    }
}
