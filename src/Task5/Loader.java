package Task5;

public class Loader extends Worker {
    private int kgPerSecond;
    private Heap heap;

    public Loader(Processor processor, Wagon wagon, Heap heap, int kgPerSecond) {
        super(processor, wagon);
        this.heap = heap;
        this.kgPerSecond = kgPerSecond;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!processor.isFinished()) {
            processor.processLoadersMove(heap, wagon, kgPerSecond);
        }
        System.out.println("Loader is resting.");
    }
}
