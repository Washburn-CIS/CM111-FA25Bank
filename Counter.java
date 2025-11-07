public class Counter {
    private  int count = 0;

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }
}
