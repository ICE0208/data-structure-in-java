import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] generateRandomArray() throws NumberFormatException, IOException {
        System.out.print("만들 랜덤 배열의 길이: ");
        int len = Integer.parseInt(br.readLine());

        int[] arr = new int[len];
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(1, len + 1);
        }

        return arr;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // ? 1. 기본 정렬 2. 고급 정렬 3. 특수 정렬 4. 나가기
        while (true) {
            System.out.println("1. 기본 정렬 2. 고급 정렬 3. 특수 정렬 4. 나가기");
            int o = Integer.parseInt(br.readLine());

            int o2;
            int[] arr;
            long before;
            long after;
            switch (o) {
                case 1:
                    System.out.println("1. 선택 정렬 2. 버블 정렬 3. 삽입 정렬");
                    o2 = Integer.parseInt(br.readLine());
                    switch (o2) {
                        case 1:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            SelectionSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("선택 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        case 2:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            BubbleSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("버블 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        case 3:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            InsertionSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("삽입 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        default:

                    }
                    break;
                case 2:
                    System.out.println("1. 병합 정렬 2. 퀵 정렬 3. 힙 정렬 4. 셸 정렬");
                    o2 = Integer.parseInt(br.readLine());
                    switch (o2) {
                        case 1:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            MergeSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("병합 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        case 2:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            QuickSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("퀵 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        case 3:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            HeapSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("힙 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        case 4:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            ShellSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("셸 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        default:
                    }
                    break;
                case 3:
                    System.out.println("1. 계수 정렬 2. 기수 정렬 3. 버킷 정렬");
                    o2 = Integer.parseInt(br.readLine());
                    switch (o2) {
                        case 1:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            CountingSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("계수 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        case 2:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            RadixSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("기수 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        case 3:
                            arr = generateRandomArray();
                            System.out.println("정렬 전 : " + Arrays.toString(arr) + "\n(정렬중......)");
                            before = System.currentTimeMillis();
                            BucketSort.sort(arr);
                            after = System.currentTimeMillis();
                            System.out.println("--------");
                            System.out.println("정렬 후 : " + Arrays.toString(arr));
                            System.out.println("버킷 정렬 소요 시간 : " + (after - before) + " ms");
                            break;
                        default:

                    }
                    break;
                case 4:
                    System.out.println("끝");
                    br.close();
                    return;
                default:
                    System.out.println("올바르지 않은 옵션");
            }
        }
    }
}