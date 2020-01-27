package JumpToJava.Tutorial03_VariableTutorial;

public class VariableTutorial {

    public static void main(String[] args){

        // 1. 변수선언
        System.out.println("---variable tutorial---");
        int a; // 변수 선언 - 변수의 이름
        a = 1; // a는 1이다.
        System.out.println(a+1); // a는 1이고 그에 1을 더하면 2가 출력된다.

        a = 2; // a는 2이다.
        System.out.println(a+1); // a는 2이고 그에 2를 더하면 3이 출력된다.

        // 2. 변수의 종류
        // 정수 = ...-3,-2,-1,0,1,2,3...
        // 실수 = ... -0.001, -0.01, -0.1, 0.0, 1.001, 2.01, 3.00001 ...
        // 소수점이 없음면 정수이고 소수점이 있으면 실수다.

        double c; // 변수의 형식은 double(실수)이고 이름은 c이다.
        c = 1.1; // c(실수)는 1.1이다.
        System.out.println(c+2.1); // c는 1.1이고 그에 2.1을 더하면 3.2를 출력한다.

        c = 1; // c(실수)는 1이다.lossy conversion possible lossy conversion from double to int
        System.out.println(c); // c는 1이지만 변수의 형식이 실수이기 때문에 1.0이 출력된다.

        //a = 1.1; //위에 선언한 int 타입의 a에 실수를 넣으면 오류가 뜬다.
        // java:incompatible types; possible lossy conversion from double to int
        // 파일의 성질이 맞지 않는다; 즉 a는 정수이고 정수에는 실수를 넣을 수 없다.

        // 3. 변수의 종류2
        // 자바에서 기본형은 8가지가 있고 이를 4가지로 분류할 수 있다.
        // 정수형, 실수형, 문자형, 논리형
        // 위에 나온 int 와 double 을 포함해서 전체적으로 정리해보자.

        // 3-1 정수형
        System.out.println("---byte,short,int,long---");
        byte byteType = 127; // 메모리크기 1 byte , 표현 가능 범위 -128~127
        short shortType = 32767; // 메모리크기 2 byte, 표현 가능 범위 -32768~32767
        int intType = 2147483647; // 메모리크기 4 byte, 표현 가능 범위 -2147483648 ~ 2147483647
        long longType = 9223372036854775807L; // 메모리 크기 8byte, -922337036854775808~9223372036854775807
        // long 타입은 끝에 L을 붙여 주어야 한다.
        System.out.println(byteType);
        System.out.println(shortType);
        System.out.println(intType);
        System.out.println(longType);
        // 사람은 숫자를 표현할 때 10진수를 사용하고 컴퓨터는 2진수를 사용한다.
        // 2진수는 값이 2배 커질수록 자리수가 하나씩 증가한다.
        // 1,10,11 등의 값이 컴퓨터 메모리에 저장될 때, 각 숫자는 1bit 라는 메모리 공간을 사용한다.
        // 8자리는 1byte(8bit=1byte)를 사용한다.
        // 즉 값이 커질수록 더 많은 메모리 공간을 사용한다는 뜻이다.
        // 정수를 저장할 때 몇 바이트를 사용하느냐에 따라 저장훌 수 있는 값의 범위가 정해진다.

        // 정수는 어떤 자료형에 저장해야 적합한가?
        // byte, short, int, long 4가지가 존재한다.
        // 자바의 기본 데이터형은 int 이다.
        // byte 나 short 에 저장해도 실제 연산 시에는 int 로 변환하는 작업을 수행한다.
        // 요즘 컴퓨터 환경은 메모리가 넉넉하기 때문에 이정도의 메모리 차이는 크지 않다.
        // *일반적으로 int 를 사용하고 int 로 표현할 수 없는 값의 범위를 표현할 때는 long 을 사용한다.

        // 3-2 실수형
        System.out.println("---float,double---");
        float floatType = 3.4028235E38f; // 메모리크기 4 byte, 표현 가능 범위 1.40239846E-45f ~ 3.40282347E+38f
        // bit 구성 ->  부호(1bit)+지수(8bit)+가수(23bit) = 32bit = 4 byte
        double doubleType = 1.7976931348623157E308; // 메모리크기 8 byte, 표현 가능 범위위 4.94065645841246544E-324 ~ 1.79769313486231570E+308
        // bit 구성 -> 부호(1bit)+지수(11bit)+가수(52bit) = 64bit = 8 byte
        System.out.println(floatType);
        System.out.println(doubleType);

        // 실수는 정수처럼 딱 떨어지는 값이 아닌 소수점을 가진 수를 말한다.
        // 실수는 사실상 무한하다.
        // 1과 2 사이에는 1.2, 1.12, 1.123, 1.1234 ...처럼 무한하게 존재한다.
        // 컴퓨터에 실수를 저장하려는 저장공간은 한정되어 있고, 어차피 무한한 값을 정확이 표현할 수 없다.
        // 그래서 최대한 근사한 값으로 표현하게 된다.
        // 표현 범위를 넓게 하기 위해서 지수로 표현하며 컴퓨터에서 실수를 표현하기 위한 부동 소수점 규칙은 IEEE754 표준에 정의되어 있다.
        // 실제 값을 표현하는 지수 부분과 소수점 자리수를 구분하는 지수부분이 나뉘어져 있기 때문에 오차가 존재할 수 밖에 없다.

        // 정수와 마찬가지로 기본적으로 float 를 사용하고 float 로 표현할 수 없는 값의 범위를 표현할 때는 double 을 사용한다
        // float 와 double 을 구분하기 위해 float 타입에는 숫자 뒤에 f를 붙여준다.

        // 3-3 문자형
        System.out.println("---char---");
        char charTypeA = 'a'; // 메모리 크기 8 byte, 표현 가능 범위 \ u000 ~ \ uFFF
        char charTypeB = 'b';
        char charTypeKorean = 'ㄱ'; // 한글 저장

        System.out.println(charTypeA);
        System.out.println((int)charTypeA); // char 타입의 charType 을 int 로 변환한다.
        // 해당 문자의 데이터 크기를 int 타입으로 확인할 수 있다.
        System.out.println(charTypeB);
        System.out.println((int)charTypeB);

        System.out.println(charTypeKorean); // 한글을 출력
        System.out.println((int)charTypeKorean);

        // 문자형은 char 한가지 이다.
        // char 타입은 2byte 의 크기를 가지고 있고, 65536개의 값을 표현할 수 있다.
        // char 타입은 유니코드 문자를 저장한다.
        // 유니코드는 실제로 숫자이며 특정한 숫자에 문자를 맵핑시켜서 표한한 것이다.
        // 유니코드는 전 세계 모든 문자를 저장할 수 있도록 처리한 방식이다.
        // 초창기에 사용하던 7bit 의 ASCII 코드는 로마자 위주의 코드였기 때문에 다른 국가의 언어를 처리할 수 없었다.
        // 그 것을 해결하고자 2byte (16bit) 공간에 문자를 할당한 것이 유니코드이다.
        // 이 코드를 가지고 어떻게 표현할 것인가 하는 인코딩 방식에는 UTF-8 이 있다.
        // 문자 저장시 2byte 로 사용하는 용량이 커지면서 1byte 만으로 표현할 수 있는 문자는 메모리를 비효율적으로 사용하게 되었다.
        // 이에 따라 문자에 따라 메모리를 가변적으로 사용하는 가변길이 문자 인코딩 UTF-8 이 생겨났다.

        // 3-4 논리형
        System.out.println("---boolean---");
        boolean booleanType = true;

        System.out.println(booleanType);

        // 논리형도 boolean 한 가지 밖에 없다.
        // 저장값은 true 와 false 두가지 이다.
        // 참과 거짓을 의미하는 데이터 타입으로 bool 이라고도 부른다.
        // boolean 을 활용하기 위해선 부울 연산을 알아야한다.

        // *부울 연산 (비교 연산)
        // == -> 좌향과 우향을 비교하여 값이 같은지 아닌지를 판별한다.
        // = 가 두개인 이유는 = -> 대입 연산자로 우향의 값을 좌향에 대입할때 사용하기 때문이다.
        System.out.println("---==---");
        System.out.println(1==2); //false
        System.out.println(1==1); //true
        System.out.println("one"=="two"); //false
        System.out.println("one"=="one"); //true

        // != -> !는 부정을 의마한다. 즉, ==와 정 반대의 결과를 보여준다.
        System.out.println("---!=---");
        System.out.println(1!=2); //true
        System.out.println(1!=1); //false
        System.out.println("one"!="two"); //true
        System.out.println("one"!="one"); //false

        // >  -> 좌향이 우향보다 크면 true 작으면 false
        // < -> 정반대의 결과
        System.out.println("--->,<---");
        System.out.println(1>0); //true
        System.out.println(1<0); //false

        // >= -> 좌향이 우향보다 크거나 같으면 true 아니면 false
        // <= 정반대의 결과
        System.out.println("--->=,<=---");
        System.out.println(1>=0); //true
        System.out.println(1>=1); //true
        System.out.println(1>=2); //false

        // .equals 문자열 비교할때 사용하는 메소드
        System.out.println("---.equals---");
        System.out.println("abc".equals("abc"));//true
        System.out.println(!"abc".equals("abc abc"));//true

        //이러한 부울 연산의 결과는 참 또는 거짓이므로 위에 선언한 boolean 타입의 변수에 대입될 수 있다.
        System.out.println("---boolean 변수 대입---");
        booleanType = 1==1;
        System.out.println(booleanType); //true
        booleanType = 1!=1;
        System.out.println(booleanType); //false

        // 3-5 문자열
        System.out.println("---String---");
        String stringType = "abc";

        System.out.println(stringType);

        // 문자열을 아래로 따로 빼둔 이유가 있다.
        // 몇가지 다른점들이 있기 때문이다.
        // 문자열이란 문장을 뜻한다.
        // 그리고 문자열에 해당하는 변수는 String 이다.
        // primitive (원시) 자료형에 대해 알고 넘어가도록 하자.
        // 이전에 보았던 byte, int, long, double, float, boolean, char 등을 자바에서 primitive 변수라고 부른다.
        // 이런 primitive 변수는 new 키워드로 생성할 수 없다.

        // String stringTest = new String("stringTest");
        // char charTest = new char("a"); //에러
        // char charTest2 = 'a'; //literal 로 값 대입

        // primitive 자료형은
        // String 은 "abc","stringTest" 와 같이 리터럴로 표기가 가능하지만 primitive 변수는 아니다.

        // String 에는 몇가지 유용한 메소드들이 있다.
        // 위에서 보았던 equals 가 그 중 하나이다.
        // equals 는 두개의 문자열이 동일한 값을 가지고 있는지를 비교하여 결과값을 리턴하는 메소드라 하였다.
        System.out.println("---String,equals---");
        String stringA = "string";
        String stringB = "stringB";
        String stringC = "string";
        String stringD = new String("string");
        System.out.println(stringA.equals(stringB)); //false
        System.out.println(stringA.equals(stringC)); //true
        System.out.println(stringA.equals(stringD)); //true
        System.out.println(stringA == stringB); // false
        System.out.println(stringA == stringC); // true
        System.out.println(stringA==stringD); // false

        // 문자열 값을 비교할때는 equals 를 사용해야 한다.
        // stringD 와 같이 new 키워드로 생성 할 경우 equals 로 비교했을 때에는 문제없이 true 를 리턴하였다.
        // 하지만 == 로 비교했을 때에는 false 를 반환하였다.
        // 문자열은 모두 같은 "string" 으로 되어어있지만 사실 stringA와 stringD는 서로 다른 객체이다.
        // == 은 두개의 자료형이 동일한 객체인지를 판별할 때 사용하는 연산자이기 때문에 false 를 리턴한다.

        // indexOf
        System.out.println("---String,indexOf---");
        String indexOf = "indexOf";
        System.out.println(indexOf.indexOf("Of")); //5

        // indexOf는 문자열에서 특정 문자가 시작되는 인덱스를 리턴한다.
        // 즉, 문자열에서 특정 문자를 입력하면 해당 문자가 문자열에서 몇번 째에 위치하는지 알려준다.
        // 위에서 보면 indexOf 에서 Of 는 6번째 부터 시작된다.
        // 결과값이 5로 나온 이유는 자바에서 숫자를 0부터 세기 때문이다.

        // replaceAll
        System.out.println("---String,replaceAll---");
        String replaceAll = "replaceAll";
        System.out.println(replaceAll.replaceAll("All","Big")); // replaceBig

        // replaceAll 은 문자열에서 특정 문자를 다른 문자로 바꾸고 싶을 경우 사용한다.
        // "replaceAll" 에서 "replaceBig" 으로 "All" 이라는 문자가 "Big" 이라는 문자로 변경되었다.

        // substring
        System.out.println("---String,substring---");
        String substring = "substring";
        System.out.println(substring.substring(0,3)); // sub

        // substring 은 문자열에서 특정 부분을 뽑아낼 때 사용한다.
        // substring(시작위치,끝위치)를 지정해서 시작위치에서 끝 위치까지의 문자를 뽑아낸다.
        // 끝위치의 문자는 포함되지 않는다.
        // 시작위치 <= a < 끝위치
        // "substring"에서 시작위치 :0 , 끝위치 : 3 이면 subs 가 이에 해당되고 끝 위치는 포함되지 않으므로
        // 최종적으로 sub 이 출력된다.

        // toUpperCase
        System.out.println("---String,toUpperCase---");
        String toUpperCase = "toUpperCase";
        System.out.println(toUpperCase.toUpperCase()); //TOUPPERCASE
        System.out.println(toUpperCase.toLowerCase()); //touppercase

        // toUpperCase 는 해당 문자열을 모두 대문자로 변경하고자 할 때 사용된다.
        // 반대로 모두 소문자로 변경 할 때에는 toLowerCase 를 사용하면 된다.
        // toUpperCase() -> TOUPPERCASE
        // toLowerCase() -> toppercase 로 출력된다.
    }

}