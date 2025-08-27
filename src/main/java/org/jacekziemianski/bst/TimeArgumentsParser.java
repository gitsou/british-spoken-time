package org.jacekziemianski.bst;

class TimeArgumentsParser implements ArgumentsParser {
    @Override
    public Time parse(String[] args) {
        if (args.length == 1 && isCorrectTime(args[0])) {
            var elements = args[0].split(":");
            if (elements.length == 2) {
                int hour = Integer.parseInt(elements[0]);
                int minute = Integer.parseInt(elements[1]);
                if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
                    return new Time(hour, minute);
                } else {
                    System.err.println("Incorrect values in TIME parameter.\n");
                }
            } else {
                System.err.println("Incorrect ':' numbers in TIME parameter.\n");
            }
        } else {
            System.err.println("Incorrect TIME parameter.\n");
        }

        System.out.print("""
                Usage: bst TIME
                
                Converts a given time into its British spoken form.
                
                Arguments:
                  TIME   Time in hh:mm format (00:00 to 23:59, 24-hour clock).
                         Example: bst 12:00 -> prints "noon"
                """);

        return null;
    }

    private boolean isCorrectTime(String time) {
        return time.matches("\\d{1,2}:\\d\\d");
    }
}
