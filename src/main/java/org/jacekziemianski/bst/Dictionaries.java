package org.jacekziemianski.bst;

/**
 * Represents a dictionary which contains words for correct hours, minutes and special cases.
 */
public interface Dictionaries {
    String getHourWord(int hour);

    String getMinuteWord(int minute);

    String getSpecialWord(String key);
}
