package Task5;

public class Unloader extends Worker
{
    private int kgPerSecond;
    private Heap heap;

    public Unloader(Processor processor, Wagon wagon, Heap heap, int kgPerSecond) {
        super(processor, wagon);
        this.heap = heap;
        this.kgPerSecond = kgPerSecond;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!processor.isFinished()) {
            processor.processUnloadersMove(heap, wagon, kgPerSecond);
        }
        System.out.println("Unloader is resting.");
    }
}
