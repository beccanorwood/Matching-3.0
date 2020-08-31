import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons extends JFrame implements ActionListener
{
	private final int WIDTH = 800; 
	private final int HEIGHT = 800; 

	private int cardPic = 0; 
	private int matches = 0; 
	private JButton[] grid;
	private HashMap<JButton, Card> hmap;
	private ArrayList <JButton> btns = new ArrayList<JButton>();
	
	public Buttons(int row, int col)
	{
		this.setLayout(new GridLayout(row, col));
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Memory Game: Level One");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(row, col));
		this.setVisible(true);

	}
	
	protected void ButtonDisplay(int row, int col, ArrayList<Card> d)
	{
		int numofButtons = row * col; 
		
		grid = new JButton[numofButtons]; 
		
		for(int b = 0; b < numofButtons; b++){
			grid[b] = new JButton(); 
			grid[b].addActionListener(this);  
			add(grid[b]); 
		}
		
		Map(d); 
	}

	private void Map(ArrayList<Card> deck)
	{
		hmap = new HashMap<JButton, Card>(); 
		
		for(int c = 0; c < deck.size(); c++) {
			hmap.put(grid[c], deck.get(c)); 
		}
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try {
			CardSelection(e);
		}
		catch(IndexOutOfBoundsException e1) {
			e1.printStackTrace();
		}
	}

	
	public void CardSelection(ActionEvent e)
	{	
		JButton src = (JButton) e.getSource(); 

		for(int i = 0; i < grid.length; i++){
			
			if(src == grid[i]){
				
				BufferedImage pic = hmap.get(src).getPic(); 
				src.setIcon(new ImageIcon(pic));
				btns.add(src); 
				cardPic++;

				if(cardPic == 2) {
					int delay = 1000; 
					Timer timer = new Timer(delay, evt-> {
						
						JButton last = btns.get(btns.size()-1); 
						JButton second_last = btns.get(btns.size()-2); 
						
						boolean match = Match(last, second_last); 
						
							if(match == true) {
			
								second_last.setBackground(Color.BLACK);
								last.setBackground(Color.BLACK);
								second_last.setIcon(null);
								last.setIcon(null);
								matches += 2; 
					
								if(matches == hmap.size()) {
									this.setVisible(false);
									this.dispose(); 
								}
						
							}
							else
							{
								second_last.setIcon(null);
								last.setIcon(null);
							}
						});
					timer.start();
					timer.setRepeats(false);
				}

			}

		}
		
	} 

	private boolean Match(JButton a, JButton b)
	{
		cardPic = 0; 
		
		return hmap.get(a).equals(hmap.get(b));
	}

}
