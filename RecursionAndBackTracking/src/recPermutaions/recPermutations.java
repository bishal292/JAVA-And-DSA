package recPermutaions;

import java.util.ArrayList;
import java.util.List;

public class recPermutations {
    /*      Permutaions means number of ways an element can be arranged (Order's Matter) -> n!

            String's sub-string method taking 2 args Start index Inclusive(Includes start index) , End index exclusive(Do not include the end index).like while(start < end)
            means substring(0,0) results in empty string.
            and subString(0) or with only start Index will results in the subString formed from the given index including all element from the index.
            substring(0) - results in the same string as previous/Original.

                                   ""/abc                   -> 1(0+1) rec func call where 0 is the length of precessed string
                                    a/bc                    -> 2(1+1) rec func call where 1 is the length of precessed string
                        ba/c                      ab/c      -> 3(2+1) each rec func call where 2 is the length of precessed string
                cba/""  bca/"" bac/""        cab/""  acb/""  abc/""

            MEANS-> At each level p + 1 recursive functions calls are made.


            places where c can be put in ba -> _ba, b_a, ab_
            "ba".subString(0,0) will result in "" + c + ("ba".subString(0) -> results in ba)
                    ===>  cba
            "ba".subString(0,1) will result in "b" + c + ("ba".subString(1) -> results in a)
                    ===>  bca

    */
    private static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            permutations(p.substring(0,i)+ch+p.substring(i),up.substring(1));
        }
    }
    private static ArrayList<String> permutations2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            ArrayList<String> prev = permutations2(p.substring(0,i)+ch+p.substring(i),up.substring(1));
            ans.addAll(prev);
        }
        return ans;
    }

    private static int permutationCount(String p,String up){
        if (up.isEmpty())return 1;
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            count += permutationCount(p.substring(0,i)+ch+p.substring(i),up.substring(1));
        }
        return count;
    }


    /*  Combination means a number of ways an element/item can be chosen from the original element/group of element(Order do not matter) but this is not a combination problem as 121 and 112 are considered different so it is a permutation problem only.
     *
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
//        PERMUTATION
        ArrayList<String> ans = permutations2("","abcd");
        System.out.println(ans);
        System.out.println(permutationCount("","abcd")); // 24
        System.out.println('2'-'2');


        dice("",0,4); // 11111 1112 1121 113 1211 122 131 14 2111 212 221 23 311 32 41 5
        System.out.println();
        dice("",0,8,0,3); // 116 125 134 143 152 161 215 224 233 242 251 26 314 323 332 341 35 413 422 431 44 512 521 53 611 62
        System.out.println();
        System.out.println(letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
