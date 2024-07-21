package swingPrograms;

import javax.swing.*;
public class CreationOfButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating instance of JFrame
		JFrame frame = new JFrame();
		
		//creating an instance of JButton
		JButton button = new JButton("Click on this Button");
		
		//x axis y axis width length
		button.setBounds(130,100,400,40);
		
		frame.add(button);
		frame.setSize(400,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		

	}

}
