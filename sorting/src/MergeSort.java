public class MergeSort {
    public static void sort(int[] arr, int p, int r) {
        if (p < r) {
            // 리스트를 절반으로 나눠서 왼쪽 부분과 오른쪽 부분으로 분할한다.
            // p ~ q, q+1 ~ r
            int q = p + ((r - p) / 2);

            // 재귀를 사용하여 왼쪽 부분과 오른쪽 부분 각각에 대해 병합 정렬을 수행한다.
            sort(arr, p, q);
            sort(arr, q + 1, r);

            // 정렬된 왼쪽 부분과 정렬된 오른쪽 부분을 합친다.
            merge(arr, p, q, r);
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {
        // 병합할 각 배열의 첫 번째 원소부터 마지막 원소까지 순서대로 비교하며 작은 원소를 임시 배열에 추가한다.
        int[] tmp = new int[arr.length];

        int t = 0;
        int i = p;
        int j = q + 1;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        // 한쪽 배열의 원소를 모두 임시 배열에 추가했을 때, 나머지 배열에 원소가 남아있다면 순서대로 임시 배열에 추가한다.

        while (i <= q) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];
        }

        // 병합한 범위에 대하여 임시 배열의 원소를 원본 배열에 복사한다.
        i = p;
        t = 0;
        while (i <= r) {
            arr[i++] = tmp[t++];
        }
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
