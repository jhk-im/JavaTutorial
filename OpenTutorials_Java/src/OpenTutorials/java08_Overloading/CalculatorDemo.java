package OpenTutorials.java08_Overloading;

// 1. overloading
// 지금까지의 계산기는 2개의 값 에 대한 연산 만을 수행할 수 있었다.
// 그런데 만약 3개의 값을 대상으로 연산을 해야 한다면 어떻게 해야할까?
// c1.setOperands(10, 20, 30); 처럼 입력값을 3개 받아야 할 것이다.
/*
public void setOperands(int left, int right, int third){
        this.left = left;
        this.right = right;
        this.third = third;
}
*/
// 위와 같이 기존의 setOperands() 메소드를 수정하면 3개의 입력값을 받을 수 있게 된다.
// 2개의 계산도 필요하다면 다음과같이 메소드의 이름을 변경하면 된다.
// c1.setOperands2(10, 20); c1.setOperands3(10, 20, 30);
// 이것도 좋은 방법이지만 매개변수의 수에 따라서 메소드의 이름이 달라지는 것은 보기좋지 않다.
// 다음의 코드를 보자.

// Example.1
/*
class Calculator {
    int left, right;
    int third = 0;

    public void setOperands(int left, int right) {
        System.out.println("setOperands(int left, int right)");
        this.left = left;
        this.right = right;
    }

    public void setOperands(int left, int right, int third){
        System.out.println("setOperands(int left, int right, int third)");
        this.left = left;
        this.right = right;
        this.third = third;
    }


    public void sum() {
        System.out.println(this.left + this.right+this.third);
    }

    public void avg() {
        System.out.println(((this.left + this.right+this.third) / 2));
    }
}

public class CalculatorDemo {

    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setOperands(10, 20);
        c1.sum();
        c1.avg();
        c1.setOperands(10, 20, 30);
        c1.sum();
        c1.avg();
    }

}
*/
// setOperands(int left, int right) 30 15
// setOperands(int left, int right, int third) 60 30
// 으로 구분되어서 출력될 것이다.
// c1.setOperands(10, 20); -> setOperands(int left, int right) 메세지
// c1.setOperands(10, 20, 30); -> setOperands(int left, int right, int third) 메세지
// 이를 통해 알 수 있는 것은 매개변수의 숫자에 따라
// 같은 이름의 서로다른 메소드를 호출하고 있다는 것을 알 수 있다.
// 이름은 같지만 시그니처가 다른 메소드를 중복으로 선언할 수 있는 방법을
// 메소드 오버로딩이라고 한다.

// 2. 오버로딩 규칙
// 결론적으로 말하면 메소드 오버로딩은 매개변수를 사용한다.
// 즉, 매개변수가 다르면 이름이 같아도 서로다른 메소드가 되는 것이다.
// 반면에 매개변수는 같지만 리턴타입이 다르면 오류가 발생한다.
// 아래의 예를 보자 .

// Example.2
/*
public class CalculatorDemo {
    void A (){System.out.println("void A()");}
    void A (int arg1){System.out.println("void A (int arg1)");}
    void A (String arg1){System.out.println("void A (String arg1)");}
    //int A (){System.out.println("void A()");}
    public static void main(String[] args) {
        CalculatorDemo od = new CalculatorDemo();
        od.A();
        od.A(1);
        od.A("coding everybody");
    }
}
*/
// A() 와 A(int) 메소드는 매개변수의 숫자가 다르다.
// A(int) 와 A(String) 메소드는 인자의 숫자는 같지만 매개변수의 데이터 타입이 다르다.
// 이런 경우는 오버로딩이 가능하다.
// 메소드를 호출 할 때 전달되는 인자의 데이터 타입에 따라서
// 어떤 메소드를 호출할지를 자바가 판단 할 수 있기 때문이다.
// 하지만 메소드의 반환값은 메소드를 호출하는 시점에서 전달되지 않는 정보이기 때문에
// int A (){System.out.println("void A()");} 는 오버로딩의 대상이 될 수 없다.

// 3. 상속과 오버로딩
// 상속의 관계에서도 오버로딩을 사용할 수 있다. 예제를 통해 알아보자.
// Example.3
/*
class OverloadingDemo {
    void A (){System.out.println("void A()");}
    void A (int arg1){System.out.println("void A (int arg1)");}
    void A (String arg1){System.out.println("void A (String arg1)");}
}

public class CalculatorDemo extends OverloadingDemo {
    void A (String arg1, String arg2){System.out.println("sub class : void A (String arg1, String arg2)");}
    void A (){System.out.println("sub class : void A ()");}
    public static void main(String[] args) {
        CalculatorDemo od = new CalculatorDemo();
        od.A();
        od.A(1);
        od.A("coding everybody");
        od.A("coding everybody", "coding everybody");
    }
}
*/
// 실행결과는 다음과 같다
/*
sub class : void A ()
void A (int arg1)
void A (String arg1)
sub class : void A (String arg1, String arg2)
*/
// CalculatorDemo 는 OverloadingDemo 를 상속받고 있다.
// CalculatorDemo 클래스에 구현된 A(String,String) 메소드는 2개의 매개변수가 있다.
// 이러한 형태는 부모클래스에 정의되어있지 않기 때문에 메소드 오버로딩이 되는 것이다.
// 반면 부모클래스와 자식클래스에 모두 A() 와같이 매개변수가 없는 메소드가 존재한다.
// 이 둘은 매개변수의 형태가 같기 때문에 오버로딩이 아닌 오버라이딩에 해당한다.
// 따라서 자식클래스의 A() 메소드가 실행된것을 볼 수 있다.

// 4. 오버로딩 vs 오버라이딩
// 오버로딩과 오버라이딩은 용어가 헷갈린다.
// 중요한 것은 오버라이딩이 무엇이고 오버로딩이 무엇인가를 구분하는 것이다.
// riding (올라탄다) 를 이용해서 부모 클래스의 메소드의 동작방법을 변경하고,
// loading 을 이용해서 같은이름, 다른 매개변수의 메소드들을 여러개 만들 수 있다는 것을 기억해두자.

// 5. 마무리
// 위의 예제는 현실적이지 않다.
// 더 많은 값을 대상으로 연산을 해야한다면 어떻게 해야할까?
// 다음과 같이 코드를 작성해보자.
// Example.4

class Calculator {
    int[] operands;

    public void setOperands(int[] oprands) {
        this.operands = oprands;
    }
    public void sum(){
        int total = 0;
        for(int value : this.operands){
            total += value;
        }
        System.out.println(total);
    }

    public void avg(){
        int total = 0;
        for(int value : this.operands){
            total += value;
        }
        System.out.println(total/this.operands.length);
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setOperands(new int[]{10,20});
        c1.sum();
        c1.avg();
        c1.setOperands(new int[]{10,20,30});
        c1.sum();
        c1.avg();
    }
}

// 위의 코드는 인자로 배열을 사용하고 있다.
// c1.setOperands(new int[]{10,20}); c1.setOperands(new int[]{10,20,30});
// 이렇게 하면 하나의 인자로 여러개의 값을 받을 수 있다.