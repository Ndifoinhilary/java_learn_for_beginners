package arrays;

public class RotateArray {
        public static void rotateLeft(int[] arr, int d) {
            int n = arr.length;
            d = d % n; // Handle cases where d > n

            if (d == 0 || n == 0) return; // No rotation needed

            // Step 1: Reverse the first d elements
            reverse(arr, 0, d - 1);

            // Step 2: Reverse the remaining n-d elements
            reverse(arr, d, n - 1);

            // Step 3: Reverse the entire array
            reverse(arr, 0, n - 1);
        }
        private static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int d = 2;

            rotateLeft(arr, d);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            // Output: 3 4 5 1 2
        }
    }


