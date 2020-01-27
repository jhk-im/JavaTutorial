package JumpToJava.Tutorial19_AbstractClassTutorial;// 1. 추상클래스란 무엇인가?
// 추상클래스는 인터페이스의 역할도 하면서 구현체도 가지고 있는 자바의 돌연변이 같은 클래스이다.
// 추상클래스는 인터페이스로 대체하는 것이 좋은 디자인이라는 의견도 있다.
// 추상클래스에 대해서 알아보기 위해 Predator 인터페이스를 추상 클래스로 둔갑시켜 보자.
// Predator 인터페이스의 원래 기능을 그대로 유지하기 위해 다음과 같이 변경한다.


public abstract class Predator extends Animal {
    public abstract String getFood();

    public boolean isPredator(){
        return  true;
    }
}

// 추상클래스를 만들기 위해서는 class 앞에 abstract 라고 표기해야 한다.
// 또한 인터페이스의 메소드 같은 역할을 하는 메소드에도 abstract 를 붙이도록 한다.
// abstract 메소드도 인터페이스 메소드와 마찬가지로 몸통이 없다.
// 즉, abstract 클래스를 상속하는 클래스에서 해당 abstract 메소드를 구현해야만 하는 것이다.

// Tiger, Lion 을 다음과 같이 변경해야한다.
/*
public class Lion extends Predator implements Bark{
    public String getFood(){
        return "beef";
    }
    public void bark(){
        System.out.println("으르렁");
    }
}

public class Tiger extends Predator implements Bark{
    public String getFood(){
        return "pork";
    }
    public void bark(){
        System.out.println("어흥");
    }
}
*/

// Tiger 와 Lion 클래스는 이제 Predator 인터페이스를 implements 하던 것에서
// Predator 추상 클래스를 extends 하도록 변경되었다.

// 그리고 Predator 추상클래스에서 abstract 메소드로 선언된 getFood 메소드가 위와 같이 구현되었다.
// 추상클래스에 abstract 로 선언된 메소드는 인터페이스의 메소드와 마찬가지로
// 추상클래스를 상속하는 클래스에서 반드시 구현해야만 하는 메소드이다.
// 추상클래스에는 abstract 메소드 뿐만 아니라 실제 메소드도 추가가 가능하다.
// 추상클래스에 실제 메소드를 추가하면 Tiger, Lion 등으로 만들어진 객체에서 그 메소드들을 모두 사용할 수 있게된다.
// 예를 들어 아래와 같이 isPredator 라는 메소드를 Predator 추상 클래스에 추가하면
// 이 클래스를 상속받은 Tiger, Lion 등에서 사용 가능하게 된다.
/*
public boolean isPredator(){
    return  true;
}*/
/*
    @Override
    public boolean isPredator() {
        return super.isPredator();
    }
*/
