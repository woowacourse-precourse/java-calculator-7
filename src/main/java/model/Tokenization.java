package model;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenization {
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final Pattern CUSTOM_OPERATION_PATTERN = Pattern.compile("^//(.*)\\\\n(.*)");
    private static final String DEFAULT_OPERATION = ",|:";

    /**
     * 구분자에 따라 문자열 분리하는 함수
     * **/
    public ArrayList<Integer> tokenize(String str){
        ArrayList<Integer> numArr = new ArrayList<>();
        String operation = DEFAULT_OPERATION;
        Matcher matcher = CUSTOM_OPERATION_PATTERN.matcher(str);

        // 구분자 확인
        if(matcher.find()){
            operation = matcher.group(1);
            str = matcher.group(2);
            operation = Pattern.quote(operation);
        }

        // 구분자에 따라 문자열 분리
        for(String i:str.split(operation)){
            if (!i.matches(NUMBER_PATTERN)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
            }
            try{
                int num = Integer.parseInt(i);
                if (num<=0){
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getErrorMessage());
                }
                numArr.add(num);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException(ErrorMessage.LENGTH.getErrorMessage());
            }
        }
        return numArr;
    }
}
