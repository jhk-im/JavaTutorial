import java.util.ArrayList;

// 1. Thread
// 동작하고 있는 프로그램을 프로세스라고한다.
// 보통 한개의 프로세스는 한가지 일을하지만
// 쓰레드를 이용하면 한 프로세스에서 두 가지 또는 그 이상의 일을 동시에 할수 있다.
// 쓰레드의 간단한 예제를 만들어보자.
public class ThreadTest extends Thread {

    // Example.1
    /*
    public void run() {
        System.out.println("thread run");
    }
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        tt.start();
    }
    */
    // ThreadTest 클래스가 Thread 클래스를 상속했다.
    // Thread 클래스의 run 메소드를 구현하면 위 예제와 같이
    // tt.test() 실행시 test 객체의 run 메소드가 수행이 된다.
    // Thread 클래스를 extends 했기 때문에 start 메소드 실행 시 run 메소드가 수행된다.
    // Thread 클래스는 start 실행 시 run 메소드가 수행되도록 내부적으로 코딩되어 있다.

    // Example.2
    // 쓰레드의 동작을 확인할 수 있는 예제를 만들어보자.

    int seq;
    public ThreadTest(int seq){
        this.seq = seq;
    }
    public void run() {
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {

        }
        System.out.println(this.seq+" thread end.");
    }
    /*
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            Thread t = new ThreadTest(i);
            t.start();
        }
        System.out.println("main end.");
    }
    */
    // for(int i=0; i<10; i++) , t.start();
    // -> 총 10개의 쓰레드를 실행시키는 예제이다.
    // Thread t = new ThreadTest(i);
    // -> 어던 쓰레드인지 확인하기 위해 쓰레드마다 생성자에 순번을 부여한다.
    // System.out.println(this.seq+" thread start."); ,  System.out.println(this.seq+" thread end.");
    // -> 그리고 쓰레드 run 실행 시 시작과 종료를 출력하게 하였고
    // Thread.sleep(1000)
    // -> 시작과 종료 사이에 1초의 간격이 생기도록 작성하였다.
    // System.out.println("main end.");
    // -> main 메소드 종료시 "main end" 가 출력된다.

    // 결과를 보면 0부터 9번 쓰레드까지 순서가 일정하지 않게 실행된다.
    // 쓰레드는 순서에 상관 없이 동시에 실행된다.
    // 쓰레드가 종료되기전 main 메소드가 종료되는데 중간쯤에 출력되게 된다.

    // 2. Join
    // 쓰레드가 모두 종료된 후에 main 메소드를 종료시키고 싶은 경우는 어떻게 해야할까?
    // 다음과 같이 메인 메소드를 작성해보자.
    // Example.3
    public static void main(String[] args){
        System.out.println("---extends Thread---");
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i=0; i<10; i++) {
            Thread t = new ThreadTest(i);
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
        // ArrayList<Thread> threads = new ArrayList<Thread>();
        // -> 생성되는 쓰레드를 담기 위해 ArrayList 객체인 threads 를 만든 후
        // t.start(); , threads.add(t);
        // -> 쓰레드 생성시 생성된 객체를 threads 에 저장한다.
        // Thread t = threads.get(i); t.join();
        // -> main 메소드 종료되기 전에 threads 에 담긴 각각의 thread 에
        // join 메소드를 호출하여 쓰레드가 종료될 때까지 대기하도록 하였다.
        // 쓰레드의 join 메소드는 쓰레드가 종료될 때 까지 기다리게 하는 메소드이다.
        // 이를 실행하면 main end 가 맨 마지막에 출력되게 된다.

        // 쓰레드 프로그래밍 시 가장 많이 실수하는 부분은
        // 쓰레드가 종료되지 않았는데 종료된 줄 알고 그 다음 로직을 수행하게 만드는 일이다.
        // 쓰레드가 종료된 후 그 다음 로직을 수행해야 할 때 꼭 필요한 것이 바로 join 메소드이다.

        // RunnableTest.java 로 이동하자.
    }

}
