package OpenTutorials.java04_ConstructorAndReset;

// 1. 초기화
// 객체 지향 프로그래밍도 초기화에 해당하는 기능이 제공되는데
// 이것을 생성자(constructor) 라고 한다.
/*
* Calculator c1 = new Calculator();
* c1.setOperands(10,20);
* c1.sum();
* c1.avg();
* */
// 위에서 setOperands 의 값으로 10과 20을 지정했다.
// 이 값들은 객체 내부에서 인스턴스 변수 left 와 right 의 값으로 설정되어 유지된다.
// 이 객체를 이용하기 위해선 기억해야 할 것이 있다.
// setOperands 메소드를 호출하기 전에 sum 과 avg 를 호출하면 원하는 값을 얻을 수 없다.
// Calculator 객체를 사용하기 위해서 사용자는
// sum 과 avg 를 호출하기 전에 setOperands 를 호출해야 한다는 것을 기억하고 있어야 한다.
// 이러한 절차를 기억해야 한다는 것은 사용자 입장에서는 불편하다.
// 그리고 잘못된 사용으로 오류가 발생할 확률을 높이는 결과를 초래 할 수 있다.

// 2. 생성자
// 그래서 사용하는 것이 생성자 (Constructor) 이다.
// 아래와 같이 인스턴스가 생성될 때 left, right 값을 입력하도록 강제하는 것이다.
/*
* Calculator c1 = new Calculator(10, 20);
* c1.sum();
* c2.avg();
* */
// 생성자는 다음과 같이 사용하면된다.
// Example.1

class Calculator {
    int left, right;

    // 생성자
    public Calculator(int left, int right) {
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

public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator c1 = new Calculator(10, 20);
        c1.sum();
        c1.avg();

    }
}

// 36행이 바로 생성자이다.
// 생성자는 이름처럼 객체를 생성할 때 호출된다.
// Calculator c1 = new Calculator(10, 20);
// 생성자 덕분에 Calculator 객체를 사용하기 위해 반드시 필요한 작업이었던
// left 와 right 의 값을 설정하는 과정을 생성과정에서 강제할 수 있게 되었다.
// 필수적인 작업을 포함시킨다는 것은 중요한 의미를 갖게 된다.

// 생성자의 특징
// -> 값을 반환하지 않는다.
// -> 생성자의 이름은 클래스 이름과 동일하다.