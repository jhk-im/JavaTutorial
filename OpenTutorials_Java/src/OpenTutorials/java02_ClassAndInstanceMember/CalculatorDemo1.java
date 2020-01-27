package OpenTutorials.java02_ClassAndInstanceMember;// 1. 클래스 멤버
// 객체도 구성원이 있다.  변수 , 메소드
// 객체를 만들기 위해 클래스를 정의하고 클래스에 대한 인스턴스를 만들었다.
// 아래의 left , right 변수는 인스턴스 멤버이다.
// 인스턴스를 만들어야 사용할 수 있고 인스턴스만다 서로 다른 값을 가지고있다.
// 클래스도 멤버를 가질 수 있다.
// 그 방법에 대해 알아보자.

// left right 처럼 하나의 클래스를 여러개의 인스턴스로 만들어서
// 각각 사용할 수 있는 점은 좋은 기능이다.
// 하지만 경우에 따라 모든 인스턴스가 하나의 값을 공유해야 할 때가 있다.

// * 원주율의 값을 사용자에게 제공한다고 생각해보자.
// 원주율인 3.14 는 이미 알려져있고 고정되어있는 숫자이다.
// 각 인스턴스마다 원주율을 별도로 가지고 있을 필요가 없다.
// 이런 경우 변수를 클래스 멤버로 만들면된다.
// static double PI = 3.14; 처럼

// 1번째 예제
/*
class Calculator {

    // 변수 PI 앞에 Static 이 붙었다.
    // static 을 변수, 메소드 앞에 붙이면 클래스의 멤버가 된다.
    // 42행으로 이동해 사용해보자.
    static double PI = 3.14;
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

public class CalculatorDemo1 {

    public static void main(String[] args) {

        // Calculator 인스턴스를 만들어 인스턴스를 통해 PI 에 접근한다.
        Calculator c1 = new Calculator();
        System.out.println(c1.PI);

        Calculator c2 = new Calculator();
        System.out.println(c2.PI);

        // 클래스를 통해서 PI 에 접근한다.
        // 이 방법은 메소드가 아닌 PI 라는 변수에 접근하기 때문에
        // 인스턴스를 생성할 필요가 없다.
        // 즉, 변수는 인스턴스가 아닌 클래스를 통해 접근이 가능하다.
        System.out.println(Calculator.PI);

    }

}
*/

//////////////////////////////////////////////////////////////////////////////////////////////

// 클래스 변수는 변수의 변경사항을 모든 인스턴스에서 공유해야 할 때도 사용한다.
// 만약 계산을 할 때 특별한 값을 포함시켜야 한다면 어떻게 해야할까?
// sum 과 avg 메소드를 실행할 때 특정값을 연산에 포함해보자.

// 2번째 예제
/*
class Calculator2 {
    static double PI = 3.14;
    // 클래스 변수인 base 가 추가되었다.
    static int base = 0;
    int left, right;

    public void setOperands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        // 더하기에 base 의 값을 포함시킨다.
        System.out.println(this.left + this.right + base);
    }

    public void avg() {
        // 평균치에 base 의 값을 포함시킨다.
        System.out.println((this.left + this.right + base) / 2);
    }
}

public class CalculatorDemo1 {

    public static void main(String[] args) {

        Calculator2 c1 = new Calculator2();
        c1.setOperands(10, 20);
        // 30 출력
        c1.sum();

        Calculator2 c2 = new Calculator2();
        c2.setOperands(20, 40);
        // 60 출력
        c2.sum();

        // 클래스 변수 base 의 값을 10으로 지정했다.
        Calculator2.base = 10;

        // 40 출력
        c1.sum();

        // 70 출력
        c2.sum();

    }

}
*/

// 30, 60, 40, 70  과 같은 결과가 출력된다.
// 108번 행에서 클래스 변수 base 를 변경하자 모든 인스턴스의 base 값이 변경되었다.

// * 클래스 변수의 용도
// -> 인스턴스에 따라서 변하지 않은 값이 필요한 경우 (final 을 이용해 상수로 선언하는 것이 바람직)
// -> 인스턴스를 생성할 필요가 없는 값을 클래스에 저장하고 싶은 경우
// -> 값의 변경사항을 모든 인스턴스가 공유해야 하는 경우

//////////////////////////////////////////////////////////////////////////////////////////////

// 2. 클래스 메소드
// 지금까지 Calculator 은 인스턴스 변수 left 와 right 를 이용해 합계와 평균을 계산한다.
// 사실 굳이 인스턴스가 left, right 값을 유지하고 있어야 할 이유는 없다.
// 합계나 평균을 구할 때마다 좌항과 우항의 값을 주는 방식으로 계산을 할 수도 있다.

//3번째 예제

class Calculator3{

    public static void sum(int left, int right){
        System.out.println(left+right);
    }

    public static void avg(int left, int right){
        System.out.println((left+right)/2);
    }
}

public class CalculatorDemo1 {

    public static void main(String[] args) {
        Calculator3.sum(10, 20);
        Calculator3.avg(10, 20);

        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
    }

}

// 위처럼 메소드가 인스턴스 변수를 참조하지 않는다면
// 클래스 메소드를 사용해서 불필요한 인스턴스의 생성을 막을 수 있다.

//////////////////////////////////////////////////////////////////////////////////////////////

// 3. 멤버타입의 비교
// 아래 예제는 클래스와 인스턴스의 차이점을 보여주는 예제이다.
// 오류가 포함되어있기 때문에 실행되지 않을 것이다.

// 원칙을 기억해두자
// -> 인스턴스 메소드는 클래스 멤버에 접근 할 수 있다.
// -> 클래스 메소드는 인스턴스 멤버에 접근 할 수 없다.
// 인스턴스 변수는 인스턴스가 만들어지면서 생성되는데,
// 클래스 메소드는 인스턴스가 생성되기 전에 만들어진다.
// 크래스 메소드가 인스턴스 멤버에 접근하는 것은
// 존재하지 않는 인스턴스 변수에 접근하는 것과 같다.
/*
class C1{
    static int static_variable = 1;
    int instance_variable = 2;
    static void static_static(){
        System.out.println(static_variable);
    }
    static void static_instance(){
        // 클래스 메소드에서는 인스턴스 변수에 접근 할 수 없다.
        //System.out.println(instance_variable);
    }
    void instance_static(){
        // 인스턴스 메소드에서는 클래스 변수에 접근 할 수 있다.
        System.out.println(static_variable);
    }
    void instance_instance(){
        System.out.println(instance_variable);
    }
}
public class CalculatorDemo1 {
    public static void main(String[] args) {
        C1 c = new C1();
        // 인스턴스를 이용해서 정적 메소드에 접근 -> 성공
        // 인스턴스 메소드가 정적 변수에 접근 -> 성공
        c.static_static();
        // 인스턴스를 이용해서 정적 메소드에 접근 -> 성공
        // 정적 메소드가 인스턴스 변수에 접근 -> 실패
        c.static_instance();
        // 인스턴스를 이용해서 인스턴스 메소드에 접근 -> 성공
        // 인스턴스 메소드가 클래스 변수에 접근 -> 성공
        c.instance_static();
        // 인스턴스를 이용해서 인스턴스 메소드에 접근 -> 성공
        // 인스턴스 메소드가 인스턴스 변수에 접근 -> 성공
        c.instance_instance();
        // 클래스를 이용해서 클래스 메소드에 접근 -> 성공
        // 클래스 메소드가 클래스 변수에 접근 -> 성공
        C1.static_static();
        // 클래스를 이용해서 클래스 메소드에 접근 -> 성공
        // 클래스 메소드가 인스턴스 변수에 접근 -> 실패
        C1.static_instance();
        // 클래스를 이용해서 인스턴스 메소드에 접근 -> 실패
        //C1.instance_static();
        // 클래스를 이용해서 인스턴스 메소드에 접근 -> 실패
        //C1.instance_instance();
    }
}
*/
// 인스턴스 변수 -> Non-Static-Field
// 클래스 변수 -> Static Field
// Field 라는 것은 클래스 전역에서 접근 할 수 있는 변수를 의미한다.