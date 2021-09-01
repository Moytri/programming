package general;

public class TemperatureTracker {
	int [] temperatureBaskets = new int[111];
    int mode = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int maxFrequency = 0;
    double sum = 0;
    double total = 0;

    // records a new temperature
    public void insert(int temperature) {
        temperatureBaskets[temperature]++;
        if (temperatureBaskets[temperature] > maxFrequency) {
            mode = temperature;
            maxFrequency = temperatureBaskets[temperature];
        }
        
        sum += temperature;
        total++;
        
        min = Math.min(min, temperature);
        max = Math.max(max, temperature);
    }

    // returns the highest temp we've seen so far
    public int getMax() {
        return max;
    }

    // returns the lowest temp we've seen so far
    public int getMin() {
        return min;
    }

    // returns the mean of all temps we've seen so far
    public double getMean() {
        return sum/total;
    }

    // return a mode of all temps we've seen so far
    public int getMode() {
        return mode;
    }
    
	public static void main(String[] args) {
		// Call what I did in InterviewCake

	}

}
