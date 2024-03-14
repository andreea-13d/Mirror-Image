package classPack;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStreamReader;

public class Read extends Photo {
	//Aici avem clasa care EXTINDE clasa PHOTO
	File f;
	
	//Aici avem functia care face citirea din fisier
	public void fileRead()throws IOException {
	//Citire nume imagine de la tastatura.
	System.out.println("Introduceti NUMELE fisierului. (format automat .bmp)");
	
	String aux =null;
	
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    aux="src/"+reader.readLine();
    aux=aux+".bmp";
    //Iar aici se face citirea din fisier.
    try {
        f = new File(
            aux);
        picture = ImageIO.read(f);
    }

    catch (IOException e) {
        System.out.println("Error: " + e);
    }
	
	}



}
