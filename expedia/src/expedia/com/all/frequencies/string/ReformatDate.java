package expedia.com.all.frequencies.string;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/reformat-date/
 * Note: would be efficient if I'd use Map (instead of month array) 
 * and StringBuilder instead of String reformatedDate
 */
public class ReformatDate {

	public static void main(String[] args) {
		ReformatDate reformatDate = new ReformatDate();
		System.out.println(reformatDate.reformatDate("20th Oct 2052"));
	}
	
	 public String reformatDate(String date) {
	        String [] month = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
	                                       "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	        
	        String [] day = new String[] {
	            "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th",
	            "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st",
	            "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"
	        };
	        
	        String [] input = date.split(" ");
	        int formatedDate = getDate(day, input[0]);
	        int formatedMonth = getMonth(month, input[1]);
	        
	        String reformatedDate = "";
	        
	        reformatedDate = input[input.length - 1] + 
	            "-" + 
	            (formatedMonth <= 9 ?  "0" +  formatedMonth : formatedMonth) +                                 "-" + 
	            (formatedDate <= 9 ?  "0" +  formatedDate : formatedDate);
	        
	        return reformatedDate;
	    }
	    
	    private int getMonth(String [] month, String m) {
	        for (int i = 0; i < month.length; i++) {
	            if (m.equals(month[i])) return i + 1;
	        }
	        return 0;
	    }
	    
	    private int getDate(String [] day, String d) {
	        for (int i = 0; i < day.length; i++) {
	            if (d.equals(day[i])) return i + 1;
	        }
	        return 0;        
	    }	

}
