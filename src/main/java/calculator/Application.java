package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String positiveNumberPattern = "[0-9]+\\.?[0-9]*";
        // Process.start();
        System.out.println("덧셈할 문자열을 입력해 주세요.");    // requestInput()
        String input = Console.readLine();
        // 문자열 파싱 -> StringParser.parseBr();
        String result = input.replace("\\n", "\n");
        // 구분자 검사 -> checkDelimiter();
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(result);
        delimiterExtractor.validate(positiveNumberPattern);
        String regex = delimiterExtractor.createRegularExpression();
        // 숫자 검사  -> checkNumber(); : 구분자가 커스텀이면 문자열을 연산식으로 바꿔주는 거 -> StringParser.parseOperationFormula();
        if (DelimiterType.CUSTOM.equals(delimiterExtractor.type())) {
            result = result.split("\n")[1];
        }
        NumberExtractor numberExtractor = new NumberExtractor(result);
        numberExtractor.validate(regex);
        List<Double> numbers = numberExtractor.extract(regex);

        // calculate()
        AddCalculator.add(numbers);
        long sum = Math.round(AddCalculator.sum());

        System.out.println("결과 : " + sum);
    }
}
