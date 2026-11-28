class Solution {
    static int count;
    static void dfs(List<List<Integer>>rooms, int curr, boolean[] vis){
        vis[curr] = true;
        count++;
        for(int vertex : rooms.get(curr)){
            if(!vis[vertex]){
                dfs(rooms,vertex,vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        count =0;
        boolean vis[] = new boolean[n];
        dfs(rooms,0,vis);

        if(count ==n) return true;
        else return false;
    }
}