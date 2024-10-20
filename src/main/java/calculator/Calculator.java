package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Calculator {
    private final DelimiterExtractor delimiterExtractor;
    private final RegexGenerator regexGenerator;
    private final StringSplitter stringSplitter;
    private final StringIntegerConverter stringIntegerConverter;

    public Calculator(
            DelimiterExtractor delimiterExtractor,
            RegexGenerator regexGenerator,
            StringSplitter stringSplitter,
            StringIntegerConverter stringIntegerConverter
    ) {
        this.delimiterExtractor = delimiterExtractor;
        this.regexGenerator = regexGenerator;
        this.stringSplitter = stringSplitter;
        this.stringIntegerConverter = stringIntegerConverter;
    }

    public void sum() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 구분자를 정규식 형태로 추출
        List<String> delimiters = delimiterExtractor.extractDelimiters(input);
        String regex = regexGenerator.create(delimiters);

        // 추출한 정규식을 이용해 문자열 분리
        List<String> splitStrings = stringSplitter.split(input, regex);

        // 컨버터를 이용해 양수 리스트로 변환
        List<Integer> numbers = stringIntegerConverter.convert(splitStrings);

        // 양수 리스트의 합 계산
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.println("결과 : " + sum);
        Console.close();
    }
}
