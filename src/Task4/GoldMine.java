package Task4;

public class GoldMine {
    private int gold;

    public GoldMine(int gold) {
        this.gold = gold;
    }

    public synchronized int digGold(int gold) {
        int availableGold = Math.min(this.gold, gold);
        this.gold -= availableGold;
        return availableGold;
    }

    public int getGold() {
        return gold;
    }
}
