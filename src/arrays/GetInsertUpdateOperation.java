package arrays;

public class GetInsertUpdateOperation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 4;
        int value = getElement(arr, target);
        System.out.println(value);


    }

    public static int getElement(int[] arr, int target) {
        return arr[target];
    }


}
