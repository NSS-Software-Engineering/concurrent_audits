package concurrent_audits;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Audit audit = new Audit();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
                System.out.println("executorService submitted add");
                for (int i = 0; i < 100; i++) {
                    audit.add(1);
                }
        });

        executorService.submit(() -> {
            System.out.println("executorService submitted inStock");
            for (int i = 0; i < 100; i++) {
                System.out.println(audit.inStock());
            }
        });

        executorService.submit(() -> {
            System.out.println("executorService submitted remove");
            for (int i = 0; i < 100; i++) {
                audit.remove(1);
            }
        });

        executorService.shutdown();

        try {
            Boolean terminated = executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("executorService is terminated :"+ terminated);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
