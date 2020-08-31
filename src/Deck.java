import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
	private ArrayList<Card> deck = new ArrayList<Card>(); 
	
	public Deck(BufferedImage[] pics, String[] names)
	{
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < pics.length; j++){
					deck.add(new Card(pics[j], names[j])); 
			}
		}
		Randomize(); 
	}
	
	public ArrayList<Card> Return()
	{
		return deck; 
	}
	
	public int size()
	{
		return deck.size(); 
	}
	
	public Card position(int index)
	{
		return deck.get(index); 
	}
	
	public void Randomize()
	{
		Collections.shuffle(deck);
	}
	
}
