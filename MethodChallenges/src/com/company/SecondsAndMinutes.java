package com.company;

public class SecondsAndMinutes {

    public static String getDurationString(int minutes, int seconds) {
        String durationValue = "Invalid Value";

        if (minutes >= 0 && seconds >= 0 && seconds <= 59 ) {
            int hours = minutes / 60;
            int remainingMinutes = minutes % 60;

            String hoursString = hours + "h";
            if (hours < 10) hoursString = "0" + hoursString;

            String minutesString = remainingMinutes + "m";
            if (remainingMinutes < 10) minutesString = "0" + minutesString;

            String secondsString = seconds + "s";
            if (seconds < 10) secondsString = "0" + secondsString;

            durationValue = hoursString + " " +  minutesString + " " + secondsString;
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
