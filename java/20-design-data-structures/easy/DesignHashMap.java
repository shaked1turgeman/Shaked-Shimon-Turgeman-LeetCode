public class DesignHashMap {
    boolean[] set;
    int[] val;

    public MyHashMap() {
        set = new boolean[1_000_001];
        val = new int[1_000_001];
    }
    
    public void put(int key, int value) {
        set[key] = true;
        val[key] = value;
    }
    
    public int get(int key) {
        if(set[key])   return val[key];
        return -1;
    }
    
    public void remove(int key) {
        set[key] = false;
        val[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
