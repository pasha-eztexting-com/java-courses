package Task4;

import java.util.concurrent.TimeUnit;

public class Miner implements Runnable {
    final private int DIG_TIMEOUT_SECONDS = 1;
    final private int DIG_AMOUNT = 3;
    private GoldMine goldMine;

    private String name;

    private int totalGold = 0;

    public Miner(GoldMine goldMine, String name) {
        this.goldMine = goldMine;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0;; i++) {
            try {
                TimeUnit.SECONDS.sleep(DIG_TIMEOUT_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int diggedGold = goldMine.digGold(DIG_AMOUNT);

            totalGold += diggedGold;
            if (diggedGold == 0) {
                return;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getTotalGold() {
        return totalGold;
    }
}
