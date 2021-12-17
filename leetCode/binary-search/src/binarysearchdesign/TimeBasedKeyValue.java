package binarysearchdesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
 	class Data {
        String val;
        int timestamp;
        
        public Data(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }
	    
    Map<String, List<Data>> map;
    public TimeBasedKeyValue() {
        this.map = new HashMap<>();
    }
	    
    public void set(String key, String value, int timestamp) {
       if (!map.containsKey(key)) {
           map.put(key, new ArrayList<>());
       } 
       map.get(key).add(new Data(value, timestamp));
    }
	    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }
	    
    public String binarySearch(List<Data> ls, int time) {
        int low = 0; int high = ls.size() - 1; int mid = 0;
        
        while(low < high) {
            mid = low + (high - low)/2;
            if (ls.get(mid).timestamp == time) return ls.get(mid).val;
            if (ls.get(mid).timestamp < time) {
                if (mid + 1 <= high && ls.get(mid + 1).timestamp > time) return ls.get(mid).val;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return ls.get(low).timestamp <= time ? ls.get(low).val : "";
    }	
}
