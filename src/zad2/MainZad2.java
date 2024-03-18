package zad2;

import java.util.concurrent.CopyOnWriteArrayList;

public class MainZad2 {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        Thread writerThread = new Thread(new WriterThread(listOfNumbers));
        Thread readerThread = new Thread(new ReaderThread(listOfNumbers));

        writerThread.start();
        readerThread.start();
    }
}