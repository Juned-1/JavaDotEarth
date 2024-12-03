import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapConcept {
    public static void main(String[] args) {
        Map<String, Integer> student = new HashMap<String, Integer>();
        student.put("Hek", 45);
        student.put("Sr", 23);
        student.put("Jr", 33);
        student.put("nk", 42);
        student.put("Jl", 49);

        System.out.println(student);
        System.out.println(student.get("Hek")); //get(key)
        //key values in map are unique and values can repeat
        //keys are set and values are list
        student.put("Hek", 32);
        System.out.println(student);
        System.out.println(student.keySet());
        for(String name : student.keySet()){
            System.out.println(name + " : " + student.get(name));
        }
        //Hash table can be serialized, if we have synchronized method during thread use Hashtable otherwise use HashMap
        Map<String, Integer> st2 = new Hashtable<>();

    }
}
