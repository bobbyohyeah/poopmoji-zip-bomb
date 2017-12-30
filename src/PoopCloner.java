import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class PoopCloner{
	
	private static int count = 0;

	public static void main(final String[] args){

		try {
			clonePoops(count);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Poops not cloned.");
		}
	}
	
	public static String findPoopmoji(){
		File f = new File("C:\\Users\\Bobby\\Desktop\\Poopmoji\\");
		File[] matchingFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				//System.out.print("find Poopmoji: ");
				//System.out.println(name.startsWith("Poop") && name.endsWith("jpg"));
				return name.startsWith("poop"); //&& name.endsWith("png");
			}
		});
		System.out.println("find Poopmoji: " + matchingFiles[0].getAbsolutePath());
		return matchingFiles[0].getAbsolutePath();
	}

	public static void clonePoops(int count) throws IOException{

		while(true){
			
			BufferedImage poopClone = ImageIO.read(new File(findPoopmoji()));
			File outputFile = new File(findPoopmoji() + Integer.toString(count) + ".jpeg"); // + count + ".jpeg");
			ImageIO.write(poopClone, "jpeg", outputFile);
			System.out.println("file written " + outputFile);
			
			new File("C:\\Users\\Bobby\\Desktop\\Poopmoji\\" + Integer.toString(count)).mkdir();
			Desktop.getDesktop().open(new File("C:\\Users\\Bobby\\Desktop\\Poopmoji\\" + Integer.toString(count)));

		}
	}
}