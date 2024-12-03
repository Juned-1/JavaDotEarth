class Human{
    //Enacapsulating value with different access modifier
    private int age; //int default value = 0
    private String name; //string default value is null
    //constructor overloading
    public Human(){
        //Default constructor -- if we do not create default constructor java does it automatically and assign default values to every instance variable
        age = 60;
        name = "John";
    }
    public Human(String name){
        this.name = name;
    }
    public Human(int age,String name){
        //parameterized constructor
        this.age = age;
        this.name = name;
    }
    //accessor -- getter
    public int getAge(){return age;}
    public String getName(){return name;}
    //mutator -- setter
    public void setAge(int age){this.age = age;}
    public void setName(String name){this.name = name;}
    //Java by default gives us current object(instance) using this keyword
}
public class Encapsulation {
    public static void main(String[] args) {
        //We are binding our data with method, no one can access data without method
        //That is encapsulation of data and method
        Human jake = new Human(23,"Jake");
        System.out.println(jake.getName() + " : " + jake.getAge());
        jake.setName("Jane");
        jake.setAge(34);
        System.out.println(jake.getName() + " : " + jake.getAge());

        Human man = new Human();
        System.out.println(man.getName() + " : " + man.getAge());

        Human stew = new Human("Stwie");
        System.out.println(stew.getName() + " : " + stew.getAge());

    }
}
