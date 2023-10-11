package com.project.divideconquer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}
/**
 * 分治策略的一些应用
 */
public class DivideConquer {
    //基于分治实现二分查找
    int binarySearch(int[] nums, int target, int i, int j) {
        //区间为空直接返回-1
        if( i > j) return -1;
        int m = ( i + j) / 2;
        if(nums[m] > target) {
            return binarySearch(nums, target, i, m - 1);
        }else if(nums[m] < target) {
            return binarySearch(nums, target, m + 1, j);
        }else {
            return m;
        }

    }

    int binary(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        return binarySearch(nums, target, i, j);
    }

    //构建二叉树问题
    TreeNode dfs(int[] preOrder, Map<Integer, Integer> inOrderMap, int i, int l, int r) {
        //子树区间为空时结束循环
        if( r - l < 0) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[i]);
        //查询m 从而划分左右子树
        int m = inOrderMap.get(preOrder[i]);
        //构建左子树
        root.left = dfs(preOrder, inOrderMap, i + 1, l, m - 1);
        root.right = dfs(preOrder, inOrderMap, i + 1 + m - l, m + 1, r);
        return root;
    }

    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        //初始化哈希表 存储inorder元素到索引的映射
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inOrder.length;i++) {
            map.put(inOrder[i], i);
        }
        TreeNode root = dfs(preOrder, map, 0, 0, inOrder.length - 1);
        return root;
    }

    /**
     * 汉诺塔问题
     */
    //移动一个圆盘
    void move(List<Integer> src, List<Integer> tar) {
        //从src顶部拿一个圆盘
        Integer pan = src.remove(src.size()-1);
        //将圆盘放入tar顶部
        tar.add(pan);
    }

    void dfs(int i, List<Integer> src, List<Integer> buf, List<Integer> tar) {
        //若src只剩下一个圆盘 则将其直接移动到tar
        if(i == 1) {
            move(src, tar);
            return;
        }
        //子问题 f(i-1) 将src顶部i-1个圆盘借助tar移动到buf
        dfs(i-1, src, tar, buf);
        //子问题f(1) 将src剩余一个移动到tar
        move(src, tar);
        //子问题f(i-1) 将buf顶部i-1借助src移动到tar
        dfs(i-1, buf, src, tar);
    }

    void slove(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        dfs(n, A, B, C);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DivideConquer divideConquer = new DivideConquer();
        System.out.println(divideConquer.binary(nums, 3));
    }
}
