public class QuickSort {
    public static void main(String[] args) {
        int nums[] = {3,1,6,5,9,2,8};
        int size = nums.length;
        System.out.println("Before Sorting :");
        for(int n : nums) System.out.print(n + " ");
        System.out.println();

        quickSort(nums,0,size-1);

        System.out.println("After Sorting :");
        for(int n : nums) System.out.print(n + " ");
        System.out.println();
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low < high){
            int pivotIndex = partition(nums,low,high);
            quickSort(nums, low, pivotIndex-1);
            quickSort(nums, pivotIndex+1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low-1;
        for(int j = low; j < high; j++){
            if(nums[j] < pivot){
                i++;
                nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]); //swap [i] and [j] -- arrange elment left or right to pivot
            }
        }
        //now put pivot in its palce
        nums[high] = nums[i+1] + nums[high] - (nums[i+1] = nums[high]); //i+1 is perfect place for pivot
        return i+1; //i+1 is new partion index since this is the palce where pivot get placed
    }
}
