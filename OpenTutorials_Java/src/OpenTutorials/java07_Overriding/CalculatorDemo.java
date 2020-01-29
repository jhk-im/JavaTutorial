package OpenTutorials.java07_Overriding;

// 1. 창의적인 상속
// 상속은 상위 클래스의 기능을 하위 클래스에게 물려주는 기능이다.
// 하위 클래스는 상위 클래스의 메소드를 그대로 사용해야 할까?
// 그렇게 된다면 제약이 상당할 것이다.
// 이런 제약을 벗어나려면 하위클래스가 부모클래스의 기본적인 동작방법을 변경할 수 있어야한다.
// 이런 맥락에서 도입된 기능이 메소드 오버라이딩(overriding) 이다.

// 상속 예제를 떠올려보자.
// 클래스 Calculator 의 기본적인 동작 방법을 상속받은
// SubtractionCalculator 에 빼기 기능을 추가하고있다.
// 이것은 상위 클래스의 기능에 새로운 기능을 추가한 것이다.
// 만약 상위 클래스에서 물려 받은 메소드 sum 을 호출했을 때
// "실행 결과는 ** 입니다." 처럼 친절하게 알려줘야 한다면 어떨까?
// 예제를 통해 살펴보자.

// Example.1
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

    public void sum() {
        System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
    }

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

// Calculator 에 있던 sum() 메소드가
// SubtractionCalculator 에 내용이 추가되어 구현되었다.
/*
public void sum() {
    System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
}
*/
// "실행 결과는 30입니다." 를 출력한다.
// 실행결과 Calculator 의 sum() 가 아닌
// SubtractionCalculator sum() 이 출력되고 있다.
// 하위 클래스 입장에서 부모 클래스란 기본적인 동작 방법을 정의한 것이라고 생각할 수 있다.
// 하위 클래스에서 상위클래스와 동일한 메소드를 정의하면
// 부모 클래스로부터 물려 받은 기본 동작 방법을 변경하는 효과를 갖게된다.
// 기본동작은 폭덟게 적용되고, 예외 동작은 더 높은 우선순위를 갖는다.
// 이것은 공학에서 일반적으로 발견되는 규칙이고 이것을 메소드 오버라이딩이라고 한다.

// 2. 오버라이딩의 조건
// 상위 클래스에서 정의하고 있는 메소드 avg 는 계산 결과만 화면에 출력하고 있다.
// 계산 결과를 좀 더 다양하게 사용하기 위해
// avg 메소드가 화면에 결과를 출력하는 대신 계산 결과를 리턴해주면 좋겠다.
// 다음과 같이 수정해보았다.

// Example.2
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

    public void sum() {
        System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
    }

    public int avg() {
        return (this.left + this.right)/2;
    }

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
// SubtractionCalculator 클래스에 부모 클래스에 있는 avg() 를 다음과 같이 만들어 보았다.
/*
public int avg() {
    return (this.left + this.right)/2;
}*/
// 위 예제는 에러를 발생시킨다.
// 오버라이딩을 하기 위해서는 메소드의 리턴 형식이 같아야한다.
// 즉, 부모 클래스 avg 메소드는 리턴타입이 void 이다.
// 이것을 상속한 클래스의 avg 메소드는 리턴타입이 int 이다.
// 오버라이딩을 위해서는 다음의 조건의 충족되어야 한다.
// -> 메소드의 이름
// -> 메소드 매개변수의 숫자와 데이터 타입 그리고 순서
// -> 메소드의 리턴타입

// 위처럼 메소드의 형태를 정의하는 사항들을 메소드의 서명 (signature) 이라고 한다.
// 위에서 오류가 발생한 이유는 서명이 달라서 발생한 문제이다.
// 다음 예제와 같이 클래스의 코드를 변경하여 문제를 우회하자.

// Example.3
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

    public int avg() {
        return ((this.left + this.right) / 2);
    }
}

class SubtractionCalculator extends Calculator {

    public void sum() {
        System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
    }

    public int avg() {
        return (this.left + this.right)/2;
    }

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
// 상위 클래스와 하위 클래스의 서명이 같기때문에 오버라이딩을 할 수 있다.
// 하지만 위 예제는 부모클래스와 자식클래스의 avg() 메소드가 동일하다.
// 중복은 제거되어야 한다.
// 생성자와 마찬가지로 super 를 사용하면 이 문제를 해결할 수 있다.

// Example.4

class Calculator {
    int left, right;

    public void setOperands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public int avg() {
        return ((this.left + this.right) / 2);
    }
}

class SubtractionCalculator extends Calculator {

    public void sum() {
        System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
    }

    public int avg() {
        return super.avg();
    }

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
        System.out.println("실행 결과는" + c1.avg());
        c1.subtract();
    }

}

// 다음과 같이 자식클래스의 avg() 메소드를 super 를 사용하여 변경하였다.
/*
public int avg() {
    return super.avg();
}
*/
// 덕분에 코드의 중복을 제거할 수 있었다.
// 즉, 메소드 오버라이딩은 부모 클래스의 기능을 변경할 수 있는 방법이다.

