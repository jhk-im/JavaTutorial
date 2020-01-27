package JumpToJava.Tutorial04_TypeConversionTutorial;

public class TypeConversionTutorial {

    public static void main(String[] args) {

        // 변수는 변하는 값을 의미한다.
        // 그 반대인 것이 상수이고 상수는 constant -> 변하지 않는 값을 의미한다.

        int a = 1;
        // 변수 a는 대입연산자에 의해 1이 되었다.
        // 1 = 3; 은 컴파일 되지 않는다.
        // 1은 1이고 3은 3이다.
        // 고유한 값을 가지고 있고 그 값을 변경 할 수 없는 데이터타입을 상수라고 한다.

        // 형 변환이란 데이터 타입을 변경하는 것이다.
        // 컴퓨터는 모든 정보가 0과 1로 만들어진다.
        // 200이라는 숫자를 입력하면 0과 1로 이루어진 조합으로 저장된다.
        // 사람에게는 똑같은 200과 200.0을 컴퓨터는 전혀 다른 방식으로 저장한다.
        // 00000000 00000000 00000000 11001000 -> 200
        // 01000011 01001000 00000000 00000000 -> 200.0

        // 이렇게 형식이 다른 데이터를 더하려면 한쪽의 데이터 타입을 다른 쪽의 데이터 타입으로 Conversion 해야한다.
        // 자바는 이러한 형 변환을 자동으로 처리해준다.
        // 이러한 작업ㅇ르 암시적형변환(Implicit Conversion)이라고 부른다.

        //1. 자동 형 변환 Implicit Conversion
        double doubleTest = 3.0f;
        // 위의 코드는 double 타입의 변수에 float 타입의 값을 대입하고 있다.
        // 이 때 float 값은 자동으로 double 타입으로 형 변환이 일어난다.
        // 이것이 가능한 이유는 double 타입이 float 보다 더 많은 수를 표현할 수 있기 때문이다.
        // 즉, 타입을 변경해도 정보의 손실이 일어나지 않는 경우 자동 형 변환이 일어난다.

        //float floatA = 3.0;
        // 반대로 위의 코드는 오류가 발생한다.
        // 3.0은 상수이고 이 상수는 double 형이다.
        // 이 값을 표현범위가 좁은 float 에 넣으려고 하기 때문에 오류가 발생한다.
        // 자동 형 변환의 규칙은 다음과 같다.
        // byte -> short -> int -> long -> float -> double

        byte byteA = 100;
        short shortA;
        shortA = byteA; // byteA 를 short 타입으로 자동 형 변환

        short shortB = 100;
        byte byteB;
        // byteB = shortB; // 컴파일 에러

        int intA = 100;
        long longA;
        longA = intA; // intA 를 long 타입으로 자동 형 변환

        long longB = 100;
        //int intB = longB; // 컴파일 에러

        // 상수와 상수의 연산
        double doubleA = intA + longB;
        // 위의 연산은 두번의 형 변환이 일어난다.
        // intA와 longB를 더해야 하는데 하나는 정수고 하나는 실수이다.
        // 자동 형 변환 규칙을 보면 int 보다 long 이 더 많은 값을 담을 수 있다고 하였다.
        // 즉, int(정수)가 long(실수)로 형변환이 이루어지고 더하기 연산을 진행한다.
        // 하지만 값이 담길 doubleA 의 타입은 double 이다.
        // long 보다 double 이 더 많은 값을 담을 수 있다.
        // 결과적으로 long 타입이 double 타입으로 자동 형 변환하여 doubleA 에 대입된다.
        System.out.println("---Implicit Conversion---");
        System.out.println(doubleA); //200.0

        // 2. 명시적 형 변환 Explicit Conversion

        // 자동 형 변환이 적용되지 않는 경우 수동으로 형 변환을 해야한다.
        // 이를 명시적 형 변환(Explicit Conversion)이라 한다.

        // float floatExpConversion = 100.0; // 컴파일 에러
        // int  intExpConversion = 100.0f; // 컴파일 에러
        // 위의 예제는 모두 컴파일 에러가 발생한다.

        float floatExpConversion = (float)1.0;
        int  intExpConversion = (int)1.0f;
        // 위와 같이 괄호 안에 데이터 타입을 지정하여 값 앞에 위치시키면 된다.
        // (데이터 타입)데이터 값

        System.out.println("---Explicit Conversion---");
        System.out.println(floatExpConversion+intExpConversion); // 2.0
        // 위와 같이 floatExpConversion(float) + intExpConversion(int)를 더해보자.
        // float 이 더 많은 데이터를 담을 수 있으므로 float 으로 자동 형 변환되어 2.0을 출력한다.

        // 번 외로 float 로 자동 형 변환되는지 확인하고 싶었다.
        // 다음은 instanceof 를 이용한 데이터 변수 타입 확인하는 방법이다.

        // floatExpConversion + intExpConversion 의 값을 Object 에 담는다.
        Object obj = floatExpConversion+intExpConversion;
        // instanceof 를 이용한 비교
        // obj 에 담긴 변수 타입이 float 가 맞다면 아래의 문구를 출력한다.
        if(obj instanceof Float){
            System.out.println("floatExpConversion + intExpConversion = a ");
            System.out.println("a 의 변수 타입은 float 입니다.");
        }

        // intExpConversion 의 값을 Object 에 담는다.
        Object obj2 = intExpConversion;
        // instanceof 를 이용한 비교
        // obj2 에 담긴 변수 타입이 int 가 맞다면 아래의 문구를 출력한다.
        if(obj2 instanceof Integer){
            System.out.println("intExpConversion 의 타입은 int 입니다.");
        }

        // floatExpConversion 의 값을 Object 에 담는다.
        Object obj3 = floatExpConversion;
        // instanceof 를 이용한 비교
        // obj3 에 담긴 변수 타입이 int 가 맞다면 아래의 문구를 출력한다.
        if(obj3 instanceof Integer){
            System.out.println("floatExpConversion 의 타입은 int 입니다.");
        }
        // obj3 에 담긴 변수의 타입이 int 가 아니라면 아래의 문구를 출력한다.
        else{
            System.out.println("floatExpConversion 의 타입은 int 가 아닙니다.");
        }
    }

}

