package com.project.graph;

import com.project.utils.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于邻接表实现的图
 */
public class GraphAdjList {
    //邻接表 key代表顶点 value代表该顶点的所有邻接顶点
    Map<Vertex, List<Vertex>> adjList;

    public GraphAdjList(Vertex[][] edges) {
        this.adjList = new HashMap<>();
        //添加所有的顶点和边
        for(Vertex[] edge: edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    //获取顶点数量
    public int size() {
        return adjList.size();
    }

    //添加边
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if(!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2) || vertex2 == vertex1) {
            throw new IllegalArgumentException();
        }
        //添加边
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
    }

    //删除边
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if(!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2) || vertex2 == vertex1) {
            throw new IllegalArgumentException();
        }
        adjList.get(vertex1).remove(vertex2);
        adjList.get(vertex2).remove(vertex1);
    }

    //添加定点
    public void addVertex(Vertex vertex) {
        if(adjList.containsKey(vertex)) {
            return;
        }
        //在邻接表中添加一个新链表
        adjList.put(vertex, new ArrayList<>());
    }

    //删除顶点
    public void removeVertex(Vertex vertex) {
        if(!adjList.containsKey(vertex)) {
            throw new IllegalArgumentException();
        }
        //在邻接表中删除顶点vertex对应的链表
        adjList.remove(vertex);
        //遍历其他节点列表 删除包含vertex的边
        for(List<Vertex> list: adjList.values()) {
            list.remove(vertex);
        }
    }

    //打印邻接表
    public void print() {
        System.out.println("邻接表：");
        for(Map.Entry<Vertex, List<Vertex>> pair: adjList.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            for(Vertex v: pair.getValue()) {
                temp.add(v.val);
            }
            System.out.println(pair.getKey().val + " : " + temp + ", ");
        }
    }
}
