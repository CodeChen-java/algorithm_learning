package com.project.linearlist;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }

    /**
     * 打印链表
     */
    public void printList(ListNode root) {
        ListNode p = root;
        while(p!=null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    /**
     * 插入节点
     */
    public void insert(ListNode root, ListNode p, int val) {
        ListNode q = new ListNode(val);
        ListNode cur = root;
        while(cur!=null) {
            cur = cur.next;
            if(cur == p) break;
        }
        q.next = cur.next;
        cur.next = q;
        return;
    }

    /**
     * 删除一个节点
     */
    public void delete(ListNode root, ListNode p) {
        ListNode cur = root;
        while(cur!=null) {
            cur = cur.next;
            if(cur.next == p) break;
        }
        ListNode q = cur.next;
        cur.next = q.next;
        return;
    }

    /**
     * 查找值返回节点
     */
    public ListNode getTarget(ListNode root, int target) {
        ListNode cur = root;
        while(cur!=null) {
            if(cur.val == target) break;
            else cur = cur.next;
        }
        return cur;
    }
}
public class LinkedList {

    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        // 构建引用指向
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //插入节点并打印
        n0.insert(n0, n2, 10);
        n0.printList(n0);
        System.out.println("*************************");
        //删除节点并打印
        n0.delete(n0, n2.next);
        n0.printList(n0);
    }
}
