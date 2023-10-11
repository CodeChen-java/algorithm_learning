package com.project.graph;

import com.project.utils.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 图的遍历方式之DFS
 */
public class DFS {
    //辅助函数
    void dfs(GraphAdjList graph, Set<Vertex> visited, List<Vertex> res, Vertex vet) {
        res.add(vet);
        visited.add(vet);
        //遍历该顶点所有连接顶点
        for(Vertex adjVet:graph.adjList.get(vet)) {
            if(visited.contains(adjVet)) {
                continue;
            }
            //递归访问邻街顶点
            dfs(graph, visited, res, adjVet);
        }
    }

    //深度优先遍历
    List<Vertex> graphDFS(GraphAdjList graph, Vertex startVertex) {
        List<Vertex> res = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        dfs(graph, visited, res, startVertex);
        return res;
    }
}
