package recPermutaions;

import java.util.ArrayList;

public class recPermutations {
    /*      Permutaions means number of ways an element can be arranged -> n!

            String sub-string method taking 2 args Start index Inclusive(Includes start index) , End index exclusive(Do not include the end index).like while(start < end)
            means substring(0,0) results in empty string.
            and subString(0) or with only start Index will results in the subString formed from the given index including all element from the index.
            substring(0) - results in the same string as previous.
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

    static void main(String[] args) {
        ArrayList<String> ans = permutations2("","abcd");
        System.out.println(ans);
        System.out.println(permutationCount("","abcd")); // 24
        System.out.println('2'-'2');
    }
}
