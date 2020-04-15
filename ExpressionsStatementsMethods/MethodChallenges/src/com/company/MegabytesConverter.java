package com.company;

public class MegabytesConverter {

    public static void printMegaBytesAndKiloBytes (int kiloBytes) {
        if (kiloBytes >= 0) {
            int megabytes = kiloBytes / 1024;
            int remainder = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megabytes + " MB and " + remainder + " KB");
        } else {
            System.out.println("Invalid Value");
        };
    };
}
