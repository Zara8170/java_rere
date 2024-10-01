package dbpackage;
import java.sql.Date;
import java.util.Scanner;

public class App {
	private LoginMenuManager manager;
	private Scanner scanner;
	
	public App() {
		manager = new LoginMenuManager();
		manager.initDBConnect();
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			System.out.print("선택: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice){
				case 1:
					registerUser();
					break;
				case 2:
					loginUser();
					break;
				case 3:
					manager.releaseDB();
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 선택입니다.");
			}
		}
	}
	
	public void registerUser() {
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		System.out.print("이름: ");
		String name = scanner.nextLine();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine();
		System.out.print("전화번호: ");
		String phone = scanner.nextLine();
		System.out.print("주소 ID: ");
		int address_id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("생년월일 (YYYY-MM-DD): ");
		String birthStr = scanner.nextLine();
		Date birthyear = Date.valueOf(birthStr);
		
		User user = new User(email,name,password,phone,address_id,birthyear);
		boolean success = manager.registerUser(user);
		if(success) {
			System.out.println("회원가입이 완료되었습니다.");
		}
		else {
			System.out.println("회원가입이 실패했습니다.");
		}
		
	}
	
	public void loginUser() {
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine();
		
		boolean success = manager.loginUser(email,password);
		if(success) {
			System.out.println("로그인에 성공하셨습니다.");
		}
		else {
			System.out.println("로그인에 실패하였습니다. 이메일과 비밀번호를 확인하세요.");
		}
	}
	
	public static void main(String[] args) {
		new App().run();
	}
	
}
