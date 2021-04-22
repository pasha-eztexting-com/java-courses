package Task4;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    final private int LOG_TIMEOUT_SECONDS = 1;
    final private int BARRACKS_TIMEOUT_SECONDS = 10;
    private GoldMine goldMine;
    private List<Miner> miners;

    public Game(GoldMine goldMine, List<Miner> miners) {
        this.goldMine = goldMine;
        this.miners = miners;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0;; i++) {
            System.out.print("Second " + i + ". ");
            for (Miner miner : miners) {
                System.out.print("Miner " + miner.getName() + " has " + miner.getTotalGold() + " gold. ");
            }
            System.out.println("Gold Mine has " + goldMine.getGold() + " gold.");
            if (goldMine.getGold() == 0) {
                return;
            }
            try {
                TimeUnit.SECONDS.sleep(LOG_TIMEOUT_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % BARRACKS_TIMEOUT_SECONDS == BARRACKS_TIMEOUT_SECONDS - 1) {
                miners.add(new Miner(goldMine,"New_" + i));
            }
        }
    }
}
