class Solution {
    static int xdir[] = {-1,0,1,0};
    static int ydir[] = {0,-1,0,1};
    public static void island_dfs(char [][] grid,int x,int y){
        grid[x][y] = '0';
        for(int d = 0;d<4;d++)
        {   
            int r = x + xdir[d];
            int c = y + ydir[d];
            if(r>=0 && r< grid.length && c>=0 && c<grid[0].length && grid[r][c]!='0')
            {
                island_dfs(grid,r,c);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int island_count = 0;
        for(int i =0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == '1')
                {
                    island_dfs(grid,i,j);
                    island_count++;
                }
            }
        }
        return island_count;
    }
}