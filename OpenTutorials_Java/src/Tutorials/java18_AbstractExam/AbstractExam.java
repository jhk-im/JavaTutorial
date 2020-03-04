package Tutorials.java18_AbstractExam;

public class AbstractExam {

    public static void main(String[] args) {

        Cat c = new Cat();
        Dog d = new Dog();
        c.cry(); // 냐옹
        d.cry(); // 멍멍

        int a = 1;
        int b = 2;
        swap(a,b);
        System.out.println(a); // 1
        System.out.println(b); // 2

    }
    static void swap(int x,int y){
        int tmp = x;
        x = y;
        y = tmp;
    }
}


abstract class Animal {
    abstract void cry();
}
class Cat extends Animal {
    @Override
    void cry() {
        System.out.println("냐옹");
    }
}
class Dog extends Animal{
    @Override
    void cry() {
        System.out.println("멍멍");
    }
}
