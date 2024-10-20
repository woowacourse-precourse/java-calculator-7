package calculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern CUSTOM_SEPERATOR_PATTERN=Pattern.compile("^//(.)\\\\n{1}(.*)");
    private static final String SPLITOR="|";
    private static final String ESCAPE_CHAR="\\";
    private static final String BLANK="";

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
                .filter(num->!isBlank(num))
                .peek(num->Validator.validateCustomSeperator(num))
                .peek(num->checkIfInteger(num))
                .mapToInt(Integer::parseInt)
                .reduce(0,(a,b)->addTwoNum(a,b));

        return result;
    }

    private static void checkIfInteger(String num) {
        try{
            Integer.parseInt(num);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("특정 수가 int 범위를 넘어갔습니다");
        }
    }

    private static int addTwoNum(int a,int b) {
        if (a>Integer.MAX_VALUE-b){
            throw new IllegalArgumentException("덧셈의 결과가 int 범위를 넘어갔습니다");
        }

        return a+b;
    }

    private static boolean isBlank(String num) {
        return num.equals(BLANK);
    }

    private static void addRegex(String customSeperator) {
        StringBuilder regexBuilder=new StringBuilder();
        //커스텀 구분자가 | 이라면 이스케이프문자를 추가해햐 한다
        if (customSeperator.equals(SPLITOR)){
            customSeperator=addEscapeChar(customSeperator);
        }

        regexBuilder.append(seperatorRegex)
                    .append(SPLITOR)
                    .append(customSeperator);

       seperatorRegex=regexBuilder.toString();
    }

    private static String addEscapeChar(String customSeperator){
        StringBuilder seperatorBuilder=new StringBuilder();

        seperatorBuilder.append(ESCAPE_CHAR)
                        .append(customSeperator);

        return customSeperator.toString();
    }

}
