package Tutorials.java21_MAP;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MAP {

    public static void main(String[] args){

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("people","사람");
        map.put("baseball","야구");

        System.out.println(map.get("people")); // 사람
        System.out.println(map.get("baseball")); // 야구

        System.out.println(map.containsKey("people")); // true
        System.out.println(map.containsKey("baseball")); // true
        System.out.println(map.containsKey("soccer")); // false

        System.out.println(map.containsValue("사람")); // true
        System.out.println(map.containsValue("야구")); // true
        System.out.println(map.containsValue("축구")); // false

        System.out.println(map.remove("people")); // 사람
        System.out.println(map.containsValue("people")); // false
        System.out.println(map.remove("야구")); // null

        System.out.println(map.size()); // 1
        System.out.println(map.remove("baseball"));

        map.put("a","A");
        map.put("b","B");
        map.put("c","C");
        map.put("가","ㄱ");
        map.put("나","ㄴ");
        map.put("1","one");
        map.put("2","two");
        map.put("A","a");
        map.put("B","b");
        // {가=ㄱ, a=A, 1=one, A=a, b=B, 2=two, B=b, c=C, 나=ㄴ}
        System.out.println(map);


        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("a","A");
        treeMap.put("b","B");
        treeMap.put("c","C");
        treeMap.put("가","ㄱ");
        treeMap.put("나","ㄴ");
        treeMap.put("1","one");
        treeMap.put("2","two");
        treeMap.put("A","a");
        treeMap.put("B","b");

        // {1=one, 2=two, A=a, B=b, a=A, b=B, c=C, 가=ㄱ, 나=ㄴ}
        System.out.println(treeMap);

        System.out.println(treeMap.firstKey()); // 1
        System.out.println(treeMap.firstEntry()); // 1=one
        System.out.println(treeMap.lastKey()); // 나
        System.out.println(treeMap.lastEntry()); // 나=ㄴ
        System.out.println(treeMap.higherKey("A")); // B
        System.out.println(treeMap.higherEntry("A")); // B=b
        System.out.println(treeMap.lowerKey("A")); // 2
        System.out.println(treeMap.lowerEntry("A")); // 2=two



        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<String, String>();
        linkedMap.put("a","A");
        linkedMap.put("b","B");
        linkedMap.put("c","C");
        linkedMap.put("가","ㄱ");
        linkedMap.put("나","ㄴ");
        linkedMap.put("1","one");
        linkedMap.put("2","two");
        linkedMap.put("A","a");
        linkedMap.put("B","b");

        //{a=A, b=B, c=C, 가=ㄱ, 나=ㄴ, 1=one, 2=two, A=a, B=b}
        System.out.println(linkedMap);

        String s = "string";
        String s1 = "string";
        System.out.println(s.hashCode()); // -891985903
        System.out.println(s1.hashCode()); // -891985903
        System.out.println(s.equals(s1)); // true

        HashMap<String,Integer> testMap = new HashMap<String,Integer>();
        testMap.put("s",2);
        testMap.put("s",1);
        testMap.put("s1",2);
        System.out.println(testMap); // {s=1, s1=2}
    }

}
