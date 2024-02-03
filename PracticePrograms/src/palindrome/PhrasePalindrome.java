package palindrome;

public class PhrasePalindrome {
	// Inside a single method and easy to understand.
	public static boolean isPalindrome(String s) {
		int i=0, j=s.length()-1;
        while(i<j){
            // For left portin of the string
            char left=s.charAt(i);
            if(left>='A' && left<='Z'){
                left=(char)(left+32);//Converts upperCase Char to LowerCase
            }else if((left>='0' && left<='9')||(left>='a' && left<='z')){

            }
            else{
                i++;
                continue;//If the character at i th index is not alphanumeric then skip this iteration with increament in i th value.
            }
            // For Right portion of the String
            char right=s.charAt(j);
            if(right>='A' && right<='Z'){
                right=(char)(right+32);//Converts upperCase Char to LowerCase
            }else if((right>='0' &&  right<='9')||(right>='a' && right<='z')){

            }
            else{
                j--;
                continue;//If the character at j th index is not alphanumeric then skip this iteration with decreament in j th value.
            }
            //If both the left and right char is alphaNumeric then comparision will be done
            if(left!=right){
                return false;//If both the left and right char is not same returns false.
            }
            i++;
            j--;
        }
        return true;//This will be accessed after loop completion or when the string is null or string is with length 1
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}
}
