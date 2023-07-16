public class ShellSort {
    public static void sort(int[] arr) {
        // 갭을 배열의 길이의 절반으로 초기 설정
        int gap = arr.length / 2;
        // 갭 크기가 0보다 큰 동안 계속 반복한다.
        while (gap > 0) {
            // 갭에 따라 반복문을 돌며 적절한 위치에 삽입한다.
            for (int i = 0; i < gap; i++) {
                // 갭에 따른 순차 정렬
                insertGap(arr, i, gap);
            }
            // 갭 크기를 2로 나누어 갱신한다.
            gap /= 2;
        }
    }

    private static void insertGap(int[] arr, int first, int gap) {
        // index가 first + gap인 원소부터 차례대로 검사한다.
        for (int i = first + gap; i < arr.length; i += gap) {
            int j = i - gap;
            int temp = arr[i];

            // temp와 이미 정렬된 배열 부분과 비교하며 적절한 위치에 삽입한다. (정렬에 맞게)
            // 삽입할 위치를 찾는 반복문이다.
            while (0 <= j && arr[j] > temp) {
                // 한 칸씩 오른쪽으로 밀어낸다.
                arr[j + gap] = arr[j];
                j -= gap; // 이전 갭 위치로 이동한다.
            }
            // 찾은 위치에 값을 삽입한다.
            arr[j + gap] = temp;
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
