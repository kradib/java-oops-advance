package threading;

public class ReaderThread extends Thread{

    private Message message;

    public ReaderThread(final Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String readMessage;
        while (! (readMessage = message.read()).equals("End")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
