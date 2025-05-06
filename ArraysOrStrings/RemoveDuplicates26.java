package ArraysOrStrings;

import java.util.*;

public class RemoveDuplicates26 {
    /*
    Brute Force Solution
    Intuition : Iterate through the sorted array, copy only the unique elements to a new array, and then overwrite
                the original array with these unique elements to remove duplicates while keeping the order.
    Time Complexity : O(n)
    Space Complexity : O(n)
    */
    public static int removeDuplicates1(int[] nums) {
        int[] arr = new int[nums.length];
        int count = 1;
        arr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                arr[count] = nums[i];
                count++;
            }
        }

        System.arraycopy(arr, 0, nums, 0, arr.length);
        return count;
    }

    /*
    Optimal Solution - Linear Approach
    Intuition : Iterate through the sorted array, and whenever a new unique element is found (i.e., different from the
                previous), place that element at the count index and increment count.
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public static int removeDuplicates2(int[] nums) {
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
