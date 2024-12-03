package other;

public class A {
    //when modifier is default it can not be accessed otside current file
    int marks = 6;
    //from different package accessible only when it is public
    //Everything which we want to use outside package make it public
    //public int marks = 6;
    public void show(){
        System.out.println("Other pacakge A class");
    }

    protected int age = 35;
    //protected accessible in children class
    
}
