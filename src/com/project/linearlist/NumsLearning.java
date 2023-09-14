package com.project.linearlist;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 数组实现
 */
public class NumsLearning {

    /**
     * 随机访问元素
     */
    public int getRandomNums(int[] arrays) {
        //在区间[0, nums.length-1]中选择一个下标
        int randomIndex = ThreadLocalRandom.current().nextInt(0, arrays.length);
        return arrays[randomIndex];
    }

    /**
     *  插入元素 会造成最后一位元素丢失
     */
    public void insert(int[] arrays, int index, int val) {
        for(int i=arrays.length-1; i > index; i--) {
            arrays[i] = arrays[i-1];
        }
        arrays[index] = val;
    }

    /**
     * 删除元素
     */
    public int delete(int[] arrays, int index) {
        int deleteVal = arrays[index];
        for(int i = index;i<arrays.length-1;i++) {
            arrays[i] = arrays[i+1];
        }
        return deleteVal;
    }

    public void printArrays(int[] arrays) {
        for(int i=0;i<arrays.length;i++) {
            System.out.print(arrays[i] + "  ");
        }
    }


    /**
     * 数组扩容
     *
     */
    public int[] extendArrays(int[] arrays, int extend) {
        int[] res = new int[arrays.length + extend];
        for(int i=0;i<arrays.length;i++) {
            res[i] = arrays[i];
        }
        return res;
    }

    public static void main(String[] args) {
        NumsLearning learning = new NumsLearning();
        int[] nums = {1, 3, 5, 7 , 9};
        //在索引为2的位置插入10 结果应该是1 3 10 5 7
        //learning.insert(nums, 2, 10);
        //learning.printArrays(nums);
        //删除索引为2的元素  结果应该是1 3 7 9
        learning.delete(nums, 2);
        learning.printArrays(nums);
    }
}
