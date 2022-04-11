
public class Main {

	public static void main(String[] args) {

		IDandPasswords idPass = new IDandPasswords(); 
		
		LoginPage loginPage = new LoginPage(idPass.getLoginInfo());
	}

}
