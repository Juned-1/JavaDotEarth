import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetConcept {
    public static void main(String[] args) {
        //List can store duplicate, set store uniqule element (not sorted unlike C++ set)
        Set<Integer> st = new HashSet<Integer>();
        st.add(62);
        st.add(10);
        st.add(81);
        st.add(62);
        System.out.println(st);

        //If we want sorted set then we can use TreeSet instead of HashSet
        Set<Integer> st2 = new TreeSet<Integer>();
        st2.add(62);
        st2.add(10);
        st2.add(81);
        st2.add(62);
        System.out.println(st2);

        //working with iterator instead of forEach loop
        Iterator<Integer> values = st2.iterator();
        //hasNext() tells us whether we have next value or not
        //next() gives next value in iterator
        while(values.hasNext())
            System.out.println(values.next());
    }
}
