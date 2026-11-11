public class RandomizedSet {
    private HashMap<Integer, Integer> map; 
    private ArrayList<Integer> list; 

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))    return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))    return false;
        int i = map.get(val), j=list.get(list.size()-1);
        map.put(j,i);
        map.remove(val);
        list.set(i,j);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
