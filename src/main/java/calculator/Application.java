package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Scanner sc = new Scanner(System.in);
    	System.out.print("덧셈할 문자열을 입력해주세요.");
    	String arr = sc.next();
    	sc.close();
    	int m=arr.length();
    	int sum=0;
    	for(int i=0;i<m;i++) {
    		char c=arr.charAt(i);
    		if(c>='0'&&c<='9') {
    			sum+=c-'0';
    		}
    	}
    	System.out.println("결과 : "+sum);
    }
}
