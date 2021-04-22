package Task4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GoldMine goldMine = new GoldMine(1000);
        List<Miner> miners = new ArrayList<>();
        miners.add(new Miner(goldMine,"A"));
        miners.add(new Miner(goldMine,"B"));
        miners.add(new Miner(goldMine,"C"));
        miners.add(new Miner(goldMine,"D"));
        miners.add(new Miner(goldMine,"E"));
        new Game(goldMine, miners);
    }
}
