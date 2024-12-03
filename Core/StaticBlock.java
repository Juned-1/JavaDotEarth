class Mobile{
    String brand;
    int price;
    static String name;
    //static block are used to initialize static variable
    static{
        name = "Phone";
        System.out.println("In static block");
    }
    Mobile(){
        brand = "General";
        price = 200;
        System.out.println("In constructor");
    }
    public void show(){
        System.out.println(brand + ":" + price + ":" + name);
    }
}
public class StaticBlock {
    public static void main(String[] args) throws ClassNotFoundException {
        // Mobile obj1 = new Mobile();
        // obj1.brand = "Apple";
        // obj1.price = 1500;
        // //Static varaibel are accessed using class name, not object name
        // Mobile.name = "Smart Phone";

        // Mobile obj2 = new Mobile();
        // obj2.brand = "iOS";
        // obj2.price = 1300;
        // //obj2.name = "Phone";

        // obj1.show();
        // obj2.show();

        //Loading calss and static block without object instantiation
        Class.forName("Mobile");
    }
}
