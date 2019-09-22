package com.yangduan.dorian.algorithm.binarytree;

import com.yangduan.dorian.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangduan
 * 按层打印二叉树
 */
public class PrintBinaryTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == root) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeNode> nexts = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null != node.left) {
                    nexts.add(node.left);
                }
                if(null != node.right) {
                    nexts.add(node.right);
                }
            }
            res.add(new ArrayList<>(list));
            list.clear();
            queue.addAll(nexts);
        }
        return res;
    }
}
