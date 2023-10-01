package com.project.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的设计与实现
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    /**
     * 二叉树遍历
     */
    //层序遍历
    List<Integer> leverOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化队列加入根节点
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();  //出队
            list.add(cur.val);
            if(cur.left!=null) queue.offer(cur.left);   //添加到队列
            if(cur.right!=null) queue.offer(cur.right);
        }
        return list;
    }

    //前中后序遍历
    void preOrder(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

}

public class TreeTest {
    public static void main(String[] args) {
        // 初始化节点
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        // 构建引用指向（即指针）
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        //List<Integer> leverList = n1.leverOrder(n1);
        //for(int i=0;i<leverList.size();i++) {
        //    System.out.println(leverList.get(i));
        //}
        n1.inOrder(n1);
    }
}
