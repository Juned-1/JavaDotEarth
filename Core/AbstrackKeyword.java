//An abstract method is declared not defined so that it must be defined by subclass
//that inherit that class. i.e., abstract method must be overridden by children class
//Abstract method must be defined inside abstract calss
//But an abstract class might or might not have abstract method
//Abstract class can not be instanitated
//class which override all abstract method of abstract class is called concrete class
//Concrete calss can be instantiated
abstract class Car{
    public abstract void drive();
    public void playMusic(){
        System.out.println("Playing Music...");
    }
}
class WagonR extends Car{
    //concrete class
    public void drive(){
        System.out.println("Driving...");
    }
}
public class AbstrackKeyword {
    public static void main(String[] args) {
        Car obj = new WagonR();
        obj.drive();
        obj.playMusic();
    }
}
