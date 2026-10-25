// Time = O(n*log(M))   ,   Space = O(1)
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1, max =1;
        for(int i=0; i<piles.length; i++)   max=Math.max(max,piles[i]);
        while(max>min){
            int i=min+(max-min)/2;
            long total=0;
            for(int j=0; j<piles.length; j++){
                total+= (piles[j] / i) + (piles[j] % i == 0 ? 0 : 1);
            }
            if(total>h) min=i+1;
            else    max=i;
        }
        return min;
    }
}
