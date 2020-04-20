package com.davidlapadula;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches("I want a \\w+."));

        String regChal3 = "I want a \\w+.";
        Pattern c3Pattern = Pattern.compile(regChal3);
        Matcher matcher = c3Pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all spaces with underscores";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[a-g]+"));
        // Challenge 6, match exact string
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[a-zA-Z]+\\.\\d+$"));

        String challenge8 = "abcd.135uvqz.7tzik.990";
        Pattern c8Pat = Pattern.compile("[a-zA-Z]+\\.\\d+");
        Matcher matcher8 = c8Pat.matcher(challenge8);
        while (matcher8.find()) {
            System.out.println("Occurence 8: " + matcher8.group());
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.990\n";
        Pattern c9Pat = Pattern.compile("[a-zA-Z]+\\.(\\d+)\\s");
        Matcher matcher9 = c9Pat.matcher(challenge9);
        while (matcher9.find()) {
            System.out.println("Occurence 9: " + matcher9.group(1));
        }

        String challenge10 = "abcd.135\tuvqz.7\ttzik.100\n";
        Pattern c10Pat = Pattern.compile("[a-zA-Z]+\\.(\\d+)\\s");
        Matcher matcher10 = c10Pat.matcher(challenge10);
        while (matcher10.find()) {
            System.out.println("Start Index: " + matcher10.start(1));
            System.out.println("End Index: " + (matcher10.end(1) - 1));
        }

        String challenge11 = "{0, 2} {0, 5} {1, 3} {2, 4}";
        Pattern c11Pat = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11 = c11Pat.matcher(challenge11);
        while (matcher11.find()) {
            System.out.println("Occurence 11: " + matcher11.group(1));
        }

        String challenge11a = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}";
        Pattern c11aPat = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher11a = c11aPat.matcher(challenge11a);
        while (matcher11a.find()) {
            System.out.println("Occurence 11a: " + matcher11a.group(1));
        }

        String challenge12 = "12345";
        System.out.println(challenge12.matches("^\\d{5}$"));


        String challenge13 = "12345-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        String challenge14 = "12345-1111";
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge14.matches("^\\d{5}(-\\d{4})?$"));

    }
}
