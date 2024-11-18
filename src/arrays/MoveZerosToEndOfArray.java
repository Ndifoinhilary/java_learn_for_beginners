package arrays;

public class MoveZerosToEndOfArray {
    public static void main(String[] args) {
        int[] arr = { 2,0,1,5,6};
        int[] arr2 = moveZeros(arr);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    private static int[] moveZeros(int[] arr) {
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[current] = arr[i];
                current++;
            }
        }
        for (int i = current; i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }
}

// [1,4,5,7,8,9]
// return 8
// secondLargeElement(int[] arr)


/*
secondLargeElement(int[] arr)
max = 0
second_max = 0
for i= 0; i< arr.length; i ++
if[i] > max
second_max = max
max = arr[i]
else if ( arr[i] > max && arr[i] != max
second_max = arr[i]
else if (arr[i] > secondLarges && arr[i] != max)  {
                System.out.println(max);
                secondLarges = arr[i];
            }
 */