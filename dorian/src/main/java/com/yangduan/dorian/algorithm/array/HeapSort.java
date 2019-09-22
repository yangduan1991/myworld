package com.yangduan.dorian.algorithm.array;

public class HeapSort {

    public int[] heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = new int[]{
                4, 36, 14, 74, 543, 96, 61, 3, 66, 23, 97, 623
        };
        arr = heapSort.heapSort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

}
