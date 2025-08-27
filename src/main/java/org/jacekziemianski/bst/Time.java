package org.jacekziemianski.bst;

class Time {
    private final int hour;
    private final int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return getHour(0);
    }

    public int getHour(int addHours) {
        return (hour + addHours) % 24;
    }

    public int getMinute() {
        return getMinute(0);
    }

    public int getMinute(int addMinutes) {
        return (minute + addMinutes) % 60;
    }

    public String getTime() {
        return String.format("%02d:%02d", hour, minute);
    }
}