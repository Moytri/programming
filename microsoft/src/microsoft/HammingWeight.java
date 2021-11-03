package microsoft;

public class HammingWeight {

	public static void main(String[] args) {
		HammingWeight hammingWeight = new HammingWeight();
		System.out.println(hammingWeight.hammingWeight(000000001111101));
	}
	
    public int hammingWeight(int n) {
    	int numbrOfOne = 0;
        for (int i = 0; i < 32; i++) {
        	if ((n & (1 << i)) != 0) numbrOfOne++;
        }
        
        return numbrOfOne;
    }

}
