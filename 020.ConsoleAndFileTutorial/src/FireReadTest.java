import java.io.*;

public class FireReadTest {

    public static void main(String[] args) throws IOException {

        // 1. File 읽기
        // 이번에는 파일을 읽어보기 위해 다음과 같이 작성해보자.

        /*
        System.out.println("---Example1---");
        byte[] bytes = new byte[1024];
        FileInputStream input = new FileInputStream("d:/out1.txt");
        input.read(bytes);
        System.out.println(new String(bytes));
        input.close();
        */

        // 파일을 읽기 위해서는 위 예처럼 FileInputStream 클래스를 이용하면 된다.
        // 다만 byte 배열을 이용하여 파일을 읽어야 하기 때문에 읽어야 하는 정확한 길이를 모를 경우 좀 불편하다.
        // 위에서는 1024 byte 를 읽도록 하였다.

        // 만약 라인 단위로 읽을 수 있다면 편리할 것이다. 다음과 같이 작성해보자.

        System.out.println("---Example2---");
        BufferedReader br = new BufferedReader(new FileReader("d:/out1.txt"));
        while(true){
            String line = br.readLine();
            if (line==null) break;
            System.out.println(line);
        }
        br.close();

        // FileInputStream 대신 FileReader 와 BufferedReader 의 조합을 사용하면 라인 단위의 파일을 읽을 수 있다.
        // BufferedReader 의 ReadLine 메소드는 더이상 읽을 라인이 없을 경우 null 을 리턴한다.
        // if(line==null) break; 처럼 라인단위로 읽어 출력하고 읽을 라인이 없으면 while 문을 빠져나간다.

    }

}
