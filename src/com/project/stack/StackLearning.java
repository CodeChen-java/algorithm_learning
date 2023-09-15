package com.project.stack;

import java.util.List;

/**
 * 自定义栈的实现 基于链表实现
 */

//基于链表实现栈
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

class LinkedListStack  {
    //使用头节点作为栈顶
    private ListNode stackPeek;
    private int size = 0;

    public LinkedListStack() {
        stackPeek = null;
    }

    //获取栈的长度
    public int size() {
        return size;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    //入栈操作
    public void insert(int num) {
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        size++;
    }

    //访问栈顶元素
    public int getPeek() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    //出栈
    public int pop() {
        int num = getPeek();
        stackPeek = stackPeek.next;
        size--;
        return num;
    }

    //将list转为数组
    public int[] toArray() {
        ListNode node = stackPeek;
        int[] arrays = new int[size()];
        for(int i = arrays.length-1;i>=0;i--) {
            arrays[i] = node.val;
            node = node.next;
        }
        return arrays;
    }

    //打印栈
    public void printStack() {
        ListNode node = stackPeek;
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}


public class StackLearning {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.insert(1);
        linkedListStack.insert(2);
        linkedListStack.insert(3);
        linkedListStack.insert(4);
        linkedListStack.insert(5);
        int[] res = linkedListStack.toArray();
        for(int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
