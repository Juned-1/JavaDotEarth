import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TryWithFinally {
    public static void main(String[] args){
        int i = 3;
        int j = 0;
        //We want some code to get with or without handling exception then we write inside finally
        //This code get executed regardless of exception or not
        // try{
        //     j = 9/i;
        // }catch(Exception e){
        //     System.out.println(e);
        // }finally{
        //     System.out.println("Bye");
        // }
        //finally is mostly used to close resources
        int num = 0;
        // BufferedReader bf = null;
        System.out.println("Enter a number : ");
        // try{
        //     bf = new BufferedReader(new InputStreamReader(System.in));
        //     num = Integer.parseInt(bf.readLine());
        //     System.out.println(num);
        // }catch(Exception e){
        //     System.out.println(e);
        // }finally{
        //     bf.close();
        // }
        //In later version of Java we do not need finally, they have optimized it and provided us with tryWithResources
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            //The resource we created inside try will be automatically closed when try is over
            //We do not have to explicitly close it
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
