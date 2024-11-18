package arrays;

public class LearnSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8};
        int target = 1;
        int index = search(arr, target);
        System.out.println("Element found at index" + index);
    }

    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
