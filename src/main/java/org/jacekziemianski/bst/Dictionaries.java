package org.jacekziemianski.bst;

import java.util.Map;

public class Dictionaries {
    protected final Map<String, String> specialWords;
    protected final String[] hourWords;
    protected final String[] minuteWords;

    public Dictionaries(Map<String, String> specialWords, String[] hourWords, String[] minuteWords) {
        this.specialWords = specialWords;
        this.hourWords = hourWords;
        this.minuteWords = minuteWords;
    }

    public String getHour(int hour) {
        return hourWords[hour];
    }

    public String getMinute(int minute) {
        return minuteWords[minute];
    }

    public String getSpecialWord(String key) {
        return specialWords.get(key);
    }
}
