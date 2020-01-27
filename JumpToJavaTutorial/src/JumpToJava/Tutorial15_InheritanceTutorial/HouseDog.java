package JumpToJava.Tutorial15_InheritanceTutorial;

public class HouseDog extends Dog {
    public void sleep2(){
        System.out.println(this.name+" zZ in house");
    }
    public void sleep2(int hour){
        System.out.println(this.name+" zZ in house for " + hour + " hours");
    }
    public static void main(String[] args){
        System.out.println("---Example3---");
        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        houseDog.sleep();
        // happy zZ 가 출력된다.
        // 만약 HouseDog 는 집에서만 잔다고 해보자.
        // 그래서 sleep() 호출 시 "happy zZ" 가 아닌 "happy zZ in house"를 출력해야한다.
        // 다음과 같이 HouseDog 안에 sleep2() 메소드를 생성하고 실행해 보자.
        System.out.println("---Example4---");
        houseDog.sleep2();
        // happy zZ in house 라는 원하는 값이 출력 되었다.
        // 비교를 위해 메소드명을 sleep2로 진행하였지만 sleep 으로 해도 동일한 결과가 나온다.
        // sleep2 가아닌 Dog 의 sleep 과 동일한 이름으로 메소드를 지어도 결과가 같다는 의미이다.
        // HouseDog 클래스에 Dog 클래스와 동일한 형태의 메소드를 구현하면
        // HouseDog 클래스의 sleep2 메소드가 Dog 의 sleep 메소드보다 더 높은 우선순위를 갖게된다.
        // 그리하여 Dog 클래스의 sleep() 이 아닌 HouseDog 의 sleep() 메소드를 호출한다.

        // * 이렇게 부모 클래스의 메소드를 자식 클래스가 동일한 형태로 또 다시 구현하는 행위를
        // 메소드 오버라이딩 이라고 한다. = 메소드 덮어쓰기

        // 4. Method overloading
        // 이번에는 HouseDog 클래스에 다음과 같은 메소드를 추가해보자.
        /*
        public void sleep2(int hour){
            System.out.println(this.name+" zZ in house for " + hour + " hours");
        }
        */
        // 이미 sleep2 라는 메소드가 있지만 동일한 이름으로 메소드를 또 생성할 수 있다.
        // 단, 메소드의 입력항목이 다를 경우에만 가능하다.
        // 새로만든 sleep2 메소드는 입력항목으로 hour 라는 int 자료형이 추가되었다.
        // 이렇게 입력항목이 다른 동일한 이름의 메소드를 만드는 것을
        // 메소드 오버로딩 이라고 부른다.
        // 두개의 메소드를 동시에 사용해보도록 하자.
        System.out.println("---Example5---");
        houseDog.sleep2();
        houseDog.sleep2(3);
        // happy zZ in house 와 happy zZ in house for 3 hours 가 출력된다.

        // 5. 다중 상속
        // 다중상속은 클래스가 동시에 하나 이상의 클래스를 상속받는 것을 뜻한다.
        // c++, 파이썬 등 많은 언어가 지원하지만 자바는 지원하지 않는다.

        // 자바에서 다중상속을 한다면 다음과 같이 코드가 만들어 질 것이다.
        // 단, 동작할 수 없는 코드이다.
        /*
       class A {
            public void msg() {
                System.out.println("A message");
            }
        }

        class B {
            public void msg() {
                System.out.println("B message");
            }
        }

        class C extends A, B {
            public void static main(String[] args) {
                C test = new C();
                test.msg();
            }
        }
        * */

        // 다중 상속을 지원한다는 가정 하에 C 클래스가 A,B 클래스를 동시에 상속하도록 하였다.
        // main 메소드에서 test.msg(); 실행 시
        // A 클래스의 msg 메소드를 실행해야 할까 B의 msg 메소드를 실행해야할까?
        // 다중 상속을 지원하게 되면 이렇게 애매한 부분이 생기게 된다.
        // 자바는 이러한 불명확한 부분을 애초에 잘라낸 언어이다.

        // *다중상속을 지원하는 다른 언어들은 이러한 경우 우선순위를 적용하여 해결한다.
    }
}
