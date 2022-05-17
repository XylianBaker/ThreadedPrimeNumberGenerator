import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartPool {
    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            threadpool.submit(new GeneratePrimes());
        }

        for (int i = 0; i < 2; i++) {
            threadpool.submit(new ReadPrimes("" + i));
        }

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                threadpool.shutdownNow();
            }
        };timer.schedule(task, 2000);
    }
}
