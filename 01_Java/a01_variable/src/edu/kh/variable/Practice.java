package edu.kh.variable;

public class Practice {
	public static void main(String[] args) {
		
	    int iNum1 = 10; 
	    int iNum2 = 4;
	    float fNum = 3.0f;
	    double dNum = 2.5;
	    char ch = 'A';
	    
	    System.out.println(iNum1 / iNum2); // 2 int / int = int 
	    System.out.println((int)dNum);
	    
	    System.out.println((double)iNum1); 
	    System.out.println(iNum2 * dNum); 
	    
	    // float 사용 빈도 낮음
	    
	    System.out.println((int)fNum);
	    System.out.println((int)(iNum1 / fNum));
	    
	    // 
	    System.out.println( iNum1 / fNum ); // 3.3333333
	    System.out.println( iNum1 / (double)fNum ); // 3.3333333
	    System.out.println( (double)iNum1 / fNum ); // 3.3333333
	    // 극한값 
	    
	    System.out.println( (int)ch ); // 65
	    System.out.println( iNum1 + ch ); 
	    System.out.println((char)75);  // K를 출력하고 싶다면
	    System.out.println((char)(iNum1 + ch));  // A는 65 유니코드 K는 유니코드 75
	    
	    // % 모듈러 나머지 
	    
	    
	    
	    
	    
	   
	    
	    
	   
	    
	    
	   
	 
	   
	   
	    
	    
	    
	}

}
