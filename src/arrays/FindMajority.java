package arrays;

import java.util.*;

public class FindMajority {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 5, 5, 5, 6,7,7,7,7,7,7,7,7,7, 6, 6, 6, 6};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(findMajority(arr1)); // Output: [5, 6]
        System.out.println(findMajority(arr2)); // Output: []
    }

    public static List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;

        // Step 1: Find up to 2 potential candidates
        for (int num : nums) {
            if (count1 > 0 && num == candidate1) {
                count1++;
            } else if (count2 > 0 && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Validate the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        // Step 3: Sort the result for increasing order
        Collections.sort(result);
        return result;
    }
}
