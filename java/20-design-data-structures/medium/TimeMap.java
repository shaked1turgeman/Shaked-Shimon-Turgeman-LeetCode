public class TimeMap {
    HashMap<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))  map.put(key, new ArrayList<>());
        List<Entry> list = map.get(key);
        list.add(new Entry(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Entry> list = map.get(key);
        return binarySearch(list,0,list.size() - 1,timestamp);
    }

    public String binarySearch(List<Entry> list, int left, int right, int t){
        int i=-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid).timestamp==t)  return list.get(mid).value;
            else if(list.get(mid).timestamp>t)  right=mid-1;
            else    {i = mid;    left = mid + 1;}
        }
        return i == -1 ? "" : list.get(i).value;
    }

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
