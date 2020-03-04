package Tutorials.java20_CallByReference;

public class CallByReference {

    public static void main(String[] args){

        MyClass myClass1 = new MyClass(1);
        MyClass myClass2 = new MyClass(2);

        //두개의 필드 값을 바꿔보자
        swapValue(myClass1, myClass2);
        System.out.println(myClass1.getIndex()); //2
        System.out.println(myClass2.getIndex()); //1


    }
    static void swapValue(MyClass m1, MyClass m2){
        int tmpIndex = m1.getIndex();
        m1.setIndex(m2.getIndex());
        m2.setIndex(tmpIndex);
    }

    static void swapReference(MyClass m1, MyClass m2) {
        MyClass tmp = m1;
        m1 = m2;
        m2 = tmp;
    }
}

class MyClass{
    int index;
    public MyClass(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}