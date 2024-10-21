package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        DelimiterStringSplitter delimiterStringSplitter = DelimiterStringSplitter.extractDelimiterAndTargetString(readLine());
        int result = calculator.sum(delimiterStringSplitter.splitTargetStringToNumArray());
        System.out.println("결과 : " + result);

    }
}
