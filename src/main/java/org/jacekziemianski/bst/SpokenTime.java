package org.jacekziemianski.bst;

import java.util.List;

public class SpokenTime {
    private Time time;
    private final TimeArgumentsParser timeArgumentsParser;
    private String spokenTime = "";
    private final List<OutputRule> outputRules;

    public SpokenTime(List<OutputRule> outputRules, TimeArgumentsParser timeArgumentsParser) {
        this.outputRules = outputRules;
        this.timeArgumentsParser = timeArgumentsParser;
    }

    public int getHour() {
        return time.getHour();
    }

    public int getHour(int addHours) {
        return time.getHour(addHours);
    }

    public int getMinute() {
        return time.getMinute();
    }

    public int getMinute(int addMinutes) {
        return time.getMinute(addMinutes);
    }

    public String getTime() {
        return time.getTime();
    }

    public String getSpokenTime(String[] args) {
        if (spokenTime.isEmpty()) {
            generate(args);
        }

        return spokenTime;
    }

    private void generate(String[] args) {
        time = timeArgumentsParser.parse(args);

        spokenTime = outputRules.stream()
                .filter(s -> s.appliesTo(this))
                .findFirst()
                .map(s -> s.generate(this))
                .orElse("No rules where found to generate correct output");
    }

    @Override
    public String toString() {
        return spokenTime;
    }
}
