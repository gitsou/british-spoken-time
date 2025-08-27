package org.jacekziemianski.bst;

class TimeArgumentsParser implements ArgumentsParser {
    @Override
    public Time parse(String[] args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
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
