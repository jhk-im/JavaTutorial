import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest {

    public void shouldBeRun() {
        System.out.println("ok thanks.");
    }

    public void sayNick(String nick) {
        if("fool".equals(nick)) {
            return;
        }
        System.out.println("당신의 별명은 "+nick+" 입니다.");
    }

    public void sayNick1(String nick) {
        if("fool".equals(nick)) {
            throw new FoolException();
        }
        System.out.println("당신의 별명은 "+nick+" 입니다.");
    }
    public void sayNick2(String nick) {
        try {
            if("fool".equals(nick)) {
                throw new FoolException2();
            }
            System.out.println("당신의 별명은 "+nick+" 입니다.");
        }catch(FoolException2 e) {
            System.err.println("FoolException 이 발생했습니다.");
        }
    }

    public void sayNick3(String nick) throws FoolException {
        if("fool".equals(nick)) {
            throw new FoolException();
        }
        System.out.println("당신의 별명은 "+nick+" 입니다.");
    }

    // 1. Exception
    // 에러는 프로그램이 오동작을 하지 않기 위한 자바의 배려이다.
    // 하지만 때로는 이러한 에러를 무시하고 싶을 때도 잇고,
    // 에러가 날 때 그에 맍는 적절한 처리를 하고싶을 때도 있다.
    // 자바에서는 try ... catch, throw 등을 이용하여 에러처리를 도와준다.

    public static void main(String[] args){
        // 1-1 예외는 언제 발생하는가?
        // 오타를 쳤을 때 나는 구문 에러 같은 것이 아닌 실제 프로그램에서 잘 발생하는 에러를 살펴보자.
        // 0으로 어떤 숫자를 나누는 경우이다. 다음의 코드를 실행시켜보자.

        // Example.1
        // int c = 4/0;
        /*
        Exception in thread "main" java.lang.ArithmeticException: / by zero
        at ExceptionTest.main(ExceptionTest.java:19)
        */
        // 콘솔에 위와같은 에러가 등장한다.
        // ArithmeticException 이라는 이름의 예외가 발생한다.

        // Example.2
        // 한가지 더 실행해보자.
        // int[] a = {1,2,3};
        // System.out.println(a[3]);
        /*
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
        at ExceptionTest.main(ExceptionTest.java:30)
        */
        // 다음과 같은 에러가 등장한다.
        // a 는 1,2,3 을 가지고 있는 배열이고 자바의 셈으로 하면 0,1,2 가 존재하는 배열이다.
        // 헌데 a[3] 으로 배열에서 구할 수 없는 값이기 때문에
        // ArrayIndexOutOfBoundsException 이 나온 것이다.
        // 이런 예외가 발생하면 자바는 작접을 중단하고 에러메세지를 보여준다.


        // 1-2 예외처리하기
        // 다음은 예외처리를 위한 try, catch 문의 기본 구조이다.
        /*
        * try{
        * }catch(예외1){
        * }catch(예외2){
        * }...
        * */
        // try 문 안의 수행할 문장들에서 예외가 발생하지 않는다면 catch 문은 실행되지 않는다.
        // try 문에서 catch 에 해당하는 문제가 발생하면 catch 문이 수행된다.

        // 첫번째 예제의 에러를 예외 처리해보자. (숫자를 0으로 나눌 때 발생하는 예외)
        // Example.3
        System.out.println("---Exception 1---");
        int c;
        try{
            c = 4/0;
        }catch (ArithmeticException e){
            c = -1;
        }
        // ArithmeticException 가 발생하면 c에 -1 을 대입한다는 뜻이다.
        System.out.println(c); // -1
        // 에러가 발생하지 않고 -1 이 출력된다.


        // 1-3 finally
        // 프로그램 수행 도중 예외가 발생하면 프로그램이 중지되거나
        // 예외처리를 했을 경우 catch 구문이 실행된다.
        // 하지만 어떤 예외가 발생하더라도 반드시 실행되어야 하는 부분이 있어야 한다면?
        // 현재 클래스에서 다음의 메소드를 추가해보자.
        /*
        public void shouldBeRun() {
            System.out.println("ok thanks.");
        }
        */
        // 그리고 다음과 같이 작성해보자.
        //Example.4
        /*
        ExceptionTest et = new ExceptionTest();
        int d;
        try{
            d = 4/0;
            et.shouldBeRun();
        }catch (ArithmeticException e){
            d = -1;
        }
        */
        // 위 예를보면 et.shouldBeRun() 메소드는 절대로 실행 될 수 없다.
        // 4/0 에 의해 예외처리가 발생하여 catch 구문으로 넘어가기 때문이다.
        // shouldBeRun() 이 반드시 실행해야 하는 메소드라고 가정해 보고 아래와 같이 바꿔보자.

        System.out.println("---Exception 2---");
        ExceptionTest et = new ExceptionTest();
        int d;
        try{
            d = 4/0;
        }catch (ArithmeticException e){
            d = -1;
        }finally {
            et.shouldBeRun();
        }
        // finally 구문은 try 문장 수행 중 예외발생 여부에 상관없이 무조건 실행된다.
        // 따라서 위 코드를 실행하면 et.shouldBeRun() 메소드가 수행되어 "ok, thanks" 라는 문장이 출력될 것이다.


        // 1-4 예외 발생시키기 throw, throws
        // 예외를 활용할 수 있는 방법에 대해서 알아보자.
        // 다음과 같은 메소드를 추가하자.
        /*
        public void sayNick(String nick) {
            if("fool".equals(nick)) {
                return;
            }
            System.out.println("당신의 별명은 "+nick+" 입니다.");
        }
        */
        System.out.println("---Exception 3---");
        et.sayNick("fool");
        et.sayNick("cool");
        // sayNick() 메소드는 fool 이라는 문자열이 입력되면
        // return 으로 메소드를 종료해 별명이 출력하지 못하도록 하고있다.

        // 1-5-1 RuntimeException
        // 단순히 별명을 출력 못하게 하는 것이 아니라 적극적으로 예외를 발생시켜보자.
        // 다음과 같이 FoolException 클래스를 작성한다.
        /*
        public class FoolException extends RuntimeException {
        }
        */
        // 비교를 위해 다음과 같은 메소드를 추가한다.
        /*
        public void sayNick1(String nick) {
            if("fool".equals(nick)) {
                throw new FoolException();
            }
            System.out.println("당신의 별명은 "+nick+" 입니다.");
        }
        */
        // return 부분을 throw new FoolException() 이라는 문장으로 변경하였다.
        System.out.println("---Exception 4---");
        // et.sayNick1("fool"); // -> 뒤에가 실행 안되므로 주석처리
        et.sayNick1("cool");
        // 실행해보면 fool 입력값으로 sayNick1() 메소드 실행 시 다음과 같은 예외가 발생한다.
        /*
        Exception in thread "main" FoolException
        at ExceptionTest.sayNick1(ExceptionTest.java:20)
        at ExceptionTest.main(ExceptionTest.java:160)
        */
        // return 으로 메소드를 빠져나오는 대신
        // throw new FoolException() 을 이용해 예외를 강제로 발생시켜 보았다.
        // FoolException 이 상속받은 클래스는 RuntimeException 이다.
        // Exception 은 크게 두개로 나뉜다.
        // RuntimeException , Exception
        // RuntimeException 은 실행 시 발생하는 예외이고
        // Exception 은 컴파일 시 발생하는 예외이다.
        // Exception 은 프로그램 작성 시 이미 예측 가능한 예외를 작성할 때 사용하고
        // RuntimeException 은 예측할 수 없는 경우에 작성한다.

        // 1-5-2 Exception
        // FoolException2 클래스를 생성하고 다음과 같이 작성해보자.
        /*
        public class FoolException2 extends Exception {
        }
        */
        // 이번에는 Exception 을 상속하였다.
        // 다음과 같이 비교를 위해 메소드 하나를 추가해보자.
        /*
        public void sayNick2(String nick) {
            try {
                if("fool".equals(nick)) {
                    throw new FoolException2();
                }
                System.out.println("당신의 별명은 "+nick+" 입니다.");
            }catch(FoolException2 e) {
                System.err.println("Fool Exception 이 발생했습니다.");
            }
        }
        */
        // 메소드 내부에 try {} catch(FoolException2 e) {} 문이 추가되었다.
        // 위의 구문이 없었다면 예측 가능한 CheckException 이기 때문에 예외 처리를 컴파일러가 강제하여 컴파일 에러가 발생한다.
        System.out.println("---Exception 5---");
        et.sayNick2("fool");
        et.sayNick2("cool");
        // et.sayNick2("fool"); 에서 try... catch 문으로 FoolException 을 처리한다.


        // 1-5-3 예외던지기 throws
        // 지금 까지는 sayNick1(), sayNick2() 메소드에서 FoolException 을 발생시키고
        // 예외처리도 각각의 메소드에서 했는데 그렇게 하지않고
        // 메소드를 호출한 곳에서 FoolException 을 처리하도록 하는 방법이 있다.
        // 아래의 메소드를 추가해보자.
        /*
        public void sayNick3(String nick) throws FoolException {
            if("fool".equals(nick)) {
                throw new FoolException();
            }
            System.out.println("당신의 별명은 "+nick+" 입니다.");
        }
        */
        // sayNick3() 메소드 뒤에 throws 라는 구문을 이용하여 FoolException 을 위로 보낼 수 있다.
        // 예외를 뒤로 미루기 라고도 한다.
        // et.sayNick3("fool");
        // 위와같이 하면 main 메소드에서 컴파일 에러가 발생한다.
        // Exception in thread "main" FoolException
        // throws 구문 때문에 FoolException 의 예외 처리 대상이 sayNick() 메소드가아닌
        // sayNick3() 를 호출하는 main 메소드로 변경되었기 때문이다.
        // main 메소드가 컴파일 되기 위해선 다음과 같이 변경되어야 한다.
        System.out.println("---Exception 6---");
        try {
            et.sayNick3("fool");
            et.sayNick3("cool");
        }catch(FoolException e) {
            System.err.println("FoolException 이 발생했습니다.");
        }
        // main 에서 try..catch 로 sayNick3() 에 대한 FoolException 예외 처리를 하였다.
        // FoolException 처리를 sayNick 메소드에서 하는 것이 좋을까?
        // 아니면 main 메소드에서 하는것이 좋을까?
        // 두가지는 큰 차이가 있다.
        // sayNick 메소드에서 예외를 처리하는 경우 다음의 두 문장이 모두 수행된다.
        // et.sayNick2("fool");
        // et.sayNick2("cool");
        // 첫 번째에서 FoolException 이 발생하겠지만 그 다음 문장역시 수행된다.

        // 하지만 main 메소드에서 예외처리를 하면 두 번째 문장이 수행되지 않는다.
        // 이미 첫번째 문장에서 예외가 발생하여 catch 문으로 빠져버리기 때문이다.

        // 프로그래밍시 Exception 을 처리하는 위치는 대단히 중요하다.
        // 프로그램의 수행여부를 결정하기도 하고 트랜잭션 처리와도 밀접한 관계가 있기 때문이다.


        // 1-5-4 Transaction
        // 트랜잭션과 예외처리는 매우 밀접한 관련이 있다.
        // 트랜잭션은 하나의 작업 단위를 뜻한다.

        // 프로그램이 다음과 같이 작성되 있다고 가정해보자.
        /*
        상품발송() {
            포장();
            영수증발행();
            발송();
        }

        포장() {
            ...
        }

        영수증발행() {
            ...
        }

        발송() {
            ...
        }
        */
        // 쇼핑몰 운영자는 포장, 영수증 발행, 발송이라는 세가지중 1가지라도 실패한다면 모두 취소하고 싶어한다.
        // 이런 경우는 어떻게 예외처리를 해야 하는가?

        // 다음과 같이 포장, 영수증발행, 발송메소드에서 예외를 throw 하고
        // 상품발송 메소드에서 throw 된 예외를 처리하여 모두 취소하는 것이 완벽한 트랜잭션 처리방법이다.
        /*
        상품발송() {
            try {
                포장();
                영수증발행();
                발송();
            }catch(예외) {
                모두취소();
            }
        }

        포장() throws 예외 {
            ...
        }

        영수증발행() throws 예외 {
            ...
        }

        발송() throws 예외 {
            ...
        }
        */
        // 위와 같이 작성하면 포장, 영수증발행, 발송이라는 세개의 단위작업 중
        // 하나라도 실패할 경우 "예외"가 발생되어 상품발송이 모두 취소 될 것이다.
        // 만약 위 처럼 "상품발송" 메서드가 아닌
        // 포장, 영수증발행, 발송메소드 각각에 예외처리가 있다고 가정해보자.
        /*
        상품발송() {
            포장();
            영수증발행();
            발송();
        }

        포장(){
            try {
                ...
            }catch(예외) {
                포장취소();
            }
        }

        영수증발행() {
            try {
                ...
            }catch(예외) {
                영수증발행취소();
            }
        }

        발송() {
            try {
                ...
            }catch(예외) {
                발송취소();
            }
        }
        */
        // 이렇게 각각의 메소드에 예외처리가 되어있다면
        // 포장은 되었는데 발송은 안되고 포장도 안되었는데 발송이 되버리는 상황이 연출된다.
        // 실제 프로젝트에서도 두번째 경우처럼 트랜잭션 관리를 잘못하여
        // 고생하는 경우가 많은데 일종의 재앙에 가깝다.
        // 예외처리는 난이도가 있는 부분에 속한다.
        // 프로그래머의 실력을 평가 할 때 이 예외처리를 어떻게 하고 있느지를 보면
        // 그 사람의 실력을 어느정도 가늠 해 볼 수 있다고들 말한다.
        // 예외처리는 전체를 관통하여 모두 알아야만 정확히 할 수 있기 때문이다.



        // System.out.println("---Exception 7---");
    }

}

