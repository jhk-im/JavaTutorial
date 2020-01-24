package AccessModifier;
import Protected.ProtectedTest;

public class AccessModifier extends ProtectedTest {

    // 1. 접근 제어자 AccessModifier
    // 접근 제어자는 다음과 같다.
    // private
    // default
    // protected
    // public
    // 하나씩 알아보자.

    // 1-1 private
    // private 이 붙은 변수, 메소드는 해당 클래스에서만 접근이 가능하다.
    // 다음과 같이 작성해보자.
    private String secret;
    private String getSecret(){
        return this.secret;
    }
    public String publicAccess = "현재 클래스";

    // 같은 패키지 내부에 AccessModifier2.java 를 만들고 위와 동일한 코드를 입력한 후 다음과 같이 작성해보자.
    public static void main(String[] args){
        System.out.println("---private---");
        AccessModifier am = new AccessModifier();
        am.secret = "현재 클래스Private";
        System.out.println(am.getSecret());
        // AccessModifier 는 현재 main 이 위치하고 있는 클래스이다.
        // 그렇기 때문에 private 로 선언한 String secret 과 getSecret() 메소드에 접근할 수 있다.
        // Private 이 출력되는 것을 확인할 수 있다.

        AccessModifier2 am2 = new AccessModifier2();
        // am2.secret -> 컴파일 에러 -> 찾을 수 없음
        // am2.getSecret() -> 컴파일 에러 -> 찾을 수 없음
        // 반대로 다른 클래스인 AccessModifier2 를 보면
        // private 으로 선언한 String secret 과 getSecret() 메소드는 접근이 되지 않는다.

        // 2-2 default
        // 접근제어자가 없는 변수, 메소드는 default 접근제어자가되어 해당 패키지 내에서만 접근 가능하다.
        // 이번엔 AccessModifier2.java 에 다음과 같이 추가해보자.
        // String defaultString ="Default";
        // 외부 패키지에서도 확인을 위해 현재 패키지 밖에 Protected 패키지를 생성하고 그안에
        // ProtectedTest.java 를 만들고 동일하게 위의 코드를 작성하자.
        // 그리고 현재 클래스에서 ProtectedTest 클래스를 상속받자.
        // import Protected.ProtectedTest;
        // AccessModifier 클래스에 다음과같이 추가한다.
        // public class AccessModifier extends ProtectedTest
        // 추가한 후 다음과같이 접근하여보자.

        System.out.println("---default---");
        ProtectedTest protectedTest = new ProtectedTest();
        System.out.println(am2.defaultString); // Default
        //System.out.println(protectedTest.); -> default 접근 불가능
        // AccessModifier2 와 현재 클래스는 동일한 패키지에 있다.
        // defaultString 의 접근제어자가 default 이므로 현재 클래스에서 접근이 가능하다.
        // 반면 ProtectedTest 는 현재 클래스의 외부 패키지에 존재한다.
        // 때문에 default 접근자에는 접근이 불가능하다.
        // AccessModifier2의 defaultString 에만 접근한 String 문자열이 출력된다.


        // 1-3 protected
        // protected 가 붙은 변수, 메소드는
        // 동일 패키지 내의 클래스 또는 해당 클래스를 상속받은 외부 패키지의 클래스에서 접근가능하다.
        // 확인을 위해 AccessModifier2.java 에 다음과 같이 추가해보자.
        // protected String protectedString = "Protected";
        // ProtectedTest 에도 동일한 내용을 추가한다.
        // 추가한 후 다음과같이 작성해보자.

        System.out.println("---protected---");
        System.out.println(am2.protectedString); // 같은 패키지 Protected
        System.out.println(am.protectedString); // 다른패키지 Protected
        // 다른 패키지에 있는 ProtectedTest 클래스를 상속받은 현재 클래스에서
        // ProtectedTest 내부에 protected 로 선언된 protectedString 에 접근할 수 있다.
        // 간단하게 말해 다른 패키지에 있는 클래스의 변수에 접근할 수 있는 방법이라고 생각하자.
        // AccessModifier2 에 선언된 protected 로 선언된 protectedString 에도 접근이 가능하다.

        // 1-5 public
        // public 이 붙은 변수, 메소드는 어떤 클래스에서도 접근이 가능하다.
        // 지금까지 만든 모든 클래스에 다음과 같은 public 변수를 추가해보자.
        // AccessModifier 클래스 -> public String publicAccess = "현재 클래스";
        // AccessModifier2 클래스 -> public String publicAccess1 = "같은 패키지 클래스";
        // ProtectedTest 클래스 -> public String publicString = "다른 패키지 클래스";
        // 각각 모두 접근이 가능한지 확인하기 위해 변수명을 달리하였다.
        // 추가한 후 다음과 같이 작성해보자.

        System.out.println("---protected---");
        System.out.println(am.publicAccess); // 현재 클래스
        System.out.println(am2.publicAccess1); // 같은 패키지 클래스
        System.out.println(am.publicString); // 다른 패키지 클래스
        // publicAccess, publicAccess1, publicString 은 모두 public 이 붙어있고
        // 각각 현재클래스, 같은 패키지 다른 클래스, 다른패키지 클래스에 선언한 변수이다.
        // 어떤 클래스에서도 접근이 가능한 것을 확인할 수 있다.
        // 이상 총 4개의 접근제어자를 알아보았다.
        // 메소드도 마찬가지로 동일한 접근제어 규칙을 따른다.

        //* 클래스 내의 클래스를 inner 클래스라고 부란다.
        // inner 클래스에도 접근제어자를 붙여 접근을 제어할 수 있다.

        // * 접근제어자를 모두 public 으로 해도 프로그램은 잘 동작한다.
        // 다만 적절하게 사용하면 코딩 실수를 방지하고 기타 위험요소를 제거할 수 있는 등 장점이 있다.

    }


}
