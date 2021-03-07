package io.ds.graph;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        for(int n : nums){
            int temp = n^n;
            System.out.println(n + "^ 0 = " + temp);
        }
    }
}
