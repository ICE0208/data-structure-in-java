# Sorting

모든 로직과 코드는 오름차순을 기준으로 되어있습니다.

## <span id="top">목차</span>

### 기본 정렬

- [선택 정렬](#selection)
- [버블 정렬](#bubble)
- [삽입 정렬](#insertion)

### 고급 정렬

- [병합 정렬](#merge)
- [퀵 정렬](#quick)
- [힙 정렬](#heap)
- [셸 정렬](#shell)

### 특수 정렬

- [계수 정렬](#counting)
- [기수 정렬](#radix)
- [버킷 정렬](#bucket)

---

<br/>

## <span id="selection">선택 정렬 / Selection Sort</span>

> 선택 정렬은 배열의 요소 중 가장 작은(또는 가장 큰) 요소를 반복적으로 선택하여 목록의 정렬된 부분으로 이동하는 방식으로 작동하는 간단하고 효율적인 알고리즘이다.

### 로직

1. 주어진 리스트 중에 최대값을 찾는다.
2. 그 값을 맨 뒤에 위치한 값과 교체한다
3. 맨 마지막 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.

### 수도 코드

```
selectionSort(A[], n):
    for last <- n-1 downTo 1
        A[0...last] 중 가장 큰 수 A[k]를 찾는다
        A[k] <-> A[last]
```

### 전체 코드

[SelectionSort.java](./src/SelectionSort.java)

### 장점

정렬을 위한 비교 횟수는 많지만 교환 횟수가 적기 때문에 교환이 많이 이루어져야 하는 상황에서 효율적으로 사용될 수 있다. (내림차순 to 오름차순)

> 10만 개 배열 테스트
>
> ![selVsQuick](./img/selVsQuick.png)

### 단점

정렬을 위한 비교 횟수가 많으며, $O(N^2)$이라는 시간 복잡도를 갖기 때문에 많은 데이터를 정렬해야 하는 경우에 불리하다.

> 10만 개 배열 테스트
>
> ![selVsQuick2](./img/selVsQuick2.png)

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="bubble">버블 정렬 / Bubble Sort</span>

> 서로 인접한 두 원소의 대소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬하는 알고리즘이다. 선택 정렬과 유사하다.

### 로직

1. 요소들을 첫 번째 요소부터 차례로 바로 다음 원소와 비교하면서 앞에 있는 원소가 더 크다면 두 요소의 위치를 교환한다.
2. 가장 오른쪽으로 이동한 원소를 제외한 요소들을 대상으로 반복한다.

### 수도 코드

```
bubbleSort(A[]):
    n <- arr.length
    for last <- n-1 downto 1
        for i <- 0 to last-1
            if (A[i]) > A[i+1]
                A[i] <-> A[i+1]
```

### 전체 코드

[BubbleSort.java](./src/BubbleSort.java)

### 장점

구현이 매우 간단하고 소스코드가 직관적이다. 또한 제자리 정렬이기 때문에 공간 복잡도 측면에서 유리하다.

### 단점

시간 복잡도가 $O(N^2)$으로 굉장히 비효율적이다.

> 10만 개 배열 테스트
>
> ![bubVsQuick](./img/bubVsQuick.png)

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="insertion">삽입 정렬 / Insertion Sort</span>

> 삽입 정렬은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘이다.

### 로직

1. 두 번째 위치의 값을 temp에 저장한다.
2. temp와 이미 정렬된 배열 부분과 비교하며 적절한 위치에 삽입한다. (정렬에 맞게)
3. 1번으로 돌아가 다음 위치의 값을 temp에 저장하고 반복한다.

### 수도 코드

```
InsertionSort(A[]):
    for i <- 1 to A.length-1
        j <- i-1
        temp <- A[i]
        while (0 <= j and temp < A[j])
            A[j+1] < A[j]
            j--
        A[j+1] = temp
```

### 전체 코드

[InsertionSort.java](./src/InsertionSort.java)

### 장점

알고리즘 구현이 간단하고 이미 정렬되어 있는 경우 매우 효율적이다. 또한 별도의 메모리 공간이 필요하지 않다.

### 단점

시간 복잡도가 $O(N^2)$으로 정렬할 배열의 크기가 크다면 매우 불리하다.

> 10만 개 배열 테스트
>
> ![insVsQuick](./img/insVsQuick.png)

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="merge">병합 정렬 / Merge Sort</span>

> 병합 정렬은 배열을 더 작은 하위 배열로 나누고 각 하위 배열을 정렬한 다음 정렬된 하위 배열을 다시 병합하여 최종 정렬된 배열을 형성하는 정렬 알고리즘이다.

### 로직

1. 리스트의 길이가 1 이하일 경우, 정렬이 불필요하므로 그대로 리스트를 반환한다.
2. 리스트를 절반으로 나눠서 왼쪽 부분과 오른쪽 부분으로 분할한다.
3. 재귀를 사용하여 왼쪽 부분과 오른쪽 부분 각각에 대해 병합 정렬을 수행한다.
4. 정렬된 왼쪽 부분과 정렬된 오른쪽 부분을 합친다.

### 수도 코드

```
mergeSort(A[], p, r):
    if(p < r)
        q <- [(p+r)/2]
        mergeSort(A, p, q)
        mergeSort(A, q+1, r)
        merge(A, p, q, r)
```

### 병합 로직

1. 병합할 각 배열의 첫 번째 원소부터 마지막 원소까지 순서대로 비교하며 작은 원소를 임시 배열에 추가한다.
2. 한쪽 배열의 원소를 모두 임시 배열에 추가했을 때, 나머지 배열에 원소가 남아있다면 순서대로 임시 배열에 추가한다.

3. 병합한 범위에 대하여 임시 배열의 원소를 원본 배열에 복사한다.

### 병합 수도 코드

```
merge(A[], p, q, r):
    i <- p; j <- q+1; t <- 0
    while (i <= q and j <= r)
        if (A[i] <= A[j]) tmp[t++] <- A[i++]
        else tmp[t++] <- A[j++]
    while (i <= q)
        tmp[t++] <- A[i++]
    while (j <= r)
        tmp[t++] <- A[j++]
    i <- p; t <- 0
    while (i <= r)
        A[i++] <- tmp[t++]
```

### 전체 코드

[MergeSort.java](./src/MergeSort.java)

### 장점

무조건 절반씩 분할해가면서 정렬하기 때문에 항상 $O(N * logN)$의 시간 복잡도를 보장한다.

> 10만 개 배열 테스트
>
> ![merVsQuick](./img/merVsQuick.png)

### 단점

병할을 진행할 때 임시 배열을 사용하기 때문에 추가적인 메모리가 필요하다는 단점이 있다.

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="quick">퀵 정렬 / Quick Sort</span>

> 임의의 원소를 기준으로 잡아 기준 원소보다 작은 원소와 큰 원소 그룹으로 나누어 기준 원소의 좌우로 분할한 다음 각각을 정렬하는 알고리즘이다.

### 로직

1. 임의의 원소를 선택하여 pivot으로 지정한다. (여기서는 마지막 원소)
2. pivot을 기준으로 pivot보다 작은 요소들은 모두 pivot의 왼쪽에, 큰 요소들은 모두 pivot의 오른쪽으로 옮겨진다.
3. pivot을 제외한 왼쪽 부분과 오른쪽 부분을 다시 정렬한다. (재귀적 호출)
4. 부분 리스트들이 더 이상 분할이 불가능할 때까지 반복한다.

### 수도 코드

```
quickSort(A[], p, r):
    if (p < r)
        q <- partition(A, p, r)
        quickSort(A, p, q-1)
        quickSort(A, q+1, r)
```

### 분할 로직

1. 마지막 원소를 pivot으로 지정한다.
2. 배열을 처음부터 마지막 원소 전까지 조사하면서 원소가 pivot보다 작은 경우 왼쪽 부분으로 이동시킨다.
3. pivot을 왼쪽 부분과 오른쪽 부분 사이로 이동시킨다.

### 분할 수도 코드

```
partition(A[], p, r):
    x <- A[r]
    i <- p-1
    for j <- p to r-1
        if (A[j] < x>)
            A[++i] <-> A[j]
    A[i+1] <-> A[r]
    return i+1
```

### 전체 코드

[QuickSort.java](./src/QuickSort.java)

### 장점

일반적인 상황에서 평균적으로 $O(N*logN)$의 시간이 소요되어 매우 빠르게 정렬할 수 있다. 또한 재귀 호출에 의한 스택 메모리를 제외하고 추가적인 메모리가 거의 필요하지 않다.

> 10만 개 배열 테스트
>
> ![selVsQuick2](./img/selVsQuick2.png)

### 단점

이미 정렬되어 있거나, 동일한 원소가 많이 존재하는 경우에 시간이 오래 걸린다. 최악의 경우 $O(N^2)$의 시간이 소요된다.

> 10만 개 배열 테스트
>
> ![selVsQuick](./img/selVsQuick.png)

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="heap">힙 정렬 / Heap Sort</span>

> 힙 정렬이란 최대 힙 트리나 최소 힙 트리를 구성해 정렬을 하는 방법의 알고리즘이다.

### 로직

1. 정렬할 배열을 최대 힙으로 구성한다.
2. 가장 큰 수(루트에 위치)를 가장 끝의 노드와 교환한다.
3. 가장 끝 노드를 제외한 배열을 대상으로 1번부터 반복한다.

### 수도 코드

```
heapSort():
    buildHeap()
    for i <- n-1 downto 1
        A[i] <- deleteMax()
```

### 전체 코드

[HeapSort.java](./src/HeapSort.java)

### 장점

추가적인 메모리를 필요로하지 않으면서 $O(NlogN)$의 시간 복잡도를 보장한다.

> 1억 개 배열 테스트
>
> ![heapVsQuick](./img/heapVsQuick.png)

### 단점

이상적인 경우에 다른 $O(NlogN)$의 시간 복잡도를 가진 정렬과 비교했을 때 시간이 더 오래 걸린다.

> 10만 개 배열 테스트
>
> ![heapVsQuick2](./img/heapVsQuick2.png)

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="shell">셸 정렬 / Shell Sort</span>

> 셸 정렬은 특정한 gap 크기로 나우어 점진적으로 원소를 정렬하고, gap 크기를 점차 줄여 최종적으로 삽입 정렬을 통해 완전히 정렬하는 향상된 알고리즘이다. 적절한 gap 크기를 통해 삽입 정렬보다 빠른 정렬 성능을 제공한다.

### 로직

1. gap 크기를 설정한다.
2. 각 간격 별로 분류된 부분 리스트들을 삽입 정렬을 통해 정렬한다.
3. 각 부분 리스트의 정렬이 끝나면 gap을 줄이고 반복한다. (gap>0일 때)

### 수도 코드

```
shellSort(A[]):
    gap <- A.length / 2
    while (gap > 0)
        for k <- 0 to gap-1
        stepInsertionSort(A, k, gap)
    gap <- gap/2

stepInsertionSort(A[], k, gap):
    for(i <- k+gap; i < A.length; i <- i+gap)
        insertionItem <- A[i]

        j <- i-gap
        while(0 <= j and A[j] > insertionItem)
            A[j+gap] <- arr[j]
            j <- j-gap
        arr[j+gap] <- insertionItem

```

### 전체 코드

[ShellSort.java](./src/ShellSort.java)

### 장점

추가적인 메모리 사용이 거의 없으며 일반적인 삽입 정렬에 비해 더 빠른 정렬 속도를 제공한다.

> 10만 개 배열 테스트
>
> ![insVsShell](./img/insVsShell.png)

### 단점

간격을 잘못 설정할 경우 성능이 급격히 저하될 수 있다. 또한 정렬할 배열의 크기가 작은 경우에는 일반 삽입 정렬보다 느릴 수 있다.

> 100개 배열 테스트
>
> ![insVsShell2](./img/insVsShell2.png)

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="counting">계수 정렬 / Counting Sort</span>

> 계수 정렬은 데이터 값을 직접 비교하지 않고, 단순하게 각 숫자가 몇 개 있는지 개수를 세어 저장한 후 정렬하는 알고리즘이다.

### 로직

1. 입력된 배열의 숫자 범위 크기만큼의 배열을 만든다. (카운트 목적)
2. 입력 배열을 순환하면서 각 정수가 몇 개인지 카운트한다.
3. 카운트 배열을 순환하면서 누적합으로 바꾼다.
4. 카운트 배열의 정보를 이용하여 원본 배열의 각 원소가 정렬된 배열의 몇 번째 자리에 들어갈지를 계산하여 저장한다.

### 수도 코드

```
countingSort(A[]): (범위: 1 ~ k)
    n <- A.length
    for i <- 0 to k
        C[i] <- 0
    for j <- to n-1
        C[A[j]]++
    for i <- to k
        C[i] <- C[i] + C[i-1]
    for j <- n-1 downto 0
        B[C[A[j]]-1] <- A[j]
        C[A[j]]--
    return B
```

### 전체 코드

[CountingSort.java](./src/CountingSort.java)

### 장점

값 비교가 일어나지 않기 때문에 속도가 매우 빠르다

### 단점

개수를 저장하는 배열을 사용해야 하기 때문에 추가 공간이 필요하다.

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="radix">기수 정렬 / Radix Sort</span>

> 기수 정렬은 원소들이 모두 상수 k개 이하의 자릿수를 가진 자연수와 같은 특수한 경우에 사용할 수 있는 알고리즘이다.

### 로직

1.  0~9까지의 Bucket을 준비한다.
2.  모든 데이터에 대하여 가장 낮은 자리수에 해당하는 Buekct에 차례대로 데이터를 둔다.
3.  0부터 차례대로 버킷에서 데이터를 다시 가져온다.
4.  가장 높은 자릿수를 기준으로 하여 자리수를 높여가며 2번 3번 과정을 반복한다.

### 수도 코드

```
radixSort(A[], n, k):
   for i <- to k
       i번째 자릿수에 대해 A[0...n-1]을 안정성을 유지하면서 정렬한다
```

### 전체 코드

[RadixSort.java](./src/RadixSort.java)

### 장점

비교 연산을 하지 않아 매우 빠르며, 안정성을 유지하면서 정렬한다.

### 단점

추가적인 메모리가 많이 필요하고, 부동 소수점 실수처럼 특수한 비교 연산이 필요한 데이터에는 적용할 수 없다.

<p align="right"><a href="#top">⬆️Top</a></p>

---

<br/>

## <span id="bucket">버킷 정렬 / Bucket Sort</span>

> 정렬하고자 하는 원소들이 균등 분포할 때를 가정할 수 있을 때 적용할 수 있는 알고리즘이다.

### 로직

1. 입력 배열 arr을 n개의 동일한 크기의 버킷으로 나눈다.
2. 각 버킷 내에서 삽입 정렬 또는 다른 정렬 알고리즘을 사용하여 데이터를 정렬한다.
3. 각 버킷을 병합하여 정렬된 배열을 생성한다.

### 수도 코드

```
for i <- 0 to n-1
    A[i]를 리스트 B[n * A[i]]에 삽입한다
for i <- 0 to n-1
    리스트 B[i]에 있는 원소들을 정렬
B의 원소들을 차례대로 A로 복사
```

### 전체 코드

[BucketSort.java](./src/BucketSort.java)

### 장점

데이터의 분포가 균등한 경우 매우 빠른 속도로 정렬을 수행할 수 있다.

### 단점

추가적인 메모리 공간이 많이 필요하고, 데이터의 분포가 균등하지 않은 경우 정렬 속도가 느려질 수 있다.

<p align="right"><a href="#top">⬆️Top</a></p>
