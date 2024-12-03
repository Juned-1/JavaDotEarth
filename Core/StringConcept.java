public class StringConcept {
    public static void main(String[] args) {
        //String is class, so string varaibel we create are object
        String name = new String("Jake"); //passing value is constructor
        System.out.println(name);
        System.out.println(name.hashCode());
        System.out.println("Hello "+name); //conactination with +
        System.out.println(name.charAt(2)); //character at a given index
        System.out.println(name.concat(" Tom")); //conctinating with concat

        //Following also create object for us even if we do not explicitly create it
        String name2 = "James";
        System.out.println(name2);

        //same instance of string but two refernce s1 and s2 (since value is same)
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1 == s2);
    }
}
