package arrays;

public class SecondLargesElement {
    public static void main(String[] args) {
        int[] arr = {28078, 19451 ,935 ,28892 ,2242 ,3570, 5480, 231};
        int secondLarges = secondLargesElement(arr);
        System.out.println(secondLarges);
    }

    private static int secondLargesElement(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondLargest = max;
                max = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != max) {
                secondLargest = arr[i];
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
}
