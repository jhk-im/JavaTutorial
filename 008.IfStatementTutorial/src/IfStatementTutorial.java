import java.util.ArrayList;

public class IfStatementTutorial {

    public static void main(String[] args){

        // 1. if 문이란?

        // "돈이 있으면 택시를 타고 가고 돈이 없으면 걸어 간다."
        // 프로그래밍도 위처럼 조건을 판단해서 그 상황에 맞게 처리해야 할 경우가 생기게 된다.
        // if 문은 이런 조건을 판단하여 해당 조건에 맞는 상황을 수행하는 데 쓰인다.
        // 위와 같은 상황을 만들어 보자.

        // 돈이 있다.
        boolean money = true;

        System.out.println("---if문 example1---");
        // 돈이있는게 사실이라면
        if(money){
            System.out.println("택시를 탄다"); // 출력
        }
        // 돈이있는게 사실이 아니라면
        else{
            System.out.println("걸어 간다"); // 출력안함
        }

        // 위의 구조가 if와 else 를 이용한 기본적인 구조이다.
        // 조건문을 테스트 해서 참이면 if 문 바로 다음의 문장들을 수행하고
        // 조건문이 거짓이면 else 문 다음의 문장들을 수행한다.

        // *조건문이란 참과 거짓을 판단하는 문장을 말한다.
        // 위에서 조건문은 money 이다.

        // 2. 비교연산자
        // if 문을 사용할 때 조건문 보다는 비교 연산자를 쓰는 경우가 훨씬 많다.
        int x=3;
        int y=2;
        int z=3;
        System.out.println("---if문 비교연산자---");
        System.out.print("x<y -> ");
        System.out.println(x<y); // false
        System.out.print("x>y -> ");
        System.out.println(x>y); // true
        System.out.print("x=z -> ");
        System.out.println(x==z); // true
        System.out.print("x!=z -> ");
        System.out.println(x!=z); // false
        System.out.print("x>=y -> ");
        System.out.println(x>=y); // true
        System.out.print("y<=x -> ");
        System.out.println(y<=x); // true



        // 위에 했던 택시를 타는 경우를 다음처럼 바꾸어 보자.
        // " 3000원 이상의 돈을 가지고 있으면 택시를타고 그렇지 않으면 걸어가라"
        System.out.println("---if문 example2---");
        // 돈이 2999원 있다.
        int won = 2999;
        // 3000원 이상이라면
        if (won >= 3000){
            System.out.println("택시를 탄다"); // 출력안함
        }
        // 3000원 미만이라면
        else{
            System.out.println("걸어 간다"); // 출력
        }
        // 돈이 3000원 미만이기 때문에 else 다음 문장을 수행하게 된다.

        // 3. and(&&), or(||), not(!)
        // x || y -> x 와 y 중 적어도 하나가 참이면 true
        // x && y -> x 와 y 모두 참이어야 true
        // !x -> x 가 거짓이면 true

        // " 돈이 3000원 이상 있거나 카드가 있다면 택시를 타고 그렇지 않으면 걸어간다"
        boolean hasCard = true;
        System.out.println("---if문 example3---");
        // 3000원 이상이라면
        if (won >= 3000 || hasCard){
            System.out.println("택시를 탄다"); // 출력
        }
        // 3000원 미만이라면
        else{
            System.out.println("걸어 간다"); // 출력안함
        }
        // 돈이 3000원 미만이지만 hasCard 가 true 이기 때문에 true 가 되어 if 다음 문장을 수행한다.

        // 4. contains
        // List 자료형에는 해당 아이템이 있는지 조사하는 contains 라는 메소드가 있다.
        // contains 메소드는 조건문에 많이 활용된다.

        // "만약 주머니에 돈이 있으면 택시를 타고 없으면 걸어가라"
        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("paper");
        pocket.add("smartphone");
        pocket.add("money");

        System.out.println("---if문 example4---");

        // 주머니에서 money 를 찾고 true false 를 판단한다.
        if(pocket.contains("money")){
            System.out.println("택시를 탄다"); // 출력
        }else{
            System.out.println("걸어 간다"); // 출력안함
        }
        // pocket 리스트 안에 'money'가 있으므로 true 가되어 if 다음을 수행한다.

        // 5. else if (다중 조건 판단)
        // "지감에 돈이 있으면 택시를 타고, 지갑엔 돈이 없지만 카드가 있으면 택시를 타고, 둘다 없으면 걸어간다"
        // 위의 문장은 if와 else 만으로 판단하기 어렵다.
        // 그런점을 보완하기 위해서 다중 조건 판단을 사용한다.
        System.out.println("---if문 example5---");
        // 지갑에 돈이 있다면
        if(pocket.contains("money")){
            System.out.println("택시를 탄다"); // 출력
        }
        // 카드를 가지고 있다면
        else if(hasCard){
            System.out.println("택시를 탄다"); // 출력안함
        }
        // 둘다 없다면
        else{
            System.out.println("걸어간다"); // 출력안함
        }

        // else if 는 개수의 제한없이 사용할 수 있다.

    }

}
