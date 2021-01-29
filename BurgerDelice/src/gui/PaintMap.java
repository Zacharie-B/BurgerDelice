package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PaintMap {
	
	public ImageIcon image;
	
	public PaintMap() throws IOException {
		BufferedImage myPicture = ImageIO.read(new File("top-view-man.png"));
		image = new ImageIcon(myPicture);
	}

	public void paint(Graphics g) {
		//super.paint(g);
        //g.drawImage(image, 0, 0, null);
    }
}
