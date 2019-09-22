package com.yangduan.dorian.algorithm.array;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @author yangduan
 * 快速排序
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int i = left, j = right, base = arr[left];
        while(i < j) {
            while(i < j && arr[j] >= base) {
                j --;
            }

            while(i < j && arr[i] <= base) {
                i ++;
            }

            if(i >= j) {
                break;
            }

            swap(arr, i, j);
        }

        arr[left] = arr[i];
        arr[i] = base;

        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,4,9,6,5,17,3,7,24,19,5};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr);
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
    }

}
