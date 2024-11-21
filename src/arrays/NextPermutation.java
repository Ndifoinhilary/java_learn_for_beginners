package arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first decreasing element from the right
//        {1, 2, 3}
        int i = n - 2;
        System.out.println("printing i before loop"+ i);
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        System.out.println(i);
//        {1, 2, 3}
        // If i >= 0, it means we found a pivot (nums[i] < nums[i + 1])
        if (i >= 0) {
            // Step 2: Find the smallest element in the suffix that is greater than nums[i]
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
//            {1, 2, 3}

            // Step 3: Swap the pivot and the next largest element
            swap(nums, i, j);
        }
//        {1, 2, 3}
        // Step 4: Reverse the suffix starting from i + 1 to the end of the array
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // Helper function to swap two elements in the array


    // Helper function to reverse the elements in the array from index `start` to `end`
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        nextPermutation(arr1);
        System.out.println(Arrays.toString(arr1)); // Output: [1, 3, 2]

        int[] arr2 = {3, 2, 1};
        nextPermutation(arr2);
        System.out.println(Arrays.toString(arr2)); // Output: [1, 2, 3]

        int[] arr3 = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(arr3);
        System.out.println(Arrays.toString(arr3)); // Output: [1, 5, 8, 5, 1, 3, 5, 6, 7]
    }
}
