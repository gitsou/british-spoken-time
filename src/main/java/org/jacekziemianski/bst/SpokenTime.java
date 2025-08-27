package org.jacekziemianski.bst;

import java.util.List;

/**
 * Convert time from Time object to it spoken form.
 */
public class SpokenTime {
    private Time time;
    private final TimeArgumentsParser timeArgumentsParser;
    private final List<OutputRule> outputRules;

    /**
     * Creates a new class instance with the given rules and parser.
     *
     * @param outputRules         the list of rules used to generate spoken time
     * @param timeArgumentsParser the parser used to convert arguments intoTime
     */
    public SpokenTime(List<OutputRule> outputRules, TimeArgumentsParser timeArgumentsParser) {
        this.outputRules = outputRules;
        this.timeArgumentsParser = timeArgumentsParser;
    }

    /**
     * Returns the spoken form of the time.
     *
     * @param args command-line arguments containing the time
     * @return the spoken time
     */
    public String generateSpokenTime(String[] args) {
        time = timeArgumentsParser.parse(args);

        return outputRules.stream()
                .filter(s -> s.appliesTo(time))
                .findFirst()
                .map(s -> s.generate(time))
                .orElse("No rules where found to generate correct output");
    }
}
