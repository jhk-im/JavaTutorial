package JumpToJava.Tutorial17_InterfaceTutorial;

public class ZooKeeper {
    public void feed(Tiger tiger) {
        System.out.println("feed pork");
    }

    public void feed(Lion lion) {
        System.out.println("feed beef");
    }
    public void feed(Predator predator){
        //System.out.println("feed beef");
        System.out.println("feed "+predator.getFood());
    }

    public static void main(String[] args) {

        // 1. Interface 란 무엇인가?
        // 인터페이스는 초보 자바 개발자를 괴롭히는 단골손님이다.
        // 인터페이스는 개념없이 코드로만 이해하려면 미궁에 빠진다.
        // 이해하기 힘든 인터페이스는 도대체 왜 필요하게 된 걸까?
        // 다음의 경우를 생각해보자.

        /*
        * 난 동물원의 사육사다.
        * 육식동물이 들어오면 난 먹이를 던져준다.
        * 호랑이가 오면 돼지고기를 던져준다.
        * 사자가 오면 소고기를 던져준다.
        * */

        //이것을 코드로 담아보자.
        /*
        Animal.java
        public class Animal {
            String name;
            public void setName(String name) {
                this.name = name;
            }
        }

        Tiger.java
        public class Tiger extends Animal {}

        Lion.java
        public class Lion extends Animal {}
        */

        System.out.println("---Example1---");
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        zooKeeper.feed(tiger); // feed pork
        zooKeeper.feed(lion); // feed beef
        // 이전에 보았던 Dog 클래스와 마찬가지로 Animal 을 상속한 Tiger 와 Lion 이 등장한다.
        // 사육사 클래스인 ZooKeeper 클래스도 정의되었다.
        // ZooKeeper 클래스는 호랑이가 왔을 때, 사자가 왔을 때 각각 다른 feed 메소드가 호출된다.
        // *ZooKeeper 클래스의 feed 메소드는 메소드 오버로딩으로 구현되어있다.
        // feed pork , feed beef 가 출력된다.

        // * 동물원에 호랑이와 사자 뿐이라면 문제가 안되지만
        // 악어, 표범등이 계속 추가된다면 다음과같이 매번 feed 메소드를 추가해야 할 것이다.
        /*
        public void feed(Crocodile crocodile) {
            System.out.println("feed strawberry");
        }

        public void feed(Leopard leopard) {
            System.out.println("feed orange");
        }
        */
        // * 이렇게 추가 될 때마다 feed 메소드를 추가해야 한다면 얼마나 귀찮겠는가?
        // 이것을 극복하기 위해 사용하는 것이 바로 **인터페이스 이다.
        // 다음과 같이 Predator.java 파일을 만들고 인터페이스를 작성해보자.
        /*
        Predator.java
        public interface Predator {

        }
        */
        // 위 코드와 같이 인터페이스는 class 가 아닌 interface 라는 키워드를 사용한다.
        // Leopard, Crocodile 클래스를 추가하여 다음과 같이 작성해보자.
        // Tiger , Lion 도 implements Predator 를 추가한다.
        /*
        public class Crocodile extends Animal implements Predator {}
        public class Leopard extends Animal implements Predator {}
        */
        // 인터페이스는 implements 키워드를 사용한다.
        // 인터페이스를 구현하면 ZooKeeper 클래스의 feed 메소드를 다음과 같이 하나 더 생성한다.
        /*
        public void feed(Predator predator){
            System.out.println("feed beef");
        }
        */
        // 이전에는 feed 입력으로 Tiger, Lion 을 각각 필요로 했지만 이제 이것을 Predator 라는 인터페이스로 대체하였다.
        // tiger, lion 은 각각 Tiger, Lion 의 객체이기도 하지만 Predator 의 인터페이스 객체이기도 하다.
        // 그래서 Predator 의 자료형 타입으로 사용할 수 있는 것이다.
        // * 이와같이 객체가 한 개 이상의 타입을 갖게 되는 특성을 다형성 이라한다.

        // 이제 어떤 육식동물이 추가 되더라도 Zookeeper 는 feed 메소드를 추가할 필요가 없다.
        // 육식 동물이 추가될 때 Predator 인터페이스를 구현한 클래스 작성만 하면 되는 것이다.

        // 중요 클래스를 작성하는 입장이라면 클래스의 구현체와 상관없이 인터페이스를 기준으로 중요 클래스를 작성해야한다.
        // 구현체 (Tiger, Lion, Crocodile, Leopard...) 는 늘어도 인터페이스는 하나기 때문이다.

        // 현재는 feed 메소드를 살펴보면 "feed beef" 한가지 음식만을 출력한다.
        // 각각의 동물에 맞게 다른 음식을 출력해야 한다.
        // Predator 인터페이스 안에 다음과 같은 메소드를 추가해보자.
        // public String getFood();
        // getFood 라는 메소드를 추가했다. 이상한 점은 메소드의 몸통이 없다는 것이다.
        // *인터페이스의 메소드는 메소드의 이름과 입출력에 대한 정의만 있고 그 내용은 없다.
        // 이유는 인터페이스 규칙 때문이다.
        // getFood 라는 메소드는 Predator 인터페이스를 implements 한 클래스들이 구현해야 하는 규칙이다.

        // Tiger, Lion, Crocodile, Leopard 각각의 동물에 getFood 메소드를 다음과 같이 구현해보자.
        // ex ) Tiger -> getFood
        /*
        public String getFood(){
            return "pork";
        }
        */
        // getFood 메소드는 육식동물의 먹이인 "pork", "beef" 등을 린턴하도록 작성하였따.
        // feed 메소드도 다음과 같이 수정한다.
        /*
        public void feed(Predator predator){
            //System.out.println("feed beef");
            System.out.println("feed "+predator.getFood());
        }
        */
        // "feed beef" 에서 "feed "+predator.getFood() 로 변경되었따.
        // predator.getFood()를 호출하면 Predator 인터페이스를 구현한
        // 각각의 구현체들의 getFood() 메소드가 호출된다.

        System.out.println("---Example2---");
        Crocodile crocodile = new Crocodile();
        Leopard leopard = new Leopard();
        zooKeeper.feed(tiger); // feed pork
        zooKeeper.feed(lion); // feed beef
        zooKeeper.feed(crocodile); // feed people
        zooKeeper.feed(leopard); // feed chicken
        // pork, beef, people, chicken 으로 각각 구분되어 출력된다.

        // 2. 인터페이스는 왜 필요한가?
        // 육식동물 종류만큼의 feed 메소드가 필요했던 ZooKeeper 클래스를 Predator 인터페이스로 구현하였더니
        // 단 한개의 feed 메소드로 구현이 가능해졌다.
        // 중요한점은 메소드의 갯수가 줄어든게 아니라
        // *ZooKeeper 클래스가 동물들의 종류에 의존적인 클래스에서 -> 종류와 상관없는 독립적인 클래스가 되었다는 것이다.
        // 이것이 바로 인터페이스의 핵심이다.

        // USB 포트에 연결할 수 있는 기기는 하드디스크, 메모리스틱, 디지털 카메라 등 다양하다.
        // 바로 이 USB 포트가 물리적 세계의 인터페이스라고 할 수 있다.
        // USB 포트의 규격만 알면 어떤 기기도 만들 수 있다.
        // 컴퓨터는 USB 포트만 제공하고 어떤 기기가 만들어지는지 신경쓸 필요가 없다.
        // 이것이 바로 인터페이스의 핵심이다.

        // 컴퓨터 = > ZooKeeper
        // USB => Predator
        // HDD,DC,SDD.... -> Tiger, Lion, Crocodile
        // 전자기기들이 지켜야 하는 각종 규칙들 => 인터페이스의 메소드

    }
}