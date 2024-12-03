class Calculator{
    //private class if we do not mention access modifier will be accessible only in this Java file
    int a; //private variable (state)
    public int add(int num1, int num2){
        //method
        return num1 + num2;
    }
}
public class ClassObjectConcept {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 5;
        Calculator calc; //Declaring Reference type of Calculator -- user defined type calss Calculator
        calc = new Calculator(); //Creating object of class Calculator
        int result = calc.add(num1,num2);
        System.out.println(result);        
    }
}

//Object have properties(states) and behaviors
