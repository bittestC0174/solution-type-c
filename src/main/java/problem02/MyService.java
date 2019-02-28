package problem02;

public class MyService extends BaseService {
	
	public void service(String state) {
		
		if(state.equals("오후")) {
			String result = afternoon();
			System.out.println(result);
		}
		else super.service(state);
	}

	public String afternoon() {
		return "오후서비스시작";
	}
	
	public String day() {
		return "낮서비스시작";
	}

	public String night() {
		return "밤서비스시작";
	}
}
