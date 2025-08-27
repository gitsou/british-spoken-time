package org.jacekziemianski.bst;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            var bst = getBritishSpokenTime();
            System.out.println(bst.getSpokenTime(args));
        } catch (Exception e) {
            log.error("Exception", e);
            System.err.println("Unexpected error, please check logs for some details.");
            System.exit(1);
        }
    }

    private static SpokenTime getBritishSpokenTime() {
        BritishDictionaries britishDictionaries = getBritishDictionaries();
        List<OutputRule> outputRules = List.of(
                new SpecialHourRule(britishDictionaries),
                new HourRule(britishDictionaries),
                new QuarterPastRule(britishDictionaries),
                new QuarterToRule(britishDictionaries),
                new HalfHourRule(britishDictionaries),
                new MinutePastRule(britishDictionaries),
                new MinuteToRule(britishDictionaries),
                new DefaultRule(britishDictionaries)
        );
        return new SpokenTime(outputRules, new TimeArgumentsParser());
    }

    private static BritishDictionaries getBritishDictionaries() {
        final Map<String, String> specialWords = Map.of(
                "00:00", "midnight",
                "12:00", "noon"
        );
        final String[] hourWords = {
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
        final String[] minuteWords = {
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
        return new BritishDictionaries(specialWords, hourWords, minuteWords);
    }
}