public class ProductoConsumidor {
    private static Buffer container; 
    private static Thread productor; 
    private static Thread[] consumidores;
    private static final int NUM_CONSUMIDORES = 3;

    public static void main(String[] args) {
        container = new Buffer(); 
        productor = new Thread(new Productor(container, 1)); 
        consumidores = new Thread[NUM_CONSUMIDORES];

        for(int i = 0; i < NUM_CONSUMIDORES; i++) {
            consumidores[i] = new Thread(new Consumidor(container, i + 1));
        }

        productor.start();
    }
}
