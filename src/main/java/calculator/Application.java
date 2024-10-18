package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

    	try {
    		System.out.println("덧셈할 문자열을 입력해 주세요.");
    		String str = Console.readLine();
    		int checkNum = Application.checkStr(str);
    		System.out.println("결과 : " + checkNum);
    	}catch(Exception e) {
    		throw new IllegalArgumentException();
    	}
    }
    
    public static int checkStr(String str) {
    	if(str.length() == 0 || str == null) {
    		return 0;
    	}
    	if(str.length() == 1) {
    		return Integer.parseInt(str);
    	}
    	if(str.length() > 1) {
    		Application.checkFirstNum(str);
    	}
		return 0;
    }
    
    public static String[] checkFirstNum(String str) {
    	String[] arr = {};
    	if(Character.isDigit(str.charAt(0))) {
    		arr = str.replaceAll(":", ",").split(",");
    	}
    	if(str.charAt(0) == '/') {
    		String custom = String.valueOf(str.charAt(2));
    		str = str.substring(5, str.length());
    		arr = str.split(custom);
    	}
		return arr;
    }

    
 
}
