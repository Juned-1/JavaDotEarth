class A extends Thread{
    //Class which should be thread must be extended with Thread class
    public void run(){
        //every thread when we start call overriden run method from superclass Thread
        for(int i = 1; i <= 100; i++){
            System.out.println("Hi");
            //sleep is used to make thread wait for certain time, time is passed in milli seconds
            //sleep method throws InterruptedException
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
class B extends Thread{
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
public class ThreadPriority {
    public static void main(String[] args) {
        //We can not tell schedular to give amount of time to process or thread, It does it by itself
        //We can only suggest it through thread priority
        A obj1 = new A();
        B obj2 = new B();
        //System.out.println(obj1.getPriority());
        //obj2.setPriority(Thread.MAX_PRIORITY); //we can set priority min = 1, max = 10, if we do not pass explicitly number from 1-10, can get max(10),min(1),default(5) constant from Thread class as staticfinal variable to use
        obj1.start(); //start() method start execution of thread
        //sometime after calculation two thread might reach starting point at same time and same output can be twice or thrice same
        //we can optimize it using another sleep between execution of start
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        obj2.start();       
    }
}
