public class InsertionSort {
    public static void sort(int[] arr) {
        // 두 번째부터 차례대로 해당 위치의 값을 temp에 저장한다.
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];

            // temp와 이미 정렬된 배열 부분과 비교하며 적절한 위치에 삽입한다. (정렬에 맞게)
            // 삽입할 곳 찾기
            while (0 <= j && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 삽입하기
            arr[j + 1] = temp;
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
