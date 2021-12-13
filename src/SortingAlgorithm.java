import java.util.ArrayList;

/**
 * @author rmJay
 * @since 2021/12/05-13:16
 */

public class SortingAlgorithm {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i; j < arr.length; j++)
                if (arr[k] > arr[j]) k = j;
            swap(arr, i, k);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--)
                    arr[j + 1] = arr[j];
            arr[j+1] = temp;
        }
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length >> 1; gap >= 1; gap >>= 1) {
            for (int i = 0; i < arr.length; i++) {
                int j = i - gap;
                int temp = arr[i];
                for (; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int k = low;
        int pivot = arr[high];
        for (int i = low; i < high; i++) {
            if (pivot > arr[i])
                swap(arr, k++, i);
        }
        swap(arr, k, high);
        quickSort(arr, low, k - 1);
        quickSort(arr, k + 1, high);

    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        int i;
        for (i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (i = n - 1; i > 0 ; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int lNode = i * 2 + 1;
        int rNode = i * 2 + 2;
        if (lNode < n && arr[largest] < arr[lNode])
            largest = lNode;
        if (rNode < n && arr[largest] < arr[rNode])
            largest = rNode;
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
