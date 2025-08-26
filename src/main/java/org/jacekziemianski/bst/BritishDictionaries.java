package org.jacekziemianski.bst;

import java.util.Map;

public class BritishDictionaries extends Dictionaries {
    public BritishDictionaries(Map<String, String> specialWords, String[] hourWords, String[] minuteWords) {
        super(specialWords, hourWords, minuteWords);
    }
}
