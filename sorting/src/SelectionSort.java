public class SelectionSort {
    public static void sort(int[] arr) {
        int length = arr.length;

        // for last <- n-1 downTo 1
        for (int last = length - 1; last >= 1; last--) {
            // A[0...last] 중 가장 큰 수 A[k]를 찾는다
            int maxIndex = 0;
            for (int i = 1; i <= last; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            // A[k] <-> A[last]
            int temp = arr[last];
            arr[last] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.print("Original Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        sort(arr);
        System.out.print("\n\nSorted Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
