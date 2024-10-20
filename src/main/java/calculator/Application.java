package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {

        // 입력 받기
        String input = Console.readLine();

        // 구분자 파싱
        DelimiterParser delimiterParser = new DelimiterParser();
        delimiterParser.addDelimiters(":");
        delimiterParser.addDelimiters(",");
        delimiterParser.parse(input);

        System.out.println("indextest: "+delimiterParser.getParseIndex());

        // 숫자 추출
        NumberExtractor numberExtractor = new NumberExtractor();
        numberExtractor.extractNumbers(delimiterParser, input);
        System.out.println("numarrtest: ");

        System.out.println("numarrtest: "+numberExtractor.getNumbers().size());

        // 계산
        Calculator calculator = new Calculator();
        int result = calculator.calculateSum(numberExtractor.getNumbers());

        // 결과 출력
        System.out.println("결과 : " + result);
    }
}