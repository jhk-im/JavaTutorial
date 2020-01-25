// 연습문제 2. Multiples of 3 and 5
// 프로젝트 오일러는 프로그래밍 퀴즈를 풀이하는 곳이다.
// 이 곳에서 제공하는 퀴즈 중 가장 첫번째인 "Multiples of 3 and 5" 이다.
// http://projecteuler.net/problem=1

/*
* 10 미만의 자연수에서 3과 5의 배수를 구하면 3,5,6,9이다.
* 이들의 총 합은 23이다. 1000 미만의 자연수에서 3, 5의 배수의 총합을 구하라.
* */

// 3의 배수는 3으로 나누어 떨어지는 수이다.
// 5의 배수는 5로 나누어 떨어지는 수이다.
// 이 개념을 중심으로 다음의 코드를 살펴보자.

public class Euler1 {
    int max;

    // 생성자 int max 를 입력으로 받는다.
    // 문제에 나오는 1000미만의 자연수 인 1000을 입력값으로 받는 것이다.
    public Euler1(int max) {
        this.max = max;
    }

    // 3과 5의 배수의 총합을 리턴하는 메소드이다.
    public int sumOf3And5() { // 리턴자료형은 int 이다.
        int sum = 0;
        for(int i=0; i<max; i++) { // 1000번 반복하는 반복문이다.
            if (i%3 == 0 || i%5 == 0) {  // % 는 나머지 연산자다.
                // i 를 3 으로 나눠서 0 이된다면 3의 배수
                // i 를 5 로 나눠서 0 이 된다면 5의 배수
                // 둘 중 하나라도 true 반환하면
                sum += i; // 3, 5의 배수의 총합이니 sum 이라는 int 변수에 더한다.
                            // 계속 true 반환한 i 를 더한다.
            }
        }
        return sum; // -> 1000번의 반복문이 끝나면 모두 더한 sum 을 리턴한다.
    }

    public static void main(String[] args) {
        //System.out.println(new Euler1(10).sumOf3And5());
        // Euler1 객체에 1000을 입력하고 sumOf3And5() 메소드를 호출하여 결과값을 리턴한다.
        System.out.println(new Euler1(1000).sumOf3And5()); //233168
    }
}