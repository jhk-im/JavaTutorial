package Tutorials.java01_ClassAndInstanceAndObject;

public class Calculator {
    // 1. 메소드화
    // 아래 예쩨는 간단한 더하기 프로그램이다.
    /*
    public static void main(String[] args) {
        // 아래의 로직이 1000줄 짜리의 복잡한 로직이라고 가정하자.
        System.out.println(10 + 20);
        System.out.println(20 + 40);
    }
    */
    // 실행결과는 30과 60이다.
    // *프로그래밍의 기본은 중복을 제거하는 것이다.
    // 위의 예제는 두개의 값을 더한다는 중복이 존재한다.
    // 중복을 제거하기 위한 방법중 하나가 메소드이다.
    // 다음과 같이 작성하고 실행해보자.
    /*
    public static void sum(int left, int right) {
        System.out.println(left + right);
    }

    public static void main(String[] args) {
        sum(10, 20);
        sum(20, 40);
    }
    */
    // 동일한 결과를 출력할 것이다.
    // 여기에 더하기 뿐 아니라 평균도 구해야한다면?
    // 다음과 같이 메소드를 추가하여 실행하면 된다.
    /*
    public static void avg(int left, int right) {
        System.out.println((left + right) / 2);
    }
    public static void sum(int left, int right) {
        System.out.println(left + right);
    }
    public static void main(String[] args) {
        int left, right;

        left = 10;
        right = 20;

        sum(left, right);
        avg(left, right);
    }
    */
    // 더한값과 평균값이 출력된다.


    // 2. 객체화
    // 만약 위의 코드에 직원 정보를 데이터베이스에서 가져오는 로직이나,
    // 계산된 결과를 그래프로 표시하는 로직과 같은 것이 함께 위치한다면
    // 코드는 점점 복잡해진다.
    // 그러다가 누군가 변수 left, right 를 계산을 위한 좌향과 우항이 아니라
    // 그래프의 디자인을 변경하는 코드로 사용했되었다면
    // 하나의 프로그램 안에서 변수의 의미가 달라지게 되는 것이다. 메소드도 마찬가지이다.
    // 이러한 상황을 완화하기 위한 고민이 시작되고
    // 그 결과 객체지향이라는 개념이 등장하기 시작한다.

    /*
    * 객체지향은 많은 프로그래머들에 의해 만들어졌다.
    * 그래서 다양한 의도가 반영된 프로그래밍 패러다임이다.
    * 객체 지향이 만들어진 동기를 하나의 케이스로 설명하는 것은 어려운 일이다.
    * */

    // 객체 지향의 핵심은 연관되어 있는 변수와 메소드를 하나의 그룹으로 묶어서 그룹핑하는 것이다.
    // 메소드 sum 과 avg 는 변수 left 와 right 간에 서로 연간되어있다.
    // 합계 평균을 구하는 작업은 다른 애플리케이션에도 사용할 수 있는 기능이다.
    // 이것들을 그룹핑 해서 하나의 부품으로 만들면 필요할 때마다 반복적으로 사용할 수 있다.

    // 다음의 예를 보자. 95행 이동

    public static void main(String[] args) {

        // 2-2 인스턴스
        // 클래스를 사용하는 방법이다.
        // 클래스는 일종의 설계도다.
        // 클래스를 정의하는 것 자체로는 할 수 있는일이 많지 않다.
        // 설계도를 구체적인 제품으로 만드는 것 그때 사용하는 키워드가 new 이다.
        CalculatorDemo2 c1 = new CalculatorDemo2();
        // 위와같이 만들어진 구체적인 제품을 인스턴스라고 부른다.
        c1.setOperands(10, 20);
        c1.sum();
        c1.avg();
        // 여기서 c1 dms CalculatorDemo2 의 객체라는 의미이다.

        /*
        * 클래스와 인스턴스는 설계도와 제품이라고 설명했다.
        * 객체는 클래스일까 인스턴스일까?
        * 일반적으로 클래스가 구체적인 실체인 인스턴스가 되었을 때 객체라 부른다.
        * 코드상에서 나타나는 객체를 인스턴스
        * 로직을 설계할 때 나타나는 인스턴스를 객체라고 부른다.
        * 혹은 클래스, 인스턴스의 구분없이 포괄적으로 객체라는 말을 쓰기도 한다.
        * */

        CalculatorDemo2 c2 = new CalculatorDemo2();
        c2.setOperands(20, 40);
        c2.sum();
        c2.avg();
        // 다음처럼 새로운 인스턴스를 생성할 수 있다.
        // 각각의 인스턴스는 서로다른 변수의 값을 내부적으로 가지고 있게 된다.
        /*
        public void setOperands(int left, int right){
            this.left = left;
            this.right = right;
        }
        */
        // 이때 메소드 setOperands() 내에 this 를 기억해두자.
        // this 는 클래스를 통해 만들어진 인스턴스 자신을 가리킨다.
        // left 는 매개변수이고 setOperands 밖에서 접근할 수 없다.
        // this.left 는 메소드 밖에서 선언한 변수는 인스턴스 내의 모든 메소드에서 접근이 가능하다.

        // 변수를 다른 말로는 상태(state) 라고도 표현한다.
        // * 하나의 클래스를 바탕으로 서로 다른 상태를 가진 인스턴스를 만들면
        // 서로다른 행동을 하게된다.
        // 객체지향이 제공하는 가장 기본적인 재활용성이다.
   }


}


// 2-1 클래스
// left, right 변수와 sum, avg 메소드를
// CalculatorDemo2 클래스에 그룹화 시킨 예이다.
// 클래스는 연관되어있는 변수와 메소드의 집합이다.
// 이렇게 그룹화 한 것을 Calculator 의 main 메소드에서 사용해보자.
// 72 행 이동
class CalculatorDemo2{
    int left, right;

    public void setOperands(int left, int right){
        this.left = left;
        this.right = right;
    }

    public void sum(){
        System.out.println(this.left+this.right);
    }

    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
}
