package zad3;
import java.util.concurrent.atomic.AtomicInteger;
public class Main {
    private static final int TOTAL_CITIZENS = 100;
    private static final int TOTAL_WINDOWS = 3;

    public static AtomicInteger angryYoung = new AtomicInteger(0);
    public static AtomicInteger angryElderly = new AtomicInteger(0);
    public static AtomicInteger angryBusinessmen = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {


        Object[] windows = new Object[TOTAL_WINDOWS];
        for (int i = 0; i < TOTAL_WINDOWS; i++) {
            windows[i] = new Object();
        }

        Thread[] citizens = new Thread[TOTAL_CITIZENS];
        for (int i = 0; i < TOTAL_CITIZENS; i++) {
            citizens[i] = new Thread(new Citizen(windows));
            citizens[i].start();
        }

        for (Thread citizen : citizens) {
            citizen.join();
        }

        printAngryCitizens();

    }

    private static void printAngryCitizens() {
        System.out.printf("Процент ушедших молодых граждан: %.2f%%\n", (angryYoung.get() * 100.0 / TOTAL_CITIZENS));
        System.out.printf("Процент ушедших пожилых граждан: %.2f%%\n", (angryElderly.get() * 100.0 / TOTAL_CITIZENS));
        System.out.printf("Процент ушедших бизнесменов: %.2f%%\n", (angryBusinessmen.get() * 100.0 / TOTAL_CITIZENS));
    }
}
