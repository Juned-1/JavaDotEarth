import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceStreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,9,1,10,100);
        System.out.println(nums);
        //Reduce method take an object of class which implement BinaryOperator functional Interface which in turn extend from BiFunction functional interface
        //BiFunction<T,U,R> have method R apply(T carry, U element) to override
        //T reduce(T identity, BinaryOperator<T> accumulator); reduce identity element is initial values
        //Then reduce internally call apply from BinaryOperator
        // BinaryOperator<Integer> bi = new BinaryOperator<Integer>() {
        //     //anonymous class implemented from BiFunction function interface
        //     public Integer apply(Integer carry, Integer element){
        //         return carry + element;
        //     }
        // };

        // int res = nums.stream().reduce(0, bi);
        
        int res = nums.stream().reduce(0, (carry, element) -> carry + element);
        //can do it lambda since it is functional interface

        System.out.println(res);
    }
}
