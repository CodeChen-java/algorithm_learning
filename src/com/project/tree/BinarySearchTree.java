package com.project.tree;

/**
 * 二叉搜索树的设计与实现
 */
class BinarySearch {
    int val;
    BinarySearch left;
    BinarySearch right;

    public BinarySearch(int x) {
        this.val = x;
    }

    //查找节点值
    BinarySearch search(int num, BinarySearch root) {
        BinarySearch cur = root;
        //循环查找 直到叶子结点
        while(cur!=null) {
            if(cur.val < num) {
                cur = cur.right;
            }else if(cur.val > num) {
                cur = cur.left;
            }else {
                break;
            }
        }
        //返回目标节点
        return cur;
    }

    //插入节点
    void insert(int num, BinarySearch root) {
        if(root == null) {
            root = new BinarySearch(num);
            return;
        }
        BinarySearch cur = root, pre = null;  //pre节点是为了保存插入节点父节点的位置
        while(cur!=null) {
            if( cur.val == num) return;
            pre = cur;
            if(cur.val > num) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        //插入
        BinarySearch node = new BinarySearch(num);
        if(pre.val < num) {
            pre.right = node;
        }else {
            pre.left = node;
        }
    }

    //删除节点
    void remove(int num, BinarySearch root) {
        if(root == null) return;
        BinarySearch cur = root, pre = null;
        while(cur!=null) {
            if(cur.val == num) break;
            pre = cur;
            if(cur.val > num) cur = cur.left;
            else cur = cur.right;
        }
        //没有待删除节点就直接返回
        if(cur == null) return;
        //判断子节点数量
        if(cur.left == null || cur.right == null) {
            //子节点数量为0时等于null 为1时等于孩子节点
            BinarySearch child = cur.left != null ? cur.left : cur.right;
            //删除节点
            if(cur != root) {
                if(pre.left == cur) {
                    pre.left = child;
                }else {
                    pre.right = child;
                }
            }else {
                //如果删除节点是根 则需要重新指定
                root = child;
            }
        }else {
            //子节点数量为2
            //获取中序遍历的下一个节点
            BinarySearch tmp = cur.right;
            while(tmp.left != null) {
                tmp = tmp.left;
            }
            //递归删除节点
            remove(tmp.val, root);
            cur.val = tmp.val;
        }
    }

    void inOrder(BinarySearch root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}
public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearch root = new BinarySearch(3);
        root.insert(2, root);
        root.insert(4, root);
        root.insert(1, root);
        root.insert(5, root);
        //root.inOrder(root);
        root.remove(2, root);
        root.inOrder(root);
    }
}
