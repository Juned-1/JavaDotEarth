// class Man{
//     //To create a data carrier calss we are writing so many methods to get values nad equalize them
//     private final int id;
//     private final String name;
//     public Man(int id, String name) {
//         this.id = id;
//         this.name = name;
//     }
//     public int getId() {
//         return id;
//     }
//     public String getName() {
//         return name;
//     }
//     @Override
//     public String toString() {
//         return "Man [id=" + id + ", name=" + name + "]";
//     }
//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + id;
//         result = prime * result + ((name == null) ? 0 : name.hashCode());
//         return result;
//     }
//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Man other = (Man) obj;
//         if (id != other.id)
//             return false;
//         if (name == null) {
//             if (other.name != null)
//                 return false;
//         } else if (!name.equals(other.name))
//             return false;
//         return true;
//     }
    
// }

//record can give all those functionality and simplify the writing of code

record Man(int id, String name){
    //Record is actually is a class, it can not extends other class but can implement inetrface
    //this is just a canonical constructor
    //All instance varaible are private and fina (immutable) and must be defined inside canonical constructor not inside body of record
    //int val; -- not allowed
    //We can define static inside body of record
    static int val;
    //we can create compact cononical constructor, it does not need parameter since it is already coming from canonical constructor, also we do not need to assign
    Man{
        //It is generally used for some validity check up on data
        if(id == 0){
            throw new IllegalArgumentException("Id can not be zero");
        }
    }
    //we can also have method inside record
    public void show(){
        System.out.println("Record show");
    }
} 

public class RecordClassConcept {
    public static void main(String[] args) {
        Man m1 = new Man(2, "Nix");
        Man m2 = new Man(2, "Nix");
        System.out.println(m1);
        System.out.println(m2);
        m1.show();
        System.out.println(m1.equals(m2));
        System.out.println(m1.name()); //accessor method name are same as varaible name, as contrast to accessor getName() in normal class
        //since we do not have mutator so no confusion between get or set, it is always getter
    }
}
