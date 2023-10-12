package com.project.backtracking;

import java.util.*;

/**
 * 回溯算法
 */
public class BackTracking {
    //1. 全排列问题
    void backtrack(List<Integer> state, int[] nums, boolean[] seleted, List<List<Integer>> res) {
        //当状态长度等于元素数量时 记录解
        if(state.size() == nums.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        //遍历所有选择
        for(int i=0;i<nums.length;i++) {
            int choice = nums[i];
            //剪枝 不允许选择重复元素
            if(!seleted[i]) {
                seleted[i] = true;
                state.add(choice);
                //进行下一轮选择
                backtrack(state, nums, seleted, res);
                //撤销
                seleted[i] = false;
                state.remove(state.size()-1);
            }
        }
    }
    List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }

    //2.当数组中有相等元素时 需要进行剪枝 策略是用一个哈希表记录已经选择过的元素
    void backtrack2(List<Integer> state, int[] nums, boolean[] selected, List<List<Integer>> res) {
        if(state.size() == nums.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        Set<Integer> duplicated = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            int choice = nums[i];
            if(!selected[i] && !duplicated.contains(choice)) {
                duplicated.add(choice);
                selected[i] = true;
                state.add(choice);
                backtrack2(state, nums, selected, res);
                selected[i] = false;
                state.remove(state.size()-1);
            }
        }
    }

    //3.子集合问题  从数组选择集合使得元素和为target 可以重复选取 所以不需要selected
    void backtrack3(List<Integer> state, int[] nums, List<List<Integer>> res, int target, int start) {
        if(0 == target) {
            res.add(new ArrayList<>(state));
            return;
        }
        //剪枝 从start开始遍历 避免生成重复子集
        for(int i=start;i<nums.length;i++) {
            int choice = nums[i];
            //剪枝 若总和超过target 则跳过
            //因为数组已经排序 后边元素更大一定会超过target
            if(target - choice < 0 ) break;
            //尝试选择  更新total
            //total += choice;
            state.add(choice);
            backtrack3(state, nums, res, target - choice, i);
            //回退
            state.remove(state.size()-1);
        }
    }
    List<List<Integer>> subsetSumINave(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack3(new ArrayList<Integer>(), nums, res, target, 0 );
        return res;
    }

    //重复元素情况
    void backtrack4(List<Integer> state, int[] nums, List<List<Integer>> res, int target, int start) {
        if(0 == target) {
            res.add(new ArrayList<>(state));
            return;
        }
        //剪枝 从start开始遍历 避免生成重复子集
        for(int i=start;i<nums.length;i++) {
            int choice = nums[i];
            //剪枝 若总和超过target 则跳过
            //因为数组已经排序 后边元素更大一定会超过target
            if(target - choice < 0 ) break;
            //如果该元素与左边元素相等 说明已经被选择过
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            //尝试选择  更新total
            //total += choice;
            state.add(choice);
            backtrack3(state, nums, res, target - choice, i);
            //回退
            state.remove(state.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        BackTracking track = new BackTracking();
        //System.out.println(track.permutations(nums));
        System.out.println(track.subsetSumINave(nums, 8));
    }
}
