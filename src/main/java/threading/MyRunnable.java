package threading;

public class MyRunnable implements Runnable {

    private int sleepTime;

    public MyRunnable(int sleepTime) {
        this.sleepTime = sleepTime;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName() + " printing value" + i);
            try {
                Thread.sleep(sleepTime); // sleep for 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
