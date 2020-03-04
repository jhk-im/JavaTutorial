package Tutorials.java12_Reference;

// 1. 복제
// 전자화된 시스템의 가장 중요한 특징은 복제다.
// 현실의 사물과 다르게 전자화된 시스템 위의 데이터를 복제하는데 비용이 거의 들지 않는다.
// 이러한 특징이 소프트웨어를 기존의 산업과 구분하는 가장 큰 특징일 것이다.
// 프로그래밍에서 복제란 무엇일까? 예제를 통해 알아보자 .

//Example.1
/*
public class ReferenceDemo {

    public static void runValue(){
        int a = 1;
        int b = a;
        b = 2;
        System.out.println("runValue, "+a);
        //System.out.println("runValue, "+b);
    }

    public static void main(String[] args) {
        runValue();
    }

}
*/
// 1 을 출력할 것이다. 당연한 결과다.
// 값을 변경한 것은 변수 b 이기 때문에 a에 담겨있는 값은 그대로 이다.
// 변수 b의 값에 변수 a 의 값이 복제된 것이다.



// 2. 참조
// 그런데 자연의 산물이 아니라 거대한 약속의 집합인 소프트웨어의 세계에서 당연한 것은 없다.
// 당연하지 않은 이유는 다음 예제를 통해 분명하게 드러난다.

// Example.2
/*
class A{
    public int id;
    A(int id){
        this.id = id;
    }
}

public class ReferenceDemo {

    public static void runValue(){
        int a = 1;
        int b = a;
        b = 2;
        System.out.println("runValue, "+a);
    }

    public static void runReference(){
        A a = new A(1);
        A b = a;
        b.id = 2;
        System.out.println("runReference, "+a.id);
    }

    public static void main(String[] args) {
        runValue();
        runReference();
    }

}
*/
// runValue, 1  runReference, 2 가 출력될 것이다.
// 이코드의 주인공은 아래와 같다.
/*
b.id = 2;
System.out.println("runReference, "+a.id);
*/
// 놀라운 차이점이다. b에 담긴 인스턴스의 id 값을 2로 변경했는데
// a.id 의 값도 2가 된 것이다.
// 이것은 변수 b와 변수 a에 담긴 인스턴스가 서로 같다는 것을 의미한다.


// 3. 참조와 복제
// 앞서 필자는 전자화된 세계에서 가장 중요한 특징으로 복제를 들었다.
// 그런데 복제만으로 전자화된 시스템을 설명하는 것은 조금 부족하다.
// 비유하자면 복제는 파일을 복사하는 것이고
// 참조는 심볼릭 링크 혹은 바로가기를 만드는 것과 비슷하다.
// 원본 파일에 대해서 심볼릭 링크를 만들면 원본이 수정되면 심볼릭 링크에도
// 그 내용이 실시간으로 반영되는 것과 같은 효과다.
// 심볼릭 링크를 통해서 만든 파일은 원본 파일에 대한 주소 값이 담겨있다.
// 누군가 심볼릭 링크에 접근하면 컴퓨터는 심볼릭 링크에 저장된 원본의 주소를 참조해서
// 원본의 위치를 알아내고 원본에 대한 작업을 하게 된다.
// 다시 말해서 원본을 복제한 것이 아닌 원본 파일을 참조하고 있는 것이다.
// 덕분에 저장 장치의 용량을 절약할 수 있고,
// 원본파일을 사용하고 있는 모든 복제본이 동일한 내용을 유지할 수 있게된다.

// 프로그래밍에서 광범위하게 사용하는 라이브러리라는 개념도 일종의 참조라고 할 수 있다.
// 공용 라이브러리를 사용하게 되면 하나의 라이브러리를 여러 애플리케이션에서 공유하여 사용한다.
// 라이브러리의 내용이 변경되면 이를 참조하고 있는 애플리케이션에도 내용이 반영된다.
// 또 우리가 변수를 사용하는 이유도 말하자면 참조를 위해서라고 할 수 있다.
/*
int a =1;
A a = new A(1);
*/
// 두개의 구문의 차이점을 생각해보자.
// 전자는 데이터형이 int 이고 후자는 A 이다.
// int 는 기본 데이터형이다.
// 자바는 기본 데이터형을 제외한 모든 데이터 타입은 참조 데이터형 이라고 부른다.
// 기본데이터형은 복제되지만 참조 데이터형은 참조된다.
// new 를 사용해서 객체를 만드는 모든 데이터 타입이 참조 데이터형이라고 생각하면 된다.
// 단 String 은 제외다.
/*
A a = new A();
A b = a;
*/
// 즉, 위의 구문은 a와 b가 같은 new A(); 객체를 참조하고 있는 것이다.
// 변수에 담겨있는 데이터가 기본형이면 그 안에는 실제 데이터가 들어있고,
// 기본형이 아닌 변수에는 데이터에 대한 참조 방법이 들어있다고 할 수 있다.


// 4. 참조데이터 형과 매개변수
// 그럼 일종의 변수할당이라고 할 수 있는 메소드의 매개변수는
// 어떻게 동작하는지 다음의 예제에서 살펴보자.

// Example.3

class A{
    public int id;
    A(int id){
        this.id = id;
    }
}


public class ReferenceDemo {

    static void _value(int b){
        b = 2;
    }

    public static void runValue(){
        int a = 1;
        _value(a);
        System.out.println("runValue, "+a);
    }

    static void _reference1(A b){
        b = new A(2);
    }

    public static void runReference1(){
        A a = new A(1);
        _reference1(a);
        System.out.println("runReference1, "+a.id);
    }

    static void _reference2(A b){
        b.id = 2;
    }

    public static void runReference2(){
        A a = new A(1);
        _reference2(a);
        System.out.println("runReference2, "+a.id);
    }

    public static void main(String[] args) {
        runValue(); // runValue, 1
        runReference1(); // runReference1, 1
        runReference2(); // runReference2, 2
    }

}

// 다음과같이 출력된다.
/*
runValue, 1
runReference1, 1
runReference2, 2
*/
// 3가지 경우를 설명하고 있으므로 하나씩 살펴보자.

// runValue(); 메소드는 매개변수로 기본 데이터형(int)을 전달했다.
// 메소드 _value 의 인자로 a 를 전달했다.
// 인자 a는 매개변수 b가 되어서 _value 안으로 전달되고 있다.
// _value 안에서 b의 값을 변경했다.
// _value 가 실행된 후에 runValue 에서 a 값을 출력해본 결과 값이 유지되었다.
// 호출된 메소드의 작업이 호출한 메소드에 영향을 미치지 않고 있다.

// runReference1(); 메소드는 매개변수로 참조 데이터 타입을 전달하고 있다.
// 메소드 _reference1() 안에서 매개변수 b의 값을 다른 객체로 변경하고 있다.
// 이것은 지역변수인 b의 데이터를 교체한 것일 뿐이기 때문에
// runReference1(); 의 결과에 영향을 미치지 않는다.

// runReference2(); 메소드는 호출된 메소드의 작업이 호출한 메소드의 변수에 영향을 미친다.
// 매개변수 b의 값을 다른 객체로 교체한 것이 아니라
// 매개변수 b의 인스턴스 변수 id 값을 2로 변경하고 있다.
// 이러한 맥락에서 _reference2() 메소드이 변수 b는
// runReference2 의 변수 a 와 참조 관계로 연결되어 있는 것이기 때문에
// a와 b는 모두 같은 객체를 참조하고 있는 변수다.

// 매개변수를 다른 객체로 변경하는 것과
// 참조 데이터 타입의 매개변수에 담겨있는 것은 완전 다른 의미를 가진다.
// 두 차이점을 확실하게 이해하도록 하자.