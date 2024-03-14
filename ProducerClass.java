package classPack;

import java.io.IOException;
import java.io.PipedOutputStream;

public class ProducerClass extends Thread {
    private BufferClass buffer;
    private Write aux;
    private PipedOutputStream pipeOut;

    public ProducerClass(BufferClass b, Write x, PipedOutputStream pipeOut) {
        buffer = b;
        aux = x;
        this.pipeOut = pipeOut;
    }

    public void run() {
        aux.createPicture();
        aux.ImageMirroring();

        try {
            // Obține datele procesate sub formă de byte[]
            byte[] imageData = aux.getImageData();

            // Partiționează datele în 4 segmente
            int segmentSize = imageData.length / 4;
            for (int i = 0; i < 4; i++) {
                // Afișează mesajul pentru fiecare segment trimis la consolă
                System.out.println("Segment " + (i + 1) + " trimis la consola.");

                // Trimite segmentul prin pipe
                pipeOut.write(imageData, i * segmentSize, segmentSize);
                pipeOut.flush();

                // Așteaptă un timp pentru simularea procesării
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Închide pipe-ul la finalul procesării
            pipeOut.close();

            // Scrie imaginea în fișier (adică, partea care anterior era în aux.fileWrite())
            aux.fileWrite();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
