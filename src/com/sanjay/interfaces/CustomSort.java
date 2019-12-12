package com.sanjay.interfaces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Employee class supports the custom sort based on the last name by implementing the Comparable interface.
 */
class Employee implements Comparable<Employee> {
    private String fName;
    private String lName;
    Employee(String first, String last) {
        this.fName = first;
        this.lName = last;
    }
    @Override
    public String toString() {
        return fName + " " + lName;
    }

    @Override
    public int compareTo(Employee o) {
        return this.fName.compareTo(o.fName);
    }
}

public class CustomSort {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sanjay", "Patil");
        Employee e2 = new Employee("John", "Smith");
        Employee e3 = new Employee("Andrew", "Smith");
        List<Employee> eList = new ArrayList<>();
        eList.add(e1);
        eList.add(e2);
        eList.add(e3);
        Collections.sort(eList);
        System.out.println("Sorted Emplyee List: " + Arrays.toString(eList.toArray()));
    }
}
