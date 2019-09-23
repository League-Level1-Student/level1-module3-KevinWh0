package SlotM_mod4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Slots implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JLabel img1 = new JLabel();
	JLabel img2 = new JLabel();
	JLabel img3 = new JLabel();

	JButton roll = new JButton("Roll!");
	
	
	void displaySlots() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		roll.addActionListener(this);
		panel.add(roll);

		frame.pack();
		
	}
	
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		panel.remove(img1);
		panel.remove(img2);
		panel.remove(img3);

		// TODO Auto-generated method stub
		int rolls[] = {0,0,0};
		Random rand = new Random();

		for(int i = 0; i < 3; i++) {
			try {
				int roll = rand.nextInt(3)+1;
				
				rolls[i] = roll;
				if(i == 0) {
					
					img1 = createLabelImage(roll+".png");
				}else if(i == 1) {
					
					img2 = createLabelImage(roll+".png");

				}else {
					
					img3 = createLabelImage(roll+".png");

				}
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(rolls[0] == rolls[1] && rolls[1] == rolls[2]) {
			roll.setText("You Win");
		}
		
		panel.add(img1);
		panel.add(img2);
		panel.add(img3);
		frame.pack();
	}
    
}
