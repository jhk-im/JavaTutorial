
// 연습문제 1. 구구단
// 구구단은 정말 다양한 방법으로 많이 만들 수 있다.
// 다음의 예제를 분석해보자.

public class GuGu {
    int dan; // 2단 3단을 표시해 줄 int 변수

    // GuGu 생성자
    // GuGu 객체를 생성 할 때에는 int dan 을 입력으로 받아야 생성할 수있다.
    // GuGu 객체 생성 시 현재 2단인지 5단인지 구분하기위해서
    // int dan 에 숫자가 셋팅되는 것은 필수적인 행동이므로
    // 생성시에 입력받아 제어한다.
    public GuGu(int dan){
        this.dan = dan; // GuGu 클래스의 int dan 을 입력받은 int 데이터로 바꿔준다.
    }


    // all()에서 호출된다.
    // 2단 ,3 단 등으로 dan 이 설정되면
    // 아래의 all() 메소드에서 호출하여 1부터 9까지 순서대로 get() 에 입력한다.
    public int get(int seq){ // return 값이 int 자료형이기 때문에 리턴자료형은 int 이다.
                            // 입력값 seq 는 곱하는 수인 1~9까지의 수를 받는다
        return  this.dan * seq; // get 은 현재 dan 과 입력된 seq 를 곱한 값을 반환한다.
    }

    // toString() 에서 호출된다.
    // 1 부터 9 까지의 수를 get() 메소드에 순차적으로 담아준다.
    // get() 메소드는 수를 입력하면 현재의 단수와 입력수를 곱한 값을 리턴한다.
    // 그 리턴한 값을 result 라는 int 배열에 순차적으로 저장한다.
    public int[] all() { // int[] 을 반환하기 때문에 리턴자료형이 int[] 이다.
        int[] result = new int[9]; // result 의 크기는 9로 정해진다.
        for(int i=0; i<9; i++){ // 0->1->2->3->4->5->6->7->8 총 9번 반복하는 반복문이다.
            result[i] = this.get(i+1); // 0부터 시작하기때문에 +1 해주어야 1부터 9의 수로 입력이 된다.
                                        // 입력후 -> 입력한 수 * 현재 단수 리턴
                                        // 리턴된 수는 result 배열에 순차적으로 담기게 된다.
        } // 반복문이 9까지 돌면 false 가 되어 실행되지 않고 다음으로 넘어간다.
        //System.out.println("3");
        return result;  // 곱셈이 계산된 수가 담긴 int [] result 를 반환한다.
    }


    // toString 은 클래스 내에 선언되면 좀 특별한 의미를 갖게된다.
    // new 키워드로 생성한 객체를 System.out.println 같은 걸로 출력했을 때
    // toString() 메소드가 구현되어 있는 경우 toString() 메소드를 수행한 결과값을 리턴하게 된다.
    // 즉*** new 로 객체를 생성 할 때 자동으로 실행된다는 의미이다.
    public String toString() { // String 을 리턴하는 메소드이다.
        //System.out.println("2");
        // StringBuffer 가 사용되는 메소드이다.
        // 문자열을 추가하거나 변경할 때 주로 사용하는 자료형이라고 하였다.
        StringBuffer sb = new StringBuffer(); // StringBuffer 객체생성
        int[] result = all(); // int [] 에 all() 에서 리턴된 곱셈이 완료된 int 배열이 담긴다.
        for(int i=0; i<result.length; i++) { // result 의 길이만큼 반복하는 반복문이다.
            sb.append(result[i]); // append() 메소드는 계속 문자열을 추가해 나가는 메소드이다.
            if(i!=result.length-1) { // 각 구구단의 마지막 수에 "," 을 추가하지 않기위해
                sb.append(","); // 계산된 수를 구분하기 위해 append() 메소드로 "," 라는 문자를 추가한다.
            }
        }
        return  sb.toString(); // all() 로부터 계산된 수 배열을 받아서 append() 로 StringBuffer 에 저장하고
        // toString() 메소드로 저장된 문자열을 출력한다.


    }

    public static void main(String[] args) {
        //GuGu gugu = new GuGu(2);
        //System.out.println(gugu.get(3)); // 6
        //System.out.println(gugu); // 2단을 출력
        for(int i=2; i<10; i++) { // 2 부터 9 까지 반복하는 반복문이다.
            //System.out.println("1");
            System.out.println(new GuGu(i)); // 2부터 9까지의 수가 순차적으로 들어간다
            // 2단을 예로 들어보자
            // GuGu 객체가 new 로 생성되고 2가 입력된다.
            // -> GuGu 의 객체변수 dan 은 2로 변경된다.
            // -> toString(); 이 실행된다.
            // -> all() 메소드가 실행되고 그안에서 get() 메소드가 실행된다.
            // -> get() 메소드는 2x1 ~ 2x9 까지의 곱셈 작업을 리턴한다.
            // -> all() 메소드는 get() 메소드의 결과값을 순차적으로 int 배열에 담아둔다.
            // -> toString() 에서는 StringBuffer 를 사용해서 all() 이 반환하는 int 배열을 append() 로 추가한다.

            // 3단 ... 9단까지 반복해서 진행하고
            // 9단이 끝나면 StringBuffer 에는 2단 부터 9단까지 전부 출력하게 된다.
        }
    }

}
