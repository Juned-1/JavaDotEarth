class Laptop{
    //All class automatically inherit Object class
    String model;
    int price;
    public String toString(){
        return model + " : " + price;
    }
    //If we want other Object class method like equals directly instead inherit from Object class
    // public boolean equals(Laptop other){
    //     return this.model.equals(other.model) && this.price == other.price;
    // }
    //This will add many if check including value and hash code of object and if they match then return true
    //right click -- source Action -- generate hash code and equals -- select all variable you want to compare -- click ok
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + price;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (price != other.price)
            return false;
        return true;
    }
    
}
public class ObjectClass {
    public static void main(String[] args) {
        Laptop lap1 = new Laptop();
        lap1.model = "Lenovo Yoga";
        lap1.price = 1000;
        System.out.println(lap1);
        System.out.println(lap1.toString());

        Laptop lap2 = new Laptop();
        lap2.model = "Lenovo Yoga";
        lap2.price = 1000;
        boolean result1 = lap1 == lap2;
        System.out.println(result1);
        boolean result2 = lap1.equals(lap2);
        System.out.println(result2);
    }
}
