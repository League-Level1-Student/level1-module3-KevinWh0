package Whack_a_mole_Mod4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MoleGame implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Date timeAtStart = new Date();
	int score = 0;

	void speak(String words) { 
	    try { 
	        Runtime.getRuntime().exec("say " + words).waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	void drawMoleGrid() {
		frame.dispose();
		//frame.setBounds(120, 200, 300, 350);
		frame = new JFrame();
		panel = new JPanel();
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension frameSize = new Dimension(300,350);
		frame.setSize(frameSize);	
		frame.setBounds(120, 200, 300, 350);
		
		
		int molePos = genRandoMolePos();
		for(int i = 0; i < 24; i++) {
			JButton temp = new JButton();
			temp.addActionListener(this);
			
			if(molePos == i) {
				temp.setText("Mole!");
			}else {
				temp.setText("\n");
				
			}
			
			panel.add(temp);
			
			
		}
		
		
		
	}
	void runGame() {
	
		drawMoleGrid();
		

		
		
	}
	int  genRandoMolePos() {
		Random rand = new Random();
		return rand.nextInt(24);
		
		//temp[pos].setText = "Mole";
		
	}
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	    score = 0;
	    timeAtStart = new Date();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String butSrcTxt = e.getActionCommand();
		if(butSrcTxt.equals("\n")) {
			System.out.println("NOT A MOLE");
		}else {
			System.out.println("MOLE!");
			//speak("Mole!");
			score++;
			if(score > 9) {
				endGame(timeAtStart, score);
				
			}
		}
		//genRandomole();
		drawMoleGrid();
	}
}
