package ArraysOrStrings;

import java.util.Arrays;

public class RemoveElement27 {
    /*
    Optimal Solution 1 - Two Pointer Approach
    Intuition : Using two pointers from both ends to swap non-"val" values to the front and push "val"s to the back.
                Return the left pointer as that represents the number of non-"val" values in the array.
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public static int removeElementSol1(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                if (nums[right] != val) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                }
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /*
    Optimal Solution 2 - Linear Approach
    Intuition : Loop through the array from the start and swap the non-"val" element with itself, while skipping the
                "val" element. Keep a track of the last non-"val" element and that's the count to return.
    Time Complexity : O(n)
    Space Complexity : O(1)
    */
    public static int removeElementSol2(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElementSol1(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
