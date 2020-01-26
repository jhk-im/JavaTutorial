// 1. 전문 송수신
// 대규모 프로젝트를 진행 하다보면 항상 서로 다른 시스템끼리 데이터를 주고받아야 하는 상황이 있다.
// 가장 쉽게 사용하는 것이 전문을 주고받는 방법이다.
// 여기서 전문이란 서로 약속한 규칙대로 주고받는 일반 텍스트 파일을 말한다.

// * 전문을 생성하고 파싱하는 프로그램을 만들어보자.
// 파싱 -> 전문을 길이대로 자른다 라는 의미이다.

/*
* -> 요청 전문으로 "이름", "전화번호"를 보내면 응답으로 "생일","주소"를 리턴한다.
* -> 이름은 15자리이다.
* -> 전화번호는 11자리이다.
* -> 생을은 8자리이다.
* -> 주소는 30자리이다.
* */

/*
* 요청 -> 이름(15) + 전화번호(11)
* 응담 -> 생일(8) + 주소(30)
* */

// 요청 전문의 예
// 홍길동 01099998888
// 요청 전문은 이름(10byte) + 전화번호(11byte)가 합쳐진 모습이다.
// 한글은 2바이트 이므로 홍길동 뒤에 4바이트의 여백이 필요하다.

// 응답 전문의 예
// 19801215서울시 송파구 잠실동 123-3


// 2. 전문 생성하기
// 먼저 아래와 같이 패키지를 추가한다.
package net.wikidocs.tell;
// Item 클래스가 가져야 할 속성
// 이름 , 길이, 값
public class Item {

    private String name; // 이름 ex) 이름, 전화번호,생일, 주소
    private int length; // 길이 ex) 주소(30) 에서 30-> 자리수 길이
    private String value; // 값 ex) 이름 = 홍길동 에서 홍길동 이라는 값

    // name, length, value 변수에 직접 접근 할 필요가 없으므로
    // private 으로 바꾸고 값을 세팅하고 읽기위해 getter 와 setter 를 설정하자.

    // name 의 getter setter
    // getName() 은 리턴자료형 String 이며
    // 호출시 Item 의 name 을 리턴한다.
    public String getName(){
        return name;
    }
    // setName(name) 은 String 변수를 입력받으며
    // Item 객체의 name 변수를 입력값으로 set 해준다.
    public void setName(String name){
        this.name = name;
    }

    // length 의 getter setter
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    // value 의 getter setter
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // create 메소드는 name, length, value 를 입력으로 받아서
    // Item 객체를 생성하고 리턴해주는 static 메소드이다.
    // 이러한 메소드를 팩토리 메소드라 부른다.

    public static Item create(String name, int length, String value) {
        Item item = new Item();
        item.setName(name);
        item.setLength(length);
        item.setValue(value);
        return item;
    }


    // 보통 데이터 성격의 클래스를 만들 때에는
    // 속성들을 private 으로 선안한 후에 getter 와 setter 를 구현해 사용한다.

    // 이제 한 개의 항목에 값을 설정해보고
    // 항목의 길이에 맞게끔 데이터가 생성되도록 작성해보자.

    // raw() 메소드는  호출시 String value 값을 리턴해준다.
    public String raw() {
        // StringBuffer 에 값을 담는다.
        StringBuffer padded = new StringBuffer(this.value);

        // 1. StringBuffer padded 에 toSting() 메소드로 문자열을 뽑는다
        // 2. 뽑은 문자열을 getBytes() 메소드로 바이트로 변환하고 .length 로 길이를 체크한다.
        // * 간단하게 문자열길이를 체크하는 방법은 padded.length 를 하면되지만
        // -> 한글때문에 바이트로 변환한 후 길이를 다시 세어야 한다.
        // -> "홍길동" 을 바이트로 변환하지 않고 length 메소드를 이용하면 3이 나오기 때문이다.
        // "홍길동".length(); -> 3 , "홍길동".getByte().length; // 9
        // 한글 encoding 이 UTF-8 일 경우 한글 1개의 문자는 3바이트로 계산한다.
        // 전문 송수신시 길이체크는 항상 바이트 단위로 변환한 후 체크해야 안전하다.

        // padded 에 입력된 값의 길이가 Item 의 객체변수 length 길이보다 작은 동안에 반복하는 while 문 이다.
        while (padded.toString().getBytes().length < this.length) {
            padded.append(' '); // append() 메소드로 "홍길동" 뒤로 length 만큼 ' ' 공백 문자열을 추가한다.
        }
        //while 문이 종료되면 홍길동 + 객체변수 length 길이만큼 추가된 공백 ->  문자열을 리턴한다.
        return padded.toString();
    }

    public static void main(String[] args) {
        Item item = new Item(); //Item 객체 생성
        item.setName("이름"); //String name 에 "이름" set
        item.setLength(15); // Int length 에 길이값으로 10 set
        item.setValue("홍길동"); // String value 에 "홍길동" set

        // name, length, value 를 리턴해주는 객체 변수 각각의 getter 메소드를 사용해보자.
        System.out.println("["+item.getName()+"]"); // 이름
        System.out.println("["+item.getLength()+"]"); // 자리수
        System.out.println("["+item.getValue()+"]"); // 값
        // 이름, 10, 홍길동 을 출력한다.

        // 이제 길이에 맞게 공백이 채워져있도록 값을 출려하는 메소드를 만들어보자.
        /*
        public String raw() {
            StringBuffer padded = new StringBuffer(this.value);
            while (padded.toString().getBytes().length < this.length) {
                padded.append(' ');
            }
            return padded.toString();
        }
        */
        System.out.println("["+item.raw()+"]");
        // 홍길동 + 공백 문자열 이 출력된다.
        // 이제 이름 + 전화번호처럼 여러개의 아이템이 합쳐진 완전한 송신문을 만들어야한다.

        // Packet.java 를 생성하고 이동하자.


    }


}
