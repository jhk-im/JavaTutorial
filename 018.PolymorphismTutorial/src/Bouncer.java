public class Bouncer {

    public void barkAnimal(Animal animal) {
        if (animal instanceof Tiger) {
            System.out.println("어흥");
        } else if (animal instanceof Lion) {
            System.out.println("으르렁");
        }
    }

    public void barkAnimal1(Bark animal){
        animal.bark();
    }

    public static void main(String[] args) {

        // 1. 다형성 (Polymorphism) 이란 무엇인가?
        // 다형성은 무엇이고 왜 필요한 것일까?
        //  Bouncer(경비원) 클래스는 동물을 짖게 하여 건물을 지킨다.
        // 다음의 메소드를 Bouncer 클래스에 생성한다.
        /*
        public void barkAnimal(Animal animal) {
            if (animal instanceof Tiger) {
                System.out.println("어흥");
            } else if (animal instanceof Lion) {
                System.out.println("으르렁");
            }
        }
        */
        System.out.println("---Example1---");
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer= new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);

        // barkAnimal 메소드는 입력으로 받은 animal 객체가 Tiger 면 어흥을 Lion 이면 으르렁을 출력한다.
        // *instanceof?
        // instanceof 는 특정 객체가 특정 클래스의 객체인지를 조사할 때 사용되는 자바 내장 키워드이다.
        // animal instanceof Tiger = animal 객체가 new Tiger 로 만들어진 객체인가? 를 묻는 조건식이다.

        /*
        * barkAnimal 메소드의 입력 자료형은 Tiger 나 Lion 이 아닌 Animal 이다.
        * 하지만 barkAnimal 메소드를 호출할때는 tiger 또는 lion 객체를 전달할 수 있다.
        * 이게 가능한 이유는 Tiger 클래스나 Lion 클래스가 Animal 이라는 부모 클래스를 상속한 자식 클래스이기 때문이다.
        * 자식 클래스에 의해 만들어진 객체는 언제나 부모 클래스의 자료형으로 사용할 수 있다.
        * 이것이 is a 관계이다.
        * Animal tiger = new Tiger(); -> tiger is a Animal
        * Animal lion = new Lion(); -> lion is a Animal
        * */
        // 결과적으로 어흥, 으르렁을 출력한다.

        // 다른 동물이 추가된다면? barkAnimal 메소드는 다음처럼 수정되어야 한다.
        /*
        public void barkAnimal(Animal animal) {
            if (animal instanceof Tiger) {
                System.out.println("어흥");
            } else if (animal instanceof Lion) {
                System.out.println("으르렁");
            } else if (animal instanceof Crocodile) {
                System.out.println("쩌어억");
            } else if (animal instanceof Leopard) {
                System.out.println("키야옹");
            }
        }
        */
        // 불필요한 반복작업이다.
        // 다음처럼 Bark 인터페이스를 작성해 보자
        /*
        Bark.java
        public interface Bark {
            public void bark();
        }
        */
        // 그리고 각각의 동물 클래스에 Bark 인터페이스를 구현해보자.
        // ex -> Tiger
        /*
        public class Tiger extends Animal implements Predator, Bark{
            public String getFood(){
                return "pork";
            }
            public void bark(){
                System.out.println("어흥");
            }
        }
        */
        // 인터페이스는 콤마를 이용하여 여러개를 implements 할 수 있다.
        // 모든 동물들은 Predator 와 Bark 인터페이스를 implements 하였다.
        // barkAnimal 메소드는 다음과 같이 수정할 수 있다.
        // 비교를 위해 barkAnimal1 로 만들어보자.
        /*
        public void barkAnimal1(Bark animal){
            animal.bark();
        }
        */
        // barkAnimal 의 입력 자료형이 Animal 에서 Bark 로 변경되었따.
        // 그리고 animal 의 객체 타입을 체크하여 울음소리를 구분하던 부분을
        // bark 메소드 를 호출하도록 변경하였다.
        // 복잡한 조건분기문도 사라지고 누가봐도 명확한 코드가 되었다.
        // *다형성을 이용하면 복잡한 if else 조건문을 간단하게 처리할 수 있는 경우가 많다.
        // 동물들의 객체는 각각 Tiger, Lion ... 클래스의 객체이면서
        // Animal 클래스의 객체 + Bark, Predator 인터페이스의 객체이기도 하다.
        // 이러한 이유로 barkAnimal 메소드 입력자료형을 Animal 에서 Bark 로 바꾸어 사용할 수 있는 것이다.
        // *** 객체가 여러개의 자료형 타입을 가질 수 있는 것을 다형성 폴리모피즘 이라 한다.

        // 즉, Tiger 클래스의 객체는 다음과 같은 여러가지 자료형으로 표현할 수 있다.
        /*
        Tiger tiger = new Tiger();
        Animal animal = new Tiger();
        Predator predator = new Tiger();
        Bark bark = new Tiger();
        */
        // Predator 로 선언된 predator 객체와 Bark 로 선언된 bark 객체는 사용하는 메소드가 서로 다르다.
        // predator 는 getFood() 메소드만 호출이 가능하고 bark 는 bark() 메소드만 호출이 가능하다.
        // 만약 모두 사용하고 싶다면 어떻게 해야할까?
        // Predator, Bark 인터페이스를 구현한 Tiger 로 선언된 tiger 객체를 사용하거나
        // 다음과 같이 getFood, bark 메소드를 모두 포함하는 새로운 인터페이스를 만들어 사용하면 된다.
        /*
        BarkPredator.java
        1.
        public interface BarkPredator {
            public void bark();
            public String getFood();
        }
        2.
        public interface BarkPredator extends Predator, Bark {

        }
        */
        // 2번째 방법은 기존의 인터페이스를 활용하는 방법이다.
        // 2번째 방법대로 하면 Predator 의 getFood , Bark bark 메소드를 그대로 상속받을 수 있다.
        // 인터페이스는 일반 클래스와 달리 extends 를 이용하여 여러개의 인터페이스를 동시에 상속받을 수 있다.
        // 즉, 다중 상속이 지원된다. (일반클래스는 단일상속만 가능하다.)
        // Tiger 클래스만 다음과 같이 수정해보자
        /*
        public class Tiger extends Animal implements BarkPredator{
            public String getFood(){
                return "pork";
            }
            public void bark(){
                System.out.println("어흥");
            }
        }
        */
        System.out.println("---Example2---");
        Crocodile crocodile = new Crocodile();
        Leopard leopard = new Leopard();
        bouncer.barkAnimal1(tiger);
        bouncer.barkAnimal1(lion);
        bouncer.barkAnimal1(crocodile);
        bouncer.barkAnimal1(leopard);
        // 각각의 동물별로 울음소리가 구분되어서 출력된다.

        // Tiger 만 다르게 수정하였지만 결과값은 동일하게 출력되는것을 확인할 수 있다.
        // Bouncer 클래스의 barkAnimal 메소드 입력 자료형이 Bark 더라도
        // BarkPredator 를 구현한 Tiger 객체를 전달할 수 있다.
        // 이유는 BarkPredator 는 Bark 를 상속받은 자식 인터페이스 이기 때문이다.
        // 자식 인터페이스로 생성한 객체의 자료형은 부모 인터페이스로 사용하는 것이 가능하다.

    }
}