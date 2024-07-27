package threading;

import java.util.List;

public class InterThreadCommunication {

    public static void main(String[] args) {
        Message message = new Message();
        WriterThread writerThread = new WriterThread(message, List.of("First", "Second", "Third", "Fourth", "End"));
        ReaderThread readerThread = new ReaderThread(message);

        readerThread.start();
        writerThread.start();

    }

}
