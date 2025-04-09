package ArraysOrStrings;

import java.util.*;

public class RemoveDuplicates26 {
    /*
    Optimal Solution 1 - Linear Approach
    Intuition : Iterate through the sorted array, and whenever a new unique element is found (i.e., different from the
                previous), place that element at the count index and increment count.
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public static int removeDuplicates1(int[] nums) {
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(nums));
        System.out.println(Arrays.toString(nums));
    }
}
