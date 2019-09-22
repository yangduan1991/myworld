package com.yangduan.dorian.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= nums.length; i ++) {
            while(i != nums[i-1] && nums[nums[i - 1] - 1] != nums[i - 1]) {
                swap(nums, i - 1, nums[i - 1] - 1);
            }
        }

        for(int i = 1; i <= nums.length; i ++) {
            if(i != nums[i - 1]) {
                res.add(i);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        List<Integer> res = findDisappearedNumbers.findDisappearedNumbers(nums);
        System.out.println(res);
    }

}
