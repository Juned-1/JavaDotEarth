public class TypeCasting {
    public static void main(String[] args) {
        int a = 257;
        byte b = (byte)a; //explicit type casting range ==> 2^8 = 256, it uses modulo by range a % 256
        //implicit casting (auto conversion) happen when lower type is assigned to higher typ examaple byte value is assigned to int
        float f = 9.8f;
        int floatCast = (int)f;
        System.out.println(b);
        System.out.println(floatCast);
        int n = 12;
        byte b2 = (byte)n;
        System.out.println(b2);
        //Type promotion
        byte a1 = 10;
        byte a2 = 20;
        int result = a1 * a2; //10*30 out of range of byte so promoted to integer
        System.out.println(result);
    }
}
