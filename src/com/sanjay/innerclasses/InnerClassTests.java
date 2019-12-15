package com.sanjay.innerclasses;

public class InnerClassTests {
    String name;
    public class InnerOne {
        String innerName;
        public InnerOne(String name){
            this.innerName = name;
        }
        public String print() {
            return InnerClassTests.this.name + " " + innerName;
        }
    }

    public InnerClassTests(String name){
        this.name = name;
    }

    public String print(){
        InnerOne inner = new InnerOne("Patil");
        return inner.print();
    }
    public static void main(String[] args) {
        InnerClassTests innerClassTests = new InnerClassTests("Sanjay");
        System.out.println("Name : " + innerClassTests.print());
    }
}
