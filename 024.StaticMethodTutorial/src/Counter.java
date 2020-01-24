import java.text.SimpleDateFormat;
import java.util.Date;

public class Counter {

    // Example.1
    /*
    int count = 0;
    Counter() {
        this.count++;
        System.out.println(this.count);
    }
    */

    // Example.2
    /*
    static int count = 0;
    Counter() {
        this.count++;
        System.out.println(this.count);
    }
    */

    // Example.3
    static int count = 0;
    Counter() {
        this.count++;
    }
    public static int getCount(){
        return count;
    }

    // Example.4
    public static String getCurrentDate(String fmt){
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        // Example.1을 보자
        /*
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        */
        // 다음은 웹 사이트 방문 시 조회수를 증가시키는 Counter 프로그램이다.
        // 프로그램을 실행하면 1, 1의 결과값이 나온다.
        // c1, c2 객체 생성시 count 값을 1씩 증가하더라도
        // 서로 다른 메모리를 가리키고 있기 때문에 카운트가 증가된 값이 나오지 않는다.
        // 객체 변수는 항상 독립적인 값을 갖기 때문에 당연한 결과이다.

        // Example.2를 보자
        // 다음은 count 를 static 으로 선언해 보고 실행해보자.
        /*
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        */
        // 1, 2 가 출력되는 것을 확인할 수 있다.

        // 보통의 변수의 static 키워드는 메모리 효율보다는
        // 지금처럼 공유하기 위한 용도로 훨씬 더 많이 사용하게 된다.

        // Example.3를 보자
        // static method
        // static 이라는 메소드 앞에 붙으면 스태틱 메소드가 된다.
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println(Counter.getCount());
        // Example.3 를 보면 getCount()라는 static 메소드가 추가되었다.
        // getCount() 메소드는 Counter.getCount()와 같이 클래스를 통해 호출할 수 있다.
        // * 스태틱 메소드 안에서는 인스턴스 변수 접근이 불가능하다.
        // getCount() 안에 count 는 static 변수이기 때문에 스태틱 메소드에서 접근이 가능한 것이다.
        // count 가 완료된 2가 출력된다.

        // 보통 스태틱 메소드는 유틸리니 성 메소드를 작성할 때 많이 사용된다.
        // 예를들면 오늘의 날짜 구하기, 숫자에 콤마 추가하기 등의 메소드를 작성할 때 스태틱 메소드가 유리하다.
        // Example.4를 보자
        System.out.println(Counter.getCurrentDate("yyyyMMdd"));
        // Counter 클래스의 getCurrentDate 라는 스태틱 메소드를 이용하여 오늘의 날짜를 구하는 예제이다.
        // 위 클래스를 실행하면 오늘의 날짜가 출력된다.

        // -> SingletonTest.java 로 이동하자.
    }

}
