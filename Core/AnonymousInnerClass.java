//If we want to override a class only for once then why should we create it agian instead we can create anonymous class in which we override
class A{
    public void show(){
        System.out.println("in A show");
    }
}
abstract class B{
    public abstract void showB();
}
public class AnonymousInnerClass {
    public static void main(String[] args) {
        A obj = new A(){
            //this is is definition of anonymous class to override A
            //But here first time we are using instantiation and later defining class
            //we are not using class name, it is inner class and anonymous
            public void show(){
                System.out.println("in anonymous override show");
            }
        };
        obj.show();

        B obj1 = new B(){
            //this anonymous inner class is overriding showB method of abstract class B
            //obj1 is not object of B, as we know abstract class can not have object
            //this is object of this anonymous inner class
            public void showB(){
                System.out.println("in abstract instantiation");
            }
        };
        obj1.showB();
    }
}
