package Tutorials.java11_ObjectClass;

// 1. Object 클래스
// 자바에서 상속이란 필수적이다.
// 상속을 하건 하지 않안건 긴본적인 상속을 하게된다.
/*
class O {}
class O extends Object {}
*/
// 두개의 코드는 동일하다.
// 자바에서 모든 클래스는 사실 Object 를 암시적으로 상속받고 있는 것이다.
// 그런점에서 Object 는 모든 클래스의 조상이라 할 수 있다.
// 모든 클래스가 공통으로 포함하고 있어야 하는 기능을 제공하기 위해서이다.
// 공식 API 문서에서 Object 클래스의 메소드를 보면 알 수 있다.
// http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
// 다시 말해 자바의 객체는 Object 클래스의 메소드를 반드시 가지고 있어야 하는 것이다.
// 몇가지 예제를통해 중요한 API 를 살펴보도록 하자.


// 2. toString
// toString 은 객체를 문자로 표현하는 메소드이다. 사용해보자.
// Example.1
/*
class Calculator{
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

public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator c1 = new Calculator();
        c1.setOperands(10, 20);
        System.out.println(c1);
    }

}
*/
// 다음과 같이 출력된다.
// OpenTutorials.java11_ObjectClass.Calculator@1b6d3586
// c1 이 Calculator 클래스 인스턴스라는 의미이다.
// @ 뒤의내용은 인스턴스에 대한 고유한 식별값이다.
// 해당내용도 유용한 정보이지만 클래스 설계자의 필요에 따라
// toString 의 결과를 더욱 유용하게 만들 수 있다.
/*
class Calculator{
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

    public String toString(){
        return "left : " + this.left + ", right : "+ this.right;
    }
}

public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator c1 = new Calculator();
        c1.setOperands(10, 20);
        System.out.println(c1);
        System.out.println(c1.toString());
    }

}
*/
// 다음과 같이 toString() 메소드를 추가하였고
/*
public String toString(){
    return "left : " + this.left + ", right : "+ this.right;
}
*/
// 다음과 같이 출력될 것이다.
/*
left : 10, right : 20
left : 10, right : 20
*/
// Calculator 클래스에 toString 메소드를 오버라이딩 하였다.
// 그리고 인스턴스를 System.out.println 의 인자로 전달하니
// toString 을 명시적으로 호출하지 않았음이도 덩일한 효과가 나타나고 있다.
// toString 메소드는 자바에서 특별히 취급하는 메소드이다.
// toString 을 직접 호출하지 않아도
// 어떠한 객체를 System.out.println 으로 호출하면 자동으로 toString 이 호출되도록 약속되어있다.

// 3. equals
// equals 는 객체가 같은것인지를 비교하는 API 다.
// 객체 간에 같고 다름은 필요에 따라서 달라질 수 있기 때문이다.
// Example.2
/*
class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    public boolean equals(Object obj) {
        Student _obj = (Student)obj;
        return name == _obj.name;
    }
}

class ObjectDemo {

    public static void main(String[] args) {
        Student s1 = new Student("eGoing");
        Student s2 = new Student("eGoing");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

    }

}
*/
// 결과는 false true 를 출력한다.
// System.out.println(s1 == s2); -> false 라는 이야기이다.
// s1 과 s2 가 서로 다른 객체이기 때문이다. 당연한 결과다.
// 하지만 두 개의 객체가 논리적으로는 eGoing 이라는 값을 가지고 있기 때문에
// 두개의 객체가 같은 객체로 간주되었으면 좋겠다면
// Object 클래스의 equals 를 오버라이딩 하면된다.
/*
public boolean equals(Object obj) {
    Student _obj = (Student)obj;
    return name == _obj.name;
}
*/
// (Student)obj 는 메소드 equals 로 전달된 obj 의 데이터타입이 Object 이기 때문에
// 이를 Student 타입으로 형 변환하는 코드이다.
// return name == _obj.name;
// 위 코드를 통해서 현재 객체 변수 name 과
// equals 의 인자로 전달된 객체변수 name 을 비교한 결과를 boolean 값으로 리턴하고 있다.
// 이 값에 따라서 두개의 객체는 같거나 다른것이 된다.

// equals 를 제대로 사용하기 위해선 hashCode 라는 클래스도 함께 구현해야 한다.
// 하지만 딱히 사용빈도가 높지 않기때문에 넘어가도록 하겠다.
// 메소드 equals 에 대한 권고사항은 다음과 같다.
// -> 객체 간의 동일성을 비교하고 싶을 때에는 == 가 아닌 equals 를 사용하자.
// -> equals 를 직접 구현해야 한다면 hashCode 도 함께 구현해야하면 충분히 학습 후 구현하자.
// -> 이유가 분명하지 않다면 == 은 원시 데이터형을 비교할 때만 사용하자.
// * 원시데이터 -> byte, short, int, float, double, boolean, char

// 4. finalize
// finalize 는 객체가 소멸 될 때 호출되기로 약속한 메소드이다.
// 이 메소드는 가비지 컬렉션과 관련이 있다.
// 인스턴스를 만드는 것은 내부적으로 컴퓨터의 메모리를 사용하는 것이다.
// 여기서 말하는 메모리는 RAM 을 의미한다.
// 램은 가장 빠른 저장장치이기 때문에 컴퓨터 프로그램들은
// 이 램에 저장된 후에 동작하게 된다.
// 하지만 램은 가격이 비싸고 용량이 적기 때문에 가장 소중한 저장 장치라고 할 수 있다.
// 그러므로 램을 적게 사용하는 프로그램이 좋은 프로그램이다.
// 그런이유로 많은 언어들이 램을 효율적으로 사용하기 위해서
// 더이상 사용하지 않는 데이터를 램에서 제거할 수 있는 방법들을 제공한다.
// 다만 자바에서는 제한적으로 제공되고 있는데
// 제한적이라는 뜻은 자동으로 해준다는 뜻이다.
// 이 작업을 자동화 한것을 가비지 컬렉션이라고 한다.
// 예를들어 인스턴스를 만들었고, 그것을 변수에 담았다고 치자
// 그런데 그 변수를 사용하는 곳이 더 이상 없다면 이 변수와 변수에 담겨있는 인스턴스는
// 더 이상 메모리에 머물고 있을 필요가 없다.
// 자바가 이를 감지하고 자동으로 쓰지 않은 데이터를 삭제한다.
// 따라서 개발자가 사용하지 않는 데이터를 직접 삭제하는 작업을 하지 않아도 되는 것이다.
// 이것은 어려운 메모리 관리로부터 개발자들의 부담을 경감시켰다.
// 좋은 애플리케이션을 만들기 ㅜ이해서는 가비지 컬렉션에 대한 이해가 필요하다.
// -> Java Garbage collection(NHN Hello world 블로그)


// 4. clone
// 어떤 객체가 있을 때 그 객체와 똑같은 객체를 복제해주는 기능이 clone() 메소드 이다.
// 예제를 통해 알아보자.
// Example.3

class Student implements Cloneable{
    String name;
    Student(String name){
        this.name = name;
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class ObjectDemo {

    public static void main(String[] args) {
        Student s1 = new Student("eGoing");
        try {
            Student s2 = (Student)s1.clone();
            System.out.println(s1.name);
            System.out.println(s2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
// eGoing 이 두번 출력될 것이다.
// 위 코드에서 클래스 Student 가 인터페이스 Cloneable 을 구현하고 있는것을 보도록 하자.
// 인터페이스 Cloneable 의 코드의 실제는 다음과 같다.
// public interface Cloneable(){}
// 비어있는 인터페이스다.
// 그럼에도 불구하고 이것을 사용한 이유는
// 클래스 Student 가 복제 가능하다는 것을 표시하기 위한 것이다.
// 만약 이 인터페이스를 구현하지 않은 클래스에 대해 복제를 시도하면 오류가 발생한다.
// 복사를 정교하게 하고싶다면 오버라이딩 한 메소드 clone 을 직접 구현하면 된다.

// Object 클래스를 놓고 생각해보자.
// 이 클래스가 모든 클래스의 부모라는 사실은 이해의 영역이 아니라 약속의 영역이다.
// 자바를 만든 측과 자바를 사용하는 측의 약속이다.
// 이 클래스가 clone 이나 toString 같은 메소드를 가지고 있다는 것 또한
// 이해가 아니라 숙지해야 하는 영역이다.
// 지식을 배울 때는 이해해야 하는 것과 그냥 알아야 하는 것을 잘 분별하도록 하자.