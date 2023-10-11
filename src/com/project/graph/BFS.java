package com.project.graph;

import com.project.utils.Vertex;
import com.sun.beans.finder.PrimitiveWrapperMap;

import java.util.*;

/**
 * 图的遍历方式之BFS
 */
public class BFS {
    List<Vertex> graphBFS(GraphAdjList graph, Vertex startVet) {
        //顶点序列遍历
        List<Vertex> res = new ArrayList<>();
        //哈希表用于存储被访问过的节点
        Set<Vertex> visited = new HashSet<>();
        visited.add(startVet);
        Queue<Vertex> que = new LinkedList<>();
        que.offer(startVet);
        //以顶点为起点 循环访问直至访问完所有顶点
        while(!que.isEmpty()) {
            Vertex v = que.poll();
            res.add(v);
            //遍历该节点的所有临界顶点
            for(Vertex adjVet: graph.adjList.get(v)) {
                if(visited.contains(adjVet)) continue;
                que.offer(adjVet);
                visited.add(adjVet);
            }
        }
        return res;
    }
}
