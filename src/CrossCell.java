import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CrossCell extends JPanel{
	private static int SIZE = 40;
	public static final int TOP = 0;
	public static final int RIGHT = 1;
	public static final int BOTTOM = 2;
	public static final int LEFT = 3;
	private int row = -1;
	private int col = -1;
	boolean filled = false;
	private JTextField textField = new JTextField();
	private char character= '0';
	private boolean [] wall = {true, true, true, true};
    
	private boolean current = false;
	private boolean end = false;
	//private boolean
	
	public CrossCell(int r, int c){
		row = r;
		col = c;
		setPreferredSize(new Dimension (SIZE,SIZE));
	}
	public void setCharacter(char c) {
		character=c;
	}
    public void setFilled(boolean f) {
    	filled=f;
   	if (f == false) {
    		textField= new JTextField(3) {
    				@Override public void setBorder(Border border) {
    				//No!
    			}
    		}; 
    		if (filled == true) {
    			textField.setText("z");
    		}
    		
    		add(textField);
    		textField.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e) {
    				check2();
    			}
    		});
    		
   	}
 
   	if(f == true) {
    	repaint();
   	}
    }
	public boolean check2() {
		if (filled == false) {
		System.out.println("check2");
		String text = textField.getText();
		char c = text.charAt(0);
			if (c== character|| character=='0') {
			 return true;
			}
			else {
			 return false;
			}
		}
		else {
			return true;
		}
   	}
	public int getRow(){
		return row;
	}
    
	public int getCol(){
		return col;
	}
    
	public boolean isWall(int index){ // is there a wall there?
		return wall[index];
	}
	
	public void paintComponent(Graphics g){
		//draw the background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, SIZE, SIZE);
		g.setColor(Color.BLACK);
        
		//draw the walls
//		if (isWall(RIGHT)) {
//			System.out.println("draw right wall");
//			g.drawLine(SIZE, 0, SIZE, SIZE); //side line
//		}
		if (isWall(LEFT)) {
			//System.out.println("draw left wall");
			g.drawLine(0, 0, 0, SIZE); //side line
		}
		if (isWall(TOP)) {
			g.drawLine(0, 0, SIZE, 0); //top line
		}
		if (filled== true){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, SIZE, SIZE);
		}
	
		
	}
}
