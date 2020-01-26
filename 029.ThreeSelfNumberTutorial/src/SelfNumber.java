// 연습문제 3. SelfNumber

/*
* 어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
* ex ) d(91) = 9+1+91 = 101
* 이때, n을 d(n)의 제너레이터(generator) 라고한다.
* 위의 예에서 91은 제너레이터이다.
* 어떤 숫자들은 하나 이상의 제너레이터를 가지고 이쓴ㄴ데,
* 101 제너레이터는 91 뿐만 아니라 100도 있다.
* 그런데 반대로, 제너레이터가 없는 숫자들도 있으며,
* 이런 숫자를 인도의 수학자가 Self-number 라 이름을 붙였다.
* ex) 1,3,5,7,9,20,31 은 셀프 넘버들이다.
*
* 문제 : 1이상이고 5000보다 작은 모든 셀프넘버들의 합을 구하라.
*
* */

// 제너레이터가 하나 이상인 숫자  ex) 101
// d(100) = 1+0+0+100= 101
// d(91) = 9+1+91 = 101

// 제너레이터가 없는 숫자
// 1,3,5,7,9,20,31  => 셀프넘버

// 아래는 1 부터 5000 까지 제너레이터로 만들어지는 숫자를 먼저 구하고
// 1 부터 5000까지 그 숫자가 있는지 조사하여 self Number 를 찾는 알고리즘이다.

import java.util.ArrayList;

public class SelfNumber {
    // Int 를 담는 ArrayList 를 정적 변수로 선언하였다.
    // 정적 변수는 항상 값이 변하지 않는 경우 static 을 사용하여 선언하여
    // 메모리 이점을 얻을 수 있다.
    private static ArrayList<Integer> numbersHasGenerator;

    // 스태틱 메소드는 유틸리티 성 메소드를 작성할 때 많이 사용된다.
    // 오늘의 날짜 구하기, 숫자에 콤마 추가하기 등의 메소드를 작성 할때 유용하다.
    // *유틸리티란 사용자의 편리성을 향상하는 유용하고 실용적인 소프트웨어를 말한다.

    // boolean 값을 리턴하는 스테틱 메소드이다.
    // 스태틱 메소드 안에서는 인스턴스 변수 접근이 불가능하다.
    // numbersHasGenerator 는 스태틱으로 선언된 ArrayList 변수이므로 메소드 내부에서 접근이 가능하다.
    // 입력값으로 int 변수를 받고 그 값을
    // numbersHasGenerator.contains() 메소드를 사용하여 참 거짓을 판별한다.
    // contains() 메소드는 리스트 안에 입력하는 항목값이 있는지를 판별하여 결과를 boolean 값으로 리턴한다.
    // 즉, hasGenerator(num) 메소드는 입력한 num 라는 int 값이
    // numbersHasGenerator 라는 ArrayList 안에 존재하는지 여부를 판별하여 false , true 로 리턴해주는 역할을 한다.
    private static boolean hasGenerator(int num) {
        return numbersHasGenerator.contains(num);
    }


    // 리턴도 없고 입력도 없는 스태틱 메소드이다.
    // 1부터 5000까지 제너레이터로 만들어지는 숫자를 구하는 메소드
    private static void calculateNumbersHasGenerator() {
        // numbersHasGenerator ArrayList 객체를 생성한다.
        numbersHasGenerator = new ArrayList<Integer>();
        for (int i = 0; i <= 5000; i++) { // 5000번 반복하는 반복문

            // num 이라는 String 변수에 valueOf() 메소들를 이용하여 1부터 5000까지 순차적으로 하나씩 담는다.
            // valueOf 와 toString 은 입력된 값을 String 으로 변환한다.
            // 입력값이 null 이라면 toString() 은 Null PointerException(NPE) 을 발생시키고
            // valueOf 는 "null" 이라는 문자열로 처리한다.
            String num = String.valueOf(i);

            int no = 0; // no 라는 int 변수 선언

            for (int n = 0; n < num.length(); n++) // num 길이만큼 반복한다.

                // ex) 101 이라면 문자열 길이가 3 이므로 3번 반복한다.
                // 101 에서 첫번째(1), 두번째(0), 세번째(1) 을 구분해야한다.
                no += Integer.parseInt(num.substring(n, n + 1));
                // Integer.parseInt() 메소드는 입력값을 int 로 변환한다.
                // num.substring() 메소드는 문자열에서 특정 부분을 뽑아낼 경우 사용한다.
                // -> 입력값으로 substring(시작위치,끝위치) 으로 입력한다.
                // 첫 반복문에서 n=0 , n+1 = 1 이므로 num.substring(0,1) 이된다.
                // 결과적으로 int 1이되어 no 라는 int 변수에 더해진다.
                // 3번 반복하면서 no 에 1 + 0 + 1  이 되어 2가된다.


            // 반복문이 끝나고 최종적으로 계산이 끝난 no 와
            // 해당 제너레이터 숫자인 i 를 더해서 numbersHasGenerator ArrayList 에 추가한다.
            numbersHasGenerator.add(no + i);

            // * self number 는 해당 계산으로 나오지 않기 때문에
            // numbersHasGenerator 에 더해지지 않을 것이다.
        }
    }


    public static void main(String[] args) {
        // 1. 1부터 5000까지 제너레이터로 만들어지는 숫자를 구하는
        // calculateNumbersHasGenerator(); 를 실행한다.
        calculateNumbersHasGenerator();

        // 2. 1부터 5000까지 다시 반복하면서 selfNum 를 구한다.
        int sum = 0; // sum 이라는 변수를 만들고
        for (int i = 0; i < 5001; i++) // 5000번 반복하는 반복문
            // hasGenerator() 메소드에 1부터 5000까지 순차적으로 입력한다.
            // hasGenerator 에서는 입력된 값으로
            // numberHasGenerator 에 contains() 메소드를 사용하여
            // 저장되어 있는지 아닌지를 판별하고 true 혹은 false 를 리턴한다.
            // numberHasGenerator 에는 self number 를 제외한 Generator 가 담겨있으므로
            // hasGenerator() 의 입력값이 self number 라면 false 를 리턴하게 된다.
            if (!hasGenerator(i)) // hasGenerator() 가 false 를 리턴한다면
                sum += i; // sum 이라는 int 변수에 계속 더한다.

        // 반복문이 마무리 되면 구하려 하는 self number 의 합이 sum 에 더해져서
        // 최종적으로 다음과 같이 출력한다.
        System.out.println("합 : " + sum); //1227365
    }

}
