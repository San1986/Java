package com.sanjay.innerclasses;

import java.util.Arrays;

public class ArrayMinMax {
    public static class Pair {
        int min;
        int max;
        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private Pair findMinMax(int [] array) {
        if (array.length == 0){
            return null;
        }
        if (array.length == 1) {
            return new Pair(array[0], array[0]);
        }
        Arrays.sort(array);
        return new Pair(array[0], array[array.length-1]);
    }

    public static void main(String[] args) {
        ArrayMinMax test = new ArrayMinMax();
        ArrayMinMax.Pair result = test.findMinMax(new int[]{3, 1, 2, 9, 7});
        System.out.println("Min : " + result.min + " Max : " + result.max);
    }
}
