package Task2_1;

import java.io.Serializable;

public class Pudge extends Hero implements Serializable {
    protected String ultimate;

    public Pudge(String ultimate, int intelligence, int agility, int strength) {
        super(intelligence, agility, strength);
        this.ultimate = ultimate;
    }

    @Override
    public String toString() {
        return "Pudge{" + "ultimate='" + ultimate + '\'' + ", intelligence=" + intelligence + ", agility=" + agility + ", strength=" + strength + '}';
    }
}
