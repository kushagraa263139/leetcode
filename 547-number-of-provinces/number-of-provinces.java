// 0 -> path donot exist 
// 1 -> path exist but not explored
// 2 -> path exist and explored


class Solution {


    // public void createGraph(int [][] a,List<List<Integer>> graph){

    //     for(int i=0;i<graph.size();i++){
    //         graph.add(new ArrayList<>());
    //     }

    //      for(int city1=0;city1<a.length;city1++){
    //         for(int city2=0;city2<a.length;city2++){
    //             if(city1!=city2 && a[city1][city2]==1){
    //                graph.get(city1).add(city2);
    //                graph.get(city2).add(city1);
    //             }
    //         }
    //     }
    // }
    public void createGraph(int[][] a, List<List<Integer>> graph) {
    int n = a.length;

    // Step 1: Add empty lists to the graph
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }

    // Step 2: Fill adjacency list based on matrix
    for (int city1 = 0; city1 < n; city1++) {
        for (int city2 = 0; city2 < n; city2++) {
            if (city1 != city2 && a[city1][city2] == 1) {
                graph.get(city1).add(city2);
                graph.get(city2).add(city1);  // Only for undirected graphs
            }
        }
    }
}

    public void helper(List<List<Integer>> graph,boolean [] visited,int city){
        visited[city]=true;
        for(int neighbour:graph.get(city)){
            if(!visited[neighbour]) helper(graph,visited,neighbour);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        createGraph(isConnected, graph);
        boolean [] visited= new boolean[graph.size()];
        int p=0;
        for(int city1=0;city1<graph.size();city1++){
           if(!visited[city1]){
            p++;
            helper(graph,visited,city1);
           }
        }
        return p;
    }
}