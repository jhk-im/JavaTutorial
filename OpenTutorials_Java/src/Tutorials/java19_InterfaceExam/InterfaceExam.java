package Tutorials.java19_InterfaceExam;

public class InterfaceExam {

    public static void main(String[] args) {

        Cat c = new Cat();
        Dog d = new Dog();
        c.cry(); // 냐옹
        c.play(); // 쥐잡기
        d.cry(); // 멍멍
        d.play(); // 산책하기
    }

}

interface Animal {
    void cry();
}
interface Pet {
    void play();
}
class Cat implements Animal,Pet{
    @Override
    public void cry() {
        System.out.println("냐옹");
    }
    @Override
    public void play() {
        System.out.println("쥐잡기");
    }
}
class Dog implements Animal,Pet{
    @Override
    public void cry() {
        System.out.println("멍멍");
    }
    @Override
    public void play() {
        System.out.println("산책하기");
    }
}