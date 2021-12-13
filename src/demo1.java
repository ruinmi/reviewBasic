import javafx.fxml.LoadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author rmJay
 * @since 2021/11/25-21:30
 */

public class demo1 {
    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        
//        int[] arr = {0,5,3,2,1};

//        quickSort(arr, 0, arr.length-1);
//        bubbleSort(arr);
//        heapSort(arr);
//        SortingAlgorithm.bubbleSort(arr);
//        SortingAlgorithm.selectionSort(arr);
//        SortingAlgorithm.insertionSort(arr);
//        SortingAlgorithm.shellSort(arr);
//        SortingAlgorithm.quickSort(arr, 0, arr.length - 1);
        SortingAlgorithm.heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int k = nums[i];
                    nums[i] = nums[j];
                    nums[j] = k;
                }
            }
        }
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            swapInt(nums, index, i);
        }
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > base; j--) nums[j+1] = nums[j];
            nums[j+1] = base;
        }
    }

    public static void shellSortVer2(int[] arr){

        int k = 1;
        int[] gapArr = new int[32];
        gapArr[0] = 1 ;
        int item = 0;
        while ((item = (int) (Math.pow(4, k) + 3 * Math.pow(2, k - 1) + 1)) < arr.length)
            gapArr[k++] = item;
        for (int l = k-1; l >= 0; l--) {
            int gap = gapArr[l];
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i + gap < arr.length; i++) {
                int temp = arr[i+gap];
                int j = i + gap;
                for (; j - gap >= 0 && temp < arr[j - gap]; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    public static void shellSort(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i + gap < arr.length; i++) {
                int temp = arr[i+gap];
                int j = i + gap;
                for (; j - gap >= 0 && temp < arr[j - gap]; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high){

        if (high <= low) return ;

        int pivot = arr[high];
        int k = low;
        for (int i = low; i < high; i++) {
            if (pivot > arr[i]) swapInt(arr, i, k++);
        }
        swapInt(arr, high, k);
        quickSort(arr, low, k - 1);
        quickSort(arr, k + 1, high);
    }

//    public static void heapSort(int[] arr) {
//        int i;
//        int n = arr.length;
//        for (i = n / 2 - 1; i >= 0; i--)
//            heapify(arr, n, i);
//        for (i = n - 1; i > 0; i--) {
//            swapInt(arr, i, 0);
//            heapify(arr, i, 0);
//        }
//    }

//    private static void heapify(int[] arr, int n, int i) {
//        int largest = i;
//        int lNode = i * 2 + 1;
//        int rNode = i * 2 + 2;
//        if (lNode < n && arr[largest] < arr[lNode])
//            largest = lNode;
//        if (rNode < n && arr[largest] < arr[rNode])
//            largest = rNode;
//        if (largest != i) {
//            swapInt(arr, largest, i);
//            heapify(arr, n, largest);
//        }
//    }

    public static void swapInt(int[] arr, int i, int j) {
        if (arr[i] == arr[j])
            return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}

