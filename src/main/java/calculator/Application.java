package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "숫자는 양수 값이어야 합니다.";
    private static final String INPUT_VALIDATION_EXCEPTION_MESSAGE = "입력값 오류입니다.";
    private static final String COMMA = ",";
    private static final String SEMICOLON = ";";
    private static final String CUSTOM_DELIMITER_START_STR = "//";
    private static final String CUSTOM_DELIMITER_END_STR = "\\n";


    public static void inputMessage(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        inputParser(input);
    }

    public static void inputParser(String input){
        try {
            numberList = new ArrayList<>();
//            커스텀 구분자 여부 체크
            String delimiter;
            if(input.startsWith(CUSTOM_DELIMITER_START_STR)) {
                input = input.substring(2);
                delimiter = customDelimiter(input);
                int idx = input.indexOf(CUSTOM_DELIMITER_END_STR);
                input = input.substring(idx + 2);
            }
            String[] inputArray = input.split(delimiter);
        }   catch (Exception e){
            throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
        }
    }

    public static String customDelimiter(String input){
//        ||와 \n 사이에 커스텀 구분자가 있는 경우
        int idx = input.indexOf(CUSTOM_DELIMITER_END_STR);
        if(idx > 0){
            return input.substring(0, idx);
        }
        throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
    }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputMessage();
        printResult(plus());
    }
}
