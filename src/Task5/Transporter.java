package Task5;

public class Transporter extends Worker
{
    public static final String POSITION_LEFT = "LeftHeap";
    public static final String POSITION_RIGHT = "RightHeap";

    private int waySeconds;

    private String position;

    public Transporter(Processor processor, Wagon wagon, String position, int waySeconds) {
        super(processor, wagon);
        this.position = position;
        this.waySeconds = waySeconds;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!processor.isFinished()) {
            String destination = this.position.equals(Transporter.POSITION_LEFT) ? Transporter.POSITION_RIGHT : Transporter.POSITION_LEFT;
            processor.processTransportersMove(destination, wagon, waySeconds);
            this.position = destination;
        }
        System.out.println("Transporter is resting.");
    }
}
