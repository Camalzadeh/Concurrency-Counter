import java.util.concurrent.locks.Lock;

public class Counter {
    private int count = 0;
    public synchronized void increment() {
        try {
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void decrement() {
        try{
            count--;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized int getCount() {
        return count;
    }

    public synchronized void waitAndIncrement() {
        try {
            if (count % 2 != 0) {
                System.out.println("odd incrementing..."+count);
                count++;
                wait(500);
            }
            else{
                System.out.println("even incrementing..."+count);
                count++;
                notifyAll();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
