package bitmanipulation;

public class NthGrayCode {

	public static void main(String[] args) {
		NthGrayCode nthGrayCode = new NthGrayCode();
		System.out.println(nthGrayCode.findNthGrayCode(14));
	}
	
	public int findNthGrayCode(int num) {
		int i = 0;
		int output = 0;
		int b_i = 0;
		int result = 0;
		
		while(i < 31) {
			int mask_i = 1 << i;
			int mask_i_1 = 1 << (i + 1);
			
			b_i = num & mask_i;
			int b_i_1 = (num & mask_i_1) >> 1;
			
			result = b_i ^ b_i_1;
			
			output = output | result;
			i++;
		}
		
		result = b_i ^ 0;		
		output = output | result;
		
		return output;
	}

}
