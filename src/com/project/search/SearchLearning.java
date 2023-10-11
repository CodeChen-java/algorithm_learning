package com.project.search;

/**
 * 搜索算法
 */
public class SearchLearning {
    //二分查找
    int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;  //双闭区间
        while(i <= j) {
            int mid = i + ( j - i ) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target) {
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }
        return -1;
    }

    //二分查找插入点问题 无重复元素插入target 如果已存在target 则插入到左方 返回插入的索引
    int binarySearchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) {
                //mid的位置就是要放的位置
                return mid;
            }else if(nums[mid] > target) {
                //由于i每次更新时朝着变大的方向 j每次更新朝着变小的方向 因此当退出循环时 i指向第一个大于target的元素 j指向第一个小于target的元素
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }
        return i;
    }

    //二分查找插入点问题 有重复元素插入target
    int binarySearchInsertion(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] < target) {
                i = mid + 1;
            }else if(nums[target] > target) {
                j = mid - 1;
            }else {
                j = mid - 1;   //此时找到target 小于target的在区间 i - mid-1中
            }
        }
        return i;
    }
}
