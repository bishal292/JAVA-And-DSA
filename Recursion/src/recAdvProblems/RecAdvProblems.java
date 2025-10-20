package recAdvProblems;

import java.util.ArrayList;
import java.util.List;

public class RecAdvProblems {

    /*
    * LeetCode 17: Letter Combinations of a Phone Number.
    * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    * 2 -> abc ; 3 -> def ; 4 -> ghi ; 5 -> jkl ; 6 -> mno ; 7 -> pqrs ; 8 -> tuv ; 9 -> wxyz
    * */
    static final String [] alpha = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> letterCombinations(String digits){
        return letterComb("",digits);
    }
    private static List<String> letterComb(String processed, String unProcessedDigits){
        List<String> list = new ArrayList<>();
        if(unProcessedDigits.isEmpty()){
            list.add(processed);
            return list;
        }
        int idx = (int)unProcessedDigits.charAt(0) - '2';
        for(char ch : alpha[idx].toCharArray()){
            list.addAll(letterComb(processed+ch,unProcessedDigits.substring(1)));
        }
        return list;
    }

    // no. of ways we can get a certain target digit by rolling a dice for any no. of time.
    static void dice(String p,int sum,int totReq){
        if(sum > totReq){
            return;
        }
        if(totReq == sum){
            System.out.print(p + " ");
            return;
        }
        for (int i = 1; i <= Math.min(totReq - sum,6); i++) {
            dice(p+i,sum+i,totReq);
        }
    }

    // no. of ways we can get a certain target digit by rolling a dice within a rollcount limit.
    static void dice(String p,int sum,int totReq,int dicRolled, int rolLimit){
        if (dicRolled > rolLimit || sum > totReq){
            return;
        }
        if(totReq == sum){
            System.out.print(p + " ");
            return;
        }
        for (int i = 1; i <= Math.min(totReq - sum,6); i++) {
            dice(p+i,sum+i,totReq,dicRolled + 1,rolLimit);
        }
    }

    static void main(String[] args) {
        dice("",0,5); // 11111 1112 1121 113 1211 122 131 14 2111 212 221 23 311 32 41 5
        System.out.println();
        dice("",0,8,0,3); // 116 125 134 143 152 161 215 224 233 242 251 26 314 323 332 341 35 413 422 431 44 512 521 53 611 62
        System.out.println();
        System.out.println(letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
