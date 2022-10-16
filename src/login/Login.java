package login;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mainView.salaryMainView;

public class Login implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Refresh");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	JLabel messageLabel1 = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	private final JButton changepass = new JButton("Change Password");
	
	public Login(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,281,200,41);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		messageLabel1.setBounds(125,317,200,41);
		messageLabel1.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(126,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(236,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.getContentPane().add(userIDLabel);
		frame.getContentPane().add(userPasswordLabel);
		frame.getContentPane().add(messageLabel);
		frame.getContentPane().add(messageLabel1);
		
		frame.getContentPane().add(userIDField);
		frame.getContentPane().add(userPasswordField);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.getContentPane().setLayout(null);
		changepass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ACCandPasswords idandPasswords = new ACCandPasswords();
							ChangePass frame = new ChangePass(idandPasswords.getLoginInfo());
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		changepass.setFocusable(false);
		changepass.setBounds(147, 251, 152, 25);
		
		frame.getContentPane().add(changepass);
		frame.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Đăng nhập thành công");
					
					frame.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								salaryMainView frame = new salaryMainView();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Sai mật khẩu.");
					messageLabel1.setForeground(Color.red);
					messageLabel1.setText("Vui lòng nhập lại.");
					
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Sai tài khoản.");
				messageLabel1.setForeground(Color.red);
				messageLabel1.setText("Vui lòng nhập lại.");
				
			}
		}
		
	}	
}