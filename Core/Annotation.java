//Annotation is meta data, we use annotation to interact with compiler to act in certain way
//Difficult bug in programming to logical error may arise, so we tell compiler to help us correct
//Eg: I have show method in A, I want override in B and instead of show I wrote shows method mistakenly
//then we can tell compiler correct name of overridden method using @Override annotation
//There are lot of built in annotation we can use to give correction information to compiler
//We can Retention when we design our own annotation : we can set compiler level -- info will give during compiling or run time give during run time

@Deprecated
class A {
    
    public void show(){
        System.out.println("in A show");
    }
}
class B extends A{
    @Override
    public void shows(){
        System.out.println("in B show");
    }
} 
public class Annotation {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
    }
}
