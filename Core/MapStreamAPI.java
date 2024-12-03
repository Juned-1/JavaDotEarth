import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapStreamAPI {
        public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,9,1,10,100);
        System.out.println(nums);
        //map method needs object of functional interface Function<T,R> which takes two types one what type it accept aontehr type what it returns
        //And we have to override R apply(T) method
        //In our cse accept Integer and return also intger
        // Function<Integer,Integer> f = new Function<Integer, Integer>() {
        //     //anonymous class to implement Function inteface
        //     public Integer apply(Integer val){
        //         return val*2;
        //     }
        // };//belongs to java.util.function
        //Stream<Integer> s1 = nums.stream().map(f);
        //Stream<Integer> s1 = nums.stream().map(n -> n*2); //can do it lambda since functinal inteface
        //Stream we are getting from map or filter we can call sorted method on it and it will return new stream with sorted values
        Stream<Integer> s1 = nums.stream().map(n -> n*2).sorted();
        s1.forEach(val -> System.out.println(val));
        //sorting can not work with parallel stream, since sorting need elements together
    }
}
