package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    String userInput;
    String customPattern = "^//(.+)\\\\n";  // 구분자를 추출하기 위한 패턴
    String commonDelimiter = "[,:]+";  // 쉼표와 콜론을 기본 구분자로 설정
    String customDelimiter = "";

    public Calculator(String userInput) {
        this.userInput = userInput;
    }

    // 구분자를 추출하는 함수
    public String extractDelimiter() {
        Pattern regex = Pattern.compile(customPattern);
        Matcher matcher = regex.matcher(userInput);

        if (matcher.find()) {
            customDelimiter = matcher.group(1);  // //와 \n 사이의 문자를 추출 "//(.*)\\\\n"
            return customDelimiter;
        }

        return commonDelimiter;

        //return regex;
    }

    // 구분자를 사용하여 숫자배열을 추출하는 함수
    public String[] extractNumbers(String delimiter) {
        if (delimiter.equals(customDelimiter)) { //커스텀 구분자를 받으면
            String[] userInputArray = userInput.split("\\\\n", 2); // \n을 기준으로 나누기
            String regex = Pattern.quote(delimiter); // 특수문자일때에도 이스케이프 처리
            String[] numbers = userInputArray[1].split(regex); // \n 뒤의 숫자 가져오기
            return numbers;

        }

        String[] numbers = userInput.split(commonDelimiter);

        return numbers;

    }

    public int sumStringArray(String[] arr) {
        int sum = 0;
        for (String number : arr) {
            sum += Integer.parseInt(number);  // 문자열을 정수로 변환하여 더하기

        }
        return sum;
    }


}
