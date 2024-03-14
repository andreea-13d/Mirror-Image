package testPack;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import javax.imageio.ImageIO;
import classPack.Photo;
import classPack.Write;
import classPack.Interface;
import classPack.Read;
import classPack.ConsumerClass;
import classPack.ProducerClass;
import classPack.BufferClass;

import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // Aici vom instantia un element de test, cu fiecare pas necesar.
        // Citire din fisier, creare dimensiuni imagine NOUA, prelucrare imagine si crearea unei fisier .bmp pentru rezultat

        Write heart = new Write();

        long startTime = System.currentTimeMillis();
        heart.fileRead();
        long endTime = System.currentTimeMillis();
        System.out.println("Timp citire: " + (endTime - startTime) + " milliseconds");

        heart.createPicture();
        endTime = System.currentTimeMillis();
        
        startTime = System.currentTimeMillis();
        heart.ImageMirroring();
        endTime = System.currentTimeMillis();
        System.out.println("Timp procesare imagine - mirror: " + (endTime - startTime) + " milliseconds");

        // Measure the time for fileWrite
        startTime = System.currentTimeMillis();
        heart.fileWrite();
        endTime = System.currentTimeMillis();
        System.out.println("Timp scriere : " + (endTime - startTime) + " milliseconds");

        // Instantiaza BufferClass
        BufferClass b = new BufferClass();

        // Instantiaza PipedInputStream si PipedOutputStream pentru a comunica intre Producer si Consumer
        PipedInputStream pipeIn = new PipedInputStream();
        PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);

        // Instantiaza ProducerClass cu instanta Write existenta si PipedOutputStream
        ProducerClass producer = new ProducerClass(b, heart, pipeOut);

        // Instantiaza ConsumerClass cu instanta Write existenta si PipedInputStream
        ConsumerClass consumer = new ConsumerClass(b, heart, pipeIn);

        // Ruleaza thread-urile Producer si Consumer
        // producer.start();
        // consumer.start();
    }
}
