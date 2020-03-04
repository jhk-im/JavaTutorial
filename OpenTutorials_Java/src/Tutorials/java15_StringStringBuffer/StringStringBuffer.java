package Tutorials.java15_StringStringBuffer;


public class StringStringBuffer {
    public static void main(String[] args){

        /**
         * 참고 - https://wikidocs.net/276
         *       http://tcpschool.com/java/java_api_stringBuffer
         * String 과 String Buffer 의 차이
         **/

        /* StringBuffer  - mutable class
        - StringBuffer 는 단 한번만 생성된다.
        - StringBuffer 인 sb 라는 객체에 append() 메소드를 사용하여 문자가 추가 되는 것이다.
        - 생성된 객체가 변경이 가능하다는 점에서 mutable class (가변 클래스) 라고한다.
        - insert() 메소드로 원하는 위치에 문자열을 삽입할 수 있다.

            **  StringBuffer 클래스는 내부적으로 buffer 라고 하는 독립적인 공간을 가진다.
                버퍼 크기의 기본값은 16개의 문자를 저장할 수 있는 크기이며,
                생성자를 통해 그 크기를 별도로 설정할 수도 있다.
                StringBuffer 를 사용하면 문자열을 바로 추가할 수 있으므로,
                공간의 낭비도 없으며 속도도 매우 빨라진다.

            ** 장점이 많은 것 같은데 StringBuffer 만 사용하면 안되나?
               상황에 따라 다르다. StringBuffer 는 String 보다 무거운 편에 속한다.
               문자열 추가나 변경등의 작업이 많은 경우 StringBuffer 를 사용하고,
               변경 작업이 거의 없는 경우 String 을 사용하는 것이 좋다.
        */
        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println(sb); // Hello World
        System.out.println(sb.equals("Hello World")); // false
        System.out.println(sb.toString().equals("Hello World")); // true


        /* String - immutable class
        - String 은 + 연산이 있을 때 마다 새로운 String 객체가 생성된다.
        - 문자열 간 + 연산이 있는 경우 자바에서 자동으로 새로운 String 객체를 만든다.
        - "Hello" , " " , "World"  총 3개의 String 자료형 객체가 만들어진 것이다.

            ** String 자료형은 한번 값이 생성되면 그 값을 변경할 수 없다.
               이러한 속성의 클래스를 immutable class (불변 클래스) 라고한다.
               불편 클래스는 append(), insert() 와 같은 값을 변경하는 set 메소드가 없다.

            ** 불편한 것 같은데 왜 사용하는가?
               멀티 스레드 환경에서 객체가 변화되는 상황이라면
               불변 클래스 인스턴스를 사용하는 것이 좀 더 신뢰할 수 있기 때문이다.
               하나의 객체에 접근하면서 각각 객체가 서로 영향을 주어서는 안되는 경우
               불변 클래스 인스턴스를 사용하면 값이 변하지 않는다는 점이 보장된다.
        * */
        String s = "";
        s += "Hello";
        s += " ";
        s += "World";
        System.out.println(s); // Hello World




        /*
        StringBuffer 의 insert(), substring()
        **/
        sb.insert(0,"Insert - ");
        System.out.println(sb); // // Insert - Hello World
        System.out.println(sb.substring(0,6)); // Insert




    }
}
