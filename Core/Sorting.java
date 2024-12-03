import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Student implements Comparable<Student>{
    //Integer class by default implement Comparable that is why it have comparator
    //So it can automatically sort
    //But in our case there is no comparator, so we create comparator and pass
    //Or our class must implement Comparable interface and override compareTo method
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Student that) {
        return this.age > that.age ? 1 : -1;
        // if(this.age > that.age) return 1;
        // return -1;
    }
}
public class Sorting {
    public static void main(String[] args) {
        // List<Integer> nums = new ArrayList<>(); //from vs1.7 if we give type to LHS nor need in RHS, we can keep it empty
        // nums.add(10);
        // nums.add(91);
        // nums.add(56);
        // nums.add(11);
        // nums.add(78);

        // System.out.println(nums);
        //collections class contain all algorithm method (as static method)
        //Collections.sort(nums); //by default sorts in sacending order

        //sorting based on our own logic, we can pass a comparator
        //here we will sort based on last digit
        // Comparator<Integer> comp = new Comparator<Integer>() {
        //     //compartor is an inteface here we are implementing it with anonymous class
        //     public int compare(Integer i ,Integer j){
        //         //return 1 swap and then return -1 no swap
        //         if(i%10 >= j%10) return 1;
        //         return -1;
        //     }
        // };
        // Collections.sort(nums, comp);
        // System.out.println(nums);

        List<Student> studs = new ArrayList<>();
        studs.add(new Student("Jl", 21));
        studs.add(new Student("Hek", 18));
        studs.add(new Student("Fris", 19));
        studs.add(new Student("Maya", 20));

        //Collections.sort(studs);

        //Even if we use comparable in our class still we can sort using comparator

        //Convert the Comparator into lambda function 
        //Doing it in descending order to show comparator works if we explicitly mention even after comparable function

        Collections.sort(studs, (i,j) -> i.age < j.age ? 1 : -1);

        for(Student s : studs){
            System.out.println(s);
        }


    }
}
