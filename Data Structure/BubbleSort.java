public class BubbleSort {
    public static void main(String[] args) {
        int nums[] = {3,1,6,5,9,2,8};
        int size = nums.length;
        for(int n : nums) System.out.print(n + " ");
        System.out.println();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size-1-i; j++){
                if(nums[j] > nums[j+1]){
                    nums[j] = nums[j+1] + nums[j] - (nums[j+1] = nums[j]); 
                }
            }
            for(int n : nums){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
