package JumpToJava.Tutorial20_ConsoleAndFileTutorial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamTest {

    public static void main (String[] args) throws Exception {

        // 1. 콘솔 입력

        // 자바에서 System.in 을 이용하면 콘솔 입력을 얻을 수 있다.
        InputStream in = System.in;
        // InputStream 은 자바의 내장 클래스이다.
        // java.lang 패키지에 속해 있지 않은 클래스는
        // import java.io.InputStream; -> 처럼 항상 import 해서 사용해야 한다.
        // System.in 은 InputStream 의 객체임을 알 수 있다.

        /*
        System.out.println("---Example1---");
        System.out.print("입력하고 enter:");
        int a;
        a = in.read();
        System.out.println(a); // 97
        */

        // InputStream 의 read() 메소드는 다음처럼 1 byte 의 사용자의 입력을 받아드린다.
        // read 메소드로 읽은 1 byte 의 데이터는 byte 자료형으로 저장되는 것이 아니라 int 자료형을 저장된다.
        // 저장되는 int 값은 0-255 사이의 정수값으로 아스키 코드값이다.
        // * 0이라는 숫자에 해당되는 아스키 코드값은 48, a는 97이다.

        // 이제 프로그램을 실행시켜보면 프로그램은 종료되지 않고 사용자의 입력을 대기하고 있다.
        // InputStream 의 read() 메소드가 호출되면 사용자의 입력을 받을 때 까지 프로그램이 대기하기 때문이다.

        // a를 입력하고 enter: 옆에 'a' 를 입력해보고 엔터를 누른다.
        // * enter 를 눌러야 입력이 프로그램에 전달된다.
        // a 에 해당하는 아스키코드 97 이 출력된다.
        // 'abc' 를 입력해도 97이 출력된다.
        // 왜 'a' 에 해당하는 아스키 코드값만 출력되었을까?
        // InputStream 의 read 메소드는 1byte 만을 읽기 때문이다.
        // 즉, 사용자는 'abc' 의 3byte 를 전달하여도 프로그램은 1byte 만 읽은 것이다.
        // 1byte, 3byte 의 데이터를 입력 스트림 이라고한다.
        // 스트림은 이어져 있는 데이터(byte) 형태라고 이해하면 된다.

        /*
        *스트림 (Stream) 이란?
        * 수도꼭지를 틀면 물이 나오고 수도꼭지를 잠그면 물이 나오지 않는다.
        * A라는 곳에서부터 B라는 곳까지 수도관이 연결되어 있고
        * A에서 계속 물을 보낸다면 B에서 수도꼭지를 틀때마다 물이 나오게 될 것이다.
        * 여기서 스트림은 A 에서 B 수도관으로 이동하는 물의 흐름이라 할 수 있다.
        * 프로그래밍에서 스트림
        * -> 파일 데이터 (파일은 시작과 끝이 있는 데이터의 스트림이다.)
        * -> HTTP 응답 데이터 (브라우저가 요청하고 서버가 응답하는 HTTP 응답 데이터도 스트림이다.)
        * 키보드 입력 (사용자가 키보드로 입력하는 문자엵도 스트림이다.)
        */

        // 그렇다면 1byte 이상을 읽고싶으면 어떻게 해야 할까?
        // 다음과 같이 해보자.

        /*
        System.out.println("---Example2---");
        System.out.print("abc 입력하고 enter:");
        int a,b,c;
        a = in.read();
        b = in.read();
        c = in.read();

        System.out.println(a+", "+b+", "+c); // 97, 98, 99
        */

        // 프로그램을 다시 시작하고 'abc' 를 입력하면 97, 98, 99 로 출력된다.
        // 총 3byte 를 읽어들인다.

        // 다음과 같이 배열을 활용해 개선된 방법을 사용해보자.

        /*
        System.out.println("---Example3---");
        System.out.print("abc 입력하고 enter:");
        byte[] abc = new byte[3];
        in.read(abc);
        System.out.println(abc[0]+", "+abc[1]+", "+abc[2]);
        */

        // 재시작 후 동일하게 'abc' 를 입력하면 97, 98, 99 로 출력된다.
        // 길이가 3인 byte 배열을 만들고 read 메소드 호출 시 입력값으로 전달한다.
        // 콘솔 입력이 해당 배열을 저장하고 각각의 배열별로 출력할 수 있다.

        // 하지만 읽어들인 값을 항상 아스키코드 값으로 해석해야하는 방식이 불편하다.
        // 입력한 문자를 문자 그대로 출력할수는 없을까?
        // byte 대신 문자로 엽력 스트림을 읽으려면 InputStreamReader 를 사용한다.
        // 다음과 같이 import.io.InputStreamReader; 를 임포트하고 사용해보자.

        /*
        System.out.println("---Example4---");
        System.out.print("abc 입력하고 enter:");
        InputStreamReader reader = new InputStreamReader(in);
        char[] a = new char[3];
        reader.read(a);
        System.out.println(a); // abc
        */

        // InputStreamReader 객체를 생성할 때는 다음과 같이 생성자의 입력으로 InputStream 의 객체가 필요하다.
        // 이전에는 읽어들일 값을 byte 배열로 선언했다.
        // InputStreamReader 를 이용하면 다음처럼 byte 대신 char 배열을 사용할 수 있게된다.
        // 재시작 후 'abc' 입력 후 엔터를 누르면 abc 가 한번에 출력된다.

        // 많이 개선되었지만 불편함은 남아있다.
        // 가장 불편한점은 고정된 길이인 3byte 만 읽도록 고정되어 있다.
        // 엔터 입력 전까지 사용자의 입력을 전부 받아들일 수는 없을까?
        // import.io.BufferedReader; 를 입포트하고 사용해보자.

        System.out.println("---Example5---");
        System.out.print("문장을 입력하고 enter:");
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        String a = br.readLine();
        System.out.println(a);

        // BufferedReader 는 객체 생성시 생성자의 입력값으로 InputStreamReader 의 객체가 필요하다.
        // 이제 BufferedReader 의 readLine() 메소드를 이용하면 사용자가 엔터키를 입력할 때 까지 입력했떤 문자열을 전부 읽어드린다.
        // 프로그램 재시작 후 자유롭게 문장을 입력하고 엔터키를 입력하면
        // 입력한 문장이 그대로 Echo 되어 출력된다.

        // 스트림은 헷갈리는 개념이다.
        // 감싸고 감싸고 또 감싸니 내부적으로 어떻게 돌아가는지 헷갈릴 수 밖에 없다.
        // **다음과 같이 기억해두자.
        // InputStream -> byte
        // InputStreamReader -> char
        // BufferedReader -> String

        /*
        * main 메소드에 throws Exception 을 사용한 부분이 있다.
        * InputStream 으로 부터 값을 읽어들일 때는 IOException 이 발생할 수 있기 때문에
        * 예외처리를 해야하는데 throws 로 그 예외처리를 뒤로 미루게 한 것이다.
        * */


    }

}
