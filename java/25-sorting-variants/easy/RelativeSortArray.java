// Time = O(n+k)   ,   Space = O(k) *k=1001;
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counters = new int[1001];
        for(int i=0; i<arr1.length; i++)    counters[arr1[i]]++;
        int i=0, j=0;
        while(j<arr2.length){
            arr1[i]=arr2[j];
            i++;
            counters[arr2[j]]--;
            if(counters[arr2[j]]==0)    j++;
        }
        for(int h=0; h<counters.length; h++)
            {while(counters[h]!=0)   {arr1[i]=h; i++; counters[h]--;}}
        return arr1;
    }
}
