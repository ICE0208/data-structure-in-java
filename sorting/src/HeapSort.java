public class HeapSort {
    public static void sort(int[] arr) {
        // 처음에 배열을 최대힙으로 구성한다.
        buildHeap(arr, arr.length - 1);

        // 최대값을 맨 마지막 위치로 옮기고 최대값을 제외한 요소를 대상으로 반복한다.
        for (int last = arr.length - 1; last > 0; last--) {
            arr[last] = deleteMax(arr, last);
        }
    }

    // 최대힙 만들기
    private static void buildHeap(int[] arr, int last) {
        int start = (last - 1) / 2;

        for (int i = start; i >= 0; i--) {
            percolateDown(arr, i, last);
        }

    }

    // 최대값을 리턴, 루트를 맨 마지막 요소로 대체하고 다시 최대힙으로 구성
    private static int deleteMax(int[] arr, int last) {
        int max = arr[0];
        arr[0] = arr[last];
        percolateDown(arr, 0, last - 1);

        return max;
    }

    private static void percolateDown(int[] arr, int n, int last) {
        int leftChild = (n + 1) * 2 - 1;
        int rightChild = (n + 1) * 2;
        int maxChild = leftChild;

        if (leftChild > last) {
            return;
        }
        if (rightChild <= last && arr[rightChild] > arr[leftChild]) {
            maxChild = rightChild;
        }

        if (arr[n] < arr[maxChild]) {
            int tmp = arr[maxChild];
            arr[maxChild] = arr[n];
            arr[n] = tmp;

            percolateDown(arr, maxChild, last);
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