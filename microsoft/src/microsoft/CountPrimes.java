package microsoft;

public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes primes = new CountPrimes();
		System.out.println(primes.countPrimes(10));
	}
	
	public int countPrimes(int n) {
		if (n == 0) return 0;
		
		int count = 0;
		int [] primes = new int[n + 1];
		for (int i = 0; i < n; i++) {
			primes[i] = 1;
		}
		
		primes[0] = 0;
		primes[1] = 0;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (primes[i] == 1) {
                for(int j = 2; j * i <= n; j++ ) {
                	primes[i * j] = 0;
                }
			}
		}
		
        
        for(int i = 0; i < primes.length; i++) {
            if(primes[i] == 1) count++;
        }
		
		return count;
	}

}
