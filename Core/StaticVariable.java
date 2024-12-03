class Mobile{
    String brand;
    int price;
    static String name;
    public void show(){
        System.out.println(brand + ":" + price + ":" + name);
    }
    public static void show1(Mobile obj){
        //We can use static varaibel in static method but can not use instance variable inside it
        //But we can receive object refernece in static method and access variable from that object
        System.out.println("In static method");
        System.out.println(obj.brand + ":" + obj.price + ":" + name);

    }
}
public class StaticVariable {
    public static void main(String[] args) {
        Mobile obj1 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 1500;
        //Static varaibel are accessed using class name, not object name
        Mobile.name = "Smart Phone";

        Mobile obj2 = new Mobile();
        obj2.brand = "iOS";
        obj2.price = 1300;
        //obj2.name = "Phone";

        obj1.show();
        obj2.show();

        //Static method are accessed using object not using class name
        Mobile.show1(obj2);

    }
}
