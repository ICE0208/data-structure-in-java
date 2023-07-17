public class QuickSort {
    public static void sort(int[] arr, int p, int r) {
        if (p < r) {
            // pivot을 지정하고 pivot을 기준으로 pivot보다 작은 부분, 큰 부분으로 나눈다.
            // 여기서 q는 분할하고 난 다음 pivot의 위치
            int q = partition(arr, p, r);
            // pivot을 제외한 왼쪽 부분과 오른쪽 부분을 다시 정렬한다.
            // 왼쪽 부분
            sort(arr, p, q - 1);
            // 오른쪽 부분
            sort(arr, q + 1, r);
        }
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static int partition(int[] arr, int p, int r) {
        // 마지막 원소를 pivot으로 지정한다.
        int pivot = arr[r];

        // 배열을 처음부터 마지막 원소 전까지 조사하면서 원소가 pivot보다 작은 경우 왼쪽 부분으로 이동시킨다.
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // pivot을 왼쪽 부분과 오른쪽 부분 사이로 이동시킨다.
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;

        // pivot의 위치를 리턴
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.print("Original Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        sort(arr, 0, arr.length - 1);

        System.out.print("\n\nSorted Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
