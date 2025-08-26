package org.jacekziemianski.bst;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
//
//
//            String[] inputs = {
//                    "12:00 noon",
//                    "12:00 midnight",
//                    "03:15 PM",
//                    "07:45 AM"
//            };
//
//            for (String input : inputs) {
//                LocalTime time = LocalTime.parse(input.toUpperCase(Locale.ENGLISH), formatter);
//                System.out.println(input + " -> " + time);
//            }
            if (args.length > 0 && isCorrectTime(args[0])) {
                var elements = args[0].split(":");
                if (elements.length == 2) {
                    int hour = Integer.parseInt(elements[0]);
                    int minute = Integer.parseInt(elements[1]);
                    if (hour >= 0 && hour <= 12 && minute >= 0 && minute <= 59) {
                        var bst = getBritishSpokenTime(hour, minute);
                        System.out.println(bst);
                        return;
                    } else {
                        System.out.println("Incorrect TIME parameter.\n");
                    }
                }
            }
            System.out.print("""
                    Usage: bst TIME
                    
                    Converts a given time into its British spoken form.
                    
                    Arguments:
                      TIME   Time in hh:mm format (00:00 to 12:59, 12-hour clock).
                             Example: bst 12:00 -> prints "noon"
                    """);

        } catch (Exception e) {
            log.error("Exception", e);
            System.err.println("Unexpected error, please check logs for some details.");
            System.exit(1);
        }
    }

    private static SpokenTime getBritishSpokenTime(int hour, int minute) {
        NumbersToWords numbersToWords = new NumbersToWords();
        List<OutputRule> outputRules = List.of(
                new SpecialHourRule(numbersToWords),
                new HourRule(numbersToWords),
                new QuarterPastRule(numbersToWords),
                new QuarterToRule(numbersToWords),
                new HalfHourRule(numbersToWords),
                new MinutePastRule(numbersToWords),
                new MinuteToRule(numbersToWords),
                new DefaultRule(numbersToWords)
        );

        return new SpokenTime(outputRules, hour, minute);
    }

    public static boolean isCorrectTime(String time) {
        return time.matches("\\d{1,2}:\\d\\d");
    }
}