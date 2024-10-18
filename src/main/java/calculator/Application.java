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
    		String[] arr = Application.checkFirstNum(str);
    		return Application.checkArrNum(arr);
    	}
		return 0;
    }
    
    public static String[] checkFirstNum(String str) {
    	String[] arr = {};
    	if(Character.isDigit(str.charAt(0))) {
    		arr = str.split(",|:");
    	}
    	else if(str.charAt(0) == '/') {
    		String custom = str.substring(2, str.indexOf("\\n"));
    		str = str.substring(str.indexOf("\\n")+2,str.length());
    		arr = str.split(custom);
    	}
    	else {
    		throw new IllegalArgumentException();
    	}
		return arr;
    }
    
    public static int checkArrNum(String[] arr) {
    	int sum = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if(Integer.parseInt(arr[i]) >= 0) {
    			sum += Integer.parseInt(arr[i]);
    		}else {
    			throw new IllegalArgumentException();
    		}
    	}
		return sum;
    }
}
