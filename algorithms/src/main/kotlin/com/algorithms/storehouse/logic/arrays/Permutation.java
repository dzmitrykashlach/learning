package com.algorithms.storehouse.logic.arrays;

public class Permutation {

    public boolean perform(int[] array1, int[] array2) {
        boolean contains = false;
        for (int i = 0; i < array1.length - 1; i++) {

            for (int j = i + 1; j < array2.length - 1; j++) {
                if (array2[j] == array1[i]) {
                    contains = true;
                    break;
                }
                contains = false;
            }
            if (!contains) {
                return false;
            }
        }
        return contains;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 1, 2, 3, 4};
        boolean areEqual = permutation.perform(array1, array2);
        System.out.println(areEqual);

    }
}
