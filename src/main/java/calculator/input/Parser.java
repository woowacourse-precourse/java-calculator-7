package calculator.input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static String inputString; //입력 문자열
    public static String DELIMITER = ",|:"; // 기본 구분자 쉼표와 콜론
    private static final String regex = "//(.*?)\\\\n(.*?)(?=//|$)"; // 정규 표현식 패턴 정의

    public Parser(String inputString){
        this.inputString = inputString;
    }

    public void extractCustomSeparator(){ //커스텀 구분자 추출

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        // 패턴에 맞는 모든 부분 추출
        while (matcher.find()) {
            String customDelimiter = matcher.group(1);
            DELIMITER+="|"+customDelimiter;
            inputString = matcher.group(2);
        }
    }

    public List<Integer> extractNumber(){ //숫자 추출

        extractCustomSeparator(); //커스텀 구분자 추출

        String[] tokens = inputString.split(DELIMITER);
        List<Integer> numbers = convertNumbers(tokens);

        return numbers;
    }

    public List<Integer> convertNumbers(String[] tokens){
        List<Integer> numbers = new ArrayList<>();
        for(String token: tokens){
            if(isStringInteger(token)){
                Integer number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("잘못된 입력 형식 입니다.");
                }
                else numbers.add(number);
            }
            else throw new IllegalArgumentException("잘못된 입력 형식 입니다.");
        }
        return numbers;
    }

    public boolean isStringInteger(String s) { //양수인지 문자열인지 확인
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
