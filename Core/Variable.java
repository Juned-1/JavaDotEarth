public class Variable {
    public static void main(String[] args) {
        System.out.println(3+5);
        System.out.println(9+7);
        int num1 = 3;
        int num2 = 5;
        int resultAddition = num1 + num2;
        System.out.println(resultAddition);
        //number have byte (1 byte), short (2 byte), int (4 byte), long (8 byte)
        //floating point number have flaot and double, by default it is double
        //by default floating numbers are in double, to make it float use f at the end
        float marks = 5.6f;
        //char in java occupy 2 bytes, not one unlike c(ASCII code) since java include unicode to include character of all language
        //char put in single quote unlike C where single or double quote works, "" is for string in Java
        char alp = 'J';
        //boolean is either true or flase, use keyword boolean
        boolean val = true;
        byte v1 = 127;
        short v2 = 500;
        long v3 = 7347874589l; //put l after long number
        double v4 = 5.8;
        System.out.println(marks);
        System.out.println(alp);
        System.out.println(val);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        //All the type are literal above, we can use other literals like binary,hex etc
        int num3 = 0b101; //binary literals
        System.out.println(num3);
        int num4 = 0x7E; //hex literals
        System.out.println(num4);
        //In new java we can use _ between 0s for ease to counting number of 0s
        int num5 = 10_00_000;
        System.out.println(num5);
        double num6 = 12e10;
        System.out.println(num6);
        alp++;
        System.out.println(alp);
    }
}
