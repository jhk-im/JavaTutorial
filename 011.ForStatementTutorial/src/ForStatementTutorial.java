import java.util.ArrayList;

public class ForStatementTutorial {

    public static void main(String[] args){

        // 1. for 문
        // for 문도 while 문 처럼 반복적으로 수행하기 위해 사용한다.
        // numbers 라는 배열의 첫번째 요소부터 마지막 까지 출력하여 보자.
        System.out.println("---for example1---");
        String[] numbers = {"one","two","three"};
        for(int i =0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }
        // for 의 조건문은 세미콜론을 구분자로 세 부분으로 나뉘어진다.
        // 초기치 ; 조건문; 증가치;
        // 초기치는 int i = 0 이다.
        // 조건문은 i<numbers.length 이고, i가 numbers 배열의 갯수보다 적을 동안 실행한다는 의미이다.
        // 증가치는 i++ 이다.
        // 즉, i 값이 0이고 i 가 numbers 배열의 갯수보다 적을 동안에 실행되며 i는 1씩 증가한다.

        // "총 5명의 학생이 시험을 보았다. 60점이 넘으면 합격 아니면 불합격이다. 결과를 출력해보자."
        System.out.println("---for example2---");
        int[] marks = {90,25,67,45,80};
        for(int i=0; i<marks.length; i++){
            if(marks[i] >= 60){
                System.out.println((i+1)+"번 학생은 합격");
            }else{
                System.out.println((i+1)+"번 학생은 불합격");
            }
        }
        // if 문에서 조건문은 mark[i] >= 60 이다.
        // int 배열로 선언된 marks 안에는 총 5개의 점수가 담겨져 있다.
        // mark[i] 는 i가 0부터 marks 의 개수까지 반복하여 하나씩 점수를 가져온다.
        // mark[i] 가 가져온 점수와 조건문의 >= 60을 비교한다.
        // 60 보다 크거나 같은 수 -> 60 이상의 수면 if 문장을 아니면 else 문장을 수행한다.
        // 마지막으로 i가 marks 배열의 개수를 넘어가면 자동으로 for 문이 중지된다.

        // 2. for 와 continue
        // while 문에서 보았던 continue 가 for 문에도 동일하게 정용된다.
        // 즉, for 문 안의 문장을 수행하는 도중에 continue 를 만나면 for 문의 처음으로 돌아간다.
        // 위의 예제를 사용해서 60점 이상에게만 축하 메세지를 보내보자.
        System.out.println("---for example3---");
        for(int i=0; i<marks.length; i++){
            if(marks[i] < 60){
                continue;
            }
            System.out.println((i+1)+"번 학생의 합격을 축하합니다.");
        }
        // for 문의 조건문 대로 동일하게 실행을한다.
        // if 문의 조건문 대로 60점 미만인 경우 continue 가 실행되어 처음으로 돌아간다.
        // 60점 이상인 경우 continue 가 실행되지 않아 축하 메세지를 출력하게 된다.

        // 3. for 를 이용한 구구단.
        // 간단하게 구구단을 출력해보자.
        System.out.println("---for example4---");
        for(int i=2; i<10; i++){
            for(int j=1; j<10; j++){
                System.out.print(i*j+" ");
            }
            System.out.println("");
        }
        // for 문이 2번 사용된 걸 볼수있다.
        // 첫번째 for 문을 해석하면 초기값이 2인 i가 10미만인 동안에 반복한다는 의미이다.
        // 즉, 2부터 9까지의 숫자가 i에 대입되는 것이다.
        // i가 값이 대입되면 두번째 for 문을 만나게 된다.
        // 두번째 for 문을 해석하면 초기값이 1인 j가 10미만인 동안에 반복한다는 의미이다.
        // 즉, 1부터 9까지의 숫자가 j에 대입되는 것이다.
        // 다음으로 두번째 for 문 안에있는 문장이 출력된다.
        // i*j 는 ixj 라는 의미이다.
        // 2x1 -> 2x2 -> 2x3-> 2x4... 순으로 9까지 차례대로 수행하여 출력한다.
        // 9까지 마치면 다시 첫번째 for 문이 시작되고 i는 3이 된다.
        // 3x1 ... -> 4x1 ... -> 9x1 ... 9x9 까지 출력하고 i가 10이 되므로 for 문을 빠져나가게 된다.

        // while 문과 for 문은 흡사하다.
        // 실제로 for 문을 while 로 바꿀 수 있는 경우가 많고,
        // while 문도 for 문으로 바꾸어서 사용할 수 있는 경우가 많다.
        System.out.println("---for end---");
        System.out.println("---for each start ---");


        // 1. for each 문이란 무엇인가?
        // for each 는 J2SE 5.0부터 추가되었다.
        // for each 라는 키워드가 있는게 아니라 동일한 for 문을 이용하는 것이다.
        // 조건식 부분이 조금 다르다.
        // 위에서 진행했던 for 문 예제를 for each 구조로 변경해보자.
        System.out.println("---for each example1 ---");
        for(String number: numbers){
            System.out.println(number);
        }
        // for each 문은 직관적이다.
        // 다음은 for each 문의 구조이다.
        // for (type var : iterate) { body-of-loop }
        // 조건문에서 iterate 는 numbers 배열이고 numbers 배열을 루프로 돌리겠다는 의미이다.
        // type 은 iterate 의 타입이다. numbers 는 String 배열이므로 String 으로 기입 되었다.
        // var 은 numbers 가 순차적으로 루프를 돌면서 안에 있는 정보가 대입되는 곳이다.
        // 대입되는 var 을 출력한다는 문장을 실행하게 되고 one two three 가 차례대로 출력된다.

        // 다음은 ArrayList 로 for each 문을 구현해 보자.
        ArrayList<String> numbers1 = new ArrayList<String>();
        numbers1.add("one");
        numbers1.add("two");
        numbers1.add("three");
        System.out.println("---for each example2 ---");
        for(String number : numbers1){
            System.out.println(number);
        }
        // 사용법은 String[] 과 완전히 동일하다.
        // *for each 문은 따로 반복회수를 명시적으로 줄 수 없다.
        // 따라서 1 스탭씩 순차적으로 반복될때만 사용가능하다.
    }

}
