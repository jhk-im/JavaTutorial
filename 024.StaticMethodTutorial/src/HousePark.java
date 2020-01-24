// 1. 정적 변수와 메소드 (static)

// 예제를 통해 살펴보자.
public class HousePark {
    String lastName = "박";

    static String lastName1 ="박";

    public static void main(String[] args){

        HousePark pey = new HousePark();
        HousePark pes = new HousePark();

        // 박씨 집안을 나타내는 House Park 이라는 클래스이다.
        // 위와 같은 클래스를 만들고 객체를 생성하면 객체마다
        // 객체변수 lastName 을 저장하기 위한 메모리를 별도로 할당해야 한다.
        // 지금과 같은 경우 lastName 은 어떤 객체이던지 "박" 이어야 한다.
        // 이렇게 값이 변하지 않는 경우라면 static 사용 시 메모리의 이점을 얻을 수 있다.
        // 다음과 같은 스태틱 변수를 추가해보자.
        // static String lastName1 ="박";
        // 위와같이 static 키워드를 붙이면 자바에서 메모리할당을 딱 한번만 하게 되어
        // 메모리 사용에 이점을 볼 수 있게 된다.

        /*
        * 만약 HousePark 클래스의 lastName 값이 변경되지 않기를 바란다면
        * static 키워드 앞에 final 이라는 키워드를 붙이면 된다.
        * final 키워드는 한번 설정 되면 그 값을 변경하지 못하게 하는 기능이 있다.
        * 변경하려고 하면 예외가 발생한다.
        * */

        // static 을 사용하는 또 한가지 이유로 공유의 개념을 들 수 있다.
        // static 으로 설정하면 같은 곳의 메모리 주소만을 바라보기 때문에 static 변수의 값을 공유하게 된다.
        // Counter.java 로 이동해보자.

    }

}
