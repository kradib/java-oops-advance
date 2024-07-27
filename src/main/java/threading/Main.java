package threading;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread(1000);
//        MyThread t2 = new MyThread(100);
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(new MyRunnable(1000));
//        Thread t2 = new Thread(new MyRunnable(100));
//
//        t1.start();
//        t2.start();

        Counter counter = new Counter();
        SyncThread syncThread1 = new SyncThread(counter);
        SyncThread syncThread2 = new SyncThread(counter);

        syncThread1.start();
        syncThread2.start();

        syncThread1.join();
        syncThread2.join();

//        Thread.sleep(2);

        System.out.println(counter.getCount());

    }
}
