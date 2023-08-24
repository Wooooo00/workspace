package review;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // (스캐너 임포트)



public class Test1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // (스캐너 임포트)
		
		// List<IPInfo> ipInfoList = null; 참조 변수가 null인 상황이면 NullpointException이 발생할 수 있기 때문에
		// NullpointException은 RuntimeException 클래스 종류 중 하나로 
		// 프로그래머의 실수로 인하여 주로 일어나는 Unchecked Exception이기 때문에 
		// 예외처리가 아닌 코드를 수정해줌으로써 오류를 해결해주는 경우가 많다 
		
		
		
		List<IPInfo> ipInfoList = new ArrayList<IPInfo>();
		
		
		// ipInfoList.add(new IPInfo("212.133.7.8." )); -> 
		ipInfoList.add(new IPInfo("212.133.7.8", "아무이름"));
		
		
		
		
		
		
	}

}
