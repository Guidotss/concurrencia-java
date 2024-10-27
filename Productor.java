import java.util.Random;

public class Productor implements Runnable {
    private final Random random; 
    private final Buffer container; 
    private final int id;
    private final int WAIT_TIME = 1000;

    public Productor(Buffer container, int id) {
        this.container = container;
        this.id = id;
        random = new Random();
    }
    @Override
    public void run() {
        while(true){ 
            int value = random.nextInt(100);
            container.put(value);
            System.out.println("Productor " + id + " produce: " + value);
            try {
                Thread.sleep(random.nextInt(WAIT_TIME));
            }catch(InterruptedException e) {
                System.out.println("Productor " + id + " interrupted -> " + e.getMessage());
            }
        }
    }
}