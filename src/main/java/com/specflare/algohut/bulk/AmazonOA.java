package com.specflare.algohut.bulk;

public class AmazonOA {
    public int numPrefixChanges(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return Math.abs(arr[0]);
        }
        int numChanges = 0;
        for (int i = 1; i < arr.length; i++) {
            numChanges += Math.abs(arr[i] - arr[i - 1]);
        }
        numChanges += Math.abs(arr[arr.length - 1]);
        return numChanges;
    }

    public static void main(String[] args) {
        AmazonOA aoa = new AmazonOA();
        System.out.println(aoa.numPrefixChanges(new int[] {1}));
        System.out.println(aoa.numPrefixChanges(new int[] {0}));
        System.out.println(aoa.numPrefixChanges(new int[] {-1}));
        System.out.println(aoa.numPrefixChanges(new int[] {4, -1, -1, -1, -1}));
        System.out.println(aoa.numPrefixChanges(new int[] {4, -1, 3, -1, 1}));
    }
}
