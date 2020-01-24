import java.util.Scanner;

public class ScannerTest {

    public static void main (String[] args){

        // 1. Scanner
        // J2SE 5.0 부터 Scanner 라는 java.util.Scanner 클래스가 추가되었다.
        // Scanner 를 활용하면 보다 쉽게 콘솔입력을 구현할 수 있다.
        // 다음과 같이 해보자.

        /*
        System.out.println("---Example1---");
        System.out.print("단어를 입력하고 enter:");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next());
        */

        // Scanner 를 사용하기 위해 먼저 java.util.Scanner 클래스를 import 해야한다.
        // Scanner 클래스는 생성자의 입력으로 System.in 즉 InputStream 을 필요로한다.
        // Scanner 의 next() 메소드는 단어 하나(Token)를 읽어들인다.
        // Scanner 클래스는 단어 뿐만 아니라 숫자, 문자열 등 다양하게 읽어들일 수 잇는 여러 메소드가 있다.
        // next -> 단어
        // nextLine -> 라인
        // nextInt -> 정수
        // 프로그램을 실행하고 단어를 입력하면 해당 단어가 출력되는것을 확인할 수 있다.

        // 문장 출력
        /*
        System.out.println("---Example2---");
        System.out.print("문장을 입력하고 enter:");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextLine());
        */

        // 프로그램을 재실행하고 문장을 입력하면 해당 문자가 출력된다.

        // 숫자 출력
        System.out.println("---Example3---");
        System.out.print("int 를 입력하고 enter:");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt());

        // 숫자 '1' 을 입력하면 숫자가 출력된다.

        // 2. 콘솔출력
        // System.out.println 을 생각해보자.
        // System.out 은 PrintStream 클래스의 객체이다.
        // PrintStream 은 콘솔에 값을 출력할 때 사용하는 클래스이다.
        // System.out.println 은 콘솔로 디버깅 할 때 많이 사용된다.
        // System.err 은 오류메세지를 출력할 경우 사용하게 되어있다.
    }

}
