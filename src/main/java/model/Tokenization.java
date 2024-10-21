package model;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenization {
    private static final String NUMBER_PATTERN = "^-?[0-9]+$";
    private static final Pattern CUSTOM_OPERATION_PATTERN = Pattern.compile("^//(.*)\\\\n(.*)");
    private static final String DEFAULT_OPERATION = ",|:";


    /**
     * 구분자에 따라 문자열 분리하는 메인 함수
     * **/
    public ArrayList<Integer> tokenize(String str){
        ArrayList<Integer> numArr = new ArrayList<>();
        String delimiter = extractDelimiter(str);

        str = extractContent(str);

        String[] tokens = splitString(str, delimiter);

        // 문자열 정수형으로 변환
        for(String token : tokens){
            if (!token.matches(NUMBER_PATTERN)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getErrorMessage());
            }
            try{
                int num = Integer.parseInt(token);
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

    /**
     * 구분자 추출 메서드
     */
    private String extractDelimiter(String str) {
        Matcher matcher = CUSTOM_OPERATION_PATTERN.matcher(str);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1));
        }
        return DEFAULT_OPERATION;
    }

    /**
     * 구분자에 따라 분리한 내용 추출 메서드
     */
    private String extractContent(String str) {
        Matcher matcher = CUSTOM_OPERATION_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return str;
    }

    /**
     * 구분자에 따라 문자열 분리 메서드
     */
    private String[] splitString(String str, String delimiter) {
        return str.split(delimiter);
    }
}
