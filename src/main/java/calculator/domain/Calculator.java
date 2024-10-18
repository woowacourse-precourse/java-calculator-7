package calculator.domain;

import calculator.validation.MessageType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static String SEPERATOR_REGEX=",|:";
    private String input;


    public Calculator(String input){
        this.input=input;
    }
    //입력을 처리한다
    public int inputCalculate(){
        //커스텀 구분자 패턴이 존재하는지 확인한다
        checkExtractor(input);

        return calculate(input);

    }

    private int calculate(String input) {
        int result=0;
        String[] ar=input.split(SEPERATOR_REGEX);

        for (String num:ar){
            isNumber(num);
            result+=Integer.parseInt(num);

        }

        return result;

    }

    private static void isNumber(String num) {
        if (!(num.matches("[0-9]{0,}"))){
            throw new IllegalArgumentException("존재하지 않는 커스텀 구분자입니다");
        }
    }

    private void checkExtractor(String input){
        Pattern pattern= Pattern.compile("^//(.)\\\\n{1}(.*)");

        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){//일치한다면
            String customSeperator=matcher.group(1);
            //잘못된 구분자 입력-> 예외를 터뜨린다
            checkBadSeperator(customSeperator);
            String editedInput= matcher.group(2);
            //SEPERATOR_REGEX에 더한다
            addRegex(customSeperator);
            editInput(editedInput);

        }
    }


    private void editInput (String editedInput) {
        this.input=editedInput;
    }


    private static void addRegex(String customSeperator) {
        //커스텀 구분자가 | 이라면 이스케이프문자를 추가해햐 한다
        if (customSeperator.equals("|")){
            customSeperator="\\"+customSeperator;
        }

        SEPERATOR_REGEX=SEPERATOR_REGEX+"|"+customSeperator;
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
