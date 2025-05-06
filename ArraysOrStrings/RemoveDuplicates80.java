package ArraysOrStrings;

import java.util.*;

public class RemoveDuplicates80 {
    /*
    Brute Force Solution
    Intuition : Iterate through the sorted array, copy only the elements with count less than or equal to 2 to a new
                array, and then overwrite the original array with these elements to remove duplicates while keeping
                the order.
    Time Complexity : O(n)
    Space Complexity : O(n)
    */
    public static int removeDuplicates1(int[] nums) {
        int[] arr = new int[nums.length];
        int count = 1, k = 1;
        arr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
                if(count <= 2) {
                    arr[k] = nums[i];
                    k++;
                }
            }
            else {
                arr[k] = nums[i];
                k++;
                count = 1;
            }
        }

        System.arraycopy(arr, 0, nums, 0, arr.length);
        return k;
    }

    /*
    Optimal Solution 1 - Two Pointer Approach (since the que required us to not allocate any extra space)
    Intuition : Use two pointers to overwrite duplicates in-place while allowing at most two occurrences of each
                element in the sorted array.
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public static int removeDuplicates2(int[] nums) {
        int count = 1, j = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
                if(count <= 2) {
                    nums[j] = nums[i];
                    j++;
                }
            }
            else {
                nums[j] = nums[i];
                j++;
                count = 1;
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }
}
