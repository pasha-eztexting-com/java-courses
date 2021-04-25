package Task5;

abstract public class Worker implements Runnable {
    protected Processor processor;
    protected Wagon wagon;

    public Worker(Processor processor, Wagon wagon) {
        this.processor = processor;
        this.wagon = wagon;
    }

    @Override
    abstract public void run();
}
