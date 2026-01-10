import java.util.*;

public class SearchingAlgorithms {

    // 1. Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // 2. Binary Search (array must be sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 3. Jump Search (array must be sorted)
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int)Math.sqrt(n);
        int prev = 0;

        while (arr[Math.min(step, n)-1] < target) {
            prev = step;
            step += (int)Math.sqrt(n);
            if (prev >= n) return -1;
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // 4. Interpolation Search (array must be sorted)
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) return low;
                return -1;
            }
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[pos] == target) return pos;
            if (arr[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    // 5. Exponential Search (array must be sorted)
    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) return 0;
        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }
        return Arrays.binarySearch(arr, i/2, Math.min(i, arr.length), target);
    }

    // 6. Hashing (using HashMap)
    public static int hashingSearch(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return map.getOrDefault(target, -1);
    }

    // 7. Ternary Search (array must be sorted)
    public static int ternarySearch(int[] arr, int left, int right, int target) {
        if (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == target) return mid1;
            if (arr[mid2] == target) return mid2;

            if (target < arr[mid1]) return ternarySearch(arr, left, mid1-1, target);
            else if (target > arr[mid2]) return ternarySearch(arr, mid2+1, right, target);
            else return ternarySearch(arr, mid1+1, mid2-1, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {11, 12, 22, 25, 33, 64, 90};
        int target = 222;

        Runnable linearTask = () -> System.out.println("Linear Search: " + linearSearch(data, target));
        Runnable binaryTask = () -> System.out.println("Binary Search: " + binarySearch(data, target));
        Runnable jumpTask = () -> System.out.println("Jump Search: " + jumpSearch(data, target));
        Runnable interpolationTask = () -> System.out.println("Interpolation Search: " + interpolationSearch(data, target));
        Runnable exponentialTask = () -> System.out.println("Exponential Search: " + exponentialSearch(data, target));
        Runnable hashingTask = () -> System.out.println("Hashing Search: " + hashingSearch(data, target));
        Runnable ternaryTask = () -> System.out.println("Ternary Search: " + ternarySearch(data, 0, data.length-1, target));

        // Run all in parallel threads
        new Thread(linearTask).start();
        new Thread(binaryTask).start();
        new Thread(jumpTask).start();
        new Thread(interpolationTask).start();
        new Thread(exponentialTask).start();
        new Thread(hashingTask).start();
        new Thread(ternaryTask).start();
    }
}
