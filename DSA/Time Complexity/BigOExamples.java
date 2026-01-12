
public class BigOExamples {
    public static int getFirstElement(int[] arr) { 
        return arr[0]; // Always one step, regardless of size
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0,right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    } 

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) L[i] = arr[left + i];
        for(int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];

        // 0(N log N)
    }

    public static void printPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++){
                System.out.println(arr[i] + ", "+arr[j]);
            }
        }
    }

    public static void printTriplets(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                }
            }   
        }
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i + 1);
            permute(rest, ans + ch);
        }
    }

    public static void main(String[] args) {
        getFirstElement(new int[]{2,5,10}); // 0(1)
        binarySearch(new int[]{1,3,7,9,14,22,36}, 36); // 0(log N)
        linearSearch(new int[]{19,93,47,91,14,22,536}, 93); // 0(N)
        mergeSort(new int[]{3,6,2,8,4}, 0, 4); // 0(N log N)
        printPairs(new int[]{1,2,3,4,5,6}); // 0(N*N)
        printTriplets(new int[]{1,2,3,4,5,6}); // 0(N * N * N)
        fib(5); // 0(2^N)
        permute("String", "answer"); // 0(N!)


    }
}