class Calculator{
    //Overloaded method based on signature
    int a = 9; //by default public access modifier
    public int add(int num1, int num2){
        return num1 + num2;
    }
    public int add(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }
    public double add(double num1, int num2){
        return num1 + num2;
    }
}
public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(4,5));
        System.out.println(calc.add(7,8,9));
        System.out.println(calc.add(5.9,6));
        //different instance have different states
        Calculator calc2 = new Calculator();
        calc2.a = 10;
        System.out.println(calc.a);
        System.out.println(calc2.a);
    }
}
