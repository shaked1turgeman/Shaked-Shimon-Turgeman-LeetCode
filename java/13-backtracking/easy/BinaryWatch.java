package easy;
import java.util.*;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        int[] leds = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        adder(res,leds,turnedOn,0,0,0);
        return res;
    }

    public void adder(List<String> res, int[] leds, int turnedOn, int i, int h, int m){
    if (h >= 12 || m >= 60) return;
    if (turnedOn == 0)  {res.add(String.format("%d:%02d", h, m));    return;}
    if (i == leds.length) return;
    else{
            adder(res,leds,turnedOn,i+1,h,m);
            if (i < 4)  adder(res, leds, turnedOn - 1, i + 1, h + leds[i], m);
            else    adder(res, leds, turnedOn - 1, i + 1, h, m + leds[i]);
        }
    }
}
