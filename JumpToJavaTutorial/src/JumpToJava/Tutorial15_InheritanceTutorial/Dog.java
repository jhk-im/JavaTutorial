package JumpToJava.Tutorial15_InheritanceTutorial;

public class Dog extends Animal {
    public void sleep(){
        System.out.println(this.name+" zZ");
    }
    public static void main(String[] args){

        // 학습자료 출처 https://wikidocs.net/280

        // 1. 상속 (Inheritance) 란 무엇인가?
        // 말 그대로 자식이 부모로부터 무언가를 물려받는 것이다.
        // Animal.java 파일을 생성하고 다음과 같이 작성해보자.

        /*
          public class Animal {
            String name;
            public void setName(String name){
                this.name = name;
            }
        }*/

        // Dog 클래스에서 Animal 클래스를 상속받아보자.
        // extends 를 사용한다. -> 자식 클래스 extends 부모 클래스 -> public class InheritanceTutorial extends Animal {}
        // 이제 Dog 클래스는 Animal 클래스를 상속받았다.
        // Dog 클래스에 name 이라는 객체변수와 setName 이라는 메소드를 만들지 않았지만
        // Animal 클래스를 상속받았기 때문에 그대로 사용할 수 있다.
        // 메소드를 사용해보자.
        System.out.println("---Example1---");
        Dog dog = new Dog();
        dog.setName("poppy");
        System.out.println(dog.name); // poppy
        // poppy 라는 문자열을 출력하게 된다.

        // 이번에는 Dog 클래스에 sleep() 이라는 메소드를 다음과 같이 추가해보자.
        /*
        public void sleep(){
            System.out.println(this.name+"zZ");
        }
        */
        System.out.println("---Example2---");
        System.out.println(dog.name); // poppy
        dog.sleep(); // poppy zZ
        // 이제 Dog 클래스에 Animal 클래스보다 기능이 더 추가되었다.
        // 이렇듯 부모 클래스를 상속받은 자식클래스는 부모 클래스의 기능에 더하여 좀 더 많은 기능을 갖도록 설계한다.
        // poppy 와 poppy zZ 를 출력하는 것을 볼수있다.

        // 2. IS-A 관계
        // Dog 클래스는 Animal 클래스를 상속받았다.
        // Dog 클래스는 Animal 의 하위 개념이라고 할 수 있다.
        // Dog 은 Animal 이다. 라고 표현 할 수있다.
        // 자바는 이러한 관계를 IS-A 관계라고 표현한다.
        // 즉, Dog is a Animal 이라고 생각하면 된다.
        // IS-A 관계 (상속관계)에 있을 때 자식 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있다.
        // 즉, 다음과 같은 코딩이 가능하다.
        Animal dog1 = new Dog();
        // 반대의 경우 즉, 부모 클래스로 만들어진 객체를 자식 클래스의 자료형으로 사용할 수는 없다.
        // Dog dog2 = new Animal(); // 컴파일 에러
        // 개념적으로 살펴보면 두번째 코드는 성립할 수 없다는 것을 알 수 있다.
        // Animal dog = new Dog(); -> "개로 만든 dog 객체는 동물 자료형이다."
        // 사자로 만든 lion 객체는 동물자료형이다. 호랑이로 만든 tiger 객체는 동물자료형이다. 이상하지 않다.
        // Dog dog = new Animal(); -> "동물로 만든 dog 객체는 개 자료형이다."
        // -> 동물로 만든 dog 객체는 호랑이 또는 사자 자료형도 될 수 있다는 것이다. 이상하다.
        /*
         * 자바에서 만드는 모든 클래스는 Object 라는 클래스를 상속받게 되어있다.
         * Animal 클래스는 다음의 코드와 기능적으로 완전히 동일하다.
         * public class Animal extends Object{}
         * 하지만 굳이 Object 클래스를 상속하지 않아도
         * 자바에서 만들어지는 모든 클래스는 Object 클래스를 자동으로 상속받게 끔 되어있다.
         * */

        // 3. Method overriding
        // Dog 를 좀 더 구체화 시키는 HouseDog 클래스를 만들어 보자.
        // HouseDog 클래스는 HouseDog.java 를 생성하고 Dog 클래스를 상속하여 다음과 같이 만들 수 있다.

        /*
        * public class HouseDog extends Dog {
            public static void main(String[] args){
                HouseDog houseDog = new HouseDog();
                houseDog.setName("happy");
                houseDog.sleep();
            }
         }
        * */

        //HouseDog.java 로 넘어가보자.
    }
}
