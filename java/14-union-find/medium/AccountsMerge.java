public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        HashMap<String, Integer> map = new HashMap<>();
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {parent[i] = i;  size[i] = 1;}
        for(int i=0; i<accounts.size(); i++){
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (map.containsKey(email)) union(map.get(email),i,parent,size); 
                else map.put(email,i);
            }
        }
        HashMap<Integer, List<String>> groups = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int accountIndex = entry.getValue();
            int root = find(accountIndex, parent);
            if(groups.containsKey(root)) groups.get(root).add(email);
            else{
                List<String> t =new ArrayList<>();
                t.add(email);
                groups.put(root,t);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {
            int root = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(root).get(0));
            mergedAccount.addAll(emails);
            res.add(mergedAccount);
            }
        return res;
    }

    public boolean union(int a, int b, int[] parent, int[] size) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);
        if (rootA == rootB) return false;
        if (size[rootA] < size[rootB]) {parent[rootA]=rootB;    size[rootB]+=size[rootA];} 
        else {parent[rootB]=rootA;    size[rootA]+=size[rootB];}
        return true;
    }

    public int find(int x, int[] parent) {
        if (parent[x] != x)     parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
