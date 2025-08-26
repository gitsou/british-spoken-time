package org.jacekziemianski.bst;

import java.util.List;

public class SpokenTime {
    private final int hour;
    private final int minute;
    private final String output;
    private final List<OutputRule> outputRules;

    public SpokenTime(List<OutputRule> outputRules, int hour, int minute) {
        this.outputRules = outputRules;
        this.hour = hour;
        this.minute = minute;
        this.output = generateSpokenTime();
    }

    public int getHour() {
        return hour;
    }

    public int getHour(int add) {
        return (hour + add) % 24;
    }

    public int getMinute() {
        return minute;
    }

    public int getMinute(int add) {
        return (minute + add) % 60;
    }

    public String getTime() {
        return String.format("%02d:%02d", hour, minute);
    }

    public String generateSpokenTime() {
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
