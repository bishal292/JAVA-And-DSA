package problems;

import java.util.Stack;

public class Problems {
    /**
     *   Utility Function check either the open bracket is closed or not
     * */
    public static boolean checkBrac(char c, char n) {
        if (c == '(' && n != ')') {
            return false;
        }
        if (c == '{' && n != '}') {
            return false;
        }
        if (c == '[' && n != ']') {
            return false;
        }
        return true;
    }


    /** --------------------------------------------------------------------------------------------------------------------------------
     * Leetcode 20: Valid Parenthesis -> Returns the boolean value of either the brackets are valid or not
     * means the opened bracket are Closed or not.
     * ---------------------------------------------------------------------------------------------------------------------------------
     * */

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;// odd length means 1 bracket is extra means not closed.
///  Clean solution using Stack.
        // Stack<Character> stack = new Stack<>();
        // for(int i = 0;i<n;i++){
        //     char c = s.charAt(i);
        //     if(i<n-1 && checkBrac(c,s.charAt(i+1))){
        //         i++; // if bracket is opened and closed at the same time.
        //     }else{
        //         if(!stack.isEmpty() && checkBrac(stack.peek(),c)){
        //             stack.pop();
        //         }else{
        //             stack.push(c);
        //         }
        //     }
        // }
        // return stack.isEmpty();

///  A Better Optimized using array instead of stack.

        char[] stack = new char[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[top++] = c;
            } else {
                if (top == 0) return false;
                char p = stack[top - 1];
                if (!checkBrac(p, c)) {
                    return false;
                }
                top--;
            }
        }
        return top == 0;
    }

    /** --------------------------------------------------------------------------------------------------------------------------------
     * Leetcode 921: Minimum Add to make Parenthesis Valid -> Return the minimum number of moves required to make 's' valid.
     * ---------------------------------------------------------------------------------------------------------------------------------
     * */
    public int minAddToMakeValid(String s) {
        // int count = 0;
        // Stack<Character> stack = new Stack<>();
        // for(char c:s.toCharArray()){
        //     if(c == '('){
        //         stack.push(c);
        //     }else{
        //         if(!stack.isEmpty() && stack.peek() == '('){
        //             stack.pop();
        //         }else{
        //             count++;
        //         }
        //     }
        // }
        // return stack.isEmpty() ? count : count+stack.size();

        int mustClose = 0; // brackets which are opened to be closed.
        int mustOpen = 0; // Brackets which are closed was required to be opened first.

        for(char c : s.toCharArray()){
            if(c == '('){
                mustClose++;
            }else if(mustClose == 0){
                mustOpen++;
            }else{
                mustClose--;
            }
        }
        return mustOpen + mustClose;
    }



    /** --------------------------------------------------------------------------------------------------------------------------------
     * Leetcode 1541: Minimum Insertions to Balance a Parentheses String -> main catch is '(' in the string is counted as 1 only with 2 '(('
     * Even though there is 1 ')' and requires only 1 '(' but still '(())'.
     * means in simple words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
     * ---------------------------------------------------------------------------------------------------------------------------------
     * */
    public static int minInsertions(String s) {
//         int ans = 0;
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (c == '(') { // simply add the opening brackets.
//                 stack.push(c);
//             } else {
//                 if(i + 1 < s.length() && s.charAt(i+1) == ')'){ /// if 2 consecutive '))' simply skips the next char without increment.
//                     i++;
//                 }else{ /// if there is only 1 ')' the ans must be increased by 1 for the remaining ')'
//                     ans++;
//                 }
//                 if(stack.isEmpty()){
//                     ans++;
//                 }else{
//                     stack.pop();
//                 }
//             }
//         }
//         return ans + (stack.size() * 2);

// OPTIMAL SOLUTION:
        int ans = 0;
        int open = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                open++;
            }else{
                if(i+1 <s.length() && s.charAt(i+1) == ')'){
                    i++;
                }else{
                    ans++;
                }
                if(open > 0){
                    open--;
                }else{
                    ans++;
                }
            }
        }
        return open == 0 ? ans : ans + (open * 2);
    }



    /** --------------------------------------------------------------------------------------------------------------------------------
     * Leetcode 1541: Minimum Insertions to Balance a Parentheses String -> main catch is '(' in the string is counted as 1 only with 2 '(('
     * Even though there is 1 ')' and requires only 1 '(' but still '(())'.
     * means in simple words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
     * ---------------------------------------------------------------------------------------------------------------------------------
     * */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        /// BruteForce
        // int maxArea = 0;
        // for(int i = 0;i<n;i++){
        //     int num = heights[i];
        //     int count = 1;
        //     int j = i-1;
        //     while(j>= 0 && heights[j] >= num){
        //         j--;
        //         count++;
        //     }
        //     j = i+1;
        //     while(j<n && heights[j] >= num){
        //         j++;
        //         count++;
        //     }
        //     int sum = num * (count);
        //     maxArea = Math.max(sum,maxArea);
        // }
        // return maxArea;

        /// Better -> Solution O(5N + C)
        //         int[] ls = new int[n];
        //         Arrays.fill(ls, -1);/// fills left smallest with -1
        //         int[] rs = new int[n];
        //         Arrays.fill(rs,n);/// fill right smallest with the n
        //         Stack<Integer> stack = new Stack<>();

        ///  Finding next smallest element.
        //         for(int i = 0;i<n;i++){
        //             int elem = heights[i];
        //             while(!stack.isEmpty() && heights[stack.peek()] > elem){
        //                 rs[stack.pop()] = i;
        //             }
        //             stack.push(i);
        //         }
        ///  Finding Previous smallest element.
        //         for(int i = n-1;i>= 0;i--){
        //             int elem = heights[i];
        //             while(!stack.isEmpty() && heights[stack.peek()] > elem){
        //                 ls[stack.pop()] = i;
        //             }
        //             stack.push(i);
        //         }
        //         int ans = 0;
        //         for(int i = 0;i<n;i++){
        //             ans = Math.max(ans, heights[i] * (rs[i] - ls[i] -1));
        //         }
        //         return ans;

        /// OPTIMAL SOLUTION

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                if (!stack.isEmpty())
                    ans = Math.max(ans, heights[index] * (i - stack.peek() - 1));
                else
                    ans = Math.max(ans, heights[index] * i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (!stack.isEmpty())
                ans = Math.max(ans, heights[index] * (n - stack.peek() - 1));
            else
                ans = Math.max(ans, heights[index] * n);
        }
        return ans;
    }
}
