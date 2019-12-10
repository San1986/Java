package com.sanjay.interfaces;

interface Architecture {
int levels();
default String type() {return "Townhome"; };
}

interface Amenities {
default String type() {return "Fitness";};
}

/**
 * This is a class to demo the concept of the default methods in Java interfaces.
 * Java supports the default method in the interface so that the class implementing it does not
 * need to define that method. But if the Class implements the two interfaces with the same named
 * default method then the class needs to define the default method and call the necessary as needed.
 */
class Residence implements Architecture, Amenities {
    @Override
    public int levels() {
        return 0;
    }

    @Override
    public String type() {
        return Architecture.super.type();
    }
}

public class DefaultMethods {
    public static void main(String[] args) {
        Residence residence = new Residence();
        System.out.println("Residence had type:" + residence.type());
    }
}
