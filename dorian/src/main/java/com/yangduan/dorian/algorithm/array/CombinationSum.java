package com.yangduan.dorian.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangduan
 * 给一个数组和一个整数，输出数组中所有和为给定整数的元素下标
 */
public class CombinationSum {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        backtracking(candidates, cur, 0, target);
        return res;
    }

    private void backtracking(int[] candidates, List<Integer> cur, int index, int des) {
        if (des == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            cur.add(i);
            backtracking(candidates, cur, i + 1, des - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum.combinationSum2(arr, 8));
    }

}
