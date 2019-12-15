package com.sanjay.LambdaTests;

import java.util.Arrays;
import java.util.Timer;

public class LambdaUsecases {
    private void sortUsingLambda() {
        String [] aArray = new String [] {"Earth", "Venus", "Mercury", "Pluto"};
        Arrays.sort(aArray);
        System.out.println("Sorted using standard sort : " + Arrays.toString(aArray));
        Arrays.sort(aArray, (first, second) -> first.length() - second.length());
        System.out.println("Sorted using Lambda Function : " + Arrays.toString(aArray));
    }
    public static void main(String[] args) {
        LambdaUsecases lambdaUsecases = new LambdaUsecases();
        lambdaUsecases.sortUsingLambda();
    }
}
