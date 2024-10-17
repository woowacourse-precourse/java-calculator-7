package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validateUserInput(String input){

        // 문자열 가장 앞에 // \n이 존재한다
        checkCustomInPlace(input);

    }


    // // \n이 가장 처음에 하나만 존재한다
    private static void checkCustomInPlace(String input) {
        Pattern pattern= Pattern.compile("^//(.)\\\\n{1}");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()){ // 문자열 가장 앞에 // \n이 있을 때
            String customSperator=matcher.group(1);
            checkIfMinus(customSperator);
            checkIfNumber(customSperator);
            //checkIfDuplicate(input); //두개 이상 존재한다

        }else{ //문자열 가장 앞에 // \n이 없다
            //음수를 입력한 경우
            checkIfNegative(input);
            //문자열에 // \n이 없고 쉼표와 콜론 외 문자가 있을 때
            checkIfUnsigned(input);


        }
    }

    //음수를 입력
    private static void checkIfNegative(String input) {
        Pattern pattern=Pattern.compile("-[0-9]");
        Matcher matcher=pattern.matcher(input);

        if (matcher.find()) throw new IllegalArgumentException(MessageType.NEGATIVE_INPUT.getMessage());
    }

    private static void checkIfUnsigned(String input) {
        String[] numbers=input.split(",|:");

        String REGEXP_ONLY_NUM = "^[\\d]*$";
        for (String number:numbers){
            if (!Pattern.matches(REGEXP_ONLY_NUM,number)){
                throw new IllegalArgumentException(MessageType.INVALID_SEPERATOR.getMessage());
            }
        }

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
