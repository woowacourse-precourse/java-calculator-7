package calculator.domain;

import calculator.exception.InvalidInputException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern CUSTOM_SEPERATOR_PATTERN=Pattern.compile("^//(.)\\\\n{1}(.*)");
    private static final String NUMBER_REGEX="[0-9]{0,}";

    private static final String OVERFLOW_RESULT="덧셈의 결과가 int 범위를 넘어갔습니다";
    private static final String OVERFLOW_NUMBER="특정 수가 int 범위를 넘어갔습니다";
    private static final String INVALID_SEPERATOR="커스텀 구분자가 아닌 기호를 입력했습니다";

    private static final String BLANK="";

    public static int inputCalculate(String input){
        //커스텀 구분자 패턴이 존재하는지 확인한다
       return checkExtractor(input);

    }

    private static int checkExtractor(String input){
        Matcher matcher=CUSTOM_SEPERATOR_PATTERN.matcher(input);

        if (matcher.find()){//일치한다면
            String customSeperator=matcher.group(1);
            input= matcher.group(2);

            SeperatorFactory.addRegex(customSeperator);
        }

        String seperatorRegex=SeperatorFactory.getSeperatorRegex();

        return calculate(input,seperatorRegex);
    }

    private static int calculate(String input,String seperatorRegex) {
        int result= Arrays.stream(input.split(seperatorRegex))
                .filter(num->!isBlank(num))
                .peek(num->validateCustomSeperator(num))
                .peek(num->validateInteger(num))
                .mapToInt(Integer::parseInt)
                .reduce(0,(a,b)->addTwoNum(a,b));

        return result;
    }

    //존재하지 않는 커스텀 구분자 예외발생
    private static void validateCustomSeperator(String num){
        if (!(num.matches(NUMBER_REGEX))){
            throw new InvalidInputException(MessageType.INVALID_SEPERATOR);
        }
    }

    private static void validateInteger(String num){
        try{
            Integer.parseInt(num);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(MessageType.OVERFLOW_NUMBER.getMessage());
        }
    }

    private static int addTwoNum(int a,int b) {
        if (a>Integer.MAX_VALUE-b){
            throw new IllegalArgumentException(OVERFLOW_RESULT);
        }
        return a+b;
    }

    private static boolean isBlank(String num) {
        return num.equals(BLANK);
    }
}
