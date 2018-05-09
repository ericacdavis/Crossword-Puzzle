import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
public class CrosswordGenerator extends JFrame{
	private int rows = 9;
	private int cols = 10;
	private CrossCell [][] grid = new CrossCell[rows][cols];
	private JPanel crossPanel = new JPanel();
	
	public CrosswordGenerator() {
		initGUI();
		setTitle("Hollywood Crossword");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		//setSize(200, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void initGUI() {
		//title 
				JPanel titlePanel = new JPanel(); 
				titlePanel.setBackground(Color.BLACK);
				add(titlePanel, BorderLayout.PAGE_START);
				Font titleFont = new Font("Fish&Chips", Font.BOLD, 32);
				JLabel titleLabel = new JLabel("Hollywood Crossword");
				titleLabel.setBackground(Color.BLACK);
				titleLabel.setOpaque(true);
				titleLabel.setForeground(Color.MAGENTA);
				titleLabel.setFont(titleFont);
				titleLabel.setHorizontalAlignment(JLabel.CENTER);
				titlePanel.add(titleLabel);
		        
				//center panel
				JPanel centerPanel = new JPanel();
				centerPanel.setBackground(Color.BLACK);
				add(centerPanel, BorderLayout.CENTER);
		        
				//puzzle panel
				newGame();
				centerPanel.add(crossPanel, BorderLayout.PAGE_START);
				
				//clue panel
				JPanel cluePanel = new JPanel();
				cluePanel.setBackground(Color.GRAY);
				centerPanel.add(cluePanel, BorderLayout.PAGE_END);
				// clue panel1
				JPanel cluePanel1 = new JPanel();
				cluePanel1.setBackground(Color.GRAY);
				cluePanel.add(cluePanel1, BorderLayout.PAGE_START);
				JLabel clueLabel1 = new JLabel ("<html>Across: <br/> 1: Disney Channel Original Movie ____ Mouth"+ "<br/>"
						+ "2: Movie starring 2 Down <br/> 3: Catwoman; ____ Berry <br/> 4: Young actress starring on 'Grownish'"
						+ "<br/> 5: 'If you like it then you shoulda put a ring on it' title first word <html>");
				cluePanel1.add(clueLabel1);
				//clue panel2
				JPanel cluePanel2 = new JPanel();
				cluePanel2.setBackground(Color.GRAY);
				cluePanel.add(cluePanel2, BorderLayout.PAGE_END);
				JLabel clueLabel2 = new JLabel ("<html>Down: <br/> 1: Disney Animated Movie with villain Yzma"+ "<br/>"
						+ "2: Queen of TV bookclubs; weightwatchers spokersperson<br/> 3: "
						+ "OITNB character obsessed with conspiracy theories and has hallucinations <br/>"
						+ "4: first word of Brand of B-ball footwear named after famous b-ball player <br/>"
						+ "5: Name of beloved pet in Disney cartoon, Phineas and Ferb<html>");
				cluePanel2.add(clueLabel2);
				
		        
				//button panel
				JPanel buttonPanel = new JPanel();
				buttonPanel.setBackground(Color.BLACK);
				add(buttonPanel, BorderLayout.PAGE_END);
				JButton newMazeButton = new JButton("Check Puzzle");
				newMazeButton.setFocusable(false);
				buttonPanel.add(newMazeButton, BorderLayout.CENTER);
				
				//listeners
				newMazeButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						check();
					} 
				});
	}
	private void check() {
		System.out.println("here");
		for (int r = 0; r < rows; r++){
			for (int c = 0; c < cols; c++){
				boolean correct = grid[r][c].check2();
				System.out.println(r + ""+ c);
				if (correct == false) {
					return;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "You won!");
	}
	private void newGame() {
		crossPanel.setLayout(new GridLayout(rows, cols));
		//remove all letters
		for (int r = 0; r < rows; r++){
			for (int c = 0; c < cols; c++){
				grid[r][c] = new CrossCell (r, c);
				crossPanel.add(grid[r][c]);
			}
		}
		//false
		grid[0][1].setFilled(false);
		grid[0][1].setCharacter('L');
		grid[0][2].setFilled(false);
		grid[0][2].setCharacter('E');
		grid[0][3].setFilled(false);
		grid[0][3].setCharacter('M');
		grid[0][4].setFilled(false);
		grid[0][4].setCharacter('O');
		grid[0][5].setFilled(false);
		grid[0][5].setCharacter('N');
		grid[0][6].setFilled(false);
		grid[0][6].setCharacter('A');
		grid[0][7].setFilled(false);
		grid[0][7].setCharacter('D');
		grid[0][8].setFilled(false);
		grid[0][8].setCharacter('E');
		grid[1][2].setFilled(false);
		grid[1][2].setCharacter('M');
		grid[1][4].setFilled(false);
		grid[1][4].setCharacter('D');
		grid[2][0].setFilled(false);
		grid[2][0].setCharacter('P');
		grid[3][0].setFilled(false);
		grid[3][0].setCharacter('E');
		grid[4][0].setFilled(false);
		grid[4][0].setCharacter('R');
		grid[5][0].setFilled(false);
		grid[5][0].setCharacter('R');
		grid[6][0].setFilled(false);
		grid[6][0].setCharacter('Y');
		grid[2][2].setFilled(false);
		grid[2][2].setCharacter('P');
		grid[3][2].setFilled(false);
		grid[3][2].setCharacter('E');
		grid[4][2].setFilled(false);
		grid[4][2].setCharacter('R');
		grid[5][2].setFilled(false);
		grid[5][2].setCharacter('O');
		grid[6][2].setFilled(false);
		grid[6][2].setCharacter('R');
		grid[2][3].setFilled(false);
		grid[2][3].setCharacter('S');
		grid[2][4].setFilled(false);
		grid[2][4].setCharacter('R');
		grid[2][5].setFilled(false);
		grid[2][5].setCharacter('P');
		grid[2][6].setFilled(false);
		grid[2][6].setCharacter('L');
		grid[3][4].setFilled(false);
		grid[3][4].setCharacter('A');
		grid[4][4].setFilled(false);
		grid[4][4].setCharacter('H');
		grid[6][1].setFilled(false);
		grid[6][1].setCharacter('A');
		grid[6][3].setFilled(false);
		grid[6][3].setCharacter('A');
		grid[7][2].setFilled(false);
		grid[7][2].setCharacter('S');
		grid[7][3].setFilled(false);
		grid[7][3].setCharacter('I');
		grid[8][3].setFilled(false);
		grid[8][3].setCharacter('R');
		grid[7][4].setFilled(false);
		grid[7][4].setCharacter('N');
		grid[7][5].setFilled(false);
		grid[7][5].setCharacter('G');
		grid[7][6].setFilled(false);
		grid[7][6].setCharacter('L');
		grid[7][7].setFilled(false);
		grid[7][7].setCharacter('E');
		grid[8][6].setFilled(false);
		grid[8][6].setCharacter('Y');
		grid[4][5].setFilled(false);
		grid[4][5].setCharacter('A');
		grid[4][6].setFilled(false);
		grid[4][6].setCharacter('L');
		grid[4][7].setFilled(false);
		grid[4][7].setCharacter('L');
		grid[4][8].setFilled(false);
		grid[4][8].setCharacter('I');
		grid[4][9].setFilled(false);
		grid[4][9].setCharacter('E');
		grid[5][6].setFilled(false);
		grid[5][6].setCharacter('O');
		grid[6][6].setFilled(false);
		grid[6][6].setCharacter('L');
		grid[2][7].setFilled(false);
		grid[2][7].setCharacter('E');
		//true
		grid[7][8].setFilled(true);
		grid[0][0].setFilled(true);
		grid[1][0].setFilled(true);
		grid[1][1].setFilled(true);
		grid[2][1].setFilled(true);
		grid[3][1].setFilled(true);
		grid[4][1].setFilled(true);
		grid[5][1].setFilled(true);
		grid[7][0].setFilled(true);
		grid[8][0].setFilled(true);
		grid[7][1].setFilled(true);
		grid[8][1].setFilled(true);
		grid[1][3].setFilled(true);
		grid[3][3].setFilled(true);
		grid[4][3].setFilled(true);
		grid[5][3].setFilled(true);
		grid[8][2].setFilled(true);
		grid[5][4].setFilled(true);
		grid[6][4].setFilled(true);
		grid[8][4].setFilled(true);
		grid[1][5].setFilled(true);
		grid[3][5].setFilled(true);
		grid[5][5].setFilled(true);
		grid[6][5].setFilled(true);
		grid[5][5].setFilled(true);
		grid[8][5].setFilled(true);
		grid[1][6].setFilled(true);
		grid[3][6].setFilled(true);
		grid[5][7].setFilled(true);
		grid[8][7].setFilled(true);
		grid[6][7].setFilled(true);
		grid[1][7].setFilled(true);
		grid[3][7].setFilled(true);
		grid[1][8].setFilled(true);
		grid[2][8].setFilled(true);
		grid[3][8].setFilled(true);
		grid[5][8].setFilled(true);
		grid[6][8].setFilled(true);
		grid[8][8].setFilled(true);
		grid[0][9].setFilled(true);
		grid[1][9].setFilled(true);
		grid[2][9].setFilled(true);
		grid[3][9].setFilled(true);
		grid[5][9].setFilled(true);
		grid[6][9].setFilled(true);
		grid[7][9].setFilled(true);
		grid[8][9].setFilled(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {
	            String className = UIManager.getCrossPlatformLookAndFeelClassName();
	            UIManager.setLookAndFeel(className);
	        } catch ( Exception e) {}
	        
	        EventQueue.invokeLater(new Runnable (){
	            @Override
	            public void run() {
	                new CrosswordGenerator();
	            }   
	        });
	    }
	

}
