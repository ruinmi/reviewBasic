import java.util.Arrays;

/**
 * @author rmJay
 * @version 1.1
 * @since 2021/12/12 12:40
 */

public class review05 {
   public static void main(String[] args) {
      int[] correct = {2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50};
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
      if (Arrays.equals(arr, correct)) {
         System.out.println("BubbleSort:" + Arrays.toString(arr));
      } else {
         System.out.println("BubbleSort:" + "wrong!");
      }

      if (Arrays.equals(arr1, correct)) {
         System.out.println("selectionSort:" + Arrays.toString(arr1));
      } else {
         System.out.println("selectionSort:" + "wrong!");
      }

      if (Arrays.equals(arr2, correct)) {
         System.out.println("insertionSort:" + Arrays.toString(arr2));
      } else {
         System.out.println("insertionSort:" + "wrong!");
      }

      if (Arrays.equals(arr3, correct)) {
         System.out.println("shellSort:" + Arrays.toString(arr3));
      } else {
         System.out.println("shellSort:" + "wrong!");
      }
      if (Arrays.equals(arr4, correct)) {
         System.out.println("quickSort:" + Arrays.toString(arr4));
      } else {
         System.out.println("quickSort:" + "wrong!");
      }
      if (Arrays.equals(arr5, correct)) {
         System.out.println("heapSort:" + Arrays.toString(arr5));
      } else {
         System.out.println("heapSort:" + "wrong!");
      }
   }

   private static void bubbleSort(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
               swap(arr, j + 1, j);
            }
         }
      }
   }

   private static void selectionSort(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         int k = i;
         for (int j = i; j < arr.length; j++) {
            if (arr[j] < arr[k]) {
               k = j;
            }
         }
         swap(arr, i, k);
      }
   }

   private static void insertionSort(int[] arr) {

      for (int i = 0; i < arr.length; i++) {
         int j = i - 1;
         int temp = arr[i];
         for (; j >= 0 && arr[j] > temp; j--) {
            arr[j + 1] = arr[j];
         }
         arr[j + 1] = temp;
      }
   }

   private static void shellSort(int[] arr) {
      int n = arr.length;
      for (int gap = n >> 1; gap >= 1; gap >>= 1) {
         for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int j = i - gap;
            for (; j >= 0 && arr[j] > temp; j -= gap) {
               arr[j + gap] = arr[j];
            }
            arr[j + gap] = temp;
         }
      }
   }

   private static void quickSort(int[] arr, int low, int high) {
      if (low >= high) {
         return;
      }
      int k = low;
      int pivot = arr[high];
      for (int i = low; i < high; i++) {
         if (arr[i] < pivot) {
            swap(arr, i, k++);
         }
      }
      swap(arr, k, high);
      quickSort(arr, low, k - 1);
      quickSort(arr, k + 1, high);
   }

   private static void heapSort(int[] arr) {
      int n = arr.length;
      int i;
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

      if (lNode < n && arr[lNode] > arr[largest]) {
         largest = lNode;
      }

      if (rNode < n && arr[rNode] > arr[largest]) {
         largest = rNode;
      }

      if (largest != i) {
         swap(arr, largest, i);
         heapify(arr, n, largest);
      }

   }

   private static void swap(int[] arr, int i, int j) {
      if (arr[i] == arr[j]) return;
      arr[i] ^= arr[j];
      arr[j] ^= arr[i];
      arr[i] ^= arr[j];
    }
}
