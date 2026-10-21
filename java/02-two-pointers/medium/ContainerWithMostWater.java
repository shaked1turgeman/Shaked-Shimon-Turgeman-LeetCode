//Time = O(n) , Space = O(1)
public class MaxArea {
    public int maxArea(int[] height) {
        int maxi=0;
        int l=0, r=height.length-1, temp=0;
        while(r>l){
            temp=Math.min(height[l],height[r])*(r-l);
            if(temp>maxi)   maxi=temp;
            if(height[l]<height[r])   l++;
            else    r--;
        }
        return maxi;
    }
}
