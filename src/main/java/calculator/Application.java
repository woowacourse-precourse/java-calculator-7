package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
	private static final String DEFAULT_DELIMETERS = ",|:";
	private static final String CUSTOM_DELIMETERS_PREFIX = "//";
	private static final String CUSTOM_DELIMETERS_SUFFIX = "\\n";
	
    public static void main(String[] args) {
        System.out.println(INPUT_REQUEST_MESSAGE);
        String input = Console.readLine();
        
        if(input.isEmpty() || input.trim().isEmpty()) {
        	System.out.println(0);
        	return;
        }
        
        String delimiters = DEFAULT_DELIMETERS;
        String defaultInput = input;
        
        if(input.startsWith(CUSTOM_DELIMETERS_PREFIX)) {
        	int delimiterStartIndex = CUSTOM_DELIMETERS_PREFIX.length();
        	int delimiterEndIndex = input.indexOf(CUSTOM_DELIMETERS_SUFFIX, delimiterStartIndex);   
        	delimiters = input.substring(delimiterStartIndex, delimiterEndIndex);
        	defaultInput = input.substring(delimiterEndIndex + 2);
        } 
        
        String[] tokens = defaultInput.split(delimiters);
        
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }    
    }
}
