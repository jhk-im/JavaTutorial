import jdk.nashorn.internal.codegen.CompilerConstants;

class Updater{
    public void update(int count){
        count ++;
    }
    public void update2(CallByValueTutorial cbvTutorial){
        cbvTutorial.count++;
    }
}
public class CallByValueTutorial {

    int count = 0; // 객체변수

    public static void main(String[] args){

        // 학습자료 출처 https://wikidocs.net/265
        // 1. Call by value
        // 메소드에 값(primitive type)을 전달하는 것과 객체(reference type)를 전달하는 것에는 큰 차이가 있다.
        // 매우 중요하기 때문에 자세히 알아보도록 하자.
        // main 밖에 int count = 0; 이라는 객체변수를 만들고
        // CallByValueTutorial 밖에 Updater 클래스를 생성해보자.
        // Updater 클래스 안에는 다음과 같은 메소드를 생성해보자 .
        /*public void update(int count){
            count ++;
        }*/
        System.out.println("---Example1---");
        CallByValueTutorial cbvTutorial = new CallByValueTutorial();
        System.out.println("before update : "+cbvTutorial.count); // 0
        Updater myUpdater = new Updater();
        myUpdater.update(cbvTutorial.count);
        System.out.println("after update : "+cbvTutorial.count); // 0

        /*
        * CallByValueTutorial.java 파일 내에 CallByValueTutorial 과 Updater 라는 클래스가 2개 등장했다.
        * 특이하지만 가능한 코드이다.
        * 하나의 java 파일 내에는 여러개의 클래스를 선언할 수 있다.
        * 파일명이 CallByValueTutorial.java 라면
        * CallByValueTutorial 클래스는 public 으로 선언하라는 규칙이 있다.
        *  */

        // Updater 클래스는 전달받은 숫자를 1만큼 증가시키는 update 메소드를 가지고 있다.
        // CallByValueTutorial 클래스는 count 라는 int 변수를 가지고 있다.
        // 위의 예제는 count 의 값을 Updater 클래스의 update 메소드를 사용해 증가시키는 것이다.
        // 하지만 증가하지 않고 둘다 before after 둘다 0 으로 출력된다.

        // 다음과 같은 메소드를 Updater 클래스 내부에 생성하고 다시 실행하여 보자.
        /*public void update2(CallByValueTutorial cbvTutorial){
            cbvTutorial.count++;
        }*/
        System.out.println("---Example2---");
        System.out.println("before update : "+cbvTutorial.count); // 0
        myUpdater.update2(cbvTutorial);
        System.out.println("after update : "+cbvTutorial.count); // 1

        // myUpdater.update(cbvTutorial.count) 와 myUpdater.update2(cbvTutorial) 의 차이점은 간단하다.
        // 입력 항목을 보면 update 는 int 값을 전달하였고
        // updater 는 cbvTutorial 객체를 전달한 것이다.
        // 이것을 실행하면 이전과 다르게 before : 0 -> after : 1 을 출력한다.

        // 이렇게 메소드의 입력으로 객체를 전달받는 경우
        // 메소드가 입력받은 객체를 그대로 사용하기 때문에
        // 객체의 속성값을 변경하면 메소드 수행 후 객체의 변경된 속성값이 유지되게 된다.
    }

}
