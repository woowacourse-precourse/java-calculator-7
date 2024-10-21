package calculator;

class Func{
	public static String regex = ",|;";
	
	public static boolean contain(String speChar) {
		switch(speChar) {
		case ".":
			return true;
		case "$":
			return true;
		case "*":
			return true;
		case "^":
			return true;
		case "?":
			return true;
		case "+":
			return true;
		case "|":
			return true;
		case "(":
			return true;
		case ")":
			return true;
		}
		
		return false;
	}
	
	public static String stringOverFive(String input) {
		String copy = input.substring(0, 5);
		if(copy.startsWith("//") && copy.endsWith("\\n")) {
			String custom = copy.substring(2, 3);
			
			if(custom.equals("-")) {
				throw new IllegalArgumentException();
			}
			
			if(contain(custom)) {
				regex = regex + "|\\" + custom;
				return input.substring(5);
			}
			
			regex = regex + "|" + custom;
			return input.substring(5);
		}
		
		return input;
	}
	
	public static void split(String input) {
		String arr[] = input.split(regex);
		
		try {
			int sum = 0;
			for(int i=0;i<arr.length;i++) {
				if(Integer.parseInt(arr[i]) < 0) {
					throw new IllegalArgumentException();
				}
				
				if(arr[i].equals("")) {
					sum += 0;
					continue;
				}
				
				sum += Integer.parseInt(arr[i]);	
			}
			
			System.out.println("결과 : " + sum);
		}catch(NumberFormatException e){
			throw new IllegalArgumentException();
		}
	}
}


public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String str = camp.nextstep.edu.missionutils.Console.readLine();
        
        if(str.length()>=5) {
			Func.split(Func.stringOverFive(str));
		}
		else if(str.length()<5 && str.length() != 0) {
			Func.split(str);
		}
		else if(str.length() == 0 || str == null) {
			System.out.println("결과 : 0");
		}

    }
}
