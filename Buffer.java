public class Buffer { 
    private int content; 
    private boolean available = false;

    public synchronized int get() {
        while(!available) {
            try{ 
                wait();
            }catch(InterruptedException e) {
                System.out.println("Thread interrupted -> " + e.getMessage());
            }
        }
        available = false;
        notifyAll();
        return content;
    }
    public synchronized void put(int value) {
        while(available)  {
            try { 
                wait();
            }catch(InterruptedException e) {
                System.out.println("Thread interrupted -> " + e.getMessage());
            }
        }
        content = value;
        available = true;
        notifyAll();
    }
}