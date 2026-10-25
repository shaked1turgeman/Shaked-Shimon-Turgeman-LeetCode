import java.util.List;
import java.util.ArrayList;
// Time = O(m+n)  ,   Space = O(1)
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int first=0, second=0;
        while(first<firstList.length&&second<secondList.length){
            if(firstList[first][1]<secondList[second][0])   first++;
            else if (firstList[first][0]>secondList[second][1]) second++;
            else{
                int aStart=firstList[first][0], bStart=secondList[second][0];
                int aEnd=firstList[first][1], bEnd=secondList[second][1];
                int[] addIntersec = {Math.max(aStart, bStart),Math.min(aEnd, bEnd)};
                result.add(addIntersec);
                if(firstList[first][1]>secondList[second][1])   second++;
                else    first++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
