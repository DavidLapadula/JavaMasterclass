package com.davidlapadula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    List<String> bingoNums = Arrays.asList("N40", "B12", "B6", "G60", "G53", "I26", "I29");
	    List<String> gNums = new ArrayList<>();

	    List<String> sortedNums = bingoNums
                                    .stream()
                                    .map(String::toUpperCase)
                                    .filter(s -> s.startsWith("G"))
                                    .sorted()
//                                    .collect(Collectors.toList());
                                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

	    for (String s: sortedNums) {
            System.out.println(s);
        }

//	    bingoNums.forEach(number -> {
//	        if(number.toUpperCase().startsWith("G")) {
//	            gNums.add(number);
//            }
//        });
//
//	    gNums.sort((s1, s2) -> s1.compareTo(s2));
//
//        gNums.forEach(s -> {
//            System.out.println(s);
//        });

        Stream<String> numStream = Stream.of("B12", "B6", "G60", "G53");
        Stream<String> numStream2 = Stream.of("B12", "B6", "G60", "G53");
        Stream<String> numStreamX = Stream.concat(numStream, numStream2);
//        System.out.println(numStreamX.distinct().peek(System.out::println).count());

        Employee john = new Employee("John", 23);
        Employee jack = new Employee("Jack", 24);
        Employee jill = new Employee("Jill", 48);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jack);

        Department acct = new Department("Accounting");
        hr.addEmployee(jill);

        List<Department> depts = new ArrayList<>();
        depts.add(hr);
        depts.add(acct);

        depts
            .stream()
            .flatMap(department -> department.getEmployees().stream())
            .forEach(System.out::println);

        depts
            .stream()
            .flatMap(department -> department.getEmployees().stream())
            .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
            .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BA", "CCCC", "XYZ")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                });
    }
}
