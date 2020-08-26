import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
	private ArrayList<Card> deck = new ArrayList<Card>(); 
	
	public Deck(BufferedImage[] pics, String[] names)
	{
		for(int i = 0; i < pics.length; i++)
		{
			deck.add(new Card(pics[i], names[i])); 
		}
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
