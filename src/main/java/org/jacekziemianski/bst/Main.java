package org.jacekziemianski.bst;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
//            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
//            TemporalAccessor ta = timeFormatter.parse(String.join(" ", args));
//            LocalTime time = LocalTime.from(ta);
//            System.out.println(time);
            var elements = args[0].split(":");
            if (elements.length == 2) {
                int hour = Integer.parseInt(elements[0]);
                int minutes = Integer.parseInt(elements[1]);

                // validate
                var bst = new BritishSpokenTime(hour, minutes);
                System.out.println(bst);

                return;
            }
            return;
        }
        System.out.println("Description");
    }
}