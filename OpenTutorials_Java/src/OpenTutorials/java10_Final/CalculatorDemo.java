package OpenTutorials.java10_Final;

// 1. final
// 추상이 상속을 강제하는 것이라면
// final 은 상속 / 변경을 금지하는 규제이다.
// 예제를 통해 알아보도록 하자.
// Example.1
/*
class Calculator {
    static final double PI = 3.14;
    int left, right;

    public void setOperands(int left, int right) {
        this.left = left;
        this.right = right;
        //Calculator.PI = 6;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {

        Calculator c1 = new Calculator();
        System.out.println(c1.PI);
        //Calculator.PI = 10;
    }
}
*/
// 위의 코드에서 주목할 점은 다음과같이 변수 앞에 final 이 붙었다는 것이다.
// static final double PI = 3.14;
// 다음과 같이 주석처리된 코드가 2번 나온다.
// Calculator.PI = 10;
// 주석을 해제하면 오류가 발생한다.
// final 로 선언된 Calculator.PI 를 변경하려고 할때 자바가 허용하지 않는 것이다.
// final 로 지정된 변수는 한번 값이 할당되면 그 값을 바꿀 수 없기 때문이다.
// 이러한 특징은 인스턴수 변수에도 적용된다.


// 2. final 메소드
// final 메소드는 final 변수만큼 사용빈도가 높지 않다.
// 아래의 코드는 final 메소드 b 를 상속하려 하기 때문에 오류가 발생한다.
// Example.2
/*
class A{
    final void b(){}
}
class B extends A{
    void b(){}
}
*/

// 3. final 클래스
// 아래의 코드는 final 클래스를 상속하려하고 있다. 따라서 오류가 발생한다.
/*
final class C{
    final void b(){}
}
class D extends C{}
*/
