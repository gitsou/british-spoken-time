package org.jacekziemianski.bst;

import java.util.List;

public class BritishSpokenTime {
    private final int hour;
    private final int minute;
    private final String output;
    private final List<OutputRule> outputRules;

    public BritishSpokenTime(List<OutputRule> outputRules, int hour, int minute) {
        this.outputRules = outputRules;
        this.hour = hour;
        this.minute = minute;
        this.output = generateOutput();
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String generateOutput() {
        return outputRules.stream()
                .filter(s -> s.appliesTo(this))
                .findFirst()
                .map(s -> s.generate(this))
                .orElse("No rules where found to generate correct output");
    }

    @Override
    public String toString() {
        return output;
    }
}
