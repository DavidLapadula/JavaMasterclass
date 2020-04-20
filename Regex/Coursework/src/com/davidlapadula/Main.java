package com.davidlapadula;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string";
        String newString = string.replaceAll("I", "You");

        System.out.println(string);
        System.out.println(newString);

        String alphaNum = "adbGajhdjshdKK123md";
        System.out.println(alphaNum.replaceAll(".", "Y"));
        System.out.println(alphaNum.replaceAll("^adb", "123"));
        System.out.println(alphaNum.replaceAll("3md$", "END"));
        System.out.println(alphaNum.replaceAll("[Gaj]", "REPLACE"));
        System.out.println(alphaNum.replaceAll("[jhd][j]", "HERE"));
        System.out.println(alphaNum.replaceAll("[^ej]", "1"));
        System.out.println(alphaNum.replaceAll("\\d", "?"));

        String greet = "Hello";
        System.out.println(greet.matches("^Hello"));

        String name = "Harry is a teacher";
        System.out.println(name.replaceAll("[Hh]arry", "Peter"));

        String hasSpace = "abcdeeeee Thijs has whijte space";
        System.out.println(hasSpace.replaceAll("\\s", ""));
        System.out.println(hasSpace.replaceAll("\\b", "X"));
        System.out.println(hasSpace.replaceAll("abcde{5}", "X"));
        System.out.println(hasSpace.replaceAll("^abcde+", "X"));
        System.out.println(hasSpace.replaceAll("^abcde*", "X"));
        System.out.println(hasSpace.replaceAll("^abcde{2,5}", "X"));
        System.out.println(hasSpace.replaceAll("h+i*j", "hi"));

        StringBuilder htmlText = new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>Heading 2</h2>");
        htmlText.append("<p>Paragraph</p>");
        htmlText.append("<p>Paragraph 2 </p>");
        htmlText.append("<h2>Heading 3</h2>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        int count = 0;
        matcher.reset();
        while(matcher.find()) {
            count++;
            System.out.println(count + ": " + matcher.start() + " to " + matcher.end());
        }

        String h2Group = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2Group);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println(groupMatcher.group(1));
        }

        String h2Text = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2Text);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        h2TextMatcher.reset();

        while(h2TextMatcher.find()) {
            System.out.println(h2TextMatcher.group(2));
        }

        String person = "David";
        System.out.println(person.replaceAll("[D|d]avid", "L "));

        String tvTest = "tstvtkt";
//        String tNotVPat = "t(?!v)";
        String tNotVPat = "t(?=v)";
        Pattern tNotVPattern = Pattern.compile(tNotVPat);
        Matcher tvMatcher = tNotVPattern.matcher(tvTest);

        int count1 = 0;
        while(tvMatcher.find()) {
            count1++;
            System.out.println(count + ": " + tvMatcher.start() + " to " + tvMatcher.end());
        }

    }
}
