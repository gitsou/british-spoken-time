package org.jacekziemianski.bst;

public class NumbersToWords {
    private static final String[] hourWords = {
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
    private static final String[] minuteWords = {
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

    public static String getHourWord(int hour) {
        if (hour >= 0 && hour < hourWords.length) {
            return hourWords[hour];
        } else {
            return "";
        }
    }

    public static String getNextHourWord(int hour) {
        return getHourWord((hour + 1) % 12);
    }

    public static String getMinuteWord(int minute) {
        if (minute >= 0 && minute < minuteWords.length) {
            return minuteWords[minute];
        } else {
            return "";
        }
    }

    public static String getMinuteToWord(int minute) {
        return getMinuteWord((30 - (minute - 30)) % 60);
    }
}
