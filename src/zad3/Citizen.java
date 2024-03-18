package zad3;
import java.util.concurrent.ThreadLocalRandom;
class Citizen implements Runnable {
    private final Object[] windows;

    public Citizen(Object[] windows) {
        this.windows = windows;
    }

    @Override
    public void run() {
        int category = ThreadLocalRandom.current().nextInt(3);
        int window = ThreadLocalRandom.current().nextInt(3);

        synchronized (windows[window]) {
            if (window == 0) {
                System.out.printf("Житель [%s] получил услугу\n", whatCategory(category), window + 1);
            } else {
                angryCitizen(category);
            }
        }
    }

    private void angryCitizen(int category) {
        switch (category) {
            case 0:
                Main.angryYoung.incrementAndGet();
                break;
            case 1:
                Main.angryElderly.incrementAndGet();
                break;
            case 2:
                Main.angryBusinessmen.incrementAndGet();
                break;
        }
        System.out.printf("Житель [%s] не получил услугу\n", whatCategory(category));
    }

    private String whatCategory(int category) {
        switch (category) {
            case 0:
                return "молодой";
            case 1:
                return "пожилой";
            case 2:
                return "бизнесмен";
            default:
                return "неизвестный";
        }
    }
}
