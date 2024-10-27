public class Consumidor implements Runnable{
    private final Buffer container;
    private final int id;

    public Consumidor(Buffer container, int id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            int value = container.get();
            System.out.println("Consumidor " + id + " consume: " + value);
        }
    }
}
