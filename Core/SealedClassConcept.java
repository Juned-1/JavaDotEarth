interface Clonable {

}
sealed class A extends Thread implements Clonable permits B,C{
    //sealed seal the class
    //permits give permission to certain class to inherit it
    //permits should be last keyword after extends and implement
}
sealed class B extends A permits D{
    //subclass of sealed class can either be sealed class, final class or non-sealed class
}
final class D extends B{

}
non-sealed class C extends A{

}

//In case of interface we do not have option final, interface can not be final
//So interface can be either sealed or non-sealed.
sealed interface X permits Y{

}
// sealed interface Y extends X{
//For making we have give permission to other subclasses
// }
non-sealed interface Y extends X{

}
public class SealedClassConcept {
    public static void main(String[] args) {
        
    }
}
