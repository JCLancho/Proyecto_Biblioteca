import java.awt.Image;

import javax.swing.ImageIcon;

public class RedimensionadorImagenes {

	//metodo redim
	public static ImageIcon redim (String fichImag, int ancho, int alto){
	            ImageIcon imIcon=new ImageIcon(fichImag);

	            Image im=imIcon.getImage();

	            Image im2= im.getScaledInstance(ancho, alto, 0);

	            return new ImageIcon(im2);

	}
	
}
