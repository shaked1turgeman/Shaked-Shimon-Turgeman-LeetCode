// Time = O(1)   ,   Space = O(1)
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long a=distance(p1[0],p1[1],p2[0],p2[1]), b=distance(p2[0],p2[1],p3[0],p3[1]);
        long c=distance(p3[0],p3[1],p4[0],p4[1]), d=distance(p1[0],p1[1],p4[0],p4[1]);
        long e=distance(p1[0],p1[1],p3[0],p3[1]), f=distance(p4[0],p4[1],p2[0],p2[1]);
        if(a==0 || b==0 || c==0 || d==0 || e==0 || f==0)    return false;
        long[] sort = new long[] {a,b,c,d,e,f};
        int sides=0, vertical=0;
        
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (sort[j] > sort[j+1]) 
                    {long temp = sort[j]; sort[j] = sort[j+1]; sort[j+1] = temp;}
            }
        }

        return (sort[0] > 0 && sort[0] == sort[1] && sort[1] == sort[2] &&
                sort[2] == sort[3] && sort[4] == sort[5]);
    }

    public long distance(int x1, int y1, int x2, int y2){
        long dx = (long) x2 - x1;
        long dy = (long) y2 - y1;
        return dx * dx + dy * dy;
    }
}
