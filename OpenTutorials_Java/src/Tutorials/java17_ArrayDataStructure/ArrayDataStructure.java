package Tutorials.java17_ArrayDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayDataStructure {

    public static void main(String[] args) {

        /**
         * 배열의 한계
        **/
        //Array
        String[] student = new String[5];
        student[0] = "한진섭";
        student[1] = "최찬호";
        student[2] = "정화영";
        student[3] = "김성국";
        student[4] = "박용규";
        student[1] = null;
        for(int i=0; i<student.length; i++){
            System.out.println(student[i]); //  [한진섭, null, 정화영, 김성국, 박용규]
        }
        System.out.println("--");
        for(int j=0; j<student.length; j++){
            if(student[j] != null){
                System.out.println(student[j]); // [한진섭, 정화영, 김성국, 박용규]
            }
        }
        // List
        ArrayList<String> studentList = new ArrayList<String>();
        studentList.add("한진섭");
        studentList.add("최찬호");
        studentList.add("정화영");
        studentList.add("김성국");
        studentList.add("박용규");
        System.out.println("--");
        System.out.println(studentList); // [한진섭, 최찬호, 정화영, 김성국, 박용규]
        studentList.remove(1);
        System.out.println(studentList); // [한진섭, 정화영, 김성국, 박용규]
        studentList.add(1,"안호영");
        System.out.println(studentList); // [한진섭, 안호영, 정화영, 김성국, 박용규]


        // LinkedList
        LinkedList<String> studentLiked = new LinkedList<String>();
        studentLiked.add("한진섭");
        studentLiked.add("최찬호");
        studentLiked.add("정화영");
        studentLiked.add("김성국");
        studentLiked.add("박용규");
        System.out.println("--");
        System.out.println(studentLiked); // [한진섭, 최찬호, 정화영, 김성국, 박용규]
        studentLiked.remove(1);
        System.out.println(studentLiked); // [한진섭, 정화영, 김성국, 박용규]
        studentLiked.add(1,"안호영");
        System.out.println(studentLiked); // [한진섭, 안호영, 정화영, 김성국, 박용규]

        Test test = new Test();
        test.display(1); // 1
        test.display(1,20); // 20
        test.display(1,1.5f); // 2.5
        test.display(1,'a'); // char a code = 97 --> 2번째 메소드 호출
        System.out.println(test.display(1,2,3)); // 6

        Parent pa = new Parent();
        pa.display(); // 부모 클래스의 display()
        Child ch = new Child();
        ch.display(); //부모 클래스의 display() -> 자식 클래스에서 실행
        Parent pc = new Child();
        pc.display(); //부모 클래스의 display() -> 자식 클래스에서 실행
        // Child cp = new Parent(); error
    }

}

class Test{
    void display (int num1){
        System.out.println(num1);
    }
    void display (int num1,int num2){
        System.out.println(num1*num2);
    }
    void display (int num1,float num2){
        System.out.println(num1+num2);
    }
    int display (int num1,int num2, int num3){
        return num1+num2+num3;
    }

}

class Child extends Parent {
    @Override
    void display() {
        super.display();
        System.out.println("-> 자식 클래스에서 실행");
    }
}
class Parent {
    void display() {
        System.out.println("부모 클래스의 display()");
    }
}
