package string;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 */
public class EncodeDecodeTinyUrl {
    Map<Integer, String> map = new HashMap();
    String host = "http://tinyurl.com/";
    
	public static void main(String[] args) {
		EncodeDecodeTinyUrl url = new EncodeDecodeTinyUrl();
		String tiny = url.encode("https://leetcode.com/problems/design-tinyurl");
		System.out.println(url.decode(tiny));
	}

    public String encode(String longUrl) {
      int key = longUrl.hashCode();
      map.put(key, longUrl);
      return host+key;
    }

    public String decode(String shortUrl) {
      int key = Integer.parseInt(shortUrl.replace(host,""));
      return map.get(key);
    }

}
