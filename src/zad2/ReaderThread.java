package zad2;
import java.util.concurrent.CopyOnWriteArrayList;
class ReaderThread implements Runnable {
    private CopyOnWriteArrayList<Integer> list;

    public ReaderThread(CopyOnWriteArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            if (!list.isEmpty()) {
                System.out.println("Read: " + list.get(0));
                list.remove(0);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}