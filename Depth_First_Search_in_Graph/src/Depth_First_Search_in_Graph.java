/* Problem Statement (PB)

Given a graph represented using an adjacency list, perform Depth First Search (DFS) traversal starting from a given node start.

DFS explores as far as possible along each branch before backtracking.

Return a list containing the order of nodes visited during the DFS traversal.

Example

Graph:

1 -> 2,3
2 -> 1,5,6
3 -> 1,4,7
4 -> 3,8
5 -> 2
6 -> 2
7 -> 3,8
8 -> 7,4

Start node:

start = 1

Output:

[1, 2, 5, 6, 3, 4, 8, 7]
Time Complexity (TC)

O(V + E)

Where:

V = number of vertices (nodes)

E = number of edges

Reason:

Each vertex is visited once

Each edge is explored once

Space Complexity (SC)

O(V)

Space is used for:

Visited array → O(V)

DFS recursion stack → O(V) in worst case

Result list (dfs) → O(V)

Therefore overall:

SC = O(V)*/

import java.util.ArrayList;

public class Depth_First_Search_in_Graph {


    public static void depthfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int n, ArrayList<Integer> dfs)
    {
        visited[n] = 1;
        dfs.add(n);

        for(int neighbour : adj.get(n))
        {
            if(visited[neighbour] == 0)
            {
                depthfs(adj,visited,neighbour,dfs);
            }
        }
    }

    public static ArrayList<Integer> DFS_Traversal(ArrayList<ArrayList<Integer>> adj, int start)
    {

        ArrayList<Integer> dfs = new ArrayList<>();
        int[] visited = new int[adj.size()];

        depthfs(adj,visited,start,dfs);

        return dfs;
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=8;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(3);
        adj.get(4).add(8);

        adj.get(5).add(2);

        adj.get(6).add(2);

        adj.get(7).add(3);
        adj.get(7).add(8);

        adj.get(8).add(7);
        adj.get(8).add(4);

        ArrayList<Integer> dfs = DFS_Traversal(adj,1);
        System.out.println("The DFS Traversal of the Graph is: ");
        System.out.print(dfs);
    }
}
