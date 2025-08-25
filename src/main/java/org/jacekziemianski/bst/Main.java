package org.jacekziemianski.bst;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
//            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
//            TemporalAccessor ta = timeFormatter.parse(String.join(" ", args));
//            LocalTime time = LocalTime.from(ta);
//            System.out.println(time);
                var elements = args[0].split(":");
                if (elements.length == 2) {
                    var bst = getBritishSpokenTime(elements);
                    System.out.println(bst);

                    return;
                }
            }
            System.out.println("Description");

        } catch (Exception e) {
            log.error("Exception", e);
            System.err.println("Unexpected error, please check logs for some details.");
            System.exit(1);
        }
    }

    private static BritishSpokenTime getBritishSpokenTime(String[] elements) {
        int hour = Integer.parseInt(elements[0]);
        int minute = Integer.parseInt(elements[1]);

        List<OutputRule> outputRules = List.of(
                new SpecialHourRule(),
                new HourRule(),
                new QuarterPastRule(),
                new QuarterToRule(),
                new HalfHourRule(),
                new MinutePastRule(),
                new MinuteToRule(),
                new DefaultRule()
        );

        return new BritishSpokenTime(outputRules, hour, minute);
    }
}