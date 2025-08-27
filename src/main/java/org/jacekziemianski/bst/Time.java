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
        return getHour(0);
    }

    public int getHour(int addHours) {
        if (hour + addHours >= 0) {
            return (hour + addHours) % 24;
        } else {
            return 24 + ((hour + addHours) % 24);
        }
    }

    public int getMinute() {
        return getMinute(0);
    }

    public int getMinute(int addMinutes) {
        if (minute + addMinutes >= 0) {
            return (minute + addMinutes) % 60;
        } else {
            return 60 + ((minute + addMinutes) % 60);
        }
    }

    public String getTime() {
        return String.format("%02d:%02d", hour, minute);
    }
}