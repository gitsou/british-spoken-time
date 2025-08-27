package org.jacekziemianski.bst;

public class Time {
    private final int hour;
    private final int minute;

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

    public int getAdjustedMinute(int offset) {
        if (minute + offset >= 0) {
            return (minute + offset) % 60;
        } else {
            return 60 + ((minute + offset) % 60);
        }
    }

    public String getTime() {
        return String.format("%02d:%02d", hour, minute);
    }
}