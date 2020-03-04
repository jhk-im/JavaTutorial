package Tutorials.java09_Abstract;

// 1. abstract
// abstract 를 번역하면 추상이다.
// abstract 는 상속을 강제하는 일종의 규제이다.
// 즉, abstract 클래스나 메소드를 사용하기 위해서는
// 반드시 상속해서 사용하도록 강제하는 것이 abstract 이다.

// 2. 추상 메소드
// 추상 메소드란 메소드의 시그니처만이 정의된 비어있는 메소드를 의미한다.
// 아래의 예를 보도록 하자.
// Example.1
/*
abstract class A{
    public abstract int b();
    //본체가 있는 메소드는 abstract 키워드를 가질 수 없다.
    //public abstract int c(){System.out.println("Hello")}
    //추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재 할 수 있다.
    public void d(){
        System.out.println("world");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        A obj = new A();
    }
}
*/
// 위의 예제는 에러가 발생한다.
// b() 메소드 선언부분에 abstract 라는 키워드가 등장한다.
// 이 키워드는 메소드 b 는 메소드의 시그니처만 정의되어 있고
// 이 메소드의 구체적인 구현은 하위 클래스에서 오버라이딩 해야 한다는 의미이다.
// 이렇게 내용이 비어있는 메소드를 추상 메소드라 부른다.
// 추상 메소드를 하나라도 포함한 클래스는 추상 클래스가 되고,
// 자연스럽게 앞에 abstract 가 붙는다.
//  A obj = new A(); -> 이렇게 추상클래스를 인스턴스화 하면 오류가 발생한다.
// 추상 클래스는 구체적인 메소드의 내용이 존재하지 않기 때문에 인스턴스화 시켜서 사용할 수 없기 때문이다.
// 이렇게 불편한 추상클래스는 왜 사용하는 것일까?


// 2. 추상클래스의 상속
// 위에나온 오류를 해결하기 위해서는 클래스 A를 상속한 하위 클래스를 만들고
// 추상 메소드를 오버라이드 하여 내용있는 메소드로 마들어야 한다. 다음과 같이 해보자.
// Example.2
/*
abstract class A{
    public abstract int b();
    public void d(){
        System.out.println("world");
    }
}
class B extends A{
    public int b(){return 1;}
}
public class AbstractDemo {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.b());
    }
}
*/
// 1을 출력한다.
// 클래스 B 가 A를 상속하고 A 안에있는 b() 추상메소드를 오버라이딩 하여 구체화하였다.
// 그 결과 오류가 나지 않고 b() 메소드를 사용할 수 있게 되었다.


// 3. 추상클래스를 사용하는 이유
// 추상 클래스는 상속을 강제하기 위한 것이다.
// 즉 부모 클래스에는 메소드의 시그니처만 정의해 놓고
// 그 메소드의 실제 동작방법은 상속받은 하위 클래스의 책임으로 위임하고 있다.
// 사실 작은 프로젝트는 이런식으로 작성하는 경우가 거의 없다.
// 예제를 통해 추상클래스의 용도를 생각해보자.
// Example.3

abstract class Calculator{
    int left, right;
    public void setOperands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public abstract void sum();
    public abstract void avg();
    public void run(){
        sum();
        avg();
    }
}
class CalculatorDecoPlus extends Calculator {
    public void sum(){
        System.out.println("+ sum :"+(this.left+this.right));
    }
    public void avg(){
        System.out.println("+ avg :"+(this.left+this.right)/2);
    }
}
class CalculatorDecoMinus extends Calculator {
    public void sum(){
        System.out.println("- sum :"+(this.left+this.right));
    }
    public void avg(){
        System.out.println("- avg :"+(this.left+this.right)/2);
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        CalculatorDecoPlus c1 = new CalculatorDecoPlus();
        c1.setOperands(10, 20);
        c1.run();

        CalculatorDecoMinus c2 = new CalculatorDecoMinus();
        c2.setOperands(10, 20);
        c2.run();
    }
}

// 위 예제는 sum 메소드와 avg 를 실행하는 절차를 run 메소드를 통해서 한번에 실행되도록 한 코드이다.
// 경우에 따하서 합계와 평귱을 화면에 출력하는 모습을 달리해야하는 경우가 있다고 치자.
// 상황에 따라 동작방법이 달라지는 메소드는 추상 메소드로 만들어서
// 하위 클래스에서 구현하도록 하고
// 모든 클래스의 공통분모인 setOperands() 와 run() 메소드는 상위 클래스에 두어서
// 코드의 중복, 유지보수의 편의성을 도모할 수 있다.
// 다음과 같은 결과가 출력된다.
/*
+ sum :30
+ avg :15
- sum :30
- avg :15
*/
// Calculator 클래스에서 sum(), avg() 메소드를 추상메소드로 선언하고
// CalculatorDecoPlus, CalculatorDecoMinus 클래스는 Calculator 를 상속하여
// 각각 sum(), avg() 메소드를 오버라이딩 하여서
// 서로 다른 결과물을 출력하도록 메소드를 구체화 한 것이다.


// 4. 디자인 패턴
// 이러한 개발 방법을 template method pattern 이라고 한다.
// 자주 사용하는 모양을 모아둔 템플릿이 있다고 가정하자.
// 템플릿은 모양을 결정하지만 템플릿을 통해서 그려질 도형은
// 팬의 종류나 색상에 따라서 달라진다.
// 즉, 공통 분모인 메소드 run 은 메소드 sum 과 avg 가 어떻게 동작할지 알 수 없지만
// sum 이 실행되고 avg 를 실행시킨다.
// 어떤 기호로 출력을 시작할지는 하우 ㅣ클래스에서 결정하고 있다.

// 예제를 통해서도 알 수 있지만 프로그래밍이라는 것은 반복되는 패턴이 있다.
// 이런 패턴들을 모아서 정리한 것이 디자인 패턴이다.
// 시각 디자인이 아닌 좋은 소프트웨어를 만들기 위한 설계로서의 디자인이다.
// 디자인 패턴의 장점은 두가지가 있따.
// 하나는 좋은 설계를 단기간에 학습할 수 있다는 점이다. (비교적 단기간)
// 다른 하나는 소통에 도움이된다는 점이다.
// 설계 방법에 따라 적절한 이름이 있다면 상호간에 생각을 일치시키는 데 큰 도움이 될 것이다.
