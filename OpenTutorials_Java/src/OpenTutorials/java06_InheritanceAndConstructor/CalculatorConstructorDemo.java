package OpenTutorials.java06_InheritanceAndConstructor;

// 1. 기본 생성자
// 편리함을 위해서 어떠한 기능을 수용하면 그 기능이
// 기존의 체계와 관계하면서 다양한 문제를 발생시킨다.
// 그 문제를 한마디로 줄여서 복잡도의 증가라고 할 수 있다.
// 생성자가 상속을 만나면서 발생한 복잡성을 살펴보자.
// 그 맥락에서 super 키워드의 의미도 중요하게 다뤄보자.

// Example.1
/*
public class ConstructorDemo {
    public static void main(String[] args) {
        ConstructorDemo  c = new ConstructorDemo();
    }
}
*/
// 위 예제는 에러를 발생시키지 않는다.
// ConstructorDemo 객체를 생성할 때 자동으로 생성자를 만들어주기 때문이다.

// Example.2
/*
public class ConstructorDemo {
    public ConstructorDemo(int param1) {}
    public static void main(String[] args) {
        ConstructorDemo  c = new ConstructorDemo();
    }
}
*/
// 위 예제는 에러를 발생시킨다.
// 매개변수가 있는 생성자가 있을때는 자동으로 기본 생성자를 만들어주지 않는다.
// 따라서 위의 예제는 존재하지 않은 생성자를 호출하고 있다.

// Example.3
/*
public class ConstructorDemo {
    public ConstructorDemo(){}
    public ConstructorDemo(int param1) {}
    public static void main(String[] args) {
        ConstructorDemo  c = new ConstructorDemo();
    }
}
*/
// 위와같이 기본 생성자를 추가해주어야 에러가 발생하지 않는다.

// Example.4
/*
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

class SubtractionCalculator extends Calculator {
    // 생성자
    public SubtractionCalculator(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void subtract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorConstructorDemo {

    public static void main(String[] args) {
        SubtractionCalculator c1 = new SubtractionCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.subtract();
    }

}
*/
// 위 예제는 30 15 -10 을 출력한다.
// SubtractionCalculator 생성자로 left 와 right 값을 받아서 초기화시키고 있다.
// 만약 Calculator 가 메소드 setOperands 가 아니라
// 생성자를 통해서 left, right 값을 설정하도록 하고싶다면 다음과 같이 변경해야한다.

// Example.5
/*
class Calculator {
    int left, right;

    public Calculator(int left, int right){
        this.left = left;
        this.right = right;
    }

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

class SubtractionCalculator extends Calculator {
    // 생성자
    public SubtractionCalculator(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void subtract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorConstructorDemo {

    public static void main(String[] args) {
        SubtractionCalculator c1 = new SubtractionCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.subtract();
    }

}
*/
// 위 코드는 오류가 발생한다.
// 하위 클래스인 SubtractionCalculator 가 호출될 때 자동으로
// 상위 클래스인 Calculator 의 기본생성자를 호출하게 된다.
// 그런데 Calculator 에는 매개변수가 있는 생성자가 있다.
// 그럴경우 자바는 자동으로 상위 클래스의 기본 생성자를 만들어주지 않는다.
// 따라서 존재하지 않는 생성자를 호출하게 되기 때문에 에러가 발생한다.
// 이 문제를 해결하기 위해서는 상위 클래스에 기본 생성자를 추가하면 된다.

// Example.6
/*
class Calculator {
    int left, right;

    public Calculator(){

    }

    public Calculator(int left, int right){
        this.left = left;
        this.right = right;
    }

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

class SubtractionCalculator extends Calculator {
    // 생성자
    public SubtractionCalculator(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void subtract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorConstructorDemo {

    public static void main(String[] args) {
        SubtractionCalculator c1 = new SubtractionCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.subtract();
    }

}
*/
// public Calculator(){} 와 같이 기본 생성자를 추가하니 오류가 발생하지 않는다.
// 하지만 Calculator 에는 left 와 right 값을 초기화할 수 있는 생성자가 이미 존재한다.
// 이것을 사용하면 불필요한 절차를 생략할 수 있다. 어떻게 호출할 수 있을까?

// 2. super
// super 는 상위 클래스를 가리키는 키워드다. 예제를 통해서 super 의 사용법을 알아보자.

class Calculator {
    int left, right;

    public Calculator(int left, int right){
        this.left = left;
        this.right = right;
    }

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

class SubtractionCalculator extends Calculator {
    // 생성자
    public SubtractionCalculator(int left, int right) {
        super(left,right);
    }

    public void subtract() {
        System.out.println(this.left - this.right);
    }
}

public class CalculatorConstructorDemo {

    public static void main(String[] args) {
        SubtractionCalculator c1 = new SubtractionCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.subtract();
    }

}
// Calculator 의 기본생성자가 없어졌다.
// 또다른 차이점은 아래와 같다.
/*
public SubtractionCalculator(int left, int right) {
    super(left,right);
}
*/
// super 키워드는 부모 클래스를 의미한다.
// super 에 () 붙이면 부모클래스의 생성자를 의미하게 된다.
// 이렇게하면 부모 클래스의 기본생성자가 없어져도 오류가 발생하지 않는다.

// 하위 클래스의 생성자에서 super 를 사용할 때 주의할점은
// super 가 가장먼저 나타나야 한다는 점이다.
// 즉, 부모가 초기화되기 전에 자식이 초기화되는 일을 방지하기 위한 정책이라고 생각하자.
