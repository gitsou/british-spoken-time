package org.jacekziemianski.bst;

public class InputParams {
    private final String[] inputParameters;
    private final int hour = 0;
    private final int minutes = 0;

    public InputParams(String[] inputParameters) {
        this.inputParameters = inputParameters;
    }

//    public parse() {
//
//    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }
}
