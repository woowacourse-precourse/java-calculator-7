package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    String userInput;
    String customPattern = "^//(.+)\\\\n";  // 줄바꿈 문자
    String commonPattern = "[,:]+";  // 쉼표와 콜론을 기본 구분자로 설정

    public Calculator(String userInput) {
        this.userInput = userInput;
    }

    // 구분자를 추출하는 함수
    public String extractDelimiter() {
        /*String[] userInputArray = userInput.split("\\\\n", 2); // \n을 기준으로 나누기
        System.out.println(Arrays.toString(userInputArray));
        String delimiter = userInputArray[0].substring(2); // userInputArray에서 //; 부분이 1, \n 뒷부분이 2
        System.out.println(delimiter);
        String regex = Pattern.quote(delimiter);
        System.out.println(userInputArray[1]);
        String[] numbers = userInputArray[1].split(regex);
*/
        // 정규식을 사용하여 //와 \n 사이의 구분자 추출

        Pattern regex = Pattern.compile(customPattern);
        Matcher matcher = regex.matcher(userInput);

        if (matcher.find()) {
            String delimiter = matcher.group(1);  // //와 \n 사이의 문자를 추출 "//(.*)\\\\n"
            return delimiter;
        }

        return null;

        //return regex;
    }

    // 구분자를 사용하여 숫자배열을 추출하는 함수
    public String[] extractNumbers(String delimiter) {
        if (delimiter != null) { //구분자를 받으면
            String[] userInputArray = userInput.split("\\\\n", 2); // \n을 기준으로 나누기
            String regex = Pattern.quote(delimiter); // 특수문자일때에도 이스케이프 처리
            String[] numbers = userInputArray[1].split(regex); // \n 뒤의 숫자 가져오기
            return numbers;

        }
        String[] numbers = userInput.split(commonPattern);
        return numbers;

    }

    public int sumStringArray(String[] arr) {
        int sum = 0;
        for (String number : arr) {
            try {
                sum += Integer.parseInt(number);  // 문자열을 정수로 변환하여 더하기
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 값 발견: " + number);
            }
        }
        return sum;
    }


}
