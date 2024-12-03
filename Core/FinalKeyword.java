//when we add final keyword in front class that class can not be inherited
// final class Calc{
//     public void show(){
//         System.out.println("in A show");
//     }
//     public void add(int a,int b){
//         System.out.println(a+b);
//     }
// }
// class AdvCalc extends Calc{

// }

class Calc{
    //When we make a method final it can be overriden
    final public void show(){
        System.out.println("in Calc show");
    }
    public void add(int a,int b){
        System.out.println(a+b);
    }
}
class AdvCalc extends Calc{
    public void show(){
        System.out.println("in AdvCalc show");
    }
}
public class FinalKeyword {
    public static void main(String[] args) {
        //final keyword with varaible make it contant its value can not be chnaged
        final int num = 8;
        //num = 9; --can not mutate, invalid changes
        System.out.println(num);
    }
}
