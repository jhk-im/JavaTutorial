public class SwitchCaseStatementTtutorial {

    public static void main(String[] args){

        // 1. switch / case 문 이란?
        // if 문과 비슷하지만 조금 더 정형화 된 모습의 제어문이다.

        // 일주일 중 7번째 요일
        int week = 7;
        String weekString = "";

        switch (week){
            case 1: weekString = "Monday";
                break;
            case 2: weekString = "Tuesday";
                break;
            case 3: weekString = "Wednesday";
                break;
            case 4: weekString = "Thursday";
                break;
            case 5: weekString = "Friday";
                break;
            case 6: weekString = "Saturday";
                break;
            case 7: weekString = "Sunday";
                break;
            default: weekString = "Invalid week";
                break;
        }
        System.out.println("---switch case example1---");
        System.out.println(weekString); // Sunday
        // week 은 입력 변수이다.
        // case 는 입력 값이다. 차례대로 숫자를 매겨 구분한다.
        // switch 문이 시작되면 입력변수와 입력값을 차례대로 비교한다.
        // 위의 입력 변수는 7로 지정이 되어있다.
        // 7에 해당하는 입력값에서 비어있는 weekString Sunday 를 넣는다.
        // 같은 값을 찾았기 때문에 목적을 달성하였다.
        // break 을 통해서 switch 문을 빠져나간다.
        // Sunday 가 출력된다.

        // 입력 변수 week 의 값에 따라서 다른 문장을 출력하게 될 것이다.
        // 5를 입력해보자.
        week = 5;
        switch (week){
            case 1: weekString = "Monday";
                break;
            case 2: weekString = "Tuesday";
                break;
            case 3: weekString = "Wednesday";
                break;
            case 4: weekString = "Thursday";
                break;
            case 5: weekString = "Friday";
                break;
            case 6: weekString = "Saturday";
                break;
            case 7: weekString = "Sunday";
                break;
            default: weekString = "Invalid week";
                break;
        }

        System.out.println("---switch case example2---");
        System.out.println(weekString); // Friday
        // case 5 에 해당하는 Friday 를 출력하게 된다.

        // 만약 1~7사이의 숫자가 아닌 다른값을 입력한다면 default 문장을 수행한다.
        // 10을 입력해 보자.
        week = 10;
        switch (week){
            case 1: weekString = "Monday";
                break;
            case 2: weekString = "Tuesday";
                break;
            case 3: weekString = "Wednesday";
                break;
            case 4: weekString = "Thursday";
                break;
            case 5: weekString = "Friday";
                break;
            case 6: weekString = "Saturday";
                break;
            case 7: weekString = "Sunday";
                break;
            default: weekString = "Invalid week";
                break;
        }
        System.out.println("---switch case example3---");
        System.out.println(weekString); // Invalid week
        // default 에 해당하는 Invalid week 문장이 출력된다.

        // *자바에서는 if문 보다는 switch / case 문을  쓰는것이 가독성에 조금 더 유리하다.
        // switch / case 문은 if else 구조로 변경 가능하지만
        // if else 구조로 작성된 코드를 switch 문으로 변경할 수 없다.

        // 하지만 if else 로도 충분히 코드를 작성할 수 있다.
        // 그래서 switch case 문을 지원하지 않는 언어들도 있다. ex) 파이썬
    }

}
