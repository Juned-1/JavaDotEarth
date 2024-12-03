// class var{
//     //But we can not give a class as name var
// }
class Alien{
    public void show(){
        System.out.println("Alien Show");
    }
};
public class LVTI {
    //var obj = 9; //not allowed at instance level
    public static void main(String[] args) {
        //Local varaible type inference(LVTI) can be done using var keyword
        //Hostorically java have been strongly typed lanaguage
        //var is only applicable to local variable, not instance variable
        //Since instance variable are for storage but local varaible in method
        //are for processing only temporarily not 
        var a = 8; //compiler assign type int to a, even if we do not mention it
        //It is still static language not dynamically typed language
        //int c; //allowed
        //var b; // not allowed since value is not assigned it can not infer type
        System.out.println(a);

        String var = "Xray";
        System.out.println(var); //even we can create varaible by name var

        var nums = new int[10]; //var nums[] error since var can not be element type of an array
        var obj = new Alien();
        obj.show();
    }
}
