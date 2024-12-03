import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class InputConcept {
    public static void main(String[] args) {
        //println() is method of PrintStream class so we have to create object of that class to use prinln
        //But actually we do not have create object, object is already created which is out inside System class as static and final reference  of PrintStream class
        System.out.println("Enter a number");
        //in is static variable inside System class of type InputStream class
        // try{
        //     int num = System.in.read(); //read method duck exception to handle if we do not read we have to handle it
        //     //read() method returns ASCII values and reads one character at a time
        //     System.out.println(num - 48);
        // }catch(Exception e){
        //     System.out.println(e);
        // }

        //Java gives us option of BufferedReader which ispart of io class, Buffer reader can allow us to read multiple character together
        //InputStreamReader need an onject of InputStream class, which we can directly pass in object
        // InputStreamReader in = new InputStreamReader(System.in);
        // BufferedReader bf = new BufferedReader(in); //Buffer Redaer require an object of InputStreamReader
        // //readLine raeds a line until \n (newline) get, but it read string to make it string we have to use parseInt from Integer object class
        // try{
        //     int num = Integer.parseInt(bf.readLine());
        //     System.out.println(num);
        //     bf.close();
        // }catch(Exception e){
        //     System.out.println(e);
        // }
        //BufferReader can take input from anywhere, not only i/o stream, but also from file, network etc.
        //BufferedReader is resource once we open it, it is our responsibility to close it

        //Instead of BufferReader one better way introduced in java is Scanner class from util, Before Scanner everyone was using BufferReader
        //Scanner takes InputStream object which we can give directly from System class for I/O
        //We can also give file reader stream or network reader stream
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
        sc.close(); //scanner object need to be closed
    }
}
