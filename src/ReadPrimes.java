public class ReadPrimes implements Runnable{

    String description;
    Boolean running = true;

    public ReadPrimes(String description){
        this.description = description;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            System.out.println(description + ": " + PrimeNumberList.getPrime());
        }
    }

    public void shutdown(){
        this.running = false;
    }
}
