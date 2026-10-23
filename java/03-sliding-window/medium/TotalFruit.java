// Time = O(n)  ,   Space = O(1)
public class TotalFruit {
    public int totalFruit(int[] fruits) {
        int right=0, left=0, fruit1=-1, fruit2=-1, max=0, check=0, cntr1=0, cntr2=0;
        
        while((fruit1==-1 || fruit2==-1) && right<fruits.length){
            int j=fruits[right];
            if (fruit1==-1  &&  fruit2==-1) {fruit1=j;   cntr1++;}
            else if (fruit2==-1  &&  fruit1!=j) {fruit2=j;   cntr2++; }
            else if(j==fruit1)  cntr1++;
            else    cntr2++;
            check=right-left+1;
            max=Math.max(check,max);
            right++;
        }
        while(right<fruits.length){
            int j=fruits[right];
            if (j!=fruit1   &&  j!=fruit2){
                while(cntr1!=0  &&  cntr2!=0){
                    int swap = fruits[left];
                    if(swap==fruit1)    cntr1--;
                    else    cntr2--;
                    left++;
                }
                if(cntr1==0)    fruit1=j;
                else    fruit2=j;
            }
            if(j==fruit1)   cntr1++;
            else    cntr2++;
            check=right-left+1;
            max=Math.max(check,max);
            right++;
        }
        return max;
    }
}
