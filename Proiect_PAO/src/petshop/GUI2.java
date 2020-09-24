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
import javax.swing.JTextField;


public class GUI2 implements ActionListener{
	JFrame frame;
	JButton button, button2;
	JPanel panel;
	JLabel label, info = new JLabel("");
	Service s;
	JTextField userText = new JTextField(20);
	public GUI2(int i, Service sGUI) {
		s = sGUI;
		if(i == 1) {
			frame = new JFrame();
			button = new JButton("Inapoi");
			button2 = new JButton("Cauta");
			panel = new JPanel();
		
			userText.setBounds(100, 20, 265, 25);
			label = new JLabel("Introduceti numele angajatului despre care vreti sa aflati mai multe");
			button.addActionListener(new Button2());
			panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
			panel.setLayout(new GridLayout(0,1));
			//panel.add(label);
			panel.add(userText);
			panel.add(info);
			panel.add(button2);
			panel.add(button);
			button2.addActionListener(this);
			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Zoo");
			frame.pack();
			frame.setVisible(true);}
		if(i == 2) {
			sGUI.Request(5,1);
			String lmessage ="<html>" + sGUI.GetGUIMessage() + "</html>";
			frame = new JFrame();
			s.EmptyGUIMessage();
			button = new JButton("Inapoi");
			panel = new JPanel();
			label = new JLabel(lmessage);
			button.addActionListener(new Button2());
			panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
			panel.setLayout(new GridLayout(0,1));
			panel.add(label);
			panel.add(button);
		
			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Zoo");
			frame.pack();
			frame.setVisible(true);
		}
		if(i == 3) {
			frame = new JFrame();
			button = new JButton("Inapoi");
			button2 = new JButton("Cauta");
			panel = new JPanel();
		
			userText.setBounds(100, 20, 265, 25);
			label = new JLabel("Introduceti numele angajatului ale carui animale vreti sa le verificati");
			button.addActionListener(new Button2());
			panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
			panel.setLayout(new GridLayout(0,1));
			//panel.add(label);
			panel.add(userText);
			panel.add(info);
			panel.add(button2);
			panel.add(button);
			button2.addActionListener(new Button3());
			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Zoo");
			frame.pack();
			frame.setVisible(true);
		}
		if(i == 4) {
			frame = new JFrame();
			button = new JButton("Inapoi");
			button2 = new JButton("Concediaza");
			panel = new JPanel();
		
			userText.setBounds(100, 20, 265, 25);
			label = new JLabel("Introduceti numele angajatului pe care vreti sa-l concediati");
			button.addActionListener(new Button2());
			panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
			panel.setLayout(new GridLayout(0,1));
			//panel.add(label);
			panel.add(userText);
			panel.add(info);
			panel.add(button2);
			panel.add(button);
			button2.addActionListener(new Button4());
			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Zoo");
			frame.pack();
			frame.setVisible(true);
		}
		if(i == 5) {
			frame = new JFrame();
			button = new JButton("Inapoi");
			button2 = new JButton("Cauta");
			panel = new JPanel();
		
			userText.setBounds(100, 20, 265, 25);
			label = new JLabel("Introduceti numele angajatului ale carui animale vreti sa interactionati");
			button.addActionListener(new Button2());
			panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
			panel.setLayout(new GridLayout(0,1));
			//panel.add(label);
			panel.add(userText);
			panel.add(info);
			panel.add(button2);
			panel.add(button);
			button2.addActionListener(new Button5());
			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Zoo");
			frame.pack();
			frame.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user = userText.getText();
		s.SetUser(user);
		s.Request(2, 1);
		info.setText("<html>"+s.GetGUIMessage()+"</html>"); 
		s.EmptyGUIMessage();
	}
	private class Button2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI(s);
		}
		
	}
	private class Button3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String user = userText.getText();
			s.SetUser(user);
			s.Request(3, 1);
			info.setText("<html>"+s.GetGUIMessage()+"</html>");
			s.EmptyGUIMessage();
		}
		
	}
	private class Button4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String user = userText.getText();
			s.SetUser(user);
			s.Request(4, 1);
			info.setText("Concediat");
		}
		
	}
	private class Button5 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String user = userText.getText();
			s.SetUser(user);
			s.Request(10, 1);
			info.setText("<html>"+s.GetGUIMessage()+"</html>");
			s.EmptyGUIMessage();
		}
		
	}
}