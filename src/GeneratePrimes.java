import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratePrimes implements Runnable{
    Boolean running = true;

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            PrimeNumberList.savePrime(randomPrime());
        }
    }

    public int randomPrime() {
        return (int)(Math.random() * 11) + 1;
    }

    public void shutdown() {
        this.running = false;
    }
}
