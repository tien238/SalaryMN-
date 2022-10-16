package app;

import java.awt.EventQueue;

import connData.ConnJDBC;
import login.ACCandPasswords;
import login.Login;
import mainView.salaryMainView;

public class Main {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					ACCandPasswords idandPasswords = new ACCandPasswords();
					
					Login loginPage = new Login(idandPasswords.getLoginInfo());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

