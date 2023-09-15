package com.project.deque;

import java.util.List;
/* 双向链表节点 */

/**
 * 自定义双端队列的实现 基于双链表
 */

class ListNode {
    int val;
    ListNode next, prev;
    ListNode(int num) {
        this.val = num;
        prev = next = null;
    }
}

class LinkedListDeque {
    private ListNode front , rear;
    private int queSize = 0;

    public LinkedListDeque() {
        front = rear = null;
    }

    //获取长度
    public int size() {
        return queSize;
    }

    public boolean isEmpty() {
        return queSize == 0;
    }

    //入队操作
    public void push(int num, boolean isFront) {
        ListNode node = new ListNode(num);
        if(isEmpty()) {
            front = rear = node;
        }else if(isFront == true) {
            //从头入队
            front.prev = node;
            node.next = front;
            front = node;
        }else {
            //从尾入队
            rear.next = node;
            node.prev = rear;

            rear = node;
        }
        queSize++;
    }

    //队首入队
    public void pushFirst(int num) {
        push(num, true);
    }

    //队尾入队
    public void pushLast(int num) {
        push(num, false);
    }

    //出队操作
    public int pop(boolean isFront) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int val;
        if(isFront == true) {
            //从队首出
            val = front.val;
            //删除头结点
            ListNode node = front.next;
            if(node != null) {
                node.prev = null;
                front.next = null;
            }
            front = node;
        }else {
            //队尾出队
            val = rear.val;
            ListNode node = rear.prev;
            if(node != null) {
                node.next = null;
                rear.prev = null;
            }
            rear = node;
        }
        queSize--;
        return val;
    }

    //队首出队
    public int popFirst() {
        int val = pop(true);
        return val;
    }

    public int popLast() {
        int val = pop(false);
        return val;
    }

    //转为数组
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}


public class LinkedDeque {
    public static void main(String[] args) {
        LinkedListDeque listDeque = new LinkedListDeque();
        listDeque.push(1, true);
        listDeque.push(2, false);
        listDeque.push(3, true);
        listDeque.push(4, false);
        listDeque.push(5, true);
        listDeque.push(6, false);
        int[] res = listDeque.toArray();
        for(int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
        System.out.println("从队头出一个元素是："+listDeque.popFirst());
        System.out.println("从队尾出一个元素是："+listDeque.popLast());
        int[] res2 = listDeque.toArray();
        for(int i=0;i<res2.length;i++) {
            System.out.println(res2[i]);
        }
        //System.out.println(listDeque.size());
    }
}
