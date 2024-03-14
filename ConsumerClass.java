package classPack;

import java.io.IOException;
import java.io.PipedInputStream;

public class ConsumerClass implements Runnable {
    private BufferClass buffer;
    private Thread t;
    private Write aux;
    private PipedInputStream pipeIn;

    public ConsumerClass(BufferClass b, Write x, PipedInputStream pipeIn) {
        buffer = b;
        aux = x;
        this.pipeIn = pipeIn;
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            // Creează un buffer pentru a citi datele din pipe
            byte[] buffer = new byte[1024];

            // Contor pentru segmentul curent
            int currentSegment = 1;

            // Citeste datele din pipe pana cand pipe-ul se inchide
            int bytesRead;
            while ((bytesRead = pipeIn.read(buffer)) != -1) {
                // Procesează și afișează mesajul pentru fiecare segment
                processSegment(buffer, bytesRead, currentSegment);

                // Incrementăm numărul segmentului curent
                currentSegment++;

                // Așteaptă un timp pentru simularea procesării
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Metoda pentru a procesa și afișa un segment
    private void processSegment(byte[] data, int  bytesRead, int segmentNumber) {
        
        // Afișează mesajul corespunzător pentru fiecare segment primit la consolă, inclusiv numărul segmentului
        System.out.println("Segmentul " + segmentNumber + " primit la consolă.");
    }
}
