package Task5;

public class Wagon {
    private int fullLoad;
    private int currentLoad;

    public Wagon(int currentLoad, int fullLoad) {
        this.currentLoad = currentLoad;
        this.fullLoad = fullLoad;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    public int getFullLoad() {
        return fullLoad;
    }

    @Override
    public String toString() {
        return "Wagon {" + currentLoad + "/" + fullLoad + "}";
    }
}
