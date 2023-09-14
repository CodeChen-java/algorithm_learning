package com.project.linearlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 简单实现ArrayList
 */
class MyList {

    private int[] nums;
    private int size = 0;        //列表长度
    private int capacity = 10;   //列表容量
    private int extendRatio = 2;  //每次扩容的倍数

    public MyList() {
        nums = new int[capacity];
    }

    //获取链表长度
    public int size() {
        return size;
    }

    //获取列表容量
    public int capacity() {
        return capacity;
    }

    //访问元素
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return nums[index];
    }

    //更新元素
    public void set(int index, int num) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        nums[index] = num;
    }

    //插入元素
    public void insert(int index, int num) {
        if(size == capacity) {
            extendNums();
        }
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        for(int i=size-1;i > index;i--) {
            nums[i] = nums[i-1];
        }
        nums[index] = num;
        size++;
        return;
    }

    //数组末尾插入元素
    public void add(int num) {
        if(size == capacity ) {
            extendNums();
        }
        nums[size] = num;
        size++;
    }

    //删除元素
    public void delete(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        for(int i=index;i<size-1;i++) {
            nums[i] = nums[i+1];
        }
        size--;
    }

    public void extendNums() {
        nums = Arrays.copyOf(nums, capacity() * extendRatio);
        capacity = nums.length;
    }

    //将列表转为数组
    public int[] toArray() {
        int size = size();
        int[] nums = new int[size];
        for(int i=0;i<size;i++) {
            nums[i] = get(i);
        }
        return nums;
    }
}

public class CustomList {
}
