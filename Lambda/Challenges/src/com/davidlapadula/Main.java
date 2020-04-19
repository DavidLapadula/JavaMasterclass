package com.davidlapadula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        // Lambda body maps to new Runnable and implements 'run'
        Runnable runnable = () -> {
            String myString = "To be split into array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        // Standalone lambda as fn because takes 1 param and returns value
        Function<String, String> lambdaFn = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i<s.length(); i++){
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFn.apply("1234567890"));
        // Pass lambda as argument
        System.out.println(everySecondChar(lambdaFn, "1234567890"));

        // Using supplier interface, which returns object
        Supplier<String> loveJava = () -> "I love java";
        String supplierResult = loveJava.get();
        System.out.println(supplierResult);

        List<String> topNames = Arrays.asList(
                "John",
                "Emily",
                "Steven",
                "Jennifer",
                "Marco"
        );

        List<String> ucList = new ArrayList<>();
        // forEach takes consumer and does action on every element
        topNames.forEach(name -> ucList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        // map lambda to comparator
        ucList.sort((s1, s2) -> s1.compareTo(s2));

        // Using method reference
        List<String> topNames2 = Arrays.asList(
                "John",
                "Emily",
                "Steven",
                "Jennifer",
                "Marco"
        );
        List<String> ucList2 = new ArrayList<>();
        topNames.forEach(name -> ucList2.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        ucList2.sort(String::compareTo);

        // Using Stream
        List<String> topNames3 = Arrays.asList(
                "John",
                "Emily",
                "Steven",
                "Jennifer",
                "Marco"
        );

        topNames3
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

//        Print names that start with A
        List<String> topNames4 = Arrays.asList(
                "John",
                "Emily",
                "Steven",
                "Jennifer",
                "Marco",
                "Analise"
        );

        long startsWithA = topNames4
                    .stream()
                    .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                    .filter(name -> name.startsWith("A"))
                    .count(); 
    }

    public static String everySecondChar(Function<String, String> fn, String s) {
        return fn.apply(s);
    }
}
