
public class Counter1 extends Thread {

    protected int count;
    protected int inc;
    protected int delay;

    public Counter1( int  init,  int  inc,  int  delay ) {
        this.count = init;
        this.inc = inc;
        this.delay = delay;
    }


    public void run() {
        try {
            for (;;) {
                System.out.print(count + " ");
                count += inc;
                sleep(delay);
            }
        } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        new Counter1(0, 1, 33).start();
        new Counter1(0, -1, 100).start();
    }
}