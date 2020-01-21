public class WhileStatementTutorial {

    public static void main(String[] args){

        // 1. while 문 이란?
        // 반복해서 문장을 수행해야 할 경우 while 문을 사용한다.
        // 조건문이 true 인 동안 while 아래의 문장들을 계속해서 수행하게 된다.

        // "열 번 찍어 안넘어 가는 나무 없다" 라는 속담을 적용시켜 보자.
        System.out.println("---while example1---");
        int treeHit = 0;
        while (treeHit <10){
            treeHit++;
            System.out.println("나무를 "+treeHit+"번 찍었다.");
            if(treeHit == 10){
                System.out.println("나무가 넘어간다.");
            }
        }
        // 위의 예에서 while 문의 조건문은 treeHit < 10 이다.
        // int 로 선언된 treeHit 가 10보다 적은 동안에 while 내부의 문장을 계속 수행한다.
        // treeHit++ 는 한번 실행할 때 마다 treeHit 를 1씩 증가시킨다는 의미이다.  = > treeHit += 1
        // if 문에서 조건문을 보면 treeHit == 10 이라고 되어있다.
        // treeHit 가 10이 되면 "나무가 넘어간다." 를 출력하게 된다.
        // treeHit 가 10이 되었기 때문에 treeHit<10 은 false 가 되어 자동으로 while 문을 빠져나간다.

        // 2. 무한루프
        // 말그대로 무한히 반복한다는 의미이다.
        // 대부분의 프로그램 중 무한루프 개념을 사용하지 않는 프로그램이 거의 없다.

        // while(true) { <수행할 문장> } -> 이것이 기본적인 형태이다.
        // while 문의 조건문이 true 이므로 계속해서 while 문을 수행한다.
        // 빠져 나간다는 어떠한 코드도 작성되지 않았기 때문에 무한 루프가 된다.
/*
        while (true){
            System.out.println("무한루프가 실행중입니다.");
        }
*/
        // 블럭주석 처리한 부분을 실행해 보면 무한루프가 실행중인 것을 확인할 수 있다.

        // 3. break -> while 문 빠져나가기
        // 커피 자판기를 생각해 보자.
        // 커피가 충분히 있을 때는 항상 "돈을 받으면 커피를 줘라" 라는 조건문을 가진 while 문이 실행된다.
        // 커피가 다 떨어지면 while 문을 멈추게하고 "판매중지" 문구를 보여주어야 할 것이다.
        // "판매중지" 를 구현해 주는 것이 break 이다.

        // 위의 상황을 구현해 보자.
        System.out.println("---while example2---");
        int coffee = 5;
        int money = 300;

        while (money > 0){
            System.out.println("커피제공");
            coffee--;
            System.out.println("커피가 "+coffee+"개 남았습니다.");
            if(coffee == 0){
                System.out.println("판매중지");
                break;
            }
        }
        // money 가 300이고 while 문의 조건문이 money > 0 이므로 계속 true 이다.
        // 즉, while (true) 와 같이 무한 루프를 돌게 된다.
        // 한번 수행할때마다 "커피제공"을 출력하고 coffee 의 수를 coffee-- 에 의해 하나 씩 차감한다.
        // if 문에서 조건문을 보면 coffee == 0 -> coffee 의 개수가 0이 되었을 때
        // "판매중지" 를 출력하고 break 이 호출되어 while 문을 빠져나가게 된다.

        // 3. continue -> while 문 조건문으로 돌아가기
        // 만약 1부터 10까지의 수중에서 홀수만을 출력하는 것을 while 문을 이용해서 작성한다고 생각해 보자.
        // while 문의 조건에 맞지 않을 때 빠져나가는 것이 아니라 맨 처음으로 돌아가게 하는 것이 필요하다.
        // 그것을 continue 를 통해 구현할 수 있다.
        System.out.println("---while example3---");
        int a = 0;
        while (a<10){
            a++;
            if (a % 2 == 0){
                continue;
            }
            System.out.println(a);
        }
        // while 문의 조건문은 a<10 -> a가 10보다 작은 동안
        // a++ -> a를 1씩 증가시킨다.
        // a % 2 == 0 -> a 를 2로 나누었을 때 나머지가 0인 경우 = 짝수인 경우이다.
        // 즉, a가 짝수이면 continue 문장을 수행한다. a를 출력하는 문장을 실행하지 않고 처음으로 돌아간다.
        // 홀수라면 continue 가 실행되지 않아서 a를 출력하는 문장을 실행하게 되어 홀수만 출력된다.

        // % 는 나머지 연산자 이다.
        // 나머지 값을 구한다는 의미이다.
        System.out.println("---나머지 연산자---");
        System.out.print("10 나누기 5의 나머지 값은 -> ");
        System.out.println(10%5); // 0
        System.out.print("9 나누기 5의 나머지 값은 -> ");
        System.out.println(9%5); // 4

        // 10을 5로 나누면 나머지가 0이 되어 0을 출력한다.
        // 9를 5로 나누면 나머지가 5가 되어 4를 출력한다.
    }

}
