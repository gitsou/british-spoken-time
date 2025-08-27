package org.jacekziemianski.bst;

/**
 * Represent parser used for input arguments
 */
interface ArgumentsParser {
    Time parse(String[] args) throws IllegalArgumentException;
}
