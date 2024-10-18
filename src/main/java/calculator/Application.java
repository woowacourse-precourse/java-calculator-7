package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
	private static final String DEFAULT_DELIMETERS = ",|:";
	
    public static void main(String[] args) {
        System.out.println(INPUT_REQUEST_MESSAGE);
        String input = Console.readLine();
        
        if(input.isEmpty() || input.trim().isEmpty()) {
        	System.out.println(0);
        	return;
        }
        
        String[] tokens = input.split(DEFAULT_DELIMETERS);
    }
}
