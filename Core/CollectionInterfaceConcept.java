import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class CollectionInterfaceConcept {
    //Collection And List
    public static void main(String[] args) {
        //We should not define so many method of Collection interface
        //So We will use in built classes with Collection to get different DS features
        //Collection<Integer> num = new ArrayList<Integer>(); //array list impelmented collection interafce
        //Integer is wrapper class for primitive int, collection work with object not with primitive
        List<Integer> num = new ArrayList<Integer>();
        num.add(5); //5 is not integer it is object until we explicitly give type to ArrayList<Integer>() instead of ArrayList()
        num.add(8);
        num.add(9);
        num.add(5);

        System.out.println(num);
        for(int n : num){
            System.out.println(n);
        }

        System.out.println(num.get(1)); //get(index) return element at that index
        System.out.println(num.indexOf(8)); //indexOf(element)
    }
}
