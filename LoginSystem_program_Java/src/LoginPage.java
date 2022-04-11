import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPassField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User ID: ");
	JLabel userPassLabel = new JLabel("User Password: ");
	JLabel msgLabel = new JLabel();
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	public LoginPage(HashMap<String, String> loginInfoOriginal) {
		loginInfo = loginInfoOriginal;
		
		userIDLabel.setBounds(25,100,100,25);
		userPassLabel.setBounds(25,150,100,25);
		
		msgLabel.setBounds(125, 250, 250, 35);
		msgLabel.setFont(new Font("Arial", Font.ITALIC, 25));
		
		userIDField.setBounds(125,100,200,25);
		userPassField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPassLabel);
		frame.add(userIDField);
		frame.add(userPassField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(msgLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPassField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			String userID = userIDField.getText();
			String userPass = String.valueOf(userPassField.getPassword());
			
			if(loginInfo.containsKey(userID)) {
				if(loginInfo.get(userID).equals(userPass)) {
					msgLabel.setForeground(Color.green);
					msgLabel.setText("Login successful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID);
				}
				else {
					msgLabel.setForeground(Color.red);
					msgLabel.setText("Wrong password!");
				}
			}
			else {
				msgLabel.setForeground(Color.red);
				msgLabel.setText("Username not found.");
			}
			
		}
	}

}
