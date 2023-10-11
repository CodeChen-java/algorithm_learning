package com.project.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于邻接矩阵实现的图
 */
public class GraphAdjMat {
    List<Integer> vertices;  //顶点列表  元素代表顶点值 索引代表顶点索引
    List<List<Integer>> adjMat;  //邻接矩阵 行列索引对应顶点索引

    public GraphAdjMat(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();
        //添加顶点
        for(int val : vertices) {
            addVertex(val);
        }
        //添加边 edges代表顶点索引
        for(int[] e: edges) {
            addEdge(e[0], e[1]);
        }
    }

    //获取顶点数量
    public int size() {
        return vertices.size();
    }

    //添加顶点
    public void addVertex(int val) {
        int size = size();
        //向顶点列表中添加新顶点的值
        vertices.add(val);
        //像邻接矩阵中增加一行
        List<Integer> newRow = new ArrayList<>(size);
        for(int j=0;j<size;j++) {
            newRow.add(0);
        }
        adjMat.add(newRow);
        //在邻接矩阵中增加一列
        for(List<Integer> row: adjMat) {
            row.add(0);
        }
    }

    //删除顶点
    public void removeVertex(int index) {
        if(index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        //在顶点列表中移除索引为index的节点
        vertices.remove(index);
        //在邻接矩阵中移除索引为index的行
        adjMat.remove(index);
        //在邻接矩阵中删除索引为index的列
        for(List<Integer> row : adjMat) {
            row.remove(index);
        }
    }

    //添加边
    public void addEdge(int i, int j) {
        if(i < 0 || j < 0 || i >= size() || j >= size()) {
            throw new IndexOutOfBoundsException();
        }
        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    //删除边
    public void removeEdge(int i, int j) {
        if(i <0 || j<0 || i>=size() || j >= size()) {
            throw new IndexOutOfBoundsException();
        }
        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    //打印邻接矩阵
    public void print() {
        System.out.println("顶点列表：");
        System.out.println(vertices);
        System.out.println("邻接矩阵：");
        for(List<Integer> list:adjMat) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        int[] vertices = {1, 2, 3, 4, 5};
        int[][] edges = {{0, 1}, {1, 3}, {3, 4}, {2, 4}};

        GraphAdjMat mat = new GraphAdjMat(vertices, edges);
        mat.addEdge(0, 4);
        mat.print();
        mat.addVertex(6);
        mat.print();
    }

}
