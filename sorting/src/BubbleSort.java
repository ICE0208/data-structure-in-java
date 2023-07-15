public class BubbleSort {
    public static void sort(int[] arr) {
        // 비교할 배열의 범위를 오른쪽부터 점점 줄인다.
        for (int last = arr.length - 1; last > 0; last--) {
            // 비교할 배열의 범위를 탐색하면서 앞에 있는 원소가 더 크다면 두 요소의 위치를 교환한다.
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
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
