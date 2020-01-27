package JumpToJava.Tutorial29_SmallProjectTutorial.tell;
import java.util.ArrayList;
import java.util.HashMap;

public class Packet {
    // HashMap 객체는 HashMap<String, Item> 처럼
    // <key, value> 를 저장할 수 있다.
    // 지금같은 경우는 Key -> 이름 , value 는 Item 객체이다.
    private HashMap<String, Item> nameAccess = new HashMap<String, Item>();

    // Item 의 갯수는 가변이기 때문에
    // ArrayList 를 이용하여 Item 객체를 담을 수 있도록 하였다.
    private ArrayList<Item> items = new ArrayList<Item>();

    // 다음은 Item 을 Packet 에 넣고 빼오는 일이다.

    // 리턴자료형이 없고 입력으로 Item 객체를 입력받는 메소드이다.
    public void addItem(Item item){
        this.items.add(item); // items 라는 ArrayList 에 입력받은 아이템을 추가한다.

        // 추가된 if문
        // containsKey() 메소드에 네임을 입력하고 해당 이름이 있을 경우
        if(nameAccess.containsKey(item.getName())) {
            // RuntimeException 을 발생시킨다.
            // 이렇게되면 중복된 이름으로 아이템이 등록되지 않는다.
            throw new RuntimeException(
                    "Duplicated item name:["+item.getName()+"]");
        }
        // 추가된 if문

        nameAccess.put(item.getName(), item);
    }

    // 리턴자료형이 Item 객체이며
    // 입력값으로 int index 를 입력받는 메소드이다.
    public Item getItem(int index){
        // 입력받은 index 로
        // items ArrayList 에서 해당 index 의 Item 객체를 꺼내와 리턴한다.
        return this.items.get(index);
    }

    // 리턴자료형이 Item 객체이며
    // 입력값으로 String name 을 입력받는 메소드이다.
    public Item getItem(String name){
        return nameAccess.get(name);
        // 입력받은 name 으로
        // nameAccess HashMap 에서 해당 name 을 찾아 Item 객체를 반환한다.
        // 이제 getItem() 메소드에 이름을 입력값으로 전달하면
        // 해당 Item 객체를 가져올 수 있게 된다.
        // *주의점
        // 각각의 Item 이 동일한 이름을 사용할 수도 있다는 점이다.
        // 이럴경우 nameAccess 의 키가 중복될 수 있기 때문에 문제가 될 수 있다.
        // 동일한 이름으로 항목을 설정할 수 없다는 규칙을 만들어야 한다.
        // addItem 으로가서 if 문을 하나 추가하자.
    }



    // String 자료형을 리턴하는 메소드이다.
    public String raw() {
        // StringBuffer 객체 result 를 만들고
        StringBuffer result = new StringBuffer();
        // for each 를 활용한다.
        // items 는 for 문을 돌릴 객체이다.
        // items ArrayList 를 돌면서
        // 타입이 Item 객체르 순차적으로 돌면서
        // 돌때마다 item 에 바꿔 담는다.
        for(Item item: items) {
            // append() 메소드를 사용해서 result 에 item.raw() 를 추가한다.
            result.append(item.raw());
        }
        // for 문이 끝나고 result 를 toString() 으로 문자열로 리턴한다.
        return result.toString();
    }

    // 리턴자료형이 없고 입력으로 String data 를 입력받는 메소드이다.
    public void parse(String data) {
        // 바이트 배열을 만들고 그안에 String 입력값을 byte 로 변환하여 담는다.
        byte[] byteData = data.getBytes();
        int pos = 0; // pos 라는 int 변수를 생성한다.
        for(Item item: items) { // ArrayList items 를 검사하여 item 에 담는 for each 문이다.

            // 임시 byte[] temp 에 새로운 byte[] 을 item 의 길이로 생성한다.
            byte[] temp = new byte[item.getLength()];

            // System. arrayCopy() 메소드는 값을 복사하는 메소드이다.
            // 입력값에는 (소스, 소스시작위치, 대상, 대상시작위치, 복사할길이) 를 입력한다.
            // 소스 -> parse(data) 메소드 입력값인 String data 의 byte 변환 값
            // 소스시작위치 = pos
            // 대상 -> 임시 byte[] 인 temp
            // 대상 시작위치 -> 0 -> 처음부터
            // 복사할 길이 -> items 에서 찾은 현재 item 의 객체변수 length 의 길이
            System.arraycopy(byteData, pos, temp, 0, item.getLength());

            // pos 에 현재 item 의 길이만큼 더한다.
            // 다시 반복되면 입력값에서 위에서 입력 된 길이 뒤부터 arrayCopy() 를 하기 위함
            // 즉, 소스 시작위치를 지정하는 것이다.
            pos += item.getLength();

            // 현재 아이템의 value 에 temp 라는 byte[] 을 String 으로 변환하여 입력한다.
            item.setValue(new String(temp));
        }
    }

    // raw 메소드가 정상적으로 동작하는지 확인해보자.
    public static void main(String[] args) {
        /*
        Packet packet = new Packet(); //Packet 객체를 생성한다.

        Item item1 = new Item(); // Item 객체를 생성한다.
        item1.setName("이름"); // Item 객체변수 name 에 "이름" 이라는 문자열을 set
        item1.setLength(15); // Item 객체변수 length 에 15 라는 int 값을 set
        item1.setValue("홍길동"); // Item 객체변수 value 에 "홍길동" 이라는 문자열을 set

        Item item2 = new Item(); // Item 객체 생성
        item2.setName("전화번호"); // Item 객체변수 name 에 "이름" 이라는 문자열을 set
        item2.setLength(11); // Item 객체변수 length 에 11 이라는 int 값을 set
        item2.setValue("01099998888"); // Item 객체변수 value 에 "01099998888" 이라는 문자열을 set
        */
        // packet 객체의 addItem() 메소드에 item 객체를 입력하여
        // ArrayList items 에 추가한다.
        /*
        packet.addItem(item1);
        packet.addItem(item2);
        */
        // raw() 메소드는 ArrayList items 에 추가된 내용을
        // 하나의 문자열로 만들어 출력하게된다.
        /*
        System.out.println("["+packet.raw()+"]");
        */
        // 홍길동 + 공백 + 01099998888 이 출력된다.

        // item 객체를 생성하는 과정이 너무 장황하다.
        // Item.java 로 이동하여 다음과 같은 메소드를 추가해보자.
        /*
        public static Item create(String name, int length, String value) {
            Item item = new Item();
            item.setName(name);
            item.setLength(length);
            item.setValue(value);
            return item;
        }
        */
        // create 메소드는 name, length, value 를 입력으로 받아서
        // Item 객체를 생성하고 리턴해주는 static 메소드이다.
        // 이러한 메소드를 팩토리 메소드라 부른다.
        // 다음과 같이 간소화하여 출력해보자.

        // create 메소드를 활용하여 조금다 간소화되었다.
        /*
        Item item1 = Item.create("이름", 15, "홍길동");
        Item item2 = Item.create("전화번호", 11, "01099998888");

        packet.addItem(item1);
        packet.addItem(item2);

        System.out.println("["+packet.raw()+"]");
        */
        // 같은 결과가 출력된다.

        // 전문을 생성하는 프로그램이 완성되었다.
        // 이렇게 생성한 전문은 타 시스템으로 송신될 것이다.
        // 그리고 타 시스템 에서는 송신된 전문을 해석하여 응답 전문을 리턴한다.
        // 응답으로 받은 전문을 파싱하는 프로그램을 작성해보자.

        // 3. 전문 파싱
        // 수신반은 전문이 다음과 같다고 가정해보자.
        // ex) 19801215서울시 송파구 잠실동 123-3
        // 수신 전문은 생일(8)+ 주소(39) 형태의 전문이다.

        // 전문을 파싱하기 위해서는 항목과 길이를 알아야한다.
        // 이미 송수신 전문 규칙을 알고있기 때문에 다음과 같이 Packet 을 만들 수 있다.
        // value 는 파싱을 해야만 알 수 있는 정보이므로 null 을 셋팅한다.

        Packet recPacket = new Packet();
        recPacket.addItem(Item.create("생일",8,null));
        recPacket.addItem(Item.create("주소",39,null));

        // 이제 parse 메소드를 추가해보자.
        // Packet 클래스 내부에 parse 메소드가 추가되었다면 사용해보자.
        // 수신전문은 recPacket 을 이용하여 다음과 같이 파싱할 수 있다.

        recPacket.parse("19801215서울시 송파구 잠실동 123-3    ");
        /*
        // parse() 메소드를 이용해 입력된 정보를 파싱하면 다음과같이 출력할 수 있다.
        System.out.println(recPacket.getItem(0).raw()); // 19801215
        System.out.println(recPacket.getItem(1).raw()); // 서울시 송파구 잠실동 123-3
        */
        // "19801215서울시 송파구 잠실동 123-3    " 로 전화번호와 주소가 통째로 입력되었을 때
        // 전화번호와 주소가 나뉘어서 각각 저장된다.
        // recPacket 에서 사용한 getItem() 메소드가 사용방법이 불편해보인다.
        // getItem(1) 과 같이 "주소" 에 해당하는 값을 얻기 위해서는
        // "주소"가 몇번째 항목인지 기억해야하기 때문이다.
        // 위처럼 항목이 2개인 경우는 알기 쉽지만 50개 이상 된다면
        // 모든 항목들의 위치를 기억하고 있어야만 하기 때문이다.

        // Packet 클래스에서 한 개의 Item 을 Access 하는 가장 좋은 방법은 Item 의 이름으로
        // Access 하는 것이 가장 좋을 것 같다.
        // Packet 클래스를 변경할 필요가 있어 보인다.
        // 변경한 후 다음과 같이 실행해보자.

        System.out.println(recPacket.getItem("생일").raw()); // 19801215
        System.out.println(recPacket.getItem("주소").raw()); // 서울시 송파구 잠실동 123-3
        // Packet 아이템들에 이름으로 접근이 가능해졌다.
    }
}
