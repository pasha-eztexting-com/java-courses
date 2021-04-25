package Task5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Processor {
    private final static int MOVE_DURATION_SECONDS = 1;

    private Semaphore loadersSemaphore;
    private Semaphore unloadersSemaphore;
    private Semaphore transportersSemaphore;
    private boolean finished = false;

    public Processor(Semaphore loadersSemaphore, Semaphore unloadersSemaphore, Semaphore transportersSemaphore) {
        this.loadersSemaphore = loadersSemaphore;
        this.unloadersSemaphore = unloadersSemaphore;
        this.transportersSemaphore = transportersSemaphore;
    }

    public boolean isFinished() {
        return finished;
    }

    public void processLoadersMove(Heap heap, Wagon wagon, int kgPerSecond) {
        try {
            loadersSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Loader received wagon and started to load. " + heap);

        while (heap.getSize() > 0) {
            try {
                TimeUnit.SECONDS.sleep(Processor.MOVE_DURATION_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newLoad = Math.min(heap.getSize(), kgPerSecond);
            heap.setSize(heap.getSize() - newLoad);

            if (wagon.getCurrentLoad() + newLoad < wagon.getFullLoad()) {
                wagon.setCurrentLoad(wagon.getCurrentLoad() + newLoad);
                System.out.println("Loader added " + newLoad + " to " + wagon + ".");
                continue;
            }

            int overload = wagon.getCurrentLoad() + newLoad - wagon.getFullLoad();
            wagon.setCurrentLoad(wagon.getFullLoad());
            if (overload > 0) {
                heap.setSize(heap.getSize() + overload);
            }
            System.out.println("Loader added " + (newLoad - overload) + " to " + wagon + " and passed it to Transporter. " + heap);

            transportersSemaphore.release();
            return;
        }
        System.out.println("Loader emptied " + heap.getName() + " and passed " + wagon + " to Transporter.");
        finished = true;
        transportersSemaphore.release();
    }
    
    public void processUnloadersMove(Heap heap, Wagon wagon, int kgPerSecond) {
        try {
            unloadersSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Unloader received " + wagon + " and started to unload. " + heap);

        while (wagon.getCurrentLoad() > 0) {
            try {
                TimeUnit.SECONDS.sleep(Processor.MOVE_DURATION_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newLoad = Math.min(wagon.getCurrentLoad(), kgPerSecond);
            heap.setSize(heap.getSize() + newLoad);
            wagon.setCurrentLoad(wagon.getCurrentLoad() - newLoad);
            System.out.println("Unloader removed " + newLoad + " from " + wagon + ".");
        }
        System.out.println("Unloader passed empty wagon to Transporter. " + heap);
        transportersSemaphore.release();
    }

    public void processTransportersMove(String destination, Wagon wagon, int waySeconds) {
        try {
            transportersSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Transporter received wagon and started to move to " + destination + ".");
        for (int i = 0; i * Processor.MOVE_DURATION_SECONDS < waySeconds; i++) {
            try {
                TimeUnit.SECONDS.sleep(Processor.MOVE_DURATION_SECONDS);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Transporter is on a way to " + destination + " for " + (i + 1) + " second" + (i == 0 ? "" : "s") + ".");
        }

        System.out.println("Transporter arrived to " + destination + " and passed " + wagon + " to " + (destination.equals(Transporter.POSITION_RIGHT) ? "Unloader" : "Loader") + ".");
        if (destination.equals(Transporter.POSITION_RIGHT)) {
            unloadersSemaphore.release();
        } else {
            loadersSemaphore.release();
        }
    }
}
