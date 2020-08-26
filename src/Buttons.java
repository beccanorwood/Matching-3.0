import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons extends JFrame implements ActionListener
{
	private static int WIDTH = 800; 
	private static int HEIGHT = 800; 
	
	private int cardPic; 
	private JButton[] grid;
	private HashMap<JButton, Card> hmap;
	
	public Buttons(int row, int col)
	{
		this.setLayout(new GridLayout(row, col));
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Memory Game: Wedding Edition ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(row, col));
	}
	
	protected void ButtonDisplay(int row, int col, ArrayList<Card> d)
	{
		int numofButtons = row * col; 
		
		grid = new JButton[numofButtons]; 
		
		for(int b = 0; b < numofButtons; b++){
			grid[b] = new JButton(); 
			grid[b].addActionListener(this); 
			this.add(grid[b]); 
		}
		
		Map(d); 
	}

	private void Map(ArrayList<Card> deck)
	{
		hmap = new HashMap<JButton, Card>(); 
		
		for(int c = 0; c < deck.size(); c++) {
			hmap.put(grid[c], deck.get(c)); 
		}
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		try {
			CardSelection(e); 
		}
		catch(IndexOutOfBoundsException e2)
		{
			e2.printStackTrace();
		}
	}
	
	private void CardSelection(ActionEvent e)
	{
		JButton src = (JButton) e.getSource(); 
		//Find JButton from key value(Card)
		
		for(int i = 0; i < grid.length; i++){

			if(src == grid[i])
			{
				JButton b = grid[i]; 
				BufferedImage pic = hmap.get(b).getPic(); 
				String id = hmap.get(b).getID(); 
				
				System.out.println("JButton: " + i + " " + id); 
				 
				System.out.println("Card: " + i + " Selected!"); 
				grid[i].setIcon(new ImageIcon(pic));
				
				cardPic++; 
				
			}
		}
				
	}
	

}
