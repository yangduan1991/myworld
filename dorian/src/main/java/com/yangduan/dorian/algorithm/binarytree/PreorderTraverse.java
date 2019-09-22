package com.yangduan.dorian.algorithm.binarytree;

import com.yangduan.dorian.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangduan
 * leetcode no.114 二叉树前序遍历，不使用递归
 */
public class PreorderTraverse {

    public List<Integer> traverse(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(null == root) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);

            if(null != temp.right) {
                stack.push(temp.right);
            }
            if(null != temp.left) {
                stack.push(temp.left);
            }
        }
        return res;
    }

}
