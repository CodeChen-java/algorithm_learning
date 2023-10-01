package com.project.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基于数组实现的完全二叉树
 */
class BinaryTree {
    private List<Integer> tree;

    public BinaryTree(List<Integer> arr) {
        tree = new ArrayList<>(arr);
    }

    //获取节点数量
    public int getSize() {
        return tree.size();
    }

    //获取索引为i的节点值
    public Integer getVal(int i) {
        if( i < 0 || i >= tree.size()) return null;
        return tree.get(i);
    }

    //获取i节点的左右索引
    public Integer getLeft(int i) {
        return 2 * i + 1;
    }

    public Integer getRight(int i) {
        return 2 * i + 2;
    }

    //获取i节点的父节点
    public Integer getFath(int i) {
        return ( i - 1 ) / 2;
    }

    //层序遍历
    public List<Integer> leverOrder() {
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<tree.size();i++) {
            if(getVal(i)!=null) arr.add(getVal(i));
        }
        return arr;
    }

    //深度优先
    public void dfs(Integer i, String order, List<Integer> res) {
        // 若为空位，则返回
        if (getVal(i) == null)
            return;
        // 前序遍历
        if (order == "pre")
            res.add(getVal(i));
        dfs(getLeft(i), order, res);
        // 中序遍历
        if (order == "in")
            res.add(getVal(i));
        dfs(getRight(i), order, res);
        // 后序遍历
        if (order == "post")
            res.add(getVal(i));
    }

    //前序
    public List<Integer> preOrder() {
        List<Integer> arr = new ArrayList<>();
        dfs(0, "pre", arr);
        return arr;
    }

    //中序
    public List<Integer> inOrder() {
        List<Integer> arr = new ArrayList<>();
        dfs(0, "in", arr);
        return arr;
    }

    //后序
    public List<Integer> postOrder() {
        List<Integer> arr = new ArrayList<>();
        dfs(0, "post", arr);
        return arr;
    }

}
public class ArrayBinaryTree {
    public static void main(String[] args) {
        Integer[] tree = { 1, 2, 3, 4, null, 6, 7, 8, 9, null, null, 12, null, null, 15 };
        BinaryTree binaryTree = new BinaryTree(Arrays.asList(tree));
        List<Integer> leverList = binaryTree.leverOrder();
        //for(int i=0;i<leverList.size();i++) {
        //    System.out.println(leverList.get(i));
        //}
        List<Integer> preList = binaryTree.inOrder();
        for(int i=0;i<preList.size();i++) {
            System.out.println(preList.get(i));
        }
    }
}
