package easy;

// Time = O(n^2)   ,   Space = O(1)
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
        for(int i=0; i<n; i++){
            flipper(image[i]);
            for(int j=0; j<n; j++)  image[i][j]^=1;           
        }
        return image;
    }

    public void flipper(int[] row){
        int left=0, right=row.length-1,temp=0;
        while(right>left){
            temp=row[right];
            row[right]=row[left];
            row[left]=temp;
            right--;  left++;
        }
    }
}
