import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterStreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,9,1,10,100);
        System.out.println(nums);
        //Predicate is functional interface which tells us to override one method 
        //test() which accept any type value and return boolean
        // Predicate<Integer> p = new Predicate<Integer>() {
        //     //anonymous class to implement pridicate
        //     public boolean test(Integer val){
        //         //return val % 2 == 0 ? true : false;
        //         return val % 2 == 0; //this itself will return true or false
        //     }
        // }; //belongs to java.util.function
        //Stream<Integer> s1 = nums.stream().filter(n -> n%2 == 0); //can be done with lambda
        Stream<Integer> s1 = nums.stream().filter(n -> n%2 == 0);
        s1.forEach(val -> System.out.println(val));
    }
}
