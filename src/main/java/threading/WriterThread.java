package threading;

import java.util.List;

public class WriterThread extends Thread {


    private Message message;

    private List<String> messages;

    public WriterThread(final Message message, final List<String> messages) {
        this.message = message;
        this.messages = messages;
    }

    @Override
    public void run() {
        messages.forEach(singleMessage -> {
            try {
                message.write(singleMessage);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("All Writes done");
    }
}
