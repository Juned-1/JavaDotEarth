public class SelectionSort {
    public static void main(String[] args) {
        //selection sort reduces number of swap unlike bubble sort
        int nums[] = {3,1,6,5,9,2,8};
        int size = nums.length;
        for(int n : nums) System.out.print(n + " ");
        System.out.println();
        for(int i = 0; i < size-1; i++){
            int minIndex = i;
            for(int j = i+1; j < size; j++){
                if(nums[minIndex] > nums[j]) minIndex = j;
            }
            if(minIndex != i) nums[i] = nums[i] + nums[minIndex] - (nums[minIndex] = nums[i]);
            for(int n : nums) System.out.print(n + " ");
            System.out.println();
        }
        System.out.println("After sorting : ");
        for(int n : nums) System.out.print(n + " ");
        System.out.println();
    }
}
