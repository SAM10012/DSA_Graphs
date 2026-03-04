/* 🧩 Problem Statement

Given a graph represented using an adjacency list and a starting node, perform Breadth First Search (BFS) traversal and return the list of vertices in the order they are visited.

The graph is represented as:

ArrayList<ArrayList<Integer>> adj

where adj.get(i) contains all neighbours of vertex i.

The function:

public static ArrayList<Integer> BFS_Traversal(ArrayList<ArrayList<Integer>> adj, int start)

returns an ArrayList<Integer> containing the BFS traversal starting from the given node.

⏱ Time Complexity (TC)
👉 O(V + E)

Where:

V = Number of vertices (adj.size())

E = Number of edges

Reason:

Each vertex is visited exactly once → O(V)

Each edge is explored once during traversal → O(E)

So total:

O(V + E)
💾 Space Complexity (SC)
👉 O(V)

Because of:

visited[] array → O(V)

Queue → In worst case stores O(V) nodes

bfs result list → O(V)

Total auxiliary space:

O(V)

(Note: Adjacency list is input, so it is not counted.)*/

import java.util.*;

public class BFS_Traversal_of_Graph {

    public static ArrayList<Integer> BFS_Traversal(ArrayList<ArrayList<Integer>> adj, int start)
    {
        int[] visited = new int[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<Integer>();

        queue.offer(start);
        visited[start] = 1;


        while(!queue.isEmpty())
        {
            int n = queue.poll();
            bfs.add(n);

                for(int neighbour : adj.get(n))
                {
                    if(visited[neighbour] == 0) {
                        queue.offer(neighbour);
                        visited[neighbour] = 1;
                    }
                }
            }
            return bfs;
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=8;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(1).add(2);
        adj.get(1).add(6);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);

        adj.get(3).add(2);

        adj.get(4).add(2);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(7);

        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(8);

        adj.get(7).add(6);
        adj.get(7).add(5);

        adj.get(8).add(6);

        ArrayList<Integer> bfs = BFS_Traversal(adj,6);
        System.out.println("The BFS Traversal of the Graph is: ");
        System.out.print(bfs);

     }
}
