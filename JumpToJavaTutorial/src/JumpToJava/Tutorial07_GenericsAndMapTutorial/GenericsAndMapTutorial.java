package JumpToJava.Tutorial07_GenericsAndMapTutorial;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericsAndMapTutorial {

    public static void main(String[] args){

        // Generics 는 자바 J2SE 5.0 이후에 도입된 개념이다.
        // Generics 사용법에 대해서 알아보자.

        // 1. Generics
        ArrayList<String> generics = new ArrayList<String>();
        // ArrayList
        ArrayList arrayList = new ArrayList();

        // 두 개 코드의 차이점은 ArrayList 라는 타입 바로 옆에 <String>과 같은 문구가 있느냐 없느냐 이다.
        // <String>을 추가한 Generics 표현식은 다음과 같은 의미이다.
        // "ArrayList 안에 담을 수 있는 자료형은 String 뿐이다."
        // *String 뿐만 아니라 <Integer>, <Animal>, <Dog> 등 어떤 자료형도 사용할 수 있다.

        // Generics 를 사용하면 좀 더 명확한 타입 체크가 가능해진다.
        // Generics 를 사용하지 않는 경우를 살펴보도록 하자.

        arrayList.add("Array");
        arrayList.add("List");
        arrayList.add("Test");

        String array = (String) arrayList.get(0); // Object 를 String 으로 캐스팅한다. (String)
        String list = (String) arrayList.get(1);
        // 위처럼 Generics 를 사용하지 않을 경우
        // ArrayList 안에 추가되는 객체는 Object 자료형으로 인식된다.
        // Object 자료형은 모든 객체가 상속하고 있는 가장 기본적인 자료형이다.
        // 따라서 ArrayList 객체인 arrayList 에 값을 넣을 때는 문제가 안되지만
        // 값을 가져올 경우 항상 Object 자료형에서 String 자료형으로 형 변환을 해 주어야 한다.

        System.out.println("---ArrayList/Object---");
        System.out.println(array); // Array
        System.out.println(list); // List

        // 형 변환을 해주지 않으면 사용이 불가능하다.
        // String test = arrayList.get(2); // 컴파일 에러
        // arrayList 안에 String 객체 이외의 객체를 넣을 수 있기 때문에
        // 형 변환 과정에서 잘못된 형 변환으로 오류가 발생할 수 있다.
        // 이러한 이유에서 Generics 가 탄생하였다.

        // Generics 로 동일하게 실행하여 보자.
        generics.add("Generics");
        generics.add("Test");

        String generics1 = generics.get(0); // 아까와 다르게 에러가 뜨지 않는다.
        String test = generics.get(1);

        System.out.println("---Generics Test---");
        System.out.println(generics1); // Array
        System.out.println(test); // List

        // Generics 로 자료형을 선언하기만 하면 그 이후로는 자료형에 대한 형 변환 과정이 필요없다.
        // 이미 컴파일러가 generics 에는 반드시 String 자료형만 추가 되어야 함을 알기 때문이다.
        // 이렇게 Generics 를 이용하면 형변환에 의한 불필요한 코딩, 잘못된 형 변환에 의한 런타임 오류에서 벗어날 수 있다.


        // 2.Map
        // 사람을 예로 들면 이름 = 홍길동 , 생일 = 00월 00일 등으로 구분할 수 있다.
        // Map 은 이러한 대응 관계를 쉽게 표현할 수 있게 해주는 자료형이다.
        // 요즘 나오는 대부분의 언어들이 갖고 있는 자료형으로 Associative array, Hash 라고도 불린다.
        // Map 은 Dictionary -> 사전과 비슷하다.
        // people = 사람, soccer = 축구 라는 뜻이 부합되듯이
        // Key 와 Value 라는 것을 한 쌍으로 갖는 자료형이다.

        // Map 은 List 나 Array 처럼 순차적으로 값을 구하지 않는다.
        // Map 의 가장 큰 특징이라면 key 로 value 를 얻어낸다는 점이다.
        // people 이란 단어를 찾기위해 사전을 순차적으로 검색하는 것이 아니라
        // people 이란 단어가 있는 곳만을 펼쳐보는 것이다.

        // 2-1 put()
        // Map 중에서 가장 간단한 HashMap 에 대해서 알아보자.
        // *Map 역시 List 와 마찬가지로 인터페이스다.
        // Map 인터페이스로 구현한 자료형에는 HashMap, LinkedHashMap, TreeMap 등이 있다.

        HashMap<String, String> hashMap = new HashMap<String,String>();
        hashMap.put("people","사람");
        hashMap.put("soccer","축구");
        // key 와 value 가 String 형태인 HashMap 을 만들고 항목을 입력해 보았다.
        // put() 메소드를 이용하여 put(key,value) 방식으로 입력한다.
        // *HashMap 역시 Generics 를 사용한다.

        // 2-2 get()
        // get(key) 를 입력하면 value 값을 얻을 수 있다.
        System.out.println("---HashMap.get()---");
        System.out.println(hashMap.get("people")); // 사람

        // 2-3 containsKey(), containsValue()
        // containsKey(키) 를 입력하면 해당 Key 가 존재하는지를 판단하여 그 결과값을 true, false 로 리턴한다.
        // containsValue(값) 을 입력하면 마찬가지로 해당 Value 가 존재하는 지를 판단한다.
        System.out.println("---HashMap.containsKey()---");
        System.out.println(hashMap.containsKey("people")); // true
        System.out.println(hashMap.containsKey("animal")); // false
        System.out.println("---HashMap.containsValue()---");
        System.out.println(hashMap.containsValue("축구")); // true;
        System.out.println(hashMap.containsValue("야구")); // false;

        // 2-4 remove()
        // remove(키) 를 입력하면 해당 Key 에 해당하는 데이터를 삭제한 후 Value 값을 리턴한다.
        System.out.println("---HashMap.remove()---");
        System.out.println(hashMap.remove("soccer")); // 축구

        // 2-5 size()
        // size() 는 Map 의 갯수를 리턴한다.
        System.out.println("---HashMap.size()---");
        System.out.println(hashMap.size()); // 1

        // Map 의 가장 큰 특징은 순서에 의존하지 않고 Key 로 Value 를 가져오는데 있다.
        // 하지만 Map 에 입력된 순서대로 데이터를 가져오고 싶은 경우도 있다.
        // LinkedHashMap 은 입력된 순서대로 데이터가 출력되는 특징을 가지고 있다.
        // TreeMap 은 입력된 key 의 종류순으로 데이터가 출력되는 특징을 가지고 있다.
    }

}
