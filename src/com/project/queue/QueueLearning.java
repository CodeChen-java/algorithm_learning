package com.project.queue;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义基于链表的队列实现
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int num) {
        this.val = num;
    }
}

class LinkedListQueue  {
    //定义头尾指针 头指针用来出队列 尾指针用来进队
    private ListNode front, rear;
    private int size = 0;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    //返回长度
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //进队操作
    public void push(int num) {
        ListNode node = new ListNode(num);
        if(front == null) {
            front = node;
            rear = node;
        }else {
            //队列不为空 则插入到尾指针
            rear.next = node;
            rear = node;
        }
        size++;
    }

    //出队
    public int pop() {
        if(size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        int num = front.val;
        front = front.next;
        size--;
        return num;
    }

    //访问队首
    public int peek() {
        if(size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    //将列表转为数组
    public int[] toArray() {
        int[] res = new int[size];
        ListNode node = front;
        for(int i=0;i<res.length;i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }

    //打印
    public void printQueue() {
        ListNode node = front;
        while(node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

/**
 * 自定义基于数组的队列实现
 */
class ArrayQueue {
    private int[] nums;
    private int front;
    private int queSize;

    public ArrayQueue(int capacity) {
        nums = new int[capacity];
        front = queSize = 0;
    }

    //获取长度
    public int size() {
        return queSize;
    }

    public boolean isEmpty() {
        return queSize == 0;
    }

    //获取容量
    public int capacity() {
        return nums.length;
    }

    //入队
    public void push(int num) {
        if(queSize == capacity()) {
            throw new IndexOutOfBoundsException();
        }
        int rear = (front + queSize) % capacity();
        nums[rear] = num;
        queSize++;
    }

    public int top() {
        if(queSize==0) {
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    //出队
    public int pop() {
        if(queSize==0) {
            throw new IndexOutOfBoundsException();
        }
        int num = nums[front];
        front = (front + 1 ) % capacity();
        queSize--;
        return num;
    }

    //转为数组 在合理范围内
    public int[] toArray() {
        int[] res = new int[queSize];
        for(int i=0, j = front; i<queSize;i++, j++) {
            res[i] = nums[j % capacity()];
        }
        return res;
    }

}

public class QueueLearning {
    public static void main(String[] args) {
        //LinkedListQueue linkedListQueue = new LinkedListQueue();
        //linkedListQueue.push(1);
        //linkedListQueue.push(2);
        //linkedListQueue.push(3);
        //linkedListQueue.push(4);
        //linkedListQueue.push(5);
        //linkedListQueue.printQueue();
        //System.out.println("*****************");
        ////System.out.println(linkedListQueue.peek());
        //int[] res = linkedListQueue.toArray();
        //for(int i=0;i<res.length;i++) {
        //    System.out.println(res[i]);
        //}
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(4);
        arrayQueue.push(5);
        //System.out.println(arrayQueue.top());
        arrayQueue.pop();
        int[] res = arrayQueue.toArray();
        for(int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
