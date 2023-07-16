public class CountingSort {
    // 수의 범위: 1 ~ 배열의 크기
    public static int[] sort(int[] arr) {
        int[] cnt = new int[arr.length + 1];
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = 0;
        }
        for (int n : arr) {
            cnt[n] += 1;
        }
        for (int i = 2; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[cnt[arr[i]] - 1] = arr[i];
            cnt[arr[i]] -= 1;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 6, 5, 7, 3, 8, 4, 1, 2 };
        System.out.println("Original array:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        int[] sortedArr = CountingSort.sort(arr);
        System.out.println("Sorted array:");
        for (int n : sortedArr) {
            System.out.print(n + " ");
        }
    }
}
