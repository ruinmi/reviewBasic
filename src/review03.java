import java.util.Arrays;

/**
 * @author rmJay
 * @since 2021/12/07-11:39
 */

public class review03 {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSort(arr);
        int[] arr1 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selectionSort(arr1);
        int[] arr2 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        insertionSort(arr2);
        int[] arr3 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        shellSort(arr3);
        int[] arr4 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(arr4, 0, arr4.length - 1);
        int[] arr5 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        heapSort(arr5);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j])
                    k = j;
            }
            swap(arr, k, i);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length >> 1; gap >= 1; gap >>= 1) {
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                for (; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = arr[high];
        int k = low;
        for (int i = low; i < high; i++) {
            if (pivot > arr[i])
                swap(arr, i, k++);
        }
        swap(arr, k, high);
        quickSort(arr, low, k - 1);
        quickSort(arr, k + 1, high);
    }

    public static void heapSort(int[] arr) {
        int i;
        int n = arr.length;
        for (i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int lNode = i * 2 + 1;
        int rNode = i * 2 + 2;

        if (lNode < n && arr[largest] < arr[lNode]) largest = lNode;
        if (rNode < n && arr[largest] < arr[rNode]) largest = rNode;

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int j, int i) {
        if (arr[j] == arr[i]) return;
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
    }
}
