//If a class have all method as abstract and not non abstract method then instead of this
//abstract class we can use interface

interface A {
    //If we have vriable in interface, they are by default final and static
    //interface can not be instantiated so they can not have memory in heap, therefore variable in interafce can not be non final, it is fixed value stored in stack
    //interface can not have object therefore it does not make sense for it to have non static variable
    int age = 55;
    String area = "Miami";
    //by default every method in interface is public and abstract
    void show();
    void config();
}
interface X{
    void run();
}
interface Y extends X{
    //one interface can inherit another
    //it get run inside it, we can add extra if we want to add
}
class B implements A,Y{
    //We should implement abstract method of interface or our class must become abstract class
    //A class can implement multiple interface unlike there is no multiple inheritance in case of multiple super class
    public void show(){
        System.out.println("in B show");
    }
    public void config(){
        System.out.println("in B config");
    }
    public void run(){
        System.out.println("in B run...");
    }
}
public class Interfaces {
    public static void main(String[] args) {
        //We can create refernce variable of interface type but not object
        //inetrface need to be implemented in a class and object of that class should be instantiated
        A obj;
        obj = new B();
        obj.show();
        obj.config();
        B obj1 = (B)obj; //downcasting
        obj1.run();
        System.out.println(A.age);
        System.out.println(A.area);
    }
}
