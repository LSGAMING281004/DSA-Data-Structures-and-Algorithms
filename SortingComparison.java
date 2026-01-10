import java.util.Arrays;

public class SortingComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};

        Runnable bubbleTask = () -> {
            int[] arr = Arrays.copyOf(data, data.length);
            bubbleSort(arr);
            System.out.println("Bubble Sort: " + Arrays.toString(arr));
        };

        Runnable selectionTask = () -> {
            int[] arr = Arrays.copyOf(data, data.length);
            selectionSort(arr);
            System.out.println("Selection Sort: " + Arrays.toString(arr));
        };

        Runnable insertionTask = () -> {
            int[] arr = Arrays.copyOf(data, data.length);
            insertionSort(arr);
            System.out.println("Insertion Sort: " + Arrays.toString(arr));
        };

        Runnable mergeTask = () -> {
            int[] arr = Arrays.copyOf(data, data.length);
            mergeSort(arr);
            System.out.println("Merge Sort: " + Arrays.toString(arr));
        };

        Runnable quickTask = () -> {
            int[] arr = Arrays.copyOf(data, data.length);
            quickSort(arr, 0, arr.length-1);
            System.out.println("Quick Sort: " + Arrays.toString(arr));
        };

        // Run all in parallel threads
        new Thread(bubbleTask).start();
        new Thread(selectionTask).start();
        new Thread(insertionTask).start();
        new Thread(mergeTask).start();
        new Thread(quickTask).start();
    }
}
