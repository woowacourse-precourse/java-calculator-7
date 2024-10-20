package calculator.input;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static String inputString; //입력 문자열
    public static String DELIMITER = ",|:"; // 기본 구분자 쉼표와 콜론

    public Parser(String inputString){
        this.inputString = inputString;
    }

    public void extractCustomSeparator(){ //커스텀 구분자 추출
        while (inputString.startsWith("//") && inputString.contains("\\n")){
            String customDelimiter = inputString.substring(2, inputString.indexOf("\\n")); // "//"와 "\n" 사이의 문자가 구분자
            DELIMITER += "|" + customDelimiter; // 기본 구분자에 커스텀 구분자 추가
            inputString = inputString.substring(inputString.indexOf("\\n")+2);
        }
    }

    public List<Integer> extractNumber(){ //숫자 추출

        extractCustomSeparator(); //커스텀 구분자 추출

        if(inputString.isEmpty()) throw new IllegalArgumentException("양수와 구분자가 포함된 문자열을 입력해주세요.");

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
                    throw new IllegalArgumentException("1 이상의 양의 정수만 입력 가능합니다.");
                }
                else numbers.add(number);
            }
            else throw new IllegalArgumentException("지정되지 않은 구분자입니다.");
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
