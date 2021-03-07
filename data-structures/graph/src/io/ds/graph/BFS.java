package io.ds.graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(3,2);
        graph.addEdge(3,4);

        System.out.println("################ Breadth first search" );
        graph.bfs(0);

        System.out.println("################ depth first search" );
        graph.dfs(0);

        System.out.println("################ depth  first search iterative" );
        graph.dfs_iterative(0);

    }


}

class Graph {
    int vertices;
    List<Integer>[] matrix;
    public Graph(int vertices){
        this.vertices = vertices;
        this.matrix = new LinkedList[vertices];
        for (int i =0 ; i < vertices;i++){
            matrix[i] = new LinkedList<Integer>();
        }
    }
    public  void addEdge(int u , int v){
            matrix[u].add(v);
    }

    public void bfs(int s){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        List<Integer> neighbors;
        visited[s] = true;
        while (!queue.isEmpty()){
            int element = queue.poll();
            System.out.println(" -> " + element);
            neighbors = matrix[element];
            for (int u : neighbors){
                if (!visited[u]){
                    queue.add(u);
                    visited[u] = true;
                }

            }
        }
    }

    public void dfs(int s){
        boolean[] visisted = new boolean[vertices];
        dfs_rec(0,visisted);

    }

    public void dfs_rec(int s, boolean[] visited){
        visited[s] = true;
        System.out.println(" --> " + s );
        List<Integer> v = matrix[s];
        for (int u: v){
            if(!visited[u]){
                dfs_rec(u,visited);
            }

        }
    }

    public void dfs_iterative(int s){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);


        List<Integer> neighbours ;

        while (!stack.isEmpty()){
            int v = stack.pop();
            System.out.println("v = " + v);
            neighbours = matrix[v];
            for (int u : neighbours){
                if(!visited[u]){
                    stack.push(u);
                    visited[u] = true;
                }
            }

        }


    }
}
