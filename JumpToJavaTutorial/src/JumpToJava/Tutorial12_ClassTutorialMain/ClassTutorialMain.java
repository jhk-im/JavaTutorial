package JumpToJava.Tutorial12_ClassTutorialMain;

public class ClassTutorialMain {

    public static void main(String[] args){

        // 1. class 란 무엇인가?
        // 간단한 클래스를 작성하는 것에서 부터 시작하여 조금씩 클래스의 규모를 키워가보자.
        // src 오른쪽 마우스 -> New -> Java Class 를 클릭하고 Animal 이라는 클래스를 생성해보자.
        // Animal.java 를 클릭해보면
        /*
        public class Animal{

        }
        */
        // 위처럼 가장 간단한 형태의 클래스가 생성된 것을 볼 수 있다.
        // 아직까지는 내용이 없는 빈 껎데기뿐인 클래스이다.
        // 껍데기 뿐인 클래스일지라도 아주 중요한 기능을 가지고있다.
        // *바로 객체(object)를 만드는 기능이다.
        Animal cat = new Animal();
        // new 는 객체를 생성할 때 사용하는 키워드이다.
        // 이렇게 하면 Animal 클래스의 인스턴스(instance)인 cat -> Animal 의 객체가 만들어진 것이다.

        // * 객체와 인스턴스 *
        // 클래스에 의해 만들어진 객체를 인스턴스라고도 한다.
        // 인스턴스와 객체의 차이는 무엇일까?
        // Animal cat = new Animal() -> 여기서 cat 은 객체이다.
        // 그리고 cat 이라는 객체는 Animal 의 인스턴스이다.
        // 즉, 인스턴스라는 말은 특정 객체(cat)가 어떤 클래스(Animal)의 객체인지를 관계 위주로 설명할 때 사용된다.
        // cat 은 객체이고, cat 은 animal 의 인스턴스인 것이다.

        // 과자틀 -> 클래스 , 과자틀로 만들어진 과자들 -> 객체
        Animal mouse = new Animal();
        Animal horse = new Animal();
        // 위와 같이 무수히 많은 동물 객체들을 Animal 클래스로 만들 수 있다.

        // 2. 객체 변수 (Instance variable)
        // Animal 클래스에 의해 만들어지는 동물들에 이름을 지어보자.
        // Animal.java 에 String name; 을 추가하자.
        // 이렇게 선언된 변수를 객체 변수라고 한다.
        // 이제 생성한 객체 변수를 사용해보도록 하자.

        // 객체 변수 접근
        // 객체 변수는 도트 연산자를 이용해 접근할 수 있다.
        System.out.println("---객체변수 접근---");
        System.out.println(cat.name); // null
        // cat.name -> 객체.객체변수 => 이렇게 접근할 수 있다.
        // 객체 변수에는 지정된 값이 없으므로 null 을 출력한다.
        // null 은 값이 할당되어 있지 않은 상태를 말한다.

        // 2. 메소드
        // 객체 변수에 값을 대입하는 방법은 여러가지가 있다.
        // 메소드는 그중 가장 보편적인 방법이다.
        // 클래스에는 객체변수와 더불어 메소드가 존재한다.
        // 메소드는 클래스 내에 구현된 함수를 의미하는데 보통 메소드라고 말한다.
        // Animal.java 에 setName 메소드를 추가해보자.
        /*
        public void setName(String name){
            this.name = name;
        }
        */
        // void -> 리턴값 (출력값) 없음
        // setName(입력값) -> String name
        // 해석해보면 name 이라는 문자열을 받고 출력은 없는 형태의 메소드이다.
        // setName 내부에 this.name = name 에서 this 를 이해해야한다.
        // 일단은 메소드를 호출해 보도록 하자.
        // 객체 변수 -> 객체.객체변수 로 접근한 것과 동일하다.
        cat.setName("bobby"); // 객체.메소드 로 호출할 수 있다.
        // setName 메소드는 입력항목으로 문자열을 필요로 한다.
        // 그러므로 "bobby" 라는 String 문자열을 입력하였다.
        System.out.println("---메소드로 객체변수 입력---");
        System.out.println(cat.name); // bobby
        // 메소드로 입력했던 "bobby" 가 출력되는 것을 확인할 수 있다.
        // cat.name = bobby 이므로 cat 의 객체변수 name 에 "bobby" 가 입력 되었다.
        // 메소드 사용 시 setName 내부의 this.name = name 은 this.name = "bobby"가 된 것이다.
        // 여기서 this 는 Animal 클래스에 의해 생성된 객체를 지칭한다.
        // 즉, cat 이라는 객체를 만들고 -> cat 객체가 메소드를 호출하면
        // 메소드 내부의 this 는 cat 을 지칭하게 된다.
        // 같은 방법으로 dog 객체를 만들어 메소드를 호출하면 메소드 내부의 this 는 dog 객체를 지칭하는 것이다.

        // 3. 객체 변수는 공유되지 않는다
        // dog 를 추가해 보고 메소드를 이용해 이름을 지어보자.
        Animal dog = new Animal();
        dog.setName("happy");
        mouse.setName("micky");
        horse.setName("donkey");
        // cat 과 동일한 방법으로 dog 에는 setName 에 "happy"를 입력하였다.
        System.out.println("---객체 변수는 공유되지 않는다---");
        System.out.println(cat.name); // bobby
        System.out.println(dog.name); // happy
        System.out.println(mouse.name); // micky
        System.out.println(horse.name); // donkey
        // setName 메소드가 2번 사용되었지만 값이 바뀌지 않고 각각 독립적으로 이름이 설정되었다.
        // 클래스에서 가장 중요한 부분이 객체 변수의 값이 독립적으로 유지된다는 점이다.
        // 이 점이 바로 클래스의 존재 이유이다.
        // 객체 지향적 이라는 말이 이 객체 변수의 값이 독립적으로 유지되기 때문에 가능한 것이다.

        // 객체 변수의 값을 공유하려면?
        // static 을 이용하게 되면 객체 변수를 공유하도록 만들 수도 있다.
    }

}

