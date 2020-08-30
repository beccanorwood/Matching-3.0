import java.awt.image.BufferedImage;

public class Card
{
	private BufferedImage pic; 
	private String id; 
	private boolean flipped; 

	//Constructor with BI parameter & String id
	public Card(BufferedImage pic, String id) 
	{
		this.pic = pic;
		this.id = id; 
		this.flipped = false; 
	}
	
	public void setId(String id)
	{
		this.id = id; 
	}
	
	public String getID()
	{
		return id; 
	}
	
	public void setPic(BufferedImage pic)
	{
		this.pic = pic; 
	}
	
	public BufferedImage getPic()
	{
		return pic; 
	}
	
	public void setFlipped()
	{
		this.flipped = true; 
	}
	
	public boolean getFlipped()
	{
		return flipped; 
	}
	
	public void Reset()
	{
		this.flipped = false; 
	}
	
	public boolean equals(Card other)
	{
		if(this.getID().equals(other.getID())) {
			return true;
		}
		else {
			return false; 
		}
	}
	
}
