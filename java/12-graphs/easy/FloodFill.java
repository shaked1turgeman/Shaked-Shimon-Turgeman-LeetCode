package easy;

// Time = O(m*n)   ,   Space = O(m*n)
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int destC, int prev){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length) return;
        else if(image[sr][sc]==prev){
            image[sr][sc]=destC;
            dfs(image,sr+1,sc,destC,prev);
            dfs(image,sr-1,sc,destC,prev);
            dfs(image,sr,sc+1,destC,prev);
            dfs(image,sr,sc-1,destC,prev);
        }
    }
}
