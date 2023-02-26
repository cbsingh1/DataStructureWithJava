import com.cbsingh.tree.TreeNode;

import java.util.Arrays;

public class DemoClass {

    public static void main(String[] args) {
        System.out.println(minDeletions("abcabc"));
       // System.out.println(minDeletions("aaabbbcc"));
        //System.out.println(minDeletions("ceabaacb"));
    }

    public static int minDeletions(String s) {
        int result =0;
        int[] charArr = new int[26];
        
        for (int i = 0; i < s.length(); i++)
             charArr[s.charAt(i) - 'a']++;

        Arrays.sort(charArr);

        int prev=0;
        for (int i = charArr.length-1; i >= 0; i--) {
            if(charArr[i]>0 & prev > 0) {
                if(charArr[i]==prev) {
                    charArr[i]--;
                    result++;
                }
            }
            prev = charArr[i];
        }

        return result;
    }
}

