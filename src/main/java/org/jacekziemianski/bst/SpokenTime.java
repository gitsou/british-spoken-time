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

    public String getSpokenTime(String[] args) {
        if (spokenTime.isEmpty()) {
            generate(args);
        }

        return spokenTime;
    }

    private void generate(String[] args) {
        time = timeArgumentsParser.parse(args);

        spokenTime = outputRules.stream()
                .filter(s -> s.appliesTo(time))
                .findFirst()
                .map(s -> s.generate(time))
                .orElse("No rules where found to generate correct output");
    }

    @Override
    public String toString() {
        return spokenTime;
    }
}
