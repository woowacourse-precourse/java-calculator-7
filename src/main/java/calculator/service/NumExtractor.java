package calculator.service;

import calculator.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 사용자의 입력값에서 숫자를 추출해내는 클래스
public class NumExtractor {
    // 숫자를 판별하기 위한 정규식
    private static final String NUMBER_VALID_PATTERN = "^(-)*([0-9])*$";
    // 커스텀 구분자를 지정하는 부분을 제거하기 위한 정규식
    private static final String REMOVE_CUSTOM_DELIMITER_PATTERN = "(//)(.*)(\\\\n)(.*)";

    // 기본 구분자를 활용한 숫자 추출 메소드
    public static List<Integer> extractNumbersWithBasicDelimiters(String userInput){
        List<Integer> result = new ArrayList<>();
        String[] extractedNums = userInput.split(",|:");
        //구분자 사이에 숫자 이외에 다른 것이 들어있는지 판별
        numValid(extractedNums);

        for (String eachExtractedNum : extractedNums) {
            result.add(Integer.parseInt(eachExtractedNum));
        }

        return result;
    }

    // 커스텀 구분자를 활용한 숫자 추출 메소드
    public static List<Integer> extractNumbersWithCustomDelimiter(String userInput, String delimiter){
        List<Integer> result = new ArrayList<>();
        // 커스텀 구분자를 지정하는 부분을 제거한 나머지 사용자 입력값을 추출
        String extractedNumsWithCustomDelimiter = removeCustomDelimiter(userInput);
        //커스텀 구분자를 기준으로 숫자 추출
        String[] extractedNums = extractedNumsWithCustomDelimiter.split(delimiter);
        // 구분자 사이에 숫자가 아닌 값이 들어가 있는지 판별
        numValid(extractedNums);

        for (String eachExtractedNum : extractedNums) {
            result.add(Integer.parseInt(eachExtractedNum));
        }

        return result;
    }

    // 구분자 사이에 숫자 이외에 다른 것이 들어있거나 음수가 들어있다면 예외 발생
    public static void numValid(String[] extractedNums){
        for (String eachExtractedNum : extractedNums) {

            //구분자 사이에 숫자 이외에 다른 것이 들어있다면 예외 처리
            if(!eachExtractedNum.matches(NUMBER_VALID_PATTERN)){
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
            }

            // 사용자가 입력한 숫자가 음수인 경우 예외 처리
            if(eachExtractedNum.contains("-")){
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_POSITIVE.getMessage());
            }
        }
    }

    // 커스텀 구분자를 지정하는 부분을 제거하기 위한 메소드
    public static String removeCustomDelimiter(String userInput){
        Pattern pattern = Pattern.compile(REMOVE_CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(userInput);

        if(matcher.find()){
            return matcher.group(4);
        }
        // 커스텀 구분자로 입력받는 형식과 일차하지 않다면 예외 발생
        throw new IllegalArgumentException(ErrorMessage.IS_NOT_CUSTOM_DELIMITER_PATTERN.getMessage());
    }
}
