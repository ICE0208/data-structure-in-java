public class RadixSort {
    public static int[] sort(int[] arr) {
        // 최대 값 구하기
        int max = 0;
        for (int n : arr) {
            if (n > max)
                max = n;
        }
        // 최대값을 바탕으로 최대자릿수를 구하기
        int numDigit = String.valueOf(max).length();

        int[] cnt = new int[10];
        int[] tmp = new int[arr.length];

        int curDigit = 1;
        while (curDigit <= numDigit) {
            // 나눌 값 계산
            int d = (int) (Math.pow(10, curDigit - 1));

            // 카운트 초기화
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] = 0;
            }

            // 카운트
            for (int k = arr.length - 1; k >= 0; k--) {
                int n = arr[k];
                int i = (n / d) % 10;
                cnt[i] += 1;
            }

            // 누적합
            for (int i = 1; i < cnt.length; i++) {
                cnt[i] += cnt[i - 1];
            }

            // 누적합을 이용하여 자릿수 정렬
            for (int k = arr.length - 1; k >= 0; k--) {
                int n = arr[k];
                int i = (n / d) % 10;
                tmp[cnt[i] - 1] = n;
                cnt[i] -= 1;
            }

            // 배열 복사
            arr = tmp.clone();
            curDigit++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 123, 2154, 222, 4, 283, 1560, 1061, 2150 };
        System.out.println("Original array:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        int[] sortedArr = RadixSort.sort(arr);
        System.out.println("Sorted array:");
        for (int n : sortedArr) {
            System.out.print(n + " ");
        }
    }
}
