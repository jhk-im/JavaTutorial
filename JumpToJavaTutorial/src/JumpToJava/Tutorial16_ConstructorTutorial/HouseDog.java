package JumpToJava.Tutorial16_ConstructorTutorial;

public class HouseDog extends Dog {
    public void sleep() {
        System.out.println(this.name+" zzz in house");
    }

    public void sleep(int hour) {
        System.out.println(this.name+" zzz in house for " + hour + " hours");
    }

    public HouseDog(String name){
        this.setName(name);
    }
    public HouseDog(int type){
        if(type == 1){
            this.setName("yorkshire");
        }else if(type == 2){
            this.setName("bulldog");
        }
    }

    public static void main(String[] args) {

        //1. Constructor -> 생성자란 무엇인가?

        /*
        HouseDog dog = new HouseDog();
        System.out.println(dog.name); // null 출력
        */
        // name 객체 변수에 아무런 값도 설정하지 않았기 때문에 null 이 출력된다.
        // HouseDog 클래스는 코딩하기에 따라 객체 변수 name 에 값을 설정할 수도 있고 안할 수도 있다.
        // name 이라는 객체 변수에 값을 무조건 설정해야만 객체가 생성 될 수 있도록 강제할순 없을까?

        // 이럴 때 생성자 Constructor 를 사용한다.
        // 다음과 같은 메소드를 HouseDog 클래스에 추가해보자.
        /*
        public void HouseDog(String name){
            this.setName(name);
        }
        */
        // 리턴 자료형 없음 -> 리턴타입을 정의하지 않음
        // 메소드명 = 클래스명
        // 위와같은 규칙이 있는 메소드를 생성자라고 말한다.
        // 생성자는 객체가 생성도리 때 호출된다. 바로 new 키워드로 객체가 만들어질 때이다.
        // 즉, 생성자는 new 키워드가 사용될 때 호출되는 것이다.
        // 생성자는 메소드와 마찬가지로 입력값을 받을 수 있다.
        // HouseDog 생성자는 String name 을 필요로 한다.
        // 따라서 다음과 같이 new 키워드로 객체를 만들 때 문자열을 전달해야 한다.
        HouseDog houseDog = new HouseDog("happy"); // 생성자 호출 시 문자열 전달.
        //HouseDog houseDog1 = new HouseDog(); -> 컴파일 에러
        // 컴파일 에러가 발생하는 이유는 객체 생성 방법이 생성자 규칙과 맞지 않기 때문이다.
        // 생성자가 선언된 경우 생성자의 규칙대로만 객체를 생성할 수 있다.

        System.out.println("---Example1---");
        System.out.println(houseDog.name); // happy;
        // happy 를 출력한다.
        // 이렇듯 생성자를 사용했을 때 얻게 되는 이득은
        // setName("happy") 와 같은 필수적인 행동을 객체 생성시 제어할 수 있게 된다는 것이다.

        // 2. default 생성자
        // Dog 클래스에 다음과 같은 코드를 입력해보자.
        /*
        public Dog(){

        }
        */
        // 위와같이 생성자의 입력항목이 없고 생성자 내부에 아무 내용이 없으며
        // 클래스와 이름이 동일한 메소드를 default 생성자 라고 부른다.
        // 위와 같이 디폴트 생성자를 구현하면 new Dog() 로 Dog 객체가 만들어 질 때 default 생성자가 실행된다.
        // 클래스에 생성자가 하나도 없다면 컴파일러는 자동으로 위와같은 default 생성자를 추가한다.
        // 사용자가 작성한 생성자가 하나라도 구현되어 있다면 컴파일러는 디폴트 생성자를 추가하지 않는다.
        // *이러한 이유로 위에서 살펴본 HouseDog 클래스에 name 으로 입력받는 생성자를 만들고
        // new HouseDog()는 사용할 수 없게 되는 것이다.
        // 즉, HouseDog 클래스에 이미 생성자를 만들었기 때문에 컴파일러가 default 생성자를 자동으로 추가하지 않는 것이다.

        // 3. 생성자 오버로딩
        // 하나의 클래스에 여러개의 입력항목이 다른 생성자를 만들 수 있다.
        // 이미 HouseDog(String name) 생성자가 있지만 다음과 같은 생성자를 추가할 수 있다.
        /*
        public HouseDog(int type){
            if(type == 1){
                this.setName("yorkshire");
            }else if(type == 2){
                this.setName("bulldog");
            }
        }
        */
        System.out.println("---Example2---");
        HouseDog bobby = new HouseDog("bobby");
        HouseDog yorkshire = new HouseDog(1);
        HouseDog bulldog = new HouseDog(2);
        System.out.println(bobby.name); // bobby
        System.out.println(yorkshire.name); // yorkshire
        System.out.println(bulldog.name); // bulldog
        // 2개의 생성자가 구현되어있다.
        // 하나는 String 자료형을 하나는 int 자료형을 입력으로 받는 생성자다.
        // 두개의 차이는 입력항목이다.
        // 이렇게 입력항목이 다른 여러개의 생성자를 만드는 것을 생성자 오버로딩이라 한다.
        // 메소드 오버로딩과 마찬가지의 개념이다.
        // 2가지 방법으로 HouseDog 객체를 생성하였다.
        // bobby , yorkshire, bulldog 을 출력한다.
    }
}