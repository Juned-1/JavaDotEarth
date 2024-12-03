class A extends Thread{
    //Class which should be thread must be extended with Thread class
    public void run(){
        //every thread when we start call overriden run method from superclass Thread
        for(int i = 1; i <= 100; i++)
            System.out.println("Hi");
    }
}
class B extends Thread{
    public void run(){
        for(int i = 1; i <= 100; i++)
            System.out.println("Hello");
    }
}
public class ThreadConcept {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        obj1.start(); //start() method start execution of thread
        obj2.start();
    }
}
