package multithreading;

class Resource {
    int i = 0;
    boolean status = false;

    synchronized void put(int i) throws InterruptedException {
        while(status) {
            wait();
        }
        this.i = i;
        System.out.println("PUT : " + i);
        status = true;
        notify();
    }

    synchronized void get() throws InterruptedException {
        while(!status) {
            wait();
        }
        System.out.println("GET : " + i);
        status = false;
        notify();
    }
}

class Producer implements Runnable {
    Resource r;
    Producer(Resource r) {
        this.r = r;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) { // changed while(true) to for loop
            try {
                r.put(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    Resource r;
    Consumer(Resource r) {
        this.r = r;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) { // same count
            try {
                r.get();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerandConsumer {
    public static void main(String[] args) {
        Resource r = new Resource();
        new Producer(r);
        new Consumer(r);
    }
}