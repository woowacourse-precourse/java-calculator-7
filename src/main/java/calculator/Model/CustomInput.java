package calculator.Model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CustomInput extends Input {

    public CustomInput(String input){
        super(input);
    }
    @Override
    void getNumbersFromInput(String userInput){
        String[] userInputArray =splitByDelimiter(userInput);
        System.out.println(Arrays.toString(userInputArray));

        inputNumbers = Arrays.stream(userInputArray)
                .mapToDouble(this::convertToDouble)
                .toArray();

    }
    @Override
    String[] splitByDelimiter(String userInput){

        checkCustomDelim(userInput);
        String customDelimiter = extractCustomDelimiter(userInput);
        checkDelimDigits(customDelimiter);
        addDelimiter(customDelimiter);

        String delimiterPattern = String.join("|", delim.stream()
                .map(delimiter -> Pattern.quote(delimiter))
                .toArray(size -> new String[size]));

        String newString = extractValuesAfterDelimiter(userInput);
        // 결합된 패턴을 사용해 문자열을 구분자로 나눔
        return newString.split(delimiterPattern);

    }

    /**
     * 사용자 입력으로부터 구분자 추출
     * @param userInput : 사용자 입력
     */

    String extractCustomDelimiter(String userInput){
        int idx = userInput.indexOf("\\n"); // \n인덱스
        return userInput.substring(2,idx);
    }
    /**
     * 사용자 입력으로부터 \n 이후로 값 들고오기
     * @param userInput : 사용자 입력
     */
    String extractValuesAfterDelimiter(String userInput){
        int idx = userInput.indexOf("\\n"); // \n인덱스
        return userInput.substring(idx+2);
    }

    /**
     * 구분자 리스트에 추가
     * @param customDelimiter : 커스텀 구분자
     */
    void addDelimiter(String customDelimiter){
        delim.add(customDelimiter);
    }

    /***
     * 커스텀 구분자포맷이 잘 지켜졌는지
     * @param userInput : 사용자의 입력
     */
    private void checkCustomDelim(String userInput) {
        if (!userInput.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 포맷을 지켜주세요");
        }
    }

    /**
     * 커스텀 구분자 값이 숫자인지 확인
     * @param customDelimiter : 커스텀 구분자
     */
    void checkDelimDigits(String customDelimiter){
        if (customDelimiter.chars().anyMatch(Character::isDigit)) {
            throw new IllegalStateException("구분자로 숫자는 사용할 수 없습니다.");
        }
    }

}
