package concurrent_audits;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Audit audit = new Audit();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            System.out.println("executorService submit add at: "+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
            audit.add(1);
        });

        executorService.submit(() -> {
            System.out.println("executorService submit inStock at: "+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
            for (int i = 0; i < 20; i++) {
                audit.inStock();
            }
        });

        executorService.submit(() -> {
            System.out.println("executorService submit remove at: "+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
            audit.remove(1);
        });

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
