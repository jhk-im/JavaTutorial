package JumpToJava.Tutorial05_StringBufferTutorial;

public class StringBufferTutorial {

    public static void main(String[] args){
        // StringBuffer 는 문자열을 추가하거나 변경 할 때 주로 사용하는 변수다.
        // 메소드를 살펴보도록 하자.

        //1. append() -> 문자열을 추가해주는 메소드이다.
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StringBuffer");
        stringBuffer.append(" ");
        stringBuffer.append("append() test");
        System.out.println("---stringBuffer.append()---");

        //2. toString() -> StringBuffer 에 담겨진 데이터를 String 문자로 반환해준다.
        System.out.println(stringBuffer.toString()); // StringBuffer append() test

        // string 변수로 똑같이 표현하면 다음과 같다.
        String string = "";
        string += "StringBuffer";
        string += " ";
        string += "string test";
        System.out.println(string); // StringBuffer string test

        // 두 개의 예제 모두 결과는 동일하지만 내부적으로 객체가 생성되고 메모리가 사용되는 과정이 다르다.
        // *StringBuffer 객체는 단 한번만 생성된다.
        // *String 은 + 연산이 있을 때 마다 새로운 String 객체가 생성된다.  총 4개의 String 변수 객체가 만들어지게 된다.
        // String 변수는 한번 값이 생성되면 값을 변경할 수 없다.
        // 값을 변경할 수 없는것을 immutable 이라 한다.
        // trim, toUpperCase 등의 메소드를 보면 변경되는 것 처럼 생각될 수 있다.
        // 하지만 해당 메소드 수행 시 또 다른 String 객체를 생성하여 리턴 할 뿐이다.
        // *StringBuffer 는 이와 반대로 값을 변경할 수 있다. -> mutable -> 한번 생성 된 값을 언제든지 변경할 수 있다.

        // StringBuffer 는 String 보다 무거운 편에 속한다.
        // new StringBuffer() 로 객체를 생성하는 것은 일반 String 을 사용하는 것 보다 메모리 사용량이 많고 속도가 느리다.
        // 문자열 추가나 변경등의 작업이 많을 경우 StringBuffer 를 사용하고,
        // 추가나 변경 작업이 거의 없는 경우에는 String 을 사용하는 것이 유리하다.

        // 3.insert()
        // insert 메소드는 특정 위치에 원하는 문자열을 삽입할 수 있다.

        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append("insert() test");
        stringBuffer1.insert(0,"StringBuffer ");
        // insert() 안에 0과 문자열은 0 번째 위치에 "StringBuffer " 라는 문자열을 삽입한다는 뜻이다.

        System.out.println("---StringBuffer.insert()---");
        System.out.println(stringBuffer1.toString()); // StringBuffer insert() test

        // 4.substring()
        // substring 메소드는 String 자료형의 substring 메소드의 사용법과 동일하다.
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("StringBuffer substring() test");
        System.out.println(stringBuffer2.substring(0,12)); // StringBuffer
        // substring(시작위치,끝위치)와 같이 사용하면 시작위치에서 끝 위치까지의 문자를 뽑아내게 된다.
    }

}
