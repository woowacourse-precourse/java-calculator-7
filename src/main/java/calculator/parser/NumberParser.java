package calculator.parser;

import calculator.validate.Validator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    /**
     * 잘라내진 숫자 문자열을 구분자를 기준으로 정수로 변환해서 검증하고 리스트에 담아주는 메서드
     * @param numbers 잘라내진 숫자 문자열
     * @param delimiters 구분자
     * @return 숫자 리스트
     */
    public List<Integer> parseNumbers(String numbers, String delimiters){
        String[] tokens = numbers.split("[" + delimiters + "]");
        List<Integer> numberList = new ArrayList<>();

        for(String token : tokens){
            if(!token.isEmpty()){
                int number = Validator.validate(token);
                numberList.add(number);
            }
        }
        return numberList;
    }
}
