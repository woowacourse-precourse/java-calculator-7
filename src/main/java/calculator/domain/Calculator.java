package calculator.domain;
import calculator.validation.MessageType;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern CUSTOM_SEPERATOR_PATTERN=Pattern.compile("^//(.)\\\\n{1}(.*)");
    private static String seperatorRegex=",|:";

    public static int inputCalculate(String input){
        //커스텀 구분자 패턴이 존재하는지 확인한다
        input=checkExtractor(input);

        return calculate(input);
    }

    private static String checkExtractor(String input){
        Matcher matcher=CUSTOM_SEPERATOR_PATTERN.matcher(input);

        if (matcher.find()){//일치한다면
            String customSeperator=matcher.group(1);
            //잘못된 구분자 입력-> 예외를 터뜨린다
            checkBadSeperator(customSeperator);
            input= matcher.group(2);
            //SEPERATOR_REGEX에 더한다
            addRegex(customSeperator);
        }

        return input;
    }

    private static int calculate(String input) {
        int result= Arrays.stream(input.split(seperatorRegex))
                .filter(num->!isSpace(num))
                .peek(num->isNumber(num))
                .mapToInt(Integer::parseInt)
                .sum();

        return result;

    }

    private static boolean isSpace(String num) {
        return num.equals("");
    }

    private static void isNumber(String num) {
        if (!(num.matches("[0-9]{0,}"))){
            throw new IllegalArgumentException(MessageType.INVALID_SEPERATOR.getMessage());
        }
    }

    private static void addRegex(String customSeperator) {
        //커스텀 구분자가 | 이라면 이스케이프문자를 추가해햐 한다
        if (customSeperator.equals("|")){
            customSeperator="\\"+customSeperator;
        }

       seperatorRegex=seperatorRegex+"|"+customSeperator;
    }

    private static void checkBadSeperator(String customSeperator) {
        checkIfNumber(customSeperator);
        checkIfMinus(customSeperator);
    }

    private static void checkIfNumber(String customSeperator) {
        if (customSeperator.matches("[0-9]")){
            throw new IllegalArgumentException(MessageType.NUMBER_SEPERATOR.getMessage());
        }
    }

    private static void checkIfMinus(String customSeperator) {
        if (customSeperator.equals("-")){
            throw new IllegalArgumentException(MessageType.MINUS_SEPERATOR.getMessage());
        }
    }
}
