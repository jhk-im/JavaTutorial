package Tutorials.java05_Inheritance;
// 1. 상속
// 객체지향을 통해서 달성하고자 하는 목표중 가장 중요한 것은 재활용성 이다.
// 상속은 객체지향의 재활용성을 극대화시킨 프로그래밍 기법이라고 할 수 있다.
// 동시에 객체지향을 복잡하게 하는 주요 원인이라고도 할 수 있다.

// 어떤 객체가 있을 때 그 객체의 필드(변수)와 메소드를
// 다른 객체가 물려 받을 수 있는 기능을 상속이라고 한다.

// Calculator 는 sum 과 avg 메소드를 가지고 있다.
// 그런데 이 객체가 가지고 있는 기능에 빼기를 추가하고 싶다.
// 가장 쉬운 것은 이 객체에 빼기를 의미하는 메소드를 추가하면 될 것이다.
// 하지만 객체에 메소드를 추가하는 것이 어려울 수 있다.
// -> 객체를 자신이 만들지 않았다. 그래서 소스를 변경할 수 없다.
// -> 객체가 다양한 곳에서 활용되고 있는데 메소드를 추가하면 다른 곳에서 불필요한 기능이 포함될 수 있다.
// 기존의 객체를 그대로 유지하면서 어떤 기능을 추가하는 방법이 없을까?
// 이런 맥락에서 등장하는 것이 상속이다.
// 기존 객체는 기능을 물려준다고 해서 부모 객체가되고
// 새로운 객체는 기존 객체의 기능을 물려받는다는 의미에서 자식객체가 된다.
// 부모 클래스와 자식클래스의 관계를
// 상위(super) 하위(sub) 클래스라고 표현하기도 한다.
// 기초 클래스(base class), 유도클래스(derived class) 라고도 부른다.
// 예제를 통해 알아보도록 하자.

// Example.1

class Calculator {
    int left, right;

    public void setOperands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
/*
class SubtractionCalculator extends Calculator {
    public void subtract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorDemo {

    public static void main(String[] args) {

        SubtractionCalculator c1 = new SubtractionCalculator();
        c1.setOperands(10, 20);
        c1.sum();
        c1.avg();
        c1.subtract();
    }

}
*/
// 30 15 -10 이 출력될 것이다.
/*
class SubtractionCalculator extends Calculator {
    public void subtract() {
        System.out.println(this.left - this.right);
    }
}
*/
// SubtractionCalculator 클래스가 Calculator 클래스를 상속받았다.
// SubtractionCalculator 내부에는 subtract() 메소드만 존재한다.
// 하지만 이 클래스를 생성한 c1 은 Calculator 내부에있는
// sum() 과 avg() 를 호출하고 있다.
// 이것이 바로 상속의 기본적인 의미이다.
// 상속을 통해 코드 중복을 제거할 수 있었고,
// 또 부모 클래스를 개선하면 이를 상속받고 있는 모든 자식 클래스들에게
// 그 혜택이 자동으로 돌아간다. -> 유지보수가 편리해 진다.
// 재활용성, 중복제거, 유지보수 편의의 관계는 하나가 좋아지면 다른쪽도 좋아지는 관계이다.

// 곱하기를 할수있는 클래스를 추가해보자.

// Example.2

class MultiplicationCalculator extends Calculator {
    public void multiplication() {
        System.out.println(this.left * this.right);
    }
}
/*
public class CalculatorDemo {

    public static void main(String[] args) {

        MultiplicationCalculator c1 = new MultiplicationCalculator();
        c1.setOperands(10, 20);
        c1.sum();
        c1.avg();
        c1.multiplication();

    }

}
*/

// 30 15 200 결과가 출력된다.
// 상속한 클래스를 다시 상속할 수 있을까? 가능하다.

class DivisionCalculator extends MultiplicationCalculator {
    public void division() {
        System.out.println(this.left / this.right);
    }
}
public class CalculatorDemo {

    public static void main(String[] args) {

        DivisionCalculator c1 = new DivisionCalculator();
        c1.setOperands(10, 20);
        c1.sum();
        c1.avg();
        c1.multiplication();
        c1.division();
    }

}
// -> sum() avg() 를 가지고 있는 Calculator 클래스
// -> Calculator 를 상속받고 multiplication() 메소드를 가지고있는 MultiplicationCalculator 클래스
// -> MultiplicationCalculator 를 상속받은 DivisionCalculator 클래스
// 그리하여 DivisionCalculator 인스턴스를 사용하여
// sum() avg() multiplication() division() 메소드를 모두 호출할 수 있게 되었다.

// 하지만 장점이 있으면 단점도 있는법
// 상속의 효용을 수용하기 위해서는 많은 대가를 치러야 한다.
// 간단히 말해서 복잡도의 증가이다.
