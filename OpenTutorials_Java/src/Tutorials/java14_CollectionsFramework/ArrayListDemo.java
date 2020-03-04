package Tutorials.java14_CollectionsFramework;
import java.util.*;

// 1. 배열과 컬렉션즈 프레임워크
// 배열은 연관된 데이터를 관리하기 위한 수단이었다.
// 그런데 배열에는 몇가지 불편한 점이 있는데 그중 하나가
// 한번 정해진 배열의 크기를 변경할 수 없다는 점이다.
// 이러한 불편함을 컬렉션 프레임워크를 사용하면 줄어든다.

// Example.1
/*
public class ArrayListDemo {

    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        // arrayObj[2] = "three"; 오류가 발생한다.
        for(int i=0; i<arrayObj.length; i++){
            System.out.println(arrayObj[i]);
        }

        ArrayList al = new ArrayList();
        al.add("one");
        al.add("two");
        al.add("three");
        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
        }

    }
}
*/
// 위의 예제에서 아래부분을 자세히 보자.
/*
String[] arrayObj = new String[2];
arrayObj[0] = "one";
arrayObj[1] = "two";
arrayObj[2] = "three"; 오류가 발생한다.
*/
// 배열은 newString[2]; 처럼 한번 크기를 지정하면
// 크기보다 많은 수의 값을 저장할 수 없다.
// 하지만 ArrayList 다음과 같이
/*
ArrayList al = new ArrayList();
al.add("one");
al.add("two");
al.add("three");
*/
// ArrayList 는 크기를 미리 지정하지 않기 때문에
// 얼마든지 많은 수의 값을 저장할 수 있다.

// ArrayList 는 배열과는 사용방법이 조금 다르다.
// 배열의 경우 값의 개수를 구할 때 .length 를 사용했지만
// ArrayList 는 메소드 size 를 사용한다.
// 또한 특정 값을 가져올 때 배열은 [인덱스번호] 를 사용했지만
// 컬렉션은 .get(인텍스번호) 를 사용한다.
// 위의 예제에서 아래의 부분을 바꿔보자.
/*
for(int i=0; i<al.size(); i++){
        System.out.println(al.get(i));
}
*/
// 변경------>
/*
for(int i=0; i<al.size(); i++){
        String val = al.get(i);
        System.out.println(val);
}
*/
// 위와같이 변경하면 컴파일 오류가 발생한다.
// ArrayList 메소드 add 의 입장에서는
// 인자로 어떤 형태의 값이 올지 알 수 없다.
// 그렇기 때문에 모든 데이터 타입의 조상인 Object 형식으로 데이터를 받고 있다.
// public boolean add(Object e) -> 예를 들면 이런 모양일 것이다.
// 따라서 ArrayList 내에서 add 를 통해서 입력된 값은
// Object 의 데이터 타입을 가지고 있꼬,
// get 을 이용해서 이를 꺼내도 Object 의 데이터 타입을 가지고 있게 된다.
// 따라서 다음과 같이 바꿔야 한다.
/*
for(int i=0; i<al.size(); i++){
        String val = (String)al.get(i);
        System.out.println(val);
}
*/
// get 의 리턴값을 문자열로 형변환하고 있다. 원래의 데이터 타입이 된 것이다.
// 그치만 위의 방식은 예전의 방식이다. 이제는 아래와 같이 제네릭을 사용한다.
/*
        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("three");
        for(int i=0; i<al.size(); i++){
        String val = al.get(i);
        System.out.println(val);
        }
*/
// 제네릭을 사용하면 ArrayList 내에서 사용할 데이터 타입을
// 인스턴스를 생성할 때 지정할 수 있기 때문에
// 데이터를 꺼낼 때 형변환을 하지 않아도 된다.


// 2. 컬렉션즈 프래임워크란?
// 컬렉션즈 프레임워크 라는 것은 다른말로는 컨테이너라고도 부른다.
// 즉 값을 담는 그릇이라는 의미이다.
// 그런데 그 값의 성격에 따라 컨테이너의 성격이 조금씩 달라진다.
// 자바에서는 다양한 상황에서 사용할 수 있는 다양한 컨테이너를 제공하는데
// 이것을 컬렉션즈 프레임 워크라고 부른다.
// ArrayList 는 그중 하나이다.
// Collection 과 Map 이라는 최상위 카테고리가 있고,
// 그 아래에 다양한 컬렉션들이 존재한다.
// 몇가지 구체적인 컬렉션즈 프레임워크 클래스를 살펴보자.

// Collection ->
    // Set ->
        // HashSet, LinkedHashSet, TreeSet
    // List ->
        // ArrayList, Vector, LinkedList
    // Queue ->
        // PriorityQueue

// Map ->
    // SortedMap ->
        // TreeMap
    // Hashtable
    // LinkedHashMap
    // HashMap

// ArrayList 를 찾아보면 Collection -> List 에 속해있다.
// ArrayList 는 List 라는 성격으로 분류되고 있는 것이다.
// List 는 인터페이스다.
// 그리고 List 하위 클래스들은 모두 List 인터페이스를 구현하기 때문에
// 모두 같은 API 를 가지고 있다.
// 클래스의 취지에 따라서 구현방법과 동작방법은 다르지만
// 공통의 조작방법을 가지고 있는 것이다.
// 익숙한 ArrayList 를 바탕으로 나머지 컬렉션들의 성격을 파악해보자.


// Example.2
/*
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("two");
        al.add("three");
        al.add("three");
        al.add("five");
        System.out.println("array");
        Iterator ai = al.iterator();
        while(ai.hasNext()){
            System.out.println(ai.next());
        }

        HashSet<String> hs = new HashSet<String>();
        hs.add("one");
        hs.add("two");
        hs.add("two");
        hs.add("three");
        hs.add("three");
        hs.add("five");
        Iterator hi = hs.iterator();
        System.out.println("\n hashSet");
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }

}
*/
// 위의 예제에서 아래를 찾아 살펴보면 값을 가져오는 방법이 조금 달라졌다.
/*
Iterator ai = al.iterator();
while(ai.hasNext()){
        System.out.println(ai.next());
}
*/
// 메소드 iterator 는 인터페이스 Collection 에 정의되어 있다.
// 따라서 Collection 을 구현하고 있는 모든 컬렉션즈 프레임워크는
// 이 메소드를 구현하고 있음을 보증한다.
// 메소드는 iterator 의 호출 결과는 인터페이스 iterator 를 구현한 객체를 리턴한다.
// 인터페이스 iterator 는 아래 3개의 메소드를 구현하도록 강제하고 있는데 각각의 역할은 아래와 같다.
// hasNext ->
// 반복할 데이터가 더 있으면 true, 더 이상 없으면 false
// next ->
// hashNext 가 true 라는 것은 next 가 리턴할 데이터가 존재한다는 의미다.

// 이러한 기능을 조합하면 for 문을 이요하는 것과 동일하게 데이터를 순차적으로 처리할 수 있다.

// Set 과 List 의 차이를 짚어보자.
// 위의 결과를 통해 알 수 있듯 Set 은 중복을 허용하지 않고 순서가 없지만
// List 는 중복을 허용하고 저장되는 순서가 유지된다는 것을 알 수 있다.


// 3. Set
// Set 은 한국어로 집합이라는 뜻이다.
// 여기서의 집합이란 수학의 집합과 같은 의미이다.
// 수학에서 집합은 교집합, 차집합, 합집합과 같은 연산을 할 수 있다.
// Set 도 마찬가지다.

// 아래와 같이 3개의 집합 hs1, hs2, hs3 가 있다고 하자.
// h1 -> 1,2,3
// h2 -> 3,4,5
// h3 -> 1,2
// 와 같이 구성되어 있다. set 의 API 를 이용해서 연산해보자.

// Example.2
/*
public class ArrayListDemo {

    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);

        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);

        System.out.println(A.containsAll(B)); // false
        System.out.println(A.containsAll(C)); // true

        //A.addAll(B);
        //A.retainAll(B);
        //A.removeAll(B);

        Iterator hi = A.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }

}
*/
// 부분집합 (subset)
// System.out.println(A.containsAll(B)); // false
// System.out.println(A.containsAll(C)); // true
// b 는 a 의 부분집합이 아니다.
// c는 a의 부분집합이다.

// 합집합 (union)
// A와 B의 합집합.
// A.addAll(B); -> 1,2,3,4,5

// 교집합 (intersect)
// A와 B의 교집합.
// A.retainAll(B); -> 3

// 차집합 (difference)
// A와 B의 차집합.
// A.removeAll(B); -> 1,2



// 4. Map
// Map 컬렉션에 대해 알아보자.
// Map 컬렉션은 key 와 value 의 쌍으로 값을 저장하는 컬렉션이다.
// Example.3
/*
public class ArrayListDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<String, Integer>();
        a.put("one", 1);
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);
        System.out.println(a.get("one"));
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));

        iteratorUsingForEach(a);
        iteratorUsingIterator(a);
    }

    static void iteratorUsingForEach(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

}
*/
// Map 에서 데이터를 추가할 때 사용하는 API 는 put 이다.
// put 의 첫번째 인자는 값의 key 이고,
// 두번째 인자는 key 에 대한 값이다.
// key 를 이용해서 값을 가져올 수 있다.
// System.out.println(a.get("one"));
// Map 에서 데이터를 열거할 때는 다음과같이 한다.
/*
Set<Map.Entry<String, Integer>> entries = map.entrySet();
for (Map.Entry<String, Integer> entry : entries) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
}
*/
// 메소드 entrySet(); 은 Map 데이터를 담고있는 Set 을 반환한다.
// 반환한 Set 의 값이 사용할 데이터 타입은 Map.Entry 이다.
// Map.Entry 는 인터페이스 인데 아래와 같은 API 를 가지고 있다.
// -> getKey
// -> getValue
// 위의 API 를 이용해서 Map 의 key, value 를 조회할 수 있다.

// 앞서 Set 이 수학의 집합을 프로그래밍 적으로 구현한 것이라면
// map 은 수학의 함수를 프로그래밍화 한 것이다.
// 프로그래밍을 하게 되면 수학적인 지식들을 매우 구체적으로 경험할 수 있기 때문에
// 프로그래밍은 수학에 대한 좋은 실습 도구라고 할 수 있다.
// 프로그래밍에 익숙해지고 수학공부를 시작해보면
// 프로그래밍의 많은 장치들이 수학적인 장치들을 빌려온 것임을 알 수 있다.

// 4-1 데이터 타입의 교체
// 컬렉션을 사용할 때는 데이터 타입은 가급적 해당 컬렉션을 대표하는 인터페이스를 사용하는 것이 좋다.

// HashMap<String, Integer> a = new HashMap<String, Integer>();
// 이것을 아래와 같이 수정한다면
// HashMap 이 Map 인터페이스를 구현하기 때문에 변수 a의 데이터 타입으로 Map 을 사용할 수 있다.
// Map<String, Integer> a = new HashMap<String, Integer>();
// 어떠한 필요에 의해 컬렉션을 HasMap 에서 HashTable 로 바꾸고 싶다면 아래와 같이 수정하면 된다.
// Map<String, Integer> a = new Hashtable<String, Integer>();



// 5. 정렬
// 컬렉션을 사용하는 이유 중 하나는 정렬과 같은 데이터와 관련된 작업을 하기 위해서다.
// 패키지 java.util 에는 Collections 라는 클래스가 있다.
// 이 클래스를 사용하는 방법을 알아보자.
// Example.4
class Computer implements Comparable{
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    public int compareTo(Object o) {
        return this.serial - ((Computer)o).serial;
    }
    public String toString(){
        return serial+" "+owner;
    }
}

public class ArrayListDemo {

    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));
        Iterator i = computers.iterator();
        System.out.println("before");
        while(i.hasNext()){
            System.out.println(i.next());
        }
        Collections.sort(computers);
        System.out.println("\nafter");
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

}
// 클래스 Collectors 는 다양한 클래스 메소드를 가지고 있다.
// 메소드 sort 는 그 중의 하나로 List 의 정렬을 수행한다.
// 다음은 sort 의 시그니처다.
// public static <T extends Comparable<? super T>> void sort(List<T> list)
// sort 의 인자인 list 는 데이터 타입이 List 이다.
// 즉, 메소드 sort 는 List 형식의 컬렉션을 지원한다는 것을 알 수 있다.
// 인자 list 의 제네릭<T>는 Comparable 을 extends 하고 있어야한다.
// Comparable 은 인터페이스 인데 이를 구현하고 있는 클래스는 아래 메소드를 가지고 있어야 한다.
// -> compareTo(T o)
// 메소드 sort 를 실행하면 내부적으로 compareTo 를 실행하고
// 그 결과에 따라서 객체의 선후 관계를 판별하게 된다.
// 컬렉션은 단순히 사용법을 이해하는 것으로는 부족하다.
// 알고리즘이나 자료구자라 불리는 분야에 대한 충분한 이해가 필요하다.
// 컬렉션즈 프레임워크는 이러한 분야의 성취를 누구나 쉽게 사용할 수 있도록 제공하는
// 일종의 라이브러리라고 할 수 있기 때문이다.