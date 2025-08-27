package org.jacekziemianski.bst;

/**
 * 24-hour based time without date.
 */
public class Time {
    private final int hour;
    private final int minute;

    /**
     * Creates a new time.
     *
     * @param hour   0–23
     * @param minute 0–59
     * @throws IllegalArgumentException if values are out of range
     */
    public Time(int hour, int minute) throws IllegalArgumentException {
        if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
            throw new IllegalArgumentException("Incorrect arguments (hour=" + hour + ", minute=" + minute + ") for Time class.");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    /**
     * Returns hour adjusted by offset (modulo 24).
     *
     * @param offset hours to add (can be negative)
     * @return adjusted hour (0–23)
     */
    public int getAdjustedHour(int offset) {
        if (hour + offset >= 0) {
            return (hour + offset) % 24;
        } else {
            return 24 + ((hour + offset) % 24);
        }
    }

    public int getMinute() {
        return minute;
    }

    /**
     * Returns minute adjusted by offset (modulo 60).
     *
     * @param offset minutes to add (can be negative)
     * @return adjusted minute (0–59)
     */
    public int getAdjustedMinute(int offset) {
        if (minute + offset >= 0) {
            return (minute + offset) % 60;
        } else {
            return 60 + ((minute + offset) % 60);
        }
    }

    /**
     * Return time in HH:mm format
     *
     * @return time in HH:mm format
     */
    public String getTime() {
        return String.format("%02d:%02d", hour, minute);
    }
}