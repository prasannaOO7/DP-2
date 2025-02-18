// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach


class Solution {
    public int change(int amount, int[] coins) {
  
  //      return helper(amount,coins,0);  -->recursion
        
  //      dp solution
        int m=coins.length;
        int n=amount;
        
        int[][] dp = new int [m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[m][n];
    }
  // recuursion  
    private int helper(int amount,int[] coins,int index){
        //base
        if(index==coins.length || amount<0){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        
        //case
        int case1 = helper(amount,coins,index+1);
        int case2 = helper(amount-coins[index],coins,index);
        
        return case1+case2;
    }
}