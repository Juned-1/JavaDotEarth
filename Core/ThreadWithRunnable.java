/*
    If we have multiple inheritance then we can not make thread, since multiple inheritance
    is not allowed in Java. So extending from other class and Thread at the same time
    is not possible. But we know Thread calss implement Runnable Interface which have run()
    to override. So we can create thread using Runnable interface if rqeuire in case of
    multiple inheritance.
 */
class A implements Runnable{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println("Hi");
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class B implements Runnable{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadWithRunnable {
    public static void main(String[] args) {
        //A obj1 = new A();
        //B obj2 = new B();
        //obj1.start(); --start method will not work since in Runnable interface we do not have start method
        //start method was coming from thread class
        //Thread class have multiple constructor, one of it receive Runnable object
        //We can use it and create thread and then call start from Thread object
        //Runnable obj1 = new A(); Runnable obj2 = new B();
        //Thread t1 = new Thread(obj1); Thread t2 = new Thread(obj2);
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());
        t1.start();
        t2.start();
    }
}
