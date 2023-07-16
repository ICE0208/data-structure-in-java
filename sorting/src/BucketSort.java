import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 음이 아닌 정수 범위에서 균등 분포 배열
public class BucketSort {
    public static void sort(int[] arr) {
        List<LinkedList<Integer>> b = new ArrayList<>();

        // 버킷 초기화
        for (int i = 0; i < arr.length; i++) {
            b.add(new LinkedList<Integer>());
        }

        // 최댓값 구하기
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // 버킷에 담기
        double d = max + 1;
        int bucketIndex;
        for (int i = 0; i < arr.length; i++) {
            bucketIndex = (int) ((arr[i] / d) * arr.length);
            b.get(bucketIndex).add(0, arr[i]);
        }

        // 각 버킷의 요소들을 정렬 + 병합
        int cur = 0;
        int p, r = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < b.get(i).size(); j++) {
                arr[cur++] = b.get(i).get(j);
            }
            p = r + 1;
            r = cur - 1;
            rangeInsertionSort(arr, p, r);
        }
    }

    private static void rangeInsertionSort(int[] arr, int p, int r) {
        for (int i = p + 1; i <= r; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (0 <= j && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 82, 73, 101, 65, 59, 42, 95, 32, 27, 11 };
        System.out.println("Original array:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        BucketSort.sort(arr);
        System.out.println("Sorted array:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

}