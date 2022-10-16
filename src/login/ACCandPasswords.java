package login;
import java.util.HashMap;

import connData.ConnJDBC;

public class ACCandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public ACCandPasswords(){
		
	}
	
	public HashMap<String, String> getLoginInfo(){
		return ConnJDBC.findAllAccount();
	}
}