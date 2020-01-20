import java.util.ArrayList;

public class ArrayListTutorial {

    public static void main(String[] args){

        // 지금까지 변수에 대하여 알아보았다.
        // 하지만 변수만으로 프로그래밍을 하기엔 부족한 점이 많다.
        // 예를들어 1부터 10까지 숫자들 중 홀수들의 모임인 1, 3, 5, 7, 9 라는 집합을 생각해 보자.
        // 이것들을 숫자나 문자열만으로 표현 하기는 쉽지가 않다.
        // 이러한 불편함을 해소하기 위하여 자바에 Array -> 배열이 존재하는 것이다

        // 1.Array 생성
        // 1부터 10까지의 숫자들 중 홀수들의 집합을 int 배열로 표현할 수 있다.
        // 배열은 변수바로 뒤에 [] 기호를 사용하여 표현한다.
        int[] intArray = {1,3,5,7};

        // 다음은 요일의 집합을 String 배열로 표현해 보자.
        String[] stringArray = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

        // *Array 란 변수가 아닌 변수들의 집합을 의미한다.
        // 지금까지는 1차원 배열이다. 2차원 3차원 등의 다차원 배열도 가능하다.
        // 2차원 이상의 배열은 일반적인 프로그래밍 시 잘 사용되지 않는다.

        // 배열의 길이는 고정되어 있다.
        String[] week = new String[7];
        // 배열의 길이만 설정하여 변수를 먼저 생성한 후 나중에 값을 대입하는 방법이다.
        // 위처럼 초기값 없이 변수를 만들 때에는 반드시 길이 값이 필요하다.
        // 다음과 같은 코드는 불가능하다.
        // String[] week1 = new String[]; -> 컴파일 에러

        System.out.println("---Array 값 접근하기---");
        // 2.Array 값에 접근하기
        // 위에서 만든 요일 배열중 "Thu"에 해당하는 값을 얻어보자.
        System.out.println(stringArray[3]); // Thu
        // Thu 를 출력하는 걸 볼수 있다.
        // 우리 기준으로는 월 -> 화 -> 수 -> 목 4번째 이지만
        // 자바는 0부터 숫자를 세기 때문에 0 -> 1 -> 2 -> 3
        // stringArray[3] 을 입력해야 한다.

        // 3.Array 길이
        // 프로그램 작성 시 배열이 만들어 졌다면 for 문을 돌리는 경우가 대다수다.
        // for 문 사용시 배열의 길이만큼 for 문을 돌리는 것이 중요하다.
        // 다음과 같이 length 를 이용하여 구한다.

        System.out.println("---Array 길이---");
        System.out.println(stringArray.length);
        for(int i=0; i<stringArray.length; i++){
            System.out.println(stringArray[i]); // 차례대로 출력된다.
        }

        // *빈번한 배열의 오류
        // ArrayIndexOutOfBoundsException
        // 자바 코드 작성 시 가장 많이 보게 될 오류중의 하나이다.
        // System.out.println(stringArray[7]);
        // 0->1->2->3->4->5->6 까지만 존재하기 때문에 7은 존재하지 않으므로
        // ArrayIndexOutOfBoundsException 발생

        // List
        // 리스트는 배열과 비슷하며 배열보다 편리한 기능을 많이 가지고 있다.
        // 배열은 크기가 정해져 있다고 했다.
        // 배열의 크기를 10개로 정했다면 10개 이상의 값을 담을 수 없다.
        // 프로그래밍시 크기를 알 수 있는 상황도 있지만 명확한 크기를 알 수 없는 경우가 더 많다.
        // 동적으로 갯수가 가변하는 상황이라면 List 를 사용하는 것이 유리하다.

        // 4. ArrayList
        // 자료형 중에서 가장 간단한 형태이다.

        // 4-1 add()
        ArrayList arrayList = new ArrayList();
        arrayList.add("List1");
        arrayList.add("List2");
        arrayList.add("List3");
        // 위 처럼 add()를 사용하여 데이터를 저장할 수 있다.
        // 첫번째와 두번째 위치에 다른 정보를 삽입하여 보자.
        arrayList.add(3,"List4"); // 4번째 위치에 List4 삽입.
        arrayList.add(4,"List5"); // 5번째 위치에 List5 삽입.

        // 4-2 get()
        // get()은 특정 인덱스의 값을 추출할 때 사용한다.
        System.out.println("---ArrayList.get()---");
        System.out.println(arrayList.get(0)); // List1
        System.out.println(arrayList.get(1)); // List2
        System.out.println(arrayList.get(2)); // List3

        // 4-3 size()
        // size()는 ArrayList 의 갯수를 리턴한다.
        System.out.println("---ArrayList.size()---");
        System.out.println(arrayList.size()); // 5
        // 추가하고 확인해보자.
        arrayList.add(5,"List6");
        System.out.println(arrayList.size()); // 6

        // 4-4 contains()
        // contains()는 리스트에 값이 있는지를 판별하여 그 결과를 boolean 으로 리턴한다.
        System.out.println("---ArrayList.contain()---");
        System.out.println(arrayList.contains("List1")); // true
        System.out.println(arrayList.contains("List100")); // false
        // 포함하고 있으면 true 그렇지 않으면 false 가 출력된다.

        // 4-5 remove()
        // remove 메소드에는 2개의 방식이 있다.
        // remove(객체) , remove(인덱스) 이다.
        System.out.println("---ArrayList.remove()---");
        System.out.println(arrayList.remove("List6")); // true
        System.out.println(arrayList.remove("List7")); // false
        System.out.println(arrayList.remove(0)); // List1
        // remove(객체)가 성공하면 true 아니면 false 를 리턴한다.
        // remove(인덱스)가 성공하면 삭제된 항목을 리턴한다.
    }

}
