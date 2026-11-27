class Solution {
    public int findJudge(int n, int[][] trust) {
        //using indegree and outdegree concepy...
        int indegree[] = new int[n+1];
        int outdegree[] = new int[n+1];

        for(int i=0;i<trust.length;i++){
            int a = trust[i][0];
            int b = trust[i][1];

            //trust a->b 
            outdegree[a]++;
            indegree[b]++;
            
        }

        int judge = -1;
        for(int i=1;i<=n;i++){
            if(indegree[i] == n-1 && outdegree[i] == 0){
                judge = i;
            }
        }
        return judge;
    }
}