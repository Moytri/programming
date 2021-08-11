package unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge721 {

	public static void main(String[] args) {
		AccountsMerge721 merge = new AccountsMerge721();
		
		List<List<String>> outer = new ArrayList<>();
		
		List<String> inner1 = new ArrayList<>();
		inner1.add("John");
		inner1.add("johnsmith@mail.com");
		inner1.add("john_newyork@mail.com");
		
		List<String> inner2 = new ArrayList<>();
		inner2.add("John");
		inner2.add("johnsmith@mail.com");
		inner2.add("john00@mail.com");
	
		List<String> inner3 = new ArrayList<>();
		inner3.add("John");
		inner3.add("johnnybravo@mail.com");

		outer.add(inner1);
		outer.add(inner2);
		outer.add(inner3);
		
		merge.accountsMerge(outer);
	}
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }

	class DSU {
	    int[] parent;
	    public DSU() {
	        parent = new int[10001];
	        for (int i = 0; i <= 10000; ++i)
	            parent[i] = i;
	    }
	    public int find(int x) {
	        if (parent[x] != x) parent[x] = find(parent[x]);
	        return parent[x];
	    }
	    public void union(int x, int y) {
	        parent[find(x)] = find(y);
	    }
	}
}
