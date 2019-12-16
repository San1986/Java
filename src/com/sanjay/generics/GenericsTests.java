package com.sanjay.generics;

import java.util.ArrayList;
import java.util.List;

class Pair <U, V> {
    U key;
    V value;
    Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }
}

class ComparablePair <U extends Comparable, V> {
    U key;
    V value;
    ComparablePair(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public int compare(ComparablePair p) {
        return this.key.compareTo(p.key);
    }
}

class Employee {
    String first;
    String last;
    Employee(String first, String last) {
        this.first = first;
        this.last = last;
    }
}

class Manager extends Employee {
    List<String> employees;
    Manager(String first, String last) {
        super(first, last);
        employees = new ArrayList<>();
    }
}

class EmployeeHandler {
    public void addEmployee(List<? super Employee> list) {
        list.add(new Manager("Sanjay", "Patil"));
    }
}

public class GenericsTests {
    public static void main(String[] args) {
        Pair simplePair = new Pair("Key", "Value");
        System.out.println("Key = " + simplePair.key + " Value = " + simplePair.value);

        ComparablePair comparablePair = new ComparablePair(6, 3);
        System.out.println("Result : " + comparablePair.compare(new ComparablePair(6, 2)));
    }

}
