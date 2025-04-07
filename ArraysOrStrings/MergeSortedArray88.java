package ArraysOrStrings;

import java.util.*;
public class MergeSortedArray88 {
    /* Brute Force solution that I could think of at first glance
       Intuition : Creating a third array and looping through two arrays to insert elements in increasing order into third array. Writing the sorted elements back from third array to input array.
       Time Complexity : O((m + n))
       Space Complexity : O((m + n)) */
    public static void mergeSol1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                nums3[index] = nums1[left];
                left++;
                index++;
            } else {
                nums3[index] = nums2[right];
                right++;
                index++;
            }
        }
        while (left < m) {
            nums3[index] = nums1[left];
            left++;
            index++;
        }
        while (right < n) {
            nums3[index] = nums2[right];
            right++;
            index++;
        }
        for(int i = 0; i < m + n; i++) {
            nums1[i] = nums3[i];
        }
    }

    /* Better solution - Optimizing Space and Time, compared to Brute Force
       Intuition : Avoid using extra space by replacing all the (nums1.length - m) elements in nums1 with elements in nums2, and then using Arrays.sort() to sort the array.
       Time Complexity - O((m + n) log(m + n))
       Space Complexity - O(log(m + n)) */

    public static void mergeSol2(int[] nums1, int m, int[] nums2, int n) {
        int j = Math.max(m, 0);

        for(int i = 0; i < n; i++) {
            nums1[j] = nums2[i];
            j++;
        }
        Arrays.sort(nums1);
    }

    /* Best and Optimal solution - Two Pointer Approach
       Intuition : Merging nums2 into nums1 from the back, placing the largest elements at the end to avoid overwriting elements in nums1.
       Time Complexity - O(m + n)
       Space Complexity - O(1) */

    public static void mergeSol3(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int rightIndex = m + n - 1;
        while(nIndex >= 0) {
            if(mIndex >= 0 && nums1[mIndex] > nums2[nIndex]) {
                nums1[rightIndex] = nums1[mIndex];
                mIndex--;
                rightIndex--;
            }
            else {
                nums1[rightIndex] = nums2[nIndex];
                rightIndex--;
                nIndex--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        mergeSol3(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
