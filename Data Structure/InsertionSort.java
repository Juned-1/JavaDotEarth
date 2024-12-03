public class InsertionSort {
    public static void main(String[] args) {
        //Assume first value is sorted
        //Try to sort from second valu
        int nums[] = {3,1,6,5,9,2,8};
        int size = nums.length;
        System.out.println("Before Sorting :");
        for(int n : nums) System.out.print(n + " ");
        System.out.println();

        //Insertion sort
        for(int i = 1; i < size; i++){
            int key = nums[i];
            int j = i-1;
            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }

        System.out.println("After Sorting :");
        for(int n : nums) System.out.print(n + " ");
        System.out.println();
    }
}
