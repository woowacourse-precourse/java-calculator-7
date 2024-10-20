package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

    	try {
    		System.out.println("덧셈할 문자열을 입력해 주세요.");
    		System.out.println(". $ | ( ) [ { ^ ? * + \\를 커스텀 구분자로 지정할 시 문자 앞에 \\를 기술해주세요.");
    		System.out.println("예) " + "//\\.\\n1.2.3");
    		String str = Console.readLine();
    		int checkNum = Application.checkStr(str);
    		System.out.println("결과 : " + checkNum);
    	}catch(NumberFormatException ne) {
    		throw new IllegalArgumentException("올바른 숫자와 구분자를 입력해주세요.");
    	}
    	catch(Exception e) {
    		throw new IllegalArgumentException();
    	}
    }
    
    public static int checkStr(String str) {
    	if(str == null || str.length() == 0 ) {
    		return 0;
    	}
    	if(str.length() == 1) {
    		return Integer.parseInt(str);
    	}
    	String[] arr = Application.checkFirstNum(str);
    	return Application.checkArrNum(arr);
    }
    
    public static String[] checkFirstNum(String str) {
    	String[] arr = {};
    	if(Character.isDigit(str.charAt(0))) {
    		arr = str.split(",|:");
    	}
    	else if(str.startsWith("//")) {
    		String custom = str.substring(2, str.indexOf("\\n"));
    		str = str.substring(str.indexOf("\\n")+2,str.length());
            if (".$|()[{^?*+".contains(custom.substring(0, 1))) {
            	System.err.println("커스텀 구분자 사용 시 형식을 지켜주세요.");
            	throw new IllegalArgumentException();
            }
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
    		if(arr[i] == null || arr[i].isEmpty()) {
    			sum += 0;
    		}else if(Integer.parseInt(arr[i]) >= 0) {
    			sum += Integer.parseInt(arr[i]);
    		}else {
    			throw new IllegalArgumentException();
    		}
    	}
		return sum;
    }
}
