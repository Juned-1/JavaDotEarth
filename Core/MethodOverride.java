class A{
    public void show(){
        System.out.println("In A show");
    }
    public void config(){
        System.out.println("In A config");
    }
}
class B extends A{
    public void show(){
        //override show() mthod of parent A
        System.out.println("In B show");
    }
}
public class MethodOverride {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
        obj.config();
    }
}
