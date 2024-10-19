package calculator.service;

import calculator.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

// 사용자의 입력값에서 숫자를 추출해내는 클래스
public class NumExtractor {
    //숫자를 판별하기 위한 정규식
    private static final String NUMBER_VALID_PATTERN = "^[0-9]*$";
    // 기본 구분자를 활용한 숫자 추출 메소드
    public static List<Integer> extractNumbersWithBasicDelimiters(String userInput){

        List<Integer> result = new ArrayList<>();
        String[] extractedNums = userInput.split(",|:");
        //구분자 사이에 숫자 이외에 다른 것이 들어있는지 판별한다.
        numValid(extractedNums);
        // 추출한 숫자들을 리스트에 담아 반환한다.
        for (String eachExtractedNum : extractedNums) {
            result.add(Integer.parseInt(eachExtractedNum));
        }

        return result;
    }
    // 구분자 사이에 숫자 이외에 다른 것이 들어있다면 예외를 발생시킨다.
    public static void numValid(String[] extractedNums){

        for (String eachExtractedNum : extractedNums) {
            if(!eachExtractedNum.matches(NUMBER_VALID_PATTERN)){
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
            }
        }
    }
}
