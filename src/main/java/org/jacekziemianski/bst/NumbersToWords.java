package org.jacekziemianski.bst;

import java.util.Map;

public class NumbersToWords {

    private final Map<String, String> specialWords = Map.of(
            "00:00", "midnight",
            "12:00", "noon"
    );
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
            "twenty-three"
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

    public String getHour(int hour) {
        return hourWords[hour];
    }

    public String getMinute(int minute) {
        return minuteWords[minute];
    }

    public String getSpecialWord(String key) {
        return specialWords.get(key);
    }
}
