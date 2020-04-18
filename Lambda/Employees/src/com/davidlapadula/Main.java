package com.davidlapadula;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee john = new Employee("John", 25);
        Employee dave = new Employee("Dave", 21);
        Employee alan = new Employee("Alan", 38);

        employees.add(john);
        employees.add(dave);
        employees.add(alan);

        printByAge(employees, employee -> employee.getAge() > 30);
        System.out.println("--------------------");
        printByAge(employees, employee -> employee.getAge() <= 30);

        IntPredicate g15 = i -> i > 15;
        IntPredicate l100 = i -> i < 100;

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);

        Function<Employee, String> getLastName = (employee) -> {
           return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        String firstName = getByName(getFirstName, employees.get(1));
        String lastName = getByName(getLastName, employees.get(1));

        Function<Employee, String> toUpper = employee ->  employee.getName().toUpperCase();
        Function<String, String> getFirst = name -> name.substring(0, name.indexOf(' '));
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> name.concat(" " + employee.getName());

        Function chained = toUpper.andThen(getFirst);

        String upperName = toUpper.apply(employees.get(0));
        String nameAge = concatAge.apply(upperName, employees.get(0));

        IntUnaryOperator inceBy5 = i -> i + 5;
        inceBy5.applyAsInt(10);

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello");
    }

    private static String getByName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printByAge(List<Employee> employees, Predicate<Employee> ageCondition) {
        for (Employee employee: employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }

    }
}
