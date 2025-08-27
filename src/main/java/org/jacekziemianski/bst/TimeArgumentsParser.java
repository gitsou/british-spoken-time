package org.jacekziemianski.bst;

/**
 * Parses command-line arguments into a Time object.
 */
public class TimeArgumentsParser implements ArgumentsParser {
    /**
     * Parses a single TIME argument in "HH:mm" format.
     *
     * @param args command-line arguments
     * @return a Time object
     * @throws IllegalArgumentException if the argument is missing or invalid
     */
    @Override
    public Time parse(String[] args) throws IllegalArgumentException {
        if (args == null) {
            throw new IllegalArgumentException("Expecting one TIME parameter.");
        }
        if (args.length == 1 && isCorrectTime(args[0])) {
            var elements = args[0].split(":");
            if (elements.length == 2) {
                int hour = Integer.parseInt(elements[0]);
                int minute = Integer.parseInt(elements[1]);
                if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
                    return new Time(hour, minute);
                }
            }
        }

        throw new IllegalArgumentException("Incorrect TIME parameter.");
    }

    private boolean isCorrectTime(String time) {
        return time.matches("\\d{1,2}:\\d\\d");
    }
}
