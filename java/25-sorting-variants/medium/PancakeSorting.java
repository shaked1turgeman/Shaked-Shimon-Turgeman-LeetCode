// Time = O(n^2)   ,   Space = O(n)
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for(int i=n; i>0; i--){
            for(int j=0; j<i; j++){
                if(j==i-1)  break;
                if(arr[j]==i){
                    if(j!=0)   {res.add(j+1);  flip(arr,j);}
                    res.add(i);
                    flip(arr,i-1);
                    break;
                }
            }
        }
        return res;
    }

    private void flip(int[] arr, int k){
        int left=0;
        while(k>left){
            int temp=arr[left];
            arr[left]=arr[k];
            arr[k]=temp;
            k--;
            left++;
        }
    }
}
