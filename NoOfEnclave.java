class Solution {
    static int xdir[] = {-1,0,1,0};
    static int ydir[] = {0,-1,0,1};
    public static void numEnclave_dfs(int [][] grid,int x,int y){
        grid[x][y] = 0;
        for(int d = 0;d<4;d++)
        {   
            int r = x + xdir[d];
            int c = y + ydir[d];
            if(r>=0 && r< grid.length && c>=0 && c<grid[0].length && grid[r][c]!=0)
            {
                numEnclave_dfs(grid,r,c);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int one_count = 0;
        //0th row
        for(int c = 0;c<grid[0].length;c++)
        {
            if(grid[0][c] == 1)
            {
                numEnclave_dfs(grid,0,c);
            }
        }
        //last row
        for(int c = 0;c<grid[0].length;c++)
        {
            if(grid[grid.length-1][c] == 1)
            {
                numEnclave_dfs(grid,grid.length-1,c);
            }
        }
        //first column
        for(int r = 0;r<grid.length;r++)
        {
            if(grid[r][0] == 1)
            {
                numEnclave_dfs(grid,r,0);
            }
        }
        //last column
        
        for(int r = 0;r<grid.length;r++)
        {
            if(grid[r][grid[0].length-1] == 1)
            {
                numEnclave_dfs(grid,r,grid[0].length-1);
            }
        }
        
        //check for no. of ones
        for(int i = 0;i<grid.length;i++)
        {
            for(int j =0 ;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    one_count++;
            }
        }
        return one_count;
    }
}