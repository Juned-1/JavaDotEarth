class A {
    public void show(){
        System.out.println("in A show");
    }
}
class B extends A{
    public void show(){
        System.out.println("in B show");
    }
}
public class DynamicMethodDispatch {
    public static void main(String[] args) {
        //B obj = new B();
        //It is possible refernce varaibel of type parent and instance is of type B
        A obj = new A();
        obj.show();

        obj = new B();
        obj.show();
    }
}
