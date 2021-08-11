package searching;

public class FindRepeat {
	public static int findRepeat(int[] numbers) {

        // find a number that appears more than once
        int floor = 1;
        int celling = numbers.length - 1;
        
        while (floor < celling) {
            int mid = floor + ((celling - floor)/2);
            
            int lowerRangeFloor   = floor;
            int lowerRangeCeiling = mid;
            int upperRangeFloor   = mid + 1;
            int upperRangeCeiling = celling;
            
            int numberInRange = 0;
            
            for (int number : numbers) {
                if (number >= lowerRangeFloor && number <= lowerRangeCeiling) {
                    numberInRange++;
                }
            }
            
            int uniqueInLoweBound = lowerRangeCeiling -lowerRangeFloor + 1;
            if (numberInRange > uniqueInLoweBound) {
                floor = lowerRangeFloor;
                celling = lowerRangeCeiling;
            }
            else {
                floor = upperRangeFloor;
                celling = upperRangeCeiling;
            }
        }

        return floor;
    }

	public static void main(String[] args) {
		int [] arr = {1, 6, 7, 3, 5, 4, 2, 2};
		System.out.println(findRepeat(arr));
	}
}
