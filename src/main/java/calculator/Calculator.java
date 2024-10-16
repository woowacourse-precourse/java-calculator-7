package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    static final String DEFAULT_DELIMITERS = "[,:]"; //정규식 표현
    static final String CUSTOM_DELIMITER_PREFIX = "//"; //커스텀 구분자를 구별해주는 앞부분
    static final String CUSTOM_DELIMITER_SUFFIX = "\\n"; //커스텀 구분자를 구별해주는 뒷부분

    public static String inputString(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static String [] extractNumber(String input){
        if(input.startsWith(CUSTOM_DELIMITER_PREFIX)){
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(),delimiterIndex);
            String number = input.substring(CUSTOM_DELIMITER_PREFIX.length()+customDelimiter.length()
                    +CUSTOM_DELIMITER_SUFFIX.length());
            return number.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

}
