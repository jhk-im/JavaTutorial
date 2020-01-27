package JumpToJava.Tutorial25_ThreadTutorial;

import java.util.ArrayList;

// 3. Runnable
// Thread 를 상속하여 만들기도 하지만
// 보통은 Runnable 인터페이스를 구현하도록 하는 방법을 많이 사용한다.
// Runnable 인터페이스를 사용해보자.
public class RunnableTest implements Runnable {

    int seq;
    public RunnableTest(int seq) {
        this.seq = seq;
    }

    public void run(){
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
        }
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args){
        System.out.println("---Runnable---");
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new RunnableTest(i));
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");

    }
    // Thread 를 extends 하던 것에서 Runnable 을 implements 하도록 변경되었따.
    // Runnable 인터페이스는 run 메소드를 구현하도록 강제한다.
    // 그리고 Thread 생성 부분이 다음과 같이 바뀌었다.
    // Thread t = new Thread(new RunnableTest(i)); -> implements Runnable
    // Thread t = new ThreadTest(i); -> extends Thread
    // Thread 의 생성자로 Runnable 인터페이스를 구현한 객체를 넘기는 방법이다.
    // 인터페이스를 사용했으니 상속 및 여러 부분에서 좀 더 유연한 프로그램으로 발전했다고 볼 수 있다.
    // extends Thread 와 완벽히 동일하게 동작한다.
}
