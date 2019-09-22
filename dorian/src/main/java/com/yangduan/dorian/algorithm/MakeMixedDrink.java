package com.yangduan.dorian.algorithm;

import java.util.Scanner;

public class MakeMixedDrink {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();

        int[] weights = new int[n];
        int weightSum = 0;
        int[] a = new int[n];
        float[] b = new float[n];
        float max = v;

        for(int i = 0; i < n; i ++){
            weights[i] = scanner.nextInt();
            weightSum += weights[i];
        }

        for(int i = 0; i < n; i ++){
            a[i] = scanner.nextInt();
            b[i] = ((float) a[i]) / weights[i];
            max = Math.min(max, b[i]);
        }


        max = max * weightSum > v ? v : max * weightSum;

        System.out.printf("%.4f", max);


    }

}
