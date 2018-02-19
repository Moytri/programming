 package string;

class PalindromeSentence {
    public static void main(String [] args) {
       String str = "A man, a plan, a canal: Panama";
       PalindromeSentence obj = new PalindromeSentence();
       System.out.println(obj.isPalindrome(str));	
    }

    public int isPalindrome(String A) {
	 char[] arr = A.toLowerCase().toCharArray();
	 int i=0;int j=arr.length-1;
	 while(i<j){
		/** if the value from start index is not alphanumeric, skip it **/
	     if(!((arr[i]>='a' && arr[i]<='z') || (arr[i]>='0' && arr[i]<='9'))){i++;continue;} 
	     if(!((arr[j]>='a' && arr[j]<='z') || (arr[j]>='0' && arr[j]<='9'))){j--;continue;}
	     if(arr[i++]!=arr[j--])return 0;
	  }
	    return 1;
     }
}
