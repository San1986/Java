package com.sanjay.methodreference;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Item {
    // Simple Category holder enum:
    enum Category {
        Grocery("Grocery"),
        Electronics("Electronics"),
        Gardening("Gardening");

        private String type;
        Category(String type) {
            this.type = type;
        }
        String getType() {
            return type;
        }
    }
    String name;
    Integer price;
    Category category;

    public Item(String name, int price, String category) {
        this.name = name;
        this.price = price;
        switch (category) {
            case "Grocery":
                this.category = Category.Grocery;
            case "Electronics":
                this.category = Category.Electronics;
            case "Gardening":
                this.category = Category.Gardening;
            default:
                assert false;
        }
    }
    public static int compareByPrice(Item i1, Item i2){
        return i1.price.compareTo(i2.price);
    }

    @Override
    public String toString() {
        return this.name + ":" + this.price;
    }
}

class Person {
    String name;
    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class ItemComparator {
    public int compareByName(Item i1, Item i2) {
        return i1.name.compareTo(i2.name);
    }
}

public class MethodReferencesTests {
    /*
     * Testing the following four types of the reference methods.
     */
    private void testReferenceToStaticMethod() {
        Item i1 = new Item("Rice", 4, "Grocery");
        Item i2 = new Item("Flour", 5, "Grocery");
        Item i3 = new Item("Almonds", 6, "Grocery");
        Item [] array = {i2, i1, i3};
        Arrays.sort(array, Item::compareByPrice);
        System.out.println(Arrays.toString(array));
    }

    private void testReferenceToInstanceMethod() {
        Item i1 = new Item("Rice", 4, "Grocery");
        Item i2 = new Item("Flour", 5, "Grocery");
        Item i3 = new Item("Almonds", 6, "Grocery");
        Item [] array = {i2, i1, i3};
        Arrays.sort(array, new ItemComparator()::compareByName);
        System.out.println(Arrays.toString(array));
    }

    private void testReferenceToContainingType() {
        String [] arrays = {"Sanjay", "Patil", "Sachin"};
        Arrays.sort(arrays, String::compareTo);
        System.out.println(Arrays.toString(arrays));
    }

    private void testReferenceToConstructor() {
        /*
        In this case we have the lamba expression as (args) -> new Object(args),
        and we replace this with this type of the Constructor Reference.
         */
        String [] names = {"Sanjay", "Patil"};
        Stream<Person> pStream = Arrays.stream(names).map(Person::new);
        List<Person> pArrays = pStream.collect(Collectors.toList());
        System.out.println(Arrays.toString(pArrays.toArray()));
    }

    public static void main(String[] args) {
        MethodReferencesTests test = new MethodReferencesTests();
        test.testReferenceToStaticMethod();
        test.testReferenceToInstanceMethod();
        test.testReferenceToContainingType();
        test.testReferenceToConstructor();
    }
}
