package com.company;

public class SecondsAndMinutes {

    public static String getDurationString(int minutes, int seconds) {
        String durationValue = "Invalid Value";

        if (minutes >= 0 && seconds >= 0 && seconds <= 59 ){
            int hours = minutes / 60;
            int remainingMinutes = minutes % 60;
            durationValue = hours + "h " +  remainingMinutes + "m " + seconds +  "s";
        }

        return durationValue;
    }

    public static String getDurationString(int seconds) {
        String durationValue = "Invalid value";

        if (seconds >= 0) {
            int minutes = seconds / 60;
            int remainingSeconds = seconds % 60;
            durationValue = getDurationString(minutes, remainingSeconds);
        }

        return durationValue;
    }
}
