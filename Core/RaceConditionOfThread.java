class Counter{
    int count;
    public synchronized void increment(){
        //synchronized method avoid race condittion
        //whenever we use this mthod inside java will make sure to only one tread can run this method at a time
        count++;
    }
}
public class RaceConditionOfThread {
    //Mutable resources if accessed by thread it is critical resource and each thread
    //or process race for it. So we have to make such resource thread safe

    public static void main(String[] args) {
        Counter c = new Counter();
        //Each thread race to increase count
        Runnable obj1 = () -> {
                for(int i = 1; i <= 1000; i++){
                    c.increment();
                }
        };
        Runnable obj2 = () -> {
                for(int i = 1; i <= 1000; i++){
                    c.increment();
                }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
        //Main prints count after starting thread whenever get chance, do not wait for t1 and t2 to finish
        //To make wait we use join() method. join() allows thread to come back and join
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(c.count);
    }
}
