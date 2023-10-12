package com.project.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortAlgorithm {
    /**
     * 选择排序
     * 主要思想是 先从区间0~n-1中选择最小的与nums[0]交换 然后从1~n-1中选择最小的与nums[1]交换
     */
    void selectSort(int[] nums) {
        int n = nums.length;
        //外循环 未排序区间是0~n-1
        for(int i=0;i<n;i++) {
            int k = i;
            //找到最小的位置
            for(int j = i+1;j<n;j++) {
                if(nums[j] < nums[k]) k = j;
            }
            //将最小的元素交换
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

    /**
     * 冒泡排序
     * 连续比较交换相邻元素实现排序
     */
    void bubbleSort(int[] nums) {
        //外循环 未排序区间是[0,i]
        for(int i= nums.length-1;i>0;i--) {
            boolean flag = false; //初始化标志位
            for(int j=0;j<i;j++) {
                if(nums[j] >nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if(!flag) {
                break;    //此轮冒泡未交换任何元素 直接跳出
            }
        }
    }

    /**
     * 插入排序  在未排序区间选择一个基准元素，将该元素与其左侧已排序区间的元素逐一比较大小，并将该元素插入到正确的位置
     * @param nums
     */
    void insertSort(int[] nums) {
        //假设第一个元素已经排好序
        for(int i=1;i< nums.length;i++) {
            int base = nums[i], j = i-1;
            //内循环 将base插入到0-j的正确位置
            while(j>=0&&nums[j]>base) {
                nums[j+1] = nums[j];   //将nums[j]向后移动
                j--;
            }
            nums[j+1] = base;
        }
    }


    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**
     * 快速排序
     * @param nums
     */
    //哨兵划分
    int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        while(i < j) {
            while(i < j && nums[j] >= nums[left]) {
                j--;
            }
            while(i < j && nums[i] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);  //将基准数交换至两数组的分界线
        return i;
    }
    void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot-1);
        quickSort(nums, pivot+1, right);
    }

    //归并排序 持续的将左右两个较短的有序数组合并为一个较长的有序数组直至结束
    void merge(int[] nums, int left, int mid, int right) {
        //初始化辅助数组
        int[] temp = Arrays.copyOfRange(nums, left, right+1);
        //左子数组的起始索引和结束索引
        int leftStart = left- left, leftEnd = mid - left;
        //右子数组的起始索引和结束索引
        int rightStart = mid + 1-left, rightEnd = right - left;
        int i = leftStart, j = rightStart;
        //通过覆盖原数组来合并左子数组和右子数组
        for(int k=left;k<=right;k++) {
            if(i > leftEnd) {
                nums[k] = temp[j++];
            }else if(j>rightEnd || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            }else {
                nums[k] = temp[j++];
            }
        }
    }

    void mergeSort(int[] nums, int left, int right) {
        if(left>=right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    /**
     * 桶排序  通过设置一些具有大小顺序的桶，每个桶对应一个数据范围，将数据平均分配到各个桶中；然后，在每个桶内部分别执行排序；最终按照桶的顺序将所有数据合并
     */
    void bucketSort(float[] nums) {
        //初始化n/2个桶 预计每个桶存放两个元素
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for(int i=0;i<k;i++) buckets.add(new ArrayList<>());
        //将数组分配到各个桶中
        for(float num:nums) {
            //输入数据范围[0,1) 使用num * k 映射到索引范围[0,k-1]
            int i = (int) (num * k);
            buckets.get(i).add(num);
        }
        //对各个桶进行排序
        for(List<Float> bucket: buckets) {
            Collections.sort(bucket);
        }
        //遍历桶 合并结果
        int i = 0;
        for(List<Float> bucket: buckets) {
            for(float num : bucket) {
                nums[i++] = num;
            }
        }
    }

    //计数排序
    void countingSort(int[] nums) {
        //统计最大的数字
        int m = 0;
        for(int num:nums) {
            m = Math.max(m, num);
        }
        int[] count = new int[m + 1];
        for(int num : nums) count[num]++;
        //求前缀和 将出现次数转为尾索引
        for(int i=0;i<m;i++) {
            count[i+1] += count[i];
        }
        //倒序遍历nums 将各个元素填入结果数组中
        int n = nums.length;
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--) {
            int num = nums[i];
            res[count[num] -1 ]= num;
            count[num]--;
        }
        for(int i=0;i<n;i++) {
            nums[i] = res[i];
        }
    }

}
