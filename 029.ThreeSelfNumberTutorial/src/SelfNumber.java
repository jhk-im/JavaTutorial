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
// 분석할것
import java.util.ArrayList;

public class SelfNumber {
    private static ArrayList<Integer> numbersHasGenerator;

    public static void main(String[] args) {
        calculateNumbersHasGenerator();
        int sum = 0;
        for (int i = 0; i < 5001; i++)
            if (!hasGenerator(i))
                sum += i;
        System.out.println("합 : " + sum);
    }

    private static boolean hasGenerator(int num) {
        return numbersHasGenerator.contains(num);
    }

    private static void calculateNumbersHasGenerator() {
        numbersHasGenerator = new ArrayList<Integer>();
        for (int i = 0; i <= 5000; i++) {
            String num = String.valueOf(i);
            int no = 0;
            for (int n = 0; n < num.length(); n++)
                no += Integer.parseInt(num.substring(n, n + 1));
            numbersHasGenerator.add(no + i);
        }
    }
}
