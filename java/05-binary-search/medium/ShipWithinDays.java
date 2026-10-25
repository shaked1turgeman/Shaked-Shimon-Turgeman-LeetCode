// Time = O(n*log(S))   ,   Space = O(1)  || S=sum(weights)
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int right=0, left=0;
        for(int i=0;i<weights.length;i++)
            {left=Math.max(left,weights[i]);    right+=weights[i];}
        while(right>left){
            int i = left + (right-left)/2, total=1, remain=i;
            for(int j=0; j<weights.length;j++){
                if(remain>=weights[j])   remain-=weights[j];
                else    {total++; remain=i-weights[j];}    
            }
            if(total>days)  left=i+1;
            else right=i;
        }
        return left;
    }
}
