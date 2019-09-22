package com.yangduan.dorian.algorithm.array;

/**
 * @author yangduan
 * 给定整数数组，原地把所有的偶数放到前面，奇数放到后面，顺序无要求。
 */
public class OddAndEven {

    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while(left < right) {
            while(left < A.length && A[left] % 2 == 0) {
                left ++;
            }
            while(right >= 0 && A[right] % 2 == 1) {
                right --;
            }

            if(left >= right) {
                break;
            }

            swap(A, left, right);
            left ++;
            right --;
        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        OddAndEven oddAndEven = new OddAndEven();
        int[] arr = new int[]{1,2,2,5,5,3,8,5,4,5,5,0,1,3,4,5,7,34,14,75,52,13,14};
        for (int i: oddAndEven.sortArrayByParity(arr)) {
            System.out.print(i + " ");
        }
    }

}
