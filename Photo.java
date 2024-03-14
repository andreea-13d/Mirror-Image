package classPack;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStreamReader;

//Clasa principala Photo care implementeaza interfata.
public class Photo implements Interface {
	//In picture vom stoca prima poza, in pictureResult poza rezultata, iar in height si width
	//dimensiunile imaginii.
	BufferedImage picture;
	BufferedImage pictureResult;
	int height;
	int width;
	
	
	//Creare imagine noua bazata pe imaginea de intrare
	//instantiere pictureResult cu noile dimensiuni
	public void createPicture(){
		width = picture.getWidth();
		height = picture.getHeight();
		pictureResult = new BufferedImage(
	            width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	//Aici este algoritmul din spatele procesarii imaginii
	//folosit.
	public void ImageMirroring() {
		//Vom folosi 2 for-uri pentru inaltime si latime
		for (int y = 0; y < height; y++) {
			//Se parcurge pe inaltime, incepand din stanga spre dreapta.
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {
                  //LX este un "index" pentru stanga
            	//RX este un "index" pentru dreapta
                int p = picture.getRGB(lx, y);
                //In p stocam valorile imaginii noastre DIN STANGA
                
                //Iar in imaginea rezultata punem valorile stocate din STANGA IN DREAPTA
                //Putem observa ca ne-am folosit de functiile setRGB si getRGB
                //din biblioteca clasei BufferedImage
                pictureResult.setRGB(rx, y, p);
            }
        }
	}
	//Mai jos avem niste simpli geteri si seteri.
	@Override
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.width=width;
	}
	
}

