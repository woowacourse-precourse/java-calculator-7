package calculator.domain;

import calculator.exception.InvalidInputException;
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
        Validator.validatePositive(input);
        return calculate(input);
    }

    private static String checkExtractor(String input){
        Matcher matcher=CUSTOM_SEPERATOR_PATTERN.matcher(input);

        if (matcher.find()){//일치한다면
            String customSeperator=matcher.group(1);
            Validator.validateSeperator(customSeperator);
            input= matcher.group(2);
            //SEPERATOR_REGEX에 더한다
            addRegex(customSeperator);
        }

        return input;
    }

    private static int calculate(String input) {
        int result= Arrays.stream(input.split(seperatorRegex))
                .filter(num->!isSpace(num))
                .peek(num->Validator.validateCustomSeperator(num))
                .mapToInt(Integer::parseInt)
                .sum();

        return result;
    }

    private static boolean isSpace(String num) {
        return num.equals("");
    }

    private static void addRegex(String customSeperator) {
        StringBuilder regexBuilder=new StringBuilder();
        //커스텀 구분자가 | 이라면 이스케이프문자를 추가해햐 한다
        if (customSeperator.equals("|")){
            customSeperator=addEscapeChar(customSeperator);
        }

        regexBuilder.append(seperatorRegex);
        regexBuilder.append("|");
        regexBuilder.append(customSeperator);

       seperatorRegex=regexBuilder.toString();
    }

    private static String addEscapeChar(String customSeperator){
        StringBuilder seperatorBuilder=new StringBuilder();

        seperatorBuilder.append("\\");
        seperatorBuilder.append(customSeperator);

        return customSeperator.toString();
    }

}
