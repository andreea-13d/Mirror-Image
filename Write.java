package classPack;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStreamReader;
import java.io.ByteArrayOutputStream;

public class Write extends Read {

    public void fileWrite() throws IOException {
        // ACEEASI IMPLEMENTARE CA LA TEHNICA DE READ, DOAR CA ACUM SCRIEM
        String aux = null;
        System.out.println("Introduceti NUMELE fisierului rezultat. (format automat .bmp)");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Aici se citeste de la tastatura numele imaginii rezultate
        aux = "src/" + reader.readLine();
        aux = aux + ".bmp";

        // Iar aici salvam imaginea rezultata.
        // Dupa cum se poate vedea, folosim pictureResult.
        try {
            f = new File(aux);
            ImageIO.write(pictureResult, "bmp", f);
            //System.out.println("Image modified successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Adaugăm o nouă metodă pentru a obține datele procesate sub formă de byte[]
    public byte[] getImageData() throws IOException {
        // Asigură-te că pictureResult este inițializat și conține imaginea procesată
        // Dacă pictureResult este null, poți să-l inițializezi în interiorul acestei metode sau să-l inițializezi în alte metode ale clasei Write.

        // Exemplu de inițializare:
        if (pictureResult == null) {
            createPicture();
            ImageMirroring();
        }

        // Creează un ByteArrayOutputStream pentru a colecta datele procesate
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Salvează imaginea în ByteArrayOutputStream folosind ImageIO.write
        ImageIO.write(pictureResult, "bmp", outputStream);

        // Returnează array-ul de bytes
        return outputStream.toByteArray();
    }
}
