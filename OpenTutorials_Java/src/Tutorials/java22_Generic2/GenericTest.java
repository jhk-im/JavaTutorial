package Tutorials.java22_Generic2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GenericTest {

    public static void main(String[] args) {

        MyArray<Integer> myArray = new MyArray<Integer>();
        myArray.setElement(1);
        //myArray.setElement("문자"); --> error
        System.out.println(myArray.getElement()); // 1



        MyArray<String> myArray1 = new MyArray<>();
        myArray1.setElement("hello");
        //myArray1.setElement(1); --> error
        System.out.println(myArray1.getElement()); // hello



        AnimalList<LandAnimal> landAnimal = new AnimalList<>();
        landAnimal.add(new LandAnimal());
        landAnimal.add(new Cat());
        landAnimal.add(new Dog());
        // landAnimal.add(new Sparrow()); // 오류가 발생함.
        for (int i = 0; i < landAnimal.size(); i++) {
            landAnimal.get(i).crying();
        }



        TestList<Test> testList = new TestList<>();
        //TestList<TestI> --> error
        InterfaceList<TestI> interfaceList = new InterfaceList<>();
        //InterfaceList<Test> --> error


        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        p1.<String>printInfo("hi"); // hi
        p1.printInfo("hello"); // hello
        p1.<Integer>printInfo(13); // 13
        p1.printInfo(13.5); // 13.5


        ArrayList<String> aList = new ArrayList<String>();
        aList.add("hello");
        aList.add("java");
        // aList.add(1); --> 컴파일 에러
        String hello = aList.get(0);
        String java = aList.get(1);

        ArrayList aList2 = new ArrayList();
        aList2.add("java");
        aList2.add(1);
        String hello2 = (String) aList2.get(0);
        int java2 = (int) aList2.get(1);
        System.out.println(aList2);


    }


}

class MyArray<T> {
    T element;
    void setElement(T element){
        this.element = element;
    }
    T getElement() {
        return element;
    }

}


class AnimalList<T> {
    ArrayList<T> al = new ArrayList<T>();
    void add(T animal) { al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal) { return al.remove(animal); }
    int size() { return al.size(); }
}
class LandAnimal { public void crying() { System.out.println("육지동물"); } }
class Cat extends LandAnimal { public void crying() { System.out.println("냐옹냐옹"); } }
class Dog extends LandAnimal { public void crying() { System.out.println("멍멍"); } }
class Sparrow { public void crying() { System.out.println("짹짹"); } }


class Test {}
interface TestI{}
class TestList<T extends Test>{
    public static <T> void sort(){ }
}
class InterfaceList <T extends TestI>{}


class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){
        this.info = info;
        this.id = id;
    }
    public <U> void printInfo(U info){
        System.out.println(info);
    }
}
