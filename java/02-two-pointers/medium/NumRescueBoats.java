// Time = O(n*log(n)) , Space = O(1) 
public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0, r=people.length-1, min=0;
        while(l<=r){
            if(people[l]+people[r]<=limit)  l++;
            r--;    min++;
        }
        return min;
    }
}
