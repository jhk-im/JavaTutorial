package JumpToJava.Tutorial23_StaticMethodTutorial;// 싱글톤 패턴
// 디자인 패턴중 하나인 싱글톤에 대해서 알아보자.
// static 에 대한 개념이 생기면 싱글톤을 이해하기 어렵지 않다.
// 싱글톤은 단 하나의 개체만을 생성하게 강제하는 패턴이다.
// 즉, 클래스를 통해 생성할 수 있는 객체는 오직 하나가 되는 것이다.

class Singleton {
    //Example.1
    private Singleton() {
    }

    //Example.2
    /*
    public static Singleton getInstance() {
        return new Singleton();
    }
    */

    //Example.3
    private  static  Singleton one;
    public static Singleton getInstance() {
        if(one==null) {
            one = new Singleton();
        }
        return one;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        // Example.1
        //Singleton singleton = new Singleton(); -> 컴파일 에러
        // 다음은 컴파일 에러가 발생한다.
        // 왜냐하면 Singleton 클래스의 생성자에 private 키워드로
        // 외보 쿨래스에서 Singleton 클래스의 생성자로의 접근을 막았기 때문이다.
        // 이렇게 생성자를 private 으로 만들어버리면 외부 클래스에서
        // Singleton 클래스를 new 를 이용해 생성할 수 없게 된다.
        // new 를 사용해서 무수히 많은 객체를 생성한다면 싱글톤의 정의에 어긋나게 된다.
        // 다음과 같은 코드를 추가해보자.

        // Example.2
        /*
        public static Singleton getInstance() {
            return new Singleton();
        }
        */
        // 위와 같이 코드를 변경하고 다음과 같이 getInstance 라는 static 메소드를 이용하여
        // Singleton 객체를 돌려받을 수 있다.
        // Singleton singleton = Singleton.getInstance();
        // 하지만 getInstance() 를 호출 할 때마다 새로운 객체가 생성된다.
        // 다음과 같이 변경해보자.

        // Example.3
        /*
        private  static  Singleton one;
        public static Singleton getInstance() {
            if(one==null) {
                one = new Singleton();
            }
            return one;
        }
        */
        // Singleton 클래스에 one 이라는 static 변수를두고
        // getInstance 메소드에서 one 값이 null 인 경우에만 객체를 생성하도록 한다.
        // 객체가 단 한번만 만들어지는 것이다.
        // 동작원리
        // -> 최초 getInstance 가 호출되면 one 이 null 이므로 new 의해 객체가 생성
        // -> one 은 static 변수이기 때문에 그 뒤로는 null 이 아니게 됨
        // -> 다시 getInstance 메소드 호출
        // -> one 이 null 이 아니므로 이미 만들어진 싱글톤 객체인 one 을 항상 리턴한다.

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        // getInstance() 를 두번 호출하여 각각 얻은 객체가 같은 객체인지 조사 해 보았다.
        // 둘은 같은 객체이기 때문에 true 가 출력된다.


    }
}