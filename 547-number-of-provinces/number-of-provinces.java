class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]!=true){
                count++;
                bfs(isConnected,visited,i);
            }
        }
        return count;
        
    }
    void bfs(int[][] isConnected,boolean[] visited,int i){
        visited[i]=true;
        for(int j=0;j<isConnected[i].length;j++){
            if(visited[j]==false && isConnected[i][j]==1){
                bfs(isConnected,visited,j);
            }
        }
    }
}