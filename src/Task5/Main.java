package Task5;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore loadersSemaphore = new Semaphore(1);
        Semaphore unloadersSemaphore = new Semaphore(0);
        Semaphore transportersSemaphore = new Semaphore(0);

        Processor processor = new Processor(loadersSemaphore, unloadersSemaphore, transportersSemaphore);

        Wagon wagon = new Wagon(0, 6);
        Heap leftHeap = new Heap(100, "LeftHeap");
        Heap rightHeap = new Heap(0, "RightHeap");

        new Transporter(processor, wagon, Transporter.POSITION_LEFT, 5);
        new Loader(processor, wagon, leftHeap, 2);
        new Unloader(processor, wagon, rightHeap, 3);
    }
}
