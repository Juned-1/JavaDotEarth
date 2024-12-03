//Functinal inetrface have one method
//Single abstract nethod (SAM) interface or functional inetrface
//We need to specify it with annotation FunctionalInterface by that we are guranteing that interface have one method
//Java 8 allows us to use lambda expression
//Lambda expression can be used with functional interface, since functional interface have one method
//It does not need separate verbose class for it(whether named or anonymous class)
//Lambda function does not create separate class but increases size of class in which it is included, since it write its class inside that class

@FunctionalInterface
interface A {
    //void show(int i,int j)
    //void show(int i);
    int add(int i,int j);
}
public class FunctionalInterfaceConcept {
    public static void main(String[] args) {
        // A obj = new A(){
        //     //creating anonymous implementation class of interface A
        //     public void show(){
        //         System.out.println("in show");
        //     }
        // };
        
        //Lambda expression or lambda function
        //behind the compiler does all class and method prototype, this is just syntactical sugar
        // A obj = () -> {
        //     System.out.println("in show");
        //     System.out.println("Lambda...");
        // }
        //If we have multiple statement we need curly braces if one statement we can absorb curly braces as well
        // A obj = (int i,int j) -> System.out.println("in show " + i);
        // obj.show(5,8);
        //If one parameter we can recive it directly without paraentehsis
        //A obj = i -> System.out.println("in show " + i);
        //obj.show(5);

        A obj = (i,j) -> i+j; //if returning in one line then no curly braces required nor return statement is required
        int result = obj.add(5, 9);
        System.out.println(result);

        //Lambda expression only works with functional interface, not with other interface
        //Other interface multiple method of same proptotype so it can not detect with which method it work
        // a interface have void show() and void config() two methods, then writing () -> {...}, compiler does not uderstand which one to execute like show or config
    }
}
