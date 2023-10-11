package concurrent_audits;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Audit {
    private int added;
    private int removed;

    public synchronized void add(int amount) {
        String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
                    System.out.println("Thread "+Thread.currentThread().getId() +" add(int amount) START at: "+timestamp);
        added += amount;
        try {
            Thread.sleep(1000); // Add a 100 ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println("Thread "+Thread.currentThread().getId() +" add(int amount) END at: "+timestamp);
    }

    public synchronized void remove(int amount) {
        String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println("Thread "+Thread.currentThread().getId() +" remove(int amount) START at: "+timestamp);
        removed += amount;
        try {
            Thread.sleep(1000); // Add a 100 ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println("Thread "+Thread.currentThread().getId() +" remove(int amount) END at: "+timestamp);
    }

    public int inStock() {
        String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println("Thread "+Thread.currentThread().getId() +" inStock() START at: "+timestamp);
        try {
            Thread.sleep(100); // Add a 100 ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int tmp = added - removed;
        timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println("Thread "+Thread.currentThread().getId() +" inStock() END at: "+timestamp);
        return tmp;

    }
}
