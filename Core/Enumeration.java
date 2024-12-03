//enum is useful on creating different constants
//coding status for http response or request or network code
enum Status{
    Running, Failed, Pending, Success
}

enum Laptop{
    //Laptop is class and and Mac, xps etc are object of type Laptop
    Macbook(2000), XPS(2200), Surface, Thinkpad(1500);

    private int price;

    
    private Laptop() {
        //default constructor
        price = 500;
    }

    private Laptop(int price) {
        this.price = price;
        System.out.println("in Laptop " + this.name());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
}
//enum class can not be inherited, but we can create constructor and method
//enum in Java extends from superclass Enum
public class Enumeration {
    public static void main(String[] args) {
        //In c or c++ enum is defualt type
        //But in Java everything is class, so enum is class
        Status s = Status.Running; //Running instance/object of class Status enum, Running is object
        System.out.println(s);
        System.out.println(s.getClass().getSuperclass());
        //On other language every enumeration have number 0,1,2,.. so that based on numbe rwe can pick the number
        //To get the number we can call the method ordinals
        System.out.println(s.ordinal());
        //To get all status values
        Status[] s1 = Status.values(); //status.values gives an array of status object
        for(Status temp : s1){
            System.out.println(temp + " : " + temp.ordinal());
        }

        // if(Status.Running == s) System.out.println("All good");
        // else if(Status.Failed == s) System.out.println("Try again");
        // else if(Status.Pending == s) System.out.println("Wait");
        // else System.out.println("Done");

        switch(s){
            case Running:
                System.out.println("All good!");
                break;
            case Failed:
                System.out.println("Try again!");
                break;
            case Pending:
                System.out.println("Please Wait!");
                break;
            default:
                System.out.println("Done!");
        }

        Laptop lap = Laptop.Macbook;
        lap.setPrice(2500);
        for(Laptop lap1 : Laptop.values()){
            System.out.println(lap1 + " : " + lap1.getPrice());
        }

    }
}
