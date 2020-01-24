import java.io.*;

public class FileWriteTest {

    public static void main(String[] args) throws IOException {

        // 1. File 입출력
        // 파일을 이용한 입출력 방법에 대해서 알아보도록 하자.
        // 다음과같이 입력해보자.

        // Example.1
        /*
        FileOutputStream output = new FileOutputStream("d:/out.txt");
        output.close();
        */

        // 위 예제를 실행해보면 c:/ 디렉토리 바로 밑에 새로운 파일이 하나 생성된다.

        // 파일을 생성하기 위해 FileOutputStream 클래스를 사용한다.
        // FileOutputStream 객체를 생성하기 위해서 생성자의 입력으로 파일명을 넘겨주어야 한다.
        // 경로를 포함하여 c:/out.txt 라는 파일명을 생성자의 입력으로 전달하였다.

        // 위의 예에서 보면 output.close() 라는 문장이 있는데 이것은 사용한 파일 객체를 닫아주는 것이다.
        // output.close() 는 생략해도된다. 이것은 사용한 파일 객체를 닫아주는 것이다.
        // 사실 생략해도 되는데 자바 프로그램이 종료할 때 사용한 파일 객체를 자동으로 닫아주기 때문이다.
        // 하지만 직접 파일을 닫아주는 것이 좋은데 파일을 닫지 않고 다시 사용하려고 할 경우 에러가 발생할 수 있기 때문이다.

        // 2. 파일에 내용쓰기
        // 파일에 내용을 추가하기 위해 다음과 같이 작성해보자.

        // Example.2
        /*
        for(int i=1; i<11; i++){
            String data = i+" 번째 줄입니다. \r\n";
            output.write(data.getBytes());
        }
        output.close();
        */

        // InputStream 과 마찬가지로 OutputStream 역시 바이트 단위로 데이터를 처리하는 클래스이다.
        // FileOutputStream 은 OutputStream 클래스를 상속받아 만든 클래스인데 역시 바이트 단위로 데이터를 처리하게끔 되어있다.
        // FileOutputStream 에 값을 쓸 때는 byte 배열로 써야 하므로 위와같이 String 을 byte 배열로 바꾸어주는 getBytes() 메소드를 이용해야한다.
        // 문자열을 파일에 쓸때는 FileOutputStream 이 좀 불편하다.
        // String 을 byte 배열로 변환해야하기 때문이다.
        // 다음의 예로 좀 더 편리하게 바꾸어 보자.

        // Example.3
        /*
        FileWriter fw = new FileWriter("d:/out1.txt");
        for(int i=1; i<11; i++){
            String data = i+" 번째 줄입니다. \r\n";
            fw.write(data);
        }
        fw.close();
        */

        // FileOutputStream 대신 FileWriter 를 이용하면 byte 배열 대신 문자열을 직접 파일에 쓸 수가 있다.
        // \n\r 은 줄바꿈 문자이다.
        // \n\r 을 사용하지 않는 방법은 없을까?
        // 이런 불편함을 해소하려면 FileWriter 대신 PrintWriter 를 사용하면 된다.
        // PrintWriter 를 이용하면 \n\r 을 덧붙이는 대신 println 이라는 메소드를 사용할 수 있게된다.
        // PrintWriter 를 사용해보자.

        // Example.4
        /*
        PrintWriter pw = new PrintWriter("d:/out2.txt");
        for(int i=1; i<11; i++){
            String data = i+" 번째 줄입니다.";
            pw.println(data);
        }
        pw.close();

        //위 코드와 다음의 코드를 비교해보자.
        for(int i=0; i<11; i++){
            String data = i+" 번째 줄입니다.";
            System.out.println(data);
        }
        */

        // 두 프로그램의 서로 다른 점은 data 를 출력시키는 방법이다.
        // 첫번째는 파일 출력방법이고 두번째 방법은 콘솔 출력방법이다.
        // System.out 대신 PrintWriter 를 사용했을 뿐이다.
        // out.txt , out1.txt, out2.txt 모두 d 드라이브 안에 동일한 내용이 입력되었다.

        // 3. 파일에 내용 추가하기
        // 파일에 내용을 쓰고 난 후 새로운 내용을 추가해야할 상황이 생긴다.
        // 이미 작성된 파일을 다시 추가모드로 열어야 한다.
        // 다음과 같이 작성해보자

        // Example.5
        /*
        FileWriter fw = new FileWriter("d:/out3.txt");
        for(int i=1; i<11; i++){
            String data = i+" 번째 줄입니다.\r\n";
            fw.write(data);
        }
        fw.close();

        FileWriter fw1 = new FileWriter("d:/out3.txt", true);
        for(int i=1; i<21; i++){
            String data = i+" 번째 줄입니다.\r\n";
            fw1.write(data);
        }
        fw1.close();
        */

        // fw1 이라는 객체는 FileWriter("d:/out3.txt", true) 와 같이 두번째 입력값이 추가뢰 입력되어 생성된다.
        // 두번째 boolean 입력 파라미터는 파일을 추가모드(append)로 열것인지에 대한 구분값이다.
        // 파일을 추가모드로 열면 기존 파일의 내용 이후부터 파일이 쓰여지게 된다.
        // out3.txt 파일을 열면 추가내용을 확인할 수 있다.

        // FileWriter 대신 PrintWriter 를 사용해보자.

        // Example.6
        PrintWriter pw = new PrintWriter("d:/out4.txt");
        for(int i=1; i<11; i++){
            String data = i+" 번째 줄입니다.";
            pw.println(data);
        }
        pw.close();

        PrintWriter pw1 = new PrintWriter(new FileWriter("d:/out4.txt",true));
        for(int i=1; i<21; i++){
            String data = i+" 번째 줄입니다.";
            pw1.println(data);
        }
        pw1.close();

        //PrintWriter 의 생성자의 입력으로 파일명 대신 추가모드로 열린 FileWriter 의 객체를 사용하면 된다.



    }

}
