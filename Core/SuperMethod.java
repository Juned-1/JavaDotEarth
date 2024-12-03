class A{
    //class A extends Object
    public A(){
        //super();
        System.out.println("Inside A");
    }
    public A(int a){
        //super();
        System.out.println("Inside A int");
    }
    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }
}

class B extends A{
    public char[] marks;
    public B(){
        //super()
        //super(5);
        System.out.println("Inside B");
    }
    public B(int a){
        this();
        //super(a);
        //this() will execute the constructor of same class
        System.out.println("Inside B int");
    }
    //every constructor of class have super method in it even if we do not explicitly call it
    //super() calls the constructor of super class
    //we can use it to say explictly which constructor of superclass should be used
    //if we do not explicitly mention it call default constructor of super calss
}

public class SuperMethod {
    public static void main(String[] args) {
        //Every class in java extends the Object class by default in java event if we do not mention
        B obj = new B(5);
        //B obj2 = new B();

    }
}
