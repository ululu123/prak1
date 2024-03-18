package zad2;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Random;
class WriterThread implements Runnable {
    private CopyOnWriteArrayList<Integer> list;
    private static int MAX_SIZE = 5;
    private static  int count = 0;
    public WriterThread(CopyOnWriteArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            if (count < MAX_SIZE) {
                int number = rand.nextInt(100);
                list.add(number);
                System.out.println("Added: " + number);
                count++;
            }
            else {
                break;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}