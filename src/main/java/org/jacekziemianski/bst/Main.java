package org.jacekziemianski.bst;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println(getUsage());
                return;
            }
            var bst = getBritishSpokenTime();
            System.out.println(bst.getSpokenTime(args));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            log.error("Exception", e);
            System.out.println(getUsage());
        } catch (Exception e) {
            System.err.println("Unexpected error, please check logs for more details.");
            log.error("Exception", e);
        }
    }

    private static String getUsage() {
        return """
                Usage: bst TIME
                
                Converts a given time into its British spoken form.
                
                Arguments:
                  TIME   Time in hh:mm format (00:00 to 23:59, 24-hour clock).
                         Example: bst 12:00 -> prints "noon"
                """;
    }

    private static SpokenTime getBritishSpokenTime() {
        BritishDictionaries britishDictionaries = new BritishDictionaries();
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
}