package petshop;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	JFrame frame;
	JButton button1, button2, button3, button4, button5;
	JPanel panel;
	JLabel label;
	int i = 0;
	Service sGUI;
	public GUI(Service s) {
		sGUI = s;
		frame = new JFrame();
		button1 = new JButton("Afisarea informatiilor despre un angajat");
		button2 = new JButton("Afisarea Angajatilor");
		button3 = new JButton("Afisarea animalelor din grija unui angajat");
		button4 = new JButton("Concedierea unui angajat");
		button5 = new JButton("Interactioneaza cu animalele");
		panel = new JPanel();
		label = new JLabel("Bine ati venit in aplicatia gradinii noastre Zoo");
		button1.addActionListener(this);
		button2.addActionListener(new Button2());
		button3.addActionListener(new Button3());
		button4.addActionListener(new Button4());
		button5.addActionListener(new Button5());
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Zoo");
		frame.pack();
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new GUI2(1, sGUI);
		
	}
	private class Button2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI2(2 , sGUI);
		}
		
	}
	private class Button3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI2(3, sGUI);
		}
		
	}
	private class Button4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI2(4,sGUI);
		}
		
	}
	private class Button5 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI2(5,sGUI);
		}
		
	}

}
