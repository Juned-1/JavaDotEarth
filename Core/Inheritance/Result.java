import other.tools.AdvCalc;
import other.*; //import all class file in other which is A, only file not sub package or directory
class C extends A{
    public void showAge(){
        System.out.println(age);
    }
}
public class Result {
    public static void main(String[] args) {
        // AdvCalc cal = new AdvCalc();
        // int r1 = cal.add(2,3);
        // int r2 = cal.sub(5,3);
        // int r3 = cal.mult(5, 3);
        // int r4 = cal.divd(6, 3);
        // System.out.println(r1 + " " + r2 + " " + r3 + " " + r4);
        //System class String class etc belong to package java.lang
        //Even if we do not import it explicitly, Java does import these from java.lang
        //import java.lang.*; == import every class file from java.lang
        A obj = new A();
        //System.out.println(obj.marks); -- inaccessible
        obj.show();
        B obj2 = new B();
        //System.out.println(obj2.marks);
        C obj3 = new C();
        obj3.showAge();
    }
    //general idea is one file should have onle class
    //try to make class public, instance variable private, method mostly public sometime protected, avoid default
}
