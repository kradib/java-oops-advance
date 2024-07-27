package threading;

public class SyncThread extends Thread {

    private Counter counter;

    public SyncThread(final Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for( int i=0;i<5000000;i++) {
            counter.increment();
        }
    }
}
