import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	IDandPasswords(){
		
		loginInfo.put("Uros", "qwe123");
		loginInfo.put("Dasic", "qwe123");
		loginInfo.put("BroCode", "pizza");
	}
	
	protected HashMap getLoginInfo(){
		return loginInfo;
	}
}
