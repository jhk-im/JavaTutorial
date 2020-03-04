package Tutorials.java13_Generic;

// 1. Generic
// 제네릭은 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법이다.
// 예제를 통해 살펴보자.

// Example.1
/*
class Person<T>{
public T info;
        }

public class GenericDemo {

    public static void main(String[] args) {
        Person<String> p1 = new Person<String>();
        Person<StringBuilder> p2 = new Person<StringBuilder>();
    }

}
*/
// p1.info : String
// p2.info : StringBuilder
// 각각의 인스턴스를 생성할 때 사용한 <> 사이에 어떤 데이터 타입을 사용했느냐에 따라 달라졌다.
// Person 클래스 선언부를 보자.
// public T info;
// 클래스 Person 의 필드 info 의 데이터 타입은 T로 되어있다.
// T라는 타입은 존재하지 않는다.
// 이 값은 class Person<T> 에서 정해진다.
// 그리고 Person<String> p1 = new Person<String>(); 같이
// <> 안에 지정된 데이터 타입에 의해서 class Person<T> 의 T의 타입이 정해지는 것이다.
// Person<String> 으로 데이터 타입을 먼저 정하고
// new Person<String>() 으로 인스턴스를 생성하고 있다.
// 즉, 클래스를 정의할 때는 info 의 데이터 타입을 확정하지 않고
// 인스턴스를 생성할 때 데이터 타입을 지정하는 기능을 제네릭 이라고 한다.


// 2. 제네릭을 사용하는 이유

// 2-1 타입의 안전성
// 코드를 통해 살펴보자.
// Example.4
/*
class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class StudentPerson{
    public StudentInfo info;
    StudentPerson(StudentInfo info){ this.info = info; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class EmployeePerson{
    public EmployeeInfo info;
    EmployeePerson(EmployeeInfo info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        StudentInfo si = new StudentInfo(2);
        StudentPerson sp = new StudentPerson(si);
        System.out.println(sp.info.grade); // 2
        EmployeeInfo ei = new EmployeeInfo(1);
        EmployeePerson ep = new EmployeePerson(ei);
        System.out.println(ep.info.rank); // 1
    }
}*/
// 위 예제는 StudentPerson 클래스와 EmployeeInfo 클래스가
// 사실상 동일한 형태로 되어있다. 중복이 발생하고 있기 때문에 제거해 보도록 하자.
// Example.5
/*
class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person{
    public Object info;
    Person(Object info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person("부장");
        EmployeeInfo ei = (EmployeeInfo)p1.info;
        System.out.println(ei.rank);
    }
}
*/
// 성공적으로 컴파일 되지만 실행하면 오류가 발생한다.
// Person p1 = new Person("부장"); -> 해당 코드를 살펴보자.
// 클래스 Person 의 생성자는 매개변수 info 데이터 타입이 Object 이다.
// 따라서 모든 객체가 될 수 있다.
// 그렇기 때문에 생성자 입력값에 String 이 와도 컴파일 에러가 발생하지 않는다.
// 대신 런타임 에러가 발생한다.
// 컴파일 언어의 기본은 모든 에러는 컴파일이 발생할 수 있도록 유도한다는 것이다.
// 런타임은 실제로 애플리케이션이 동작하고 있는 상황이기 때문에
// 런타임에 발생하는 에러는 항상 심각한 문제를 초래할 수 있기 때문이다.
// * 위와 같은 상황을 타입에 대해 안전하지 않은 상황이라고 생각하면 된다.
// 즉 모든 타입이 올 수 있기 때문에 타입을 엄격하게 제한할 수 없게 되는것이다.

// 2-2 제네릭화
// 위의 예제를 제네릭으로 바꿔보자.

// Example.6
/*
class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T>{
    public T info;
    Person(T info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person<EmployeeInfo> p1 = new Person<EmployeeInfo>(new EmployeeInfo(1));
        EmployeeInfo ei1 = p1.info;
        System.out.println(ei1.rank); // 성공

        Person<String> p2 = new Person<String>("부장");
        String ei2 = p2.info;
        System.out.println(ei2.rank); // 컴파일 실패
    }
}
*/
// p1은 잘 동작한다
// 중요한 것은 p2에서 컴파일 오류가 발생한다는 것이다.
// p2 info 가 String 이고 String 은 rank 필드가 없는데 이것을 호출하고 있기 때문이다.
// * 컴파일 단계에서 오류가 검출된다.
// * 중복의 제거와 타입 안전성을 동시에 추구할 수 있게 되었다.


// 3. 제네릭의 특성

// 3-1 복수의 제네릭
// 클래스내에서 여러개의 제네릭을 필요로 하는 경우가 있을 것이다.
// 예제를 통해 확인해보자.
// Example.7
/*
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){
        this.info = info;
        this.id = id;
    }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person<EmployeeInfo, int> p1 = new Person<EmployeeInfo, int>(new EmployeeInfo(1), 1);
    }
}
*/
// 위의 코드는 에러가 발생한다.
// 일단 처리형식을 보도록하자.
// 복수의 제네릭을 사용할 때는 <T,S> 와 같은 형식을 사용한다.
// 여기서 T와 S대신 어떠한 문자를 사용해도 된다.

// 3-2 기본데이터 타입과 제네릭
// 제네릭은 참조 데이터 타입에 대해서만 사용할 수 있다.
// 기본 데이터 타입에서는 사용할 수 없다.
// 따라서 아래와 같이 변경해야 한다.
// Example.8
/*
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){
        this.info = info;
        this.id = id;
    }
}
public class GenericDemo {
    public static void main(String[] args) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        System.out.println(p1.id.intValue());
    }
}
*/
// new Integer 는 기본 데이터타입인 int 를 참조 데이터 타입으로 변환해준다.
// 이러한 클래스를 래퍼 클래스라고 한다.
// 기본 데이터 타입을 사용할 수 없는 제네릭에서 int 를 사용할 수 있다.

// 3-3 제네릭의 생략
// 제네릭은 생략 가능하다.
// 아래 두개의 코드가 있다. 이 코드는 동일하게 동작한다.
// e와 i 의 데이터 타입을 알고 있기 때문이다.
/*
EmployeeInfo e = new EmployeeInfo(1);
Integer i = new Integer(10);
Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
Person p2 = new Person(e, i);
*/

// 3-4 메소드에 적용
// 제네릭을 메소드에 적용해보자.
// Example.9
/*
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){
        this.info = info;
        this.id = id;
    }
    public <U> void printInfo(U info){
        System.out.println(info);
    }
}
public class GenericDemo {
    public static void main(String[] args) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        p1.<EmployeeInfo>printInfo(e);
        p1.printInfo(e);
    }
}
*/
// printInfo(info) 메소드는 리턴 자료형으로 <U> 라는 제네릭을 반환한다.

// 3-5 extends
// 제네릭을 올 수 있는 데이터 타입을 특정 클래스의 자식으로 제한할 수 있다.
// Example.10
/*
abstract class Info{
    public abstract int getLevel();
}
class EmployeeInfo extends Info{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person<T extends Info>{
    public T info;
    Person(T info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person(new EmployeeInfo(1));
        Person<String> p2 = new Person<String>("부장");
    }
}
*/
// 컴파일에러를 발생시킨다.
// class Person<T extends Info>
// 즉 Person 의 T 는 Info 클래스나 그 자식 외에는 올 수 없다.
// extends 는 상속(extends) 뿐 아니라 구현(implements) 의 관계에서도 사용할 수 있다.

// Example.6

interface Info{
    int getLevel();
}
class EmployeeInfo implements Info{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person<T extends Info>{
    public T info;
    Person(T info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person(new EmployeeInfo(1));
        // Person<String> p2 = new Person<String>("부장"); // 컴파일에러
    }
}

// 마찬가지로 컴파일에러를 발생시킨다.
// extends 는 상속 뿐 아니라 구현 implements 의 관계에서도 사용할 수 있다.
