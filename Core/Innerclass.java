class A{
    int age;
    public void show(){
        System.out.println("in show");
    }
    class B{
        public void config(){
            System.out.println("in config");
        }
    }
    static class C{
        //We can not make outer class static, we can make inner class static
        public void configC(){
            System.out.println("in config C");
        }
    }
}
public class Innerclass {
    public static void main(String[] args) {
        //To create object of inner class we need object of outer class first
        //To create refernce type of innereclass == OuterClass.InnerClass
        A obj = new A();
        obj.show();

        A.B obj1 = obj.new B(); //creating object of inner class
        obj1.config();

        //But if inner class is static class then we do not need object to create its instance we can do it from class instance
        A.C obj2 = new A.C();
        obj2.configC();
    }
}
