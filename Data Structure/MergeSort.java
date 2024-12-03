public class MergeSort {
    public static void main(String[] args) {
        int nums[] = {3,1,6,5,9,2,8};

        System.out.println("Before Sorting :");
        for(int n : nums) System.out.print(n + " ");
        System.out.println();

        mergeSort(nums,0,nums.length-1);

        System.out.println("After Sorting :");
        for(int n : nums) System.out.print(n + " ");
        System.out.println();
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums,low,mid,high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int sizeOftempArray = (high - low) + 1;
        int[] temp = new int[sizeOftempArray];
        int i = low, j = mid+1;
        int k = 0;
        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        //if one of the array is over
        //copy remaining of left subarray
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        //copy remaining right subarray
        while(j <= high){
            temp[k++] = nums[j++];
        }

        //now copy arranged elment from temp actual array
        for(k = low; k <= high; k++){
            nums[k] = temp[k-low]; 
        }
    }
}
