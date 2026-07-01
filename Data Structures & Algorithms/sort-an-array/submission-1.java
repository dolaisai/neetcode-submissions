class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums; 
    }
    public int[] mergeSort(int[] arr, int l, int r){
        if(l == r){
            return arr; 
        }
        
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
        return arr; 
    }
    
     public void merge(int[] arr, int l, int m, int r) {

        int leftSize = m - l + 1;
        int rightSize = r - m;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        //assign left subarray values
        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[l + i];
        }

        //assign right subarray values
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // merge back into arr
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // remaining left elements
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // remaining right elements
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}