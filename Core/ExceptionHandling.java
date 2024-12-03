class MyException extends Exception{
    //Creating our own Exception, it can extends Exception or RuntimeException both are fine
    public MyException(String s){
        super(s);
    }
}
class A{
    //throws keyword is used to duck the exception to its caller method
    public void show() throws ClassNotFoundException{
        Class.forName("Demo"); //find wheteher class exist or not
    }
}
public class ExceptionHandling {
    public static void main(String[] args) {
        A obj = new A();
        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); //print stack trace of error
        }
        int i = 9;
        int j = 3;
        int nums[] = new int[5];
        String str = null; 
        try{
            //throw key word is used to throw the Exception -- throwing built in Exception
            if(j == 0 )
                throw new ArithmeticException("Can not divide by zero");
            int result = i/j;
            System.out.println(result);
            //throwing our own Exception
            if(i < 10)
                throw new MyException("We do not want to handle i < 10");

            System.out.println(str.length());
            System.out.println(nums[5]);
        }catch(ArithmeticException e){
            //General Exception is Exception class
            //Rest all Exception are subclass of it inherited from it
            //ArithmeticException is subclass of Exception
            System.out.println("Failed to divide : " + e);
        }catch(ArrayIndexOutOfBoundsException e){
            //ArrayIndexOutOfBoundsException class is subclass of Exception class
            System.out.println(e);
        }catch(MyException e){
            //Handling our own Exception
            System.out.println(e);
        }catch(Exception e){
            //If we are not sure about what kind of exception will arise
            //To be safe at the end we can handle Exception class generally
            //When we have child and parent class, make parent class at bottom of catch so that it becomes default Exception handler if no other exception meets with trhown Exception
            System.out.println("Something went wrong..." + e);
        }
        System.out.println("Bye");
    }
}
