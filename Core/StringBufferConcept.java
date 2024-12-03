public class StringBufferConcept {
    public static void main(String[] args) {
        //To create mutable string
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println(sb.capacity());
        //it provides 16 byte extra to relocate if there is no space in contiguous memory after mutation
        System.out.println(sb.length());
        sb.append(" World");
        System.out.println(sb);
        String str = sb.toString(); //toString converts string Buffer into String
        sb.insert(0, "Java ");
        //we can set our data
        sb.setLength(40); //after available data it will append extra \0
        sb.ensureCapacity(100); //it will ensure minmum capacity of 100 bytes
        System.out.println(sb);
    }
}
