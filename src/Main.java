import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Main
{
	public static void main(String[] args)
	{
		File path = new File("AnimalPics");
		File [] files = path.listFiles();
		
		int size = files.length; 
		
		BufferedImage[] images = new BufferedImage[size]; 
		String[] pic_names = new String[size]; 
		
		for (int i = 0; i < files.length; i++)
		{
		    if (files[i].isFile()){ //this line weeds out other directories/folders
		        try {
					images[i] = ImageIO.read(files[i]);
					pic_names[i] = files[i].toString();
					
				} catch (IOException e) {
					e.printStackTrace();
				} 
		    }
		}
		
		Begin(images, pic_names); 
	
	}
	
	private static void Begin(BufferedImage[] images, String[] names)
	{
		Deck d = new Deck(images, names); 
		int num_of_cards = d.size(); 
		
		ArrayList<Integer> multiples = new ArrayList<Integer>(); 
		
		for(int a = 1; a <= num_of_cards; a++)	{
			if(num_of_cards %a == 0) {
				multiples.add(a); 
			}
			else{
				continue; 
			}
		}
		
		int middle = multiples.size()/2; 
		
		int col = multiples.get(middle); 
		int row = num_of_cards/col; 

		ArrayList<Card> d1 = d.Return();
		
		Buttons b = new Buttons(row, col); 
		b.ButtonDisplay(row, col, d1);

	}

}
