package com.project.tree;

/**
 * AVL树设计
 */
class AVLTree {
    int val;
    //节点高度
    int height;
    AVLTree left;
    AVLTree right;
    public AVLTree(int x) {
        this.val = x;
    }

    //获取节点高度 空节点高度-1 叶节点高度0
    public int height(AVLTree node) {
        return node == null ? -1 : node.height;
    }

    //更新叶节点高度
    void updateHeight(AVLTree node) {
        //节点高度等于最高子树高度+1
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    //获取平衡因子 节点左子树的高度减去右子树的高度 空节点平衡因子是0
    int getBalance(AVLTree node) {
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }

    //右旋操作
    AVLTree rightRotate(AVLTree node) {
        AVLTree child = node.left;
        AVLTree grandChild = child.right;
        //以child为原点向右旋转
        child.right = node;
        node.left = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    //左旋操作
    AVLTree leftRotate(AVLTree node) {
        AVLTree child = node.right;
        AVLTree grandChild = child.left;
        child.left = node;
        node.right = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    //执行旋转操作 让子树重新恢复平衡
    AVLTree rotate(AVLTree node) {
        //获取节点平衡因子
        int balanceFactor = getBalance(node);
        //左偏树
        if(balanceFactor > 1) {
            if(getBalance(node.left) >=0) return rightRotate(node);
            else {
                //先左后右
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //右偏树
        if(balanceFactor < 1) {
            if(getBalance(node.right) <= 0) {
                return leftRotate(node);
            }else {
                //先右后左
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        //平衡树 直接返回
        return node;
    }

    //插入节点
    void insert(int val, AVLTree root) {
        root = insertHelper(root, val);
    }
    AVLTree insertHelper(AVLTree node, int val) {
        if(node == null) {
            return new AVLTree(val);
        }
        //查找插入位置
        if(val < node.val) {
            node.left = insertHelper(node.left, val);
        }else if(val > node.val) {
            node.right = insertHelper(node.right, val);
        }else {
            return node;
        }
        //更新节点高度
        updateHeight(node);
        //执行旋转操作 让子树重新平衡
        node = rotate(node);
        return node;
    }

    //递归删除节点
    AVLTree removeHelper(AVLTree node, int val) {
        if(node == null) {
            return null;
        }
        //查找节点并删除
        if(val < node.val) {
            node.left =  removeHelper(node.left, val);
        }else if(val > node.val) {
            node.right = removeHelper(node.right, val);
        }else {
            if(node.left == null || node.right == null) {
                AVLTree child = node.left != null ? node.left : node.right;
                if(child == null) return null;
                else node = child;
            }else {
                AVLTree tmp = node.right;
                while(tmp.left!=null) {
                    tmp = tmp.left;
                }
                node.right = removeHelper(node.right, tmp.val);
                node.val = tmp.val;
            }
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }

}
public class AVLTreeLearning {
}
