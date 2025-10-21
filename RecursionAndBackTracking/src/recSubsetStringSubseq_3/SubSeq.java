package recSubsetStringSubseq_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SubSeq {
    /*SubSequence means the sequence of adjacent character or elements means not any element between the range should be missing from original.
    SubSet means the elements formed from the original element by containing all or less number of elements where the element may or may not be adjacent.
    */
    /*
     * Function to print all the sub-String from the given String.
     *                  Subset Pattern
     *
     * */
    static void subSeq(String p,String up){
        if (up.isEmpty()){
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        subSeq(p + ch,up.substring(1));
        subSeq(p,up.substring(1));
    }

//    Returning all the Substring in the form of arraylist
    static ArrayList<String> subSeq2(String p ,String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeq2(p + ch,up.substring(1));
        ArrayList<String> right = subSeq2(p,up.substring(1));
        left.addAll(right);
        return left;
    }


    static ArrayList<String> subSeqAscii(String p ,String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeqAscii(p + ch,up.substring(1));
        ArrayList<String> right = subSeqAscii(p,up.substring(1));
        ArrayList<String> withAscii = subSeqAscii(p + (ch + 0),up.substring(1));
        left.addAll(right);
        left.addAll(withAscii);
        return left;
    }



    public static void main(String[] args) {
        subSeq("","abc");
        System.out.println();

        ArrayList<String> ans = subSeq2("","abc");

        System.out.println(ans);
        System.out.println(subSeqAscii("","abc"));

        ArrayList<ArrayList<Integer>> ansSub = subSet(new int[]{1,2,3}); // [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] -> means the function should return type List<List>
        for (ArrayList<Integer> a:ansSub){
            System.out.print(a + " ");
        }
        System.out.println();

        int[] arr = {1,2,3,2,3};

        ArrayList<ArrayList<Integer>> ansSubset = subsetWithDuplicate(arr);
        System.out.print("[ ");
        for(ArrayList<Integer> an : ansSubset){
            System.out.print(", "+an + " ");
        }
        System.out.println("]");
        System.out.println(ansSubset.size());
    }

    /*
    * Function to return an arraylist containing subsets.
    * total subarray count (inc. null) -> 2 ^ n
    *           Time Complexity: Outer Loop runs for n time.
    *                               -> Inner loops runs for the size of outer arrayList ( till the subarray count for previous elems.)
    *                                   So, in worst case inner loop will runs till 2 ^ (n-1) times.
    *           SO, Final Time Complexity :  O(N* 2 ^N)
    *           Space Complexity: Outer arraylist will store (2 ^ n) subsets, where few subset will be of various size like (0,1,2,3....n)
    *                            where total integers count(Elems being stored) : N * 2 ^(N-1)
    *           SO, Final Space Complexity : O(N * 2 ^ N)
    * */
    private static ArrayList<ArrayList<Integer>> subSet(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>(); // Outer or final arraylist which will store all the subsets.
        outer.add(new ArrayList<>()); // adding an empty arraylist as if there is nothing then still there would be one null subset.
        for (int num : arr){
            int n = outer.size(); // getting the size of outer list.
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i)); // duplicating the outer list at the ith index.
                inner.add(num); // add the current elem. so, that new subset is formed.
                outer.add(inner); // now add this list to the outer arraylist(Final ans list).
            }
        }
        return  outer;
    }

    private static ArrayList<ArrayList<Integer>> subsetWithDuplicate(int[] arr){
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        Arrays.sort(arr); // Sorting the array so that the duplicates will align together.

        // variable to track the previous subarray starting point.
        int start = 0;
        int end = 0;

        for (int i = 0; i<arr.length;i++){
            start = 0;
            int n = outer.size(); // get the size of subarrays count till previous.
            if(i>0 && arr[i] == arr[i-1]){ // if current element is a duplicate which was present previously. then create the subarray with the just previously built subarray.
                start = end;
            }
            end = n; // track the starting index of each new subset elems.
            for (int j = start; j < n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        return outer;
    }
}
