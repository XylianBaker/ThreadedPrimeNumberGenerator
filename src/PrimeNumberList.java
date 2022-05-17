import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrimeNumberList {
    private static CopyOnWriteArrayList<Integer> primeNumbers = new CopyOnWriteArrayList<>();

    synchronized public static void savePrime(int primeNumber) {
        if (primeNumbers.size() < 15) primeNumbers.add(primeNumber);
    }

    synchronized public static int getPrime() {
        int oldest = primeNumbers.get(0);
        primeNumbers.remove(0);
        return oldest;
    }
}
