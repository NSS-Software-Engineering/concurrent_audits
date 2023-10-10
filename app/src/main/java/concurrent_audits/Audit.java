package concurrent_audits;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Audit {
    private int added;
    private int removed;

    public synchronized void add(int amount) {
        String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
                    System.out.println(timestamp + " - Thread "+Thread.currentThread().getId() +" Adding START 1 item.");
        added += amount;
        try {
            Thread.sleep(100); // Add a 100 ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println(timestamp + " - Thread "+Thread.currentThread().getId() +" Adding END 1 item."+ String.valueOf(added - removed));
    }

    public synchronized void remove(int amount) {
        String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println(timestamp + " - Thread "+Thread.currentThread().getId() +" Removing START 1 item.");
        removed += amount;
        try {
            Thread.sleep(100); // Add a 100 ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println(timestamp + " - Thread "+Thread.currentThread().getId() +" Removing END 1 item."+ String.valueOf(added - removed));
    }

    public int inStock() {
        String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println(timestamp + " - Thread "+Thread.currentThread().getId() +" Checking START stock.");
        int tmp = added - removed;
        try {
            Thread.sleep(100); // Add a 100 ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        System.out.println(timestamp + " - Thread "+Thread.currentThread().getId() +" Checking END stock.");
        return tmp;

    }
}
