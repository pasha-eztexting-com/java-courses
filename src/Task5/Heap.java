package Task5;

public class Heap {
    private int size;
    private String name;

    public Heap(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " size is " + size + ".";
    }
}
