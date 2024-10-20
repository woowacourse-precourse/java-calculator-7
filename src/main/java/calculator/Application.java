package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {


        StringSplitter stringSplitter = new StringSplitter();
        CusTomDelimiterParser customdelimiterParser = new CusTomDelimiterParser();

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String inputString = Console.readLine();  // 사용자로부터 입력

        // 사용자 정의 구분자 추출
        String customDelimiter = customdelimiterParser.delimiter(inputString);

        // 사용자 정의 구분자가 있을 시, 사용자 정의 구분자를 포함한 문자열 분리
        if (!customDelimiter.isEmpty()) {
            String numberList[] = stringSplitter.splitWithCustomDelimiter(customDelimiter, inputString);

        }

        // 사용자 정의 구분자가 없을 시, 사용자 정의 구분자를 포함하지 않은 문자열 분리
        if (customDelimiter.isEmpty()) {

            String numberList[] = stringSplitter.splitWithDefaultDelimiter(inputString);

        }
    }

}

