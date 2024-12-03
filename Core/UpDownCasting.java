class A{
    public void show1(){
        System.out.println("in A show");
    }
}
class B extends A{
    public void show2(){
        System.out.println("in B show");
    }
}
public class UpDownCasting {
    public static void main(String[] args) {
        A obj = new B(); //object of B is upcasted to type Object of A ; A obj = (A) new B()
        obj.show1();
        //obj.show2() can not call even though objevt is of B (but upcasted type A)
        //Now we will downcast it
        B obj1 = (B) obj;
        obj1.show1();
        obj1.show2(); //now we can call show2()
        
    }
}
