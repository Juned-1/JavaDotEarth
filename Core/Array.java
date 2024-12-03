class Student {
    int rollno;
    String name;
    int marks;
}
public class Array {
    public static void main(String[] args) {
        //Array in java is an object, it will be created inside heap memory
        int arr1[] = {2,3,4};
        int arr2[]; //integer array type refernce
        arr2 = new int[4]; //allocating dynamic array size
        int arr3[] = new int[4];
        //for int all values of array by default is 0,for boolean false
        //Multi dimesional array is array of array
        int arr4[][] = new int[3][4];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                arr4[i][j] = (int)(Math.random()*100);
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        //Different for loop
        System.out.println("For Each (or Enhance For) loop...");
        for(int n[] : arr4){
            //nums throws 1 dimensional array
            for(int m : n){
                //n throws single value of int from 1d array
                System.out.print(m + " ");
            }
            System.out.println();
        }
        System.out.println("Jagged Array...");
        //Multi dimensional array with different shape is jagged array
        int arr5[][] = new int[3][];
        arr5[0] = new int[2];
        arr5[1] = new int[3];
        arr5[2] = new int[4];
        for(int i = 0; i < arr5.length; i++){
            for(int j = 0; j < arr5[i].length; j++){
                arr5[i][j] = (int)(Math.random()*10);
            }
        }
        for(int n[] : arr5){
            for(int m : n){
                System.out.print(m + " ");
            }
            System.out.println();
        }
        Student s1 = new Student();
        s1.rollno = 1;
        s1.name = "James";
        s1.marks = 87;

        Student s2 = new Student();
        s2.rollno = 2;
        s2.name = "Anika";
        s2.marks = 91;

        Student s3 = new Student();
        s3.rollno = 3;
        s3.name = "Jake";
        s3.marks = 87;

        Student students[] = new Student[3]; //here not creating three object for array instead creating three refernce to store address of object, that is how object array is created
        students[0] = s1; //We have to manually create object and assign refernce to it
        students[1] = s2;
        students[2] = s3;

        for(int i = 0; i < students.length; i++){
            System.out.println(students[i].name + " : " + students[i].marks);
        }

        for(Student stud : students){
            System.out.println(stud.name + " : " + stud.marks);
        }
    }
}
