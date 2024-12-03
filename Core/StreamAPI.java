import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamAPI {
    //From stream API we can use multiple method like map, filter, reducer method
    public static void main(String[] args) {
        //Arrays is class as List method gives a list and convert it into ArrayList
        List<Integer> nums = Arrays.asList(4,9,1,10,100);
        System.out.println(nums);
        //Normal for loop
        // for(int i = 0; i < nums.size(); i++){
        //     System.out.println(nums.get(i));
        // }
        //Enhanced for loop
        // for(int n : nums){
        //     System.out.println(n);
        // }

        //For Each loop
        //for each accept a Consumer
        //Consumer is functional interface we can implement it using class, anonymous class or lmbda function
        //Method we have to override from Consumer is void accept(T t);
        // Consumer con = new Consumer<Integer>() {
        //     //Anonymous class to override accept method of Consumer
        //     public void accept(Integer val){
        //         System.out.println(val);
        //     }
        // };
        // nums.forEach(con);
        //nums.forEach(n -> System.out.println(n)); //for each gives us one value at a time we can save it and use it in lambda


        //Stream API, Stream is an interface
        //nums.stream() return object of such class which implemented Stream interface
        
        //Stream<Integer> s1 = nums.stream(); //whenever we will change stream it will not affect actual data (nums in this case)
        //s1.forEach(n -> System.out.println(n));
        //stream is like water stream or river once used, again can not be used
        //if we use for each on same stream s1 again then it will give run time error
        //stream is closed after once used
        //s1.forEach(n -> System.out.println(n));

        //On stream we can lot of api method like filter, map etc
        //it takes a predicate (as object of of general or anonymous class implement Stream, or lambda function) based on which it will filter the stream 
        //filter returns a stream
        //Stream<Integer> s2 = s1.filter(n -> n%2 == 0);
      
        //Stream<Integer> s3 = s2.map(n -> n*2); //map return stream
        

        //performing sum of stream values using reduce, intially sum = 0, first argument indicate it
        //second argument is lambda function which sum up element with previous sum, first value in lambda function is previous(aggregate) value and second value in lambda function is current element
        //int result = s3.reduce(0, (sum, el) -> sum+el); //reduce return int
        

        //We can chain method on returned stream, nums.stream() return stream
        //On that we perform filter which return another stream
        //On that we perform map which in turn return another stream
        //On that we perform reduce which return int

        int result = nums.stream()
                        .filter(n -> n%2 == 0)
                        .map(n -> n*2)
                        .reduce(0, (sum, el) -> sum+el);
        System.out.println(result);
        //When we want to perform operation through multiple thread paralally, we create parallel stream instead of stream
        //Stream<Integer> s = nums.parallelStream().filter().map();
    }
}
