package com.davidlapadula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread(()-> {
            System.out.println("Adding Employees");
        }).start();

        List<Employee> employees = new ArrayList<>();
        Employee john = new Employee("John", 25);
        Employee dave = new Employee("Dave", 21);
        Employee alan = new Employee("Alan", 38);

        employees.add(john);
        employees.add(dave);
        employees.add(alan);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

//        for (Employee employee: employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }


        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        UpperConcat uc2 = (s1, s2) -> {
            String result = s1.toLowerCase() + s2.toLowerCase();
            return result;
        };

        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("Anonymous class name: " + getClass().getSimpleName());
            System.out.println("i in lambda: " + i);
            String result = s1.toLowerCase() + s2.toLowerCase();
            return result;
        };

        System.out.println("The Another class name: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
            System.out.println("Value is: " + number);
        };
        new Thread(r).start();
    }
}

