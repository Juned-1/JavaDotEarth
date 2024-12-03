class Search{
    public static void main(String[] args) {
        //with doublign size binary search take one extra step
        int nums[] = new int[32];//[16]//{1,1,2,3,4,5,7,8,9,65};
        int target = 8;
        int result = linearSearch(nums, target);
        if(result != -1) System.out.println(target + " is found at index " + result);
        else System.out.println(target + " is not found!");
        int result2 = binarySearch(nums, target);
        if(result2 != -1) System.out.println(target + " is found at index " + result);
        else System.out.println(target + " is not found!");
    }

    private static int linearSearch(int[] nums, int target) {
        int step = 0;
        for(int i = 0; i < nums.length; i++){
            step++;
            if(nums[i] == target){
                System.out.println("Linear search took " + step + " step");
                return i;
            }
        }
        System.out.println("Linear search took " + step + " step");
        return -1;
    }

    private static int binarySearch(int[] nums, int target){
        int left = 0; int right = nums.length - 1;
        int step = 0;
        while(left <= right){
            step++;
            int mid = (left + right)/2;
            if(nums[mid] == target){
                System.out.println("Binary search took " + step + " step.");
                return mid;
            }
            else if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println("Binary search took " + step + " step.");
        return -1;
    }
}