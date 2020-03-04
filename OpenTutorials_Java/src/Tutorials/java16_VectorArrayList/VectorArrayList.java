package Tutorials.java16_VectorArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class VectorArrayList {

    public static void main(String[] args){


        // Integer 를 담는 Vector
        Vector<Integer> integerVector = new Vector<Integer>();
        integerVector.add(1); // 맨뒤에 요소 추가
        integerVector.add(2);
        integerVector.add(3);
        integerVector.add(3,4); // 지정된 위치에 요소추가
        System.out.println(integerVector); // [1, 2, 3, 4]
        for(int i=0; i<integerVector.size(); i++){ // Vector.size()
            System.out.println(integerVector.get(i)); // Vector.get()
        }
        integerVector.remove(1);
        System.out.println(integerVector); // [1, 3, 4]
        System.out.println(integerVector.capacity()); // 10 --> 벡터의 현재 용량 반환
        //integerVector.clear();
        integerVector.removeAllElements(); // 벡터의 모든요소 삭제 후 크기 0
        System.out.println(integerVector); // []
        System.out.println(integerVector.isEmpty()); // true

        // String 을 담는 Vector
        Vector<String> stringVector = new Vector<String>();
        stringVector.add("Hello");
        stringVector.add("World");
        stringVector.add(0,"Vector");
        System.out.println(stringVector); // [Vector, Hello, World]
        for(int j=0; j<stringVector.size(); j++){  // Vector.size()
            System.out.println(stringVector.get(j)); // Vector.get()
        }

        // Integer 를 담는 ArrayList
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(1); // 맨뒤에 요소추가
        integerArrayList.add(2); // 맨뒤에 요소추가
        integerArrayList.add(3); // 맨뒤에 요소추가
        integerArrayList.add(3,4); // 지정된 위치에 요소추가
        System.out.println(integerArrayList); // [1, 2, 3 ,4]
        for(int k=0; k<integerArrayList.size(); k++) { // Vector.size()
            System.out.println(integerArrayList.get(k)); // Vector.get()
        }
        integerArrayList.remove(1);
        System.out.println(integerArrayList); // [1, 3, 4]
        integerArrayList.clear();
        System.out.println(integerArrayList); // []
        System.out.println(integerArrayList.isEmpty()); // true


        // Integer 를 담는 LinkedList
        LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
        integerLinkedList.add(1); // 맨뒤에 요소추가
        integerLinkedList.add(2); // 맨뒤에 요소추가
        integerLinkedList.add(3); // 맨뒤에 요소추가
        integerLinkedList.add(3,4); // 지정된 위치 요소추가
        System.out.println(integerLinkedList); // [1, 2, 3 ,4]
        for(Integer e : integerLinkedList){
            System.out.println(e);
        }
        integerLinkedList.remove(1);
        System.out.println(integerLinkedList); // [1, 3, 4]
        integerLinkedList.clear();
        System.out.println(integerLinkedList); // []
        System.out.println(integerLinkedList.isEmpty()); // true
    }
}
