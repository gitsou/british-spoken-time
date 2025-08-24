package org.jacekziemianski.bst;

public class BritishSpokenTime {
    private final int hour;
    private final int minutes;
    private final String output;
    private final String[] hoursWords = {
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
    private final String[] minutesWords = {
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

    public BritishSpokenTime(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
        this.output = generateOutput();
    }

    private String generateOutput() {
        String result = "";
        if (minutes == 0) {
            result = hoursWords[hour];

            if (hour != 0 && hour != 12) {
                result += " o'clock";
            }
        } else if (minutes % 15 == 0) {
            if (minutes == 15) {
                result = "quarter past " + hoursWords[hour];
            } else if (minutes == 45) {
                result = "quarter to " + hoursWords[(hour + 1) % 12];
            } else {
                result = "half past " + hoursWords[hour];
            }
        } else if (minutes % 5 == 0) {
            if (minutes < 30) {
                result = minutesWords[minutes] + " past " + hoursWords[hour];
            } else {
                result = minutesWords[(30 - (minutes - 30)) % 60] + " to " + hoursWords[(hour + 1) % 12];
            }
        } else {
            result = hoursWords[(hour)] + " " + minutesWords[minutes];
        }
        return result;
    }

    @Override
    public String toString() {
        return output;
    }
}
