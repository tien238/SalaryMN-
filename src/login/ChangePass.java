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

import connData.ConnJDBC;
import mainView.salaryMainView;

public class ChangePass implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Update");
	JButton resetButton = new JButton("Refresh");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Old Password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	private JPasswordField passwordField;
	private final JButton btnTrV = new JButton("Trở về");
	
	public ChangePass(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(53,36,343,41);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(111,236,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(235,236,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.getContentPane().add(userIDLabel);
		frame.getContentPane().add(userPasswordLabel);
		frame.getContentPane().add(messageLabel);
		
		frame.getContentPane().add(userIDField);
		frame.getContentPane().add(userPasswordField);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 200, 200, 25);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(50, 200, 75, 25);
		frame.getContentPane().add(lblNewPassword);
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ACCandPasswords idandPasswords = new ACCandPasswords();
				
				Login loginPage = new Login(idandPasswords.getLoginInfo());
			}
		});
		btnTrV.setFocusable(false);
		btnTrV.setBounds(172, 271, 100, 25);
		
		frame.getContentPane().add(btnTrV);
		frame.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			String newpass = String.valueOf(passwordField.getPassword());
			if(userID.equals("") ||password.equals("")||newpass.equals("")) {
				
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Không bỏ trống");
				
					
					
//					frame.dispose();
//					EventQueue.invokeLater(new Runnable() {
//						public void run() {
//							try {
//								salaryMainView frame = new salaryMainView();
//								frame.setVisible(true);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					});
				
			}
			else if(logininfo.get(userID)!= null &&logininfo.get(userID).equals(password) ){
				ConnJDBC.ChangePass(userID, newpass);
				messageLabel.setForeground(Color.green);
				messageLabel.setText("Thay đổi mật khẩu thành công.");
				
			}else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Sai tài khoản hoặc mật khẩu");
			}
		}
		
	}



	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}	
}