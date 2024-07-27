package threading;

public class Message {

    // There is a message queue
    //we want spawn two threads
    // reader and writer
    //Reader would be reading if only there is a message
    //Write produces the message
    //Now I want to have a synchronized communication b/w writer and reader
    //would only read when there is a message
    //Writer would only write when the message queue is empty

    private String message;

    private boolean hasMessage = false;

    public synchronized String read() {
        while (!hasMessage) {
            try {
                wait(); //wait until writer notifies
            } catch (final InterruptedException ex) {
                System.out.println("Error");
            }

        }
        hasMessage = false;
        System.out.println("I have read " + message);
        notifyAll(); //notifies all the threads on this object instance
        return message;
    }

    public synchronized void write(final String message) {
        while (hasMessage) {
            try {
                wait(); //wait until reader notifies
            } catch (final InterruptedException ex) {
                System.out.println("Error");
            }
        }
        this.message = message;
        hasMessage = true;
        System.out.println("I have written " + message);
        notifyAll(); //notifies all the threads on this object instance
    }


}
