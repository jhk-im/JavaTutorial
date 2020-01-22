public class MethodTutorialMain {
    public int sum(int a, int b){
        return a+b;
    }
    public String say(){
        return "Hi";
    }
    public void sum2(int a, int b){
        System.out.println(a+" + "+b+" = "+(a+b));
    }
    public void say2(){
        System.out.println("Hi");
    }
    public void say_nick(String nick){
        if("fool".equals(nick)){
            System.out.println("say_nick 탈출");
            return;
        }
        System.out.println("닉네임 : "+nick);
    }
    public void test(int test){
        test++;
    }
    public int varTest(int varTest){
        varTest++;
        return varTest;
    }
    int obj;
    public void objTest(MethodTutorialMain mtm){
        mtm.obj++;
    }
    public void objTest2(){
        this.obj++;
    }
    public static void main(String[] args){
        // 학습자료 출처 https://wikidocs.net/225
        // 1. Method 란 무엇인가?
        // 다른 언어에는 함수라는 것이 별도로 존재한다.
        // 하지만 자바는 클래스를 떠나 존재하는 것은 없다.
        // 그래서 자바의 함수는 따로 존재하지 않고 클래스 내에 존재한다.
        // 이 클래스 내의 함수를 메소드라고 부른다.

        /*
        * 보통 함수와 메소드가 공존하는 언어 ex)파이썬 에서는 두개를 구분하여 말하기도한다.
        * 자바에서는 메소드와 함수를 구분하여 말하지 않는다. 정확히는 메소드라 한다.
        * */

        // 메소드는 입력을 가지고 어떠한 일을 수System.out.println("---method example1---");행한 다음 결과물을 내어놓는 일을한다.

        // 메소드는 왜 사용하는 것일까?
        // 프로그래밍을 하다 보면 똑같은 내용을 반복해서 적고있는 것을 반결할 때가 있다.
        // 이 때가 바로 메소드가 필요한 때이다.
        // 여러번 반복해서 사용된다는 것은 언제고 또 다시 사용할 만한 가치가 있는 부분이라는 뜻이다.
        // 즉, 이것을 한 뭉치로 묶어 "어떤 입력값을 주었을 때 어떤 리턴값을 돌려준다" 라는 식의 메소드를  작성하는것이 현명하다.

        // public static void main 윗부분에 다음과 같은 메소드를 작성해보자.

        /*public int sum(int a, int b){
            return a+b;
        }*/
        // "sum 이라는 메소드는 입력값으로 두개의 값 (int 자료형 a, int 자료형 b)을 받으며
        // 리턴값은 두개의 입력값을 더한 in 값이다."
        // return -> 메소드의 결과 값을 돌려주는 명령어다.
        // 메소드를 사용해보자.

        System.out.println("---method example1---");
        int a = 3;
        int b = 4;
        MethodTutorialMain mtm = new MethodTutorialMain();
        int c = mtm.sum(a,b);
        System.out.println(c); // 7
        // 위 코드는 sum 메소드에 3, 4 라는 입력값을 전달하여 7 을 return 받는다.
        // 7이 출력되는 것을 확인할 수 있다.

        // * 용어의 혼용
        // 입력값을 다른말로 메소드의 인수, 입력 인수등으로 말하기도하고 리턴값을 출력 값, 결과값, 돌려주는 값 등으로 말하기도 한다.
        // 많은 용어들이 다른말로 표현되지만 의미는 동일한 경우가 많다. 기억해두자.

        // 2. Method 의 구조
        // 다음은 메소드의 구조이다.
        /*
        * public 리턴자료형 메소드명(입력자료형1 입력변수1, 입력자료형2 입력변수2, ...) {
        * ...
        * return 리턴값;// 리턴자료형이 void 인 겨우에는 return 문이 필요없다.
        * }
        *  */

        // 리턴자료형 -> 메소드 수행 후 돌려줄 값의 자료형을 의미한다.
        // 리턴값 -> return 이라는 명령을 사용한다.
        // 메소드는 입출력 유무에 따라 4가지로 분류할 수 있다.
        // a. 입력과 출력이 모두 있는 메소드
        // b. 입력과 출력이 모두 없는 메소드
        // c. 입력만 있는 메소드
        // d. 출력만 있는 메소드
        // 하나씩 알아보자.

        // a -> 평범한 메소드
        // 입력과 출력이 모두 있는 메소드가 평범한 메소드이다.
        // 위에서 진행했던 example1의 sum 메소드가 전형적인 평범한 메소드이다.
        // int c = mtm.sum(a,b); 에서 보면
        // 메소드 sum 의 리턴 자료형이 int 이기 때문에 그것이 담기는 c 의 자료형도 int 여야만 한다.
        // String d = mtm.sum(a,b); -> 다음과 같은 경우는 에러가 발생한다.

        // d -> 입력값이 없는 메소드
        // sum 메소드 아래에 다음과 같은 메소드를 작성해보자.
        /*public String say(){
            return "Hi";
        }*/
        // 리턴 자료형 -> String
        // 입력 부부은 비어있다.
        // 출력값은 "Hi"; 이다.
        // 이제 say 메소드를 사용해보자
        System.out.println("---method example2---");
        String sayString = mtm.say();
        System.out.println(sayString); // Hi

        // say 메소드는 입력값이 없기 때문에 mtm.say() 와 같이 입력부분을 비워준다.
        // 입력값 없이 Hi 라는 문자열을 돌려준다.
        // say 메소드의 리턴 자료형은 String 이기 때문에 그것을 담을 sayString 또한 String 자료형 이어야만 한다.
        // Hi 라는 문자열이 출려되는 것을 볼 수 있다.
        // 리턴 받을 변수 = 객체.메소드() 와 같은 방법으로 사용된다.

        // c -> 리턴값이 없는 메소드
        // 다음과 같은 메소드를 추가해 보자.
        /*public void sum2(int a, int b){
            System.out.println(a+" + "+b+" = "+(a+b)); // 3 + 4 = 7
        }*/

        // 리턴 자료형이 void -> 리턴값이 없음을 의미
        // 입력값은 int a, int b
        // 메소드 내부에 출력하는 코드가 적혀있다.
        // 메소드를 사용해보자.
        System.out.println("---method example3---");
        mtm.sum2(a,b);
        // 3 + 4 = 7 이 출력된다.
        // 출력되는 것이 리턴되는것과 같은거라고 생각할 수있다.
        // 여기서 3 + 4 = 7 을 출력해주는 System.out.println 문은
        // 메소드 내에서 사용되는 문장일 뿐이다. 돌려주는 값은 없다. 돌려주는 것은 return 명령어로만 가능하다.

        // b -> 입력값과 리턴값이 모두 없는 메소드
        // 다음과 같은 메소드를 추가해보자.
        /*public void say2(){
            System.out.println("Hi");
        }*/
        // 리턴 자료형이 void -> 리턴값이 없다.
        // 입력값도 비워져 있으므로 입력값도 없다.
        // 메소드를 사용해보자.
        System.out.println("---method example4---");
        mtm.say2();
        // 객체.메소드명() 으로 사용된다.
        // 리턴값 없이 메소드 내부에 있는 "Hi" 를 출력하는 System.out.println 문만 동작할 것이다.
        // 결과적으로 Hi 를 출력하게 된다.

        // 3. return 의 또 다른 쓰임새
        // 특별한 경우에 메소드를 빠져나가기를 원할 때 return 만 단독으로 써서 메소드를 즉시 빠져나갈 수 있다.
        // 다음과 같은 메소드를 추가해보자.
        /*public void say_nick(String nick){
            if("fool".equals(nick)){
            System.out.println("say_nick 탈출");
                return;
            }
            System.out.println("닉네임 : "+nick);
        }*/
        // 리턴 자료형 void -> 리턴 값 없음
        // 입력값 -> String nick  -> String 값을 입력받는다.
        // if 문 -> nick 이 "fool" 이라는 단어이면 if 문 안에있는 System.out.println 문을 실행하고 즉시 메소드를 빠져나간다.
        // if 문이 거짓이면 if 문 밖에있는 System.out.println 문을 실행하여 문자열을 출력한다.
        // 메소드를 사용해보자.
        System.out.println("---method example5---");
        String fool = "fool";
        String cool = "cool";
        mtm.say_nick(fool); // say_nick 탈출
        mtm.say_nick(cool); // 닉네임 : cool
        // say_nick 의 입력값이 fool 이면 -> "say_nick 탈출" 을 출력하고 메소드를 탈출한다.
        // say_nick 의 입력값이 fool 이 아니면 -> 메소드 안에 if 문을 지나 "닉네임 : cool" 을 출력한다.

        // * 참고로 위의 방법은 리턴 자료형이 void 일때만 해당된다.
        // 리턴자료형이 명시되어 있는 메소드에서 return 문만 작성하면 컴파일 오류가 발생한다.

        // 4. 메소드 내에 선언된 변수의 효력 범위
        // 메소드 안에서 사용하는 변수의 이름을 메소드 밖에서 사용한 이름과 동일하게 사용하면 어떻게 될까?
        // 다음과 같은 메소드를 작성해보자
        /*public void test(int test){
            test++;
        }*/
        // 리턴값은 없고 입력값으로 int 값이 들어오면 입력값을 1 증가시키는 역할을 한다.
        // 메소드를 사용해보자.
        System.out.println("---method example6---");
        int test = 1;
        mtm.test(test);
        System.out.println(test); // 1
        // test 메소드에서 test 값을 1 증가시켰지만 1을 출력 할 것이다.
        // 메소드 내에서 사용되는 변수는 메소드 안에서만 쓰여지는 변수이기 때문이다.
        // test(int test) 에서 입력 변수 test 는 메소드 안에서만 사용되는 변수라는 뜻이다.
        // 즉, 메소드에서 쓰이는 변수는 메소드 밖의 변수들과 상관이 없다.
        // * 이렇게 메소드 내에서만 쓰이는 변수를 로컬 변수 라고 말한다.

        /*
        * 만약 test 의 입력값이 객체였다면 얘기가 다르다.
        * 객체를 메소드의 입력으로 넘기고 메소드가 객체의 값을 변경한다면 객체는 변경된 값을 유지한다.
        * 메소드에 값을 전달하느냐 메소드를 전달하느냐에 따라 차이가 난다.
        * */

        // 그렇다면 메소드 외부의 int 값을 1 증가시킬 수 있는 방법은 없을까?
        // 다음과 같이 하면된다. 새로운 메소드를 추가해보자.
        /*public int varTest(int varTest){
            varTest++;
            return varTest;
        }*/
        // 위처럼 리턴 자료형을 설정하고 return 문으로 출력하는 것이다.
        System.out.println("---method example7---");
        int varTest = 1;
        varTest = mtm.varTest(varTest);
        System.out.println(varTest); // 2
        // varTest 는 입력값으로 들어온 varTest = 1 을 1 증가시켜서 그 값을 리턴한다.
        // 그 결과 2가 출력된다.

        // 객체를 넘긴다는 것은 어떤 의미일까?
        // 다음과 같은 변수와 메소드를 public static void main 밖에 생성한다.
        /*
        int obj;
        public void objTest(MethodTutorialMain mtm){
            mtm.obj++;
        }*/
        // 이전 까지는 int 변수를 public static void main 안에서 선언했으나
        // 위의 예제는 main 밖에 MethodTutorialMain 클래스의 객체 변수로 선언하였다.
        // objTest 메소드는 MethodTutorialMain 클래스의 객체를 입력받아 해당 객체의 값을 1 증가시킨다.
        // 메소드를 사용해보자.
        System.out.println("---method example8---");
        mtm.obj = 1;
        System.out.println(mtm.obj); // 1
        mtm.objTest(mtm);
        System.out.println(mtm.obj); // 2
        // 먼저 mtm.obj 에 1을 대입하고 출력하면 당연히 1을 출력한다.
        // 다음은 objTest() 메소드를 실핸한다.
        // objTest 의 입력값은 MethodTutorialMain 클래스 객체이다.
        // mtm 이 바로 MethodTutorialMain 의 클래스 객체이므로 메소드에 입력한다.
        // objTest 메소드가 실행되면 obj 에 1을 증가시킨다.
        // 그 다음 mtm.obj 를 출력하면 2 가 출력된다.
        // * 바로이것이 메소드 입력을 값이 아닌 객체로 한다는 의미이다.
        // 이렇게 메소드가 객체를 전달 받으면 메소드 내의 객체는 전달받은 객체 그 자체로 수행된다.
        // int, String 등의 primitive 자료형인 경우 값이 전달되는 것이고
        // 그 이외의 경우는 객체가 전달되는 것이다.

        // * mtm.objTest(mtm) 문을 자세히 들여다보면 불필요한 부분이 있다.
        // mtm 객체를 이용하여 objTest 라는 메소드를 호출하고자 하는데 굳이 mtm 이라는 객체를 전달해야 하는 걸까?
        // 그러지 않아도 된다. this 라는 키워드를 이용하면 객체에 접근할 수 있기 때문이다.
        // 다음과 같이 메소드를 구현하고 사용해보자.
        /*public void objTest2(){
            this.obj++;
        }*/
        System.out.println("---method example9---");
        mtm.obj = 1;
        System.out.println(mtm.obj); // 1
        mtm.objTest2();
        System.out.println(mtm.obj); // 2
        // mtm.objTest(mtm) 과 mtm.objTest2 는 동일한 작업을 하게 된다.
        // 그러므로 결과 또한 동일하다.
    }

}
