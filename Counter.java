public class Counter {
    private static int count = 0;

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