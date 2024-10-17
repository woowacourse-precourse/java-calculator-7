package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 구분자를 정규식 형태로 추출
        DelimiterExtractor extractor = new DelimiterExtractor();
        String regex = extractor.extractDelimiterRegex(input);

        // 추출한 정규식을 이용해 문자열 분리
        StringSplitter splitter = new StringSplitter();
        List<String> splitStringList = splitter.split(input, regex);

        // 컨버터를 이용해 양수 리스트로 변환
        StringIntegerConverter converter = new StringIntegerConverter();
        List<Integer> numberList = converter.convert(splitStringList);

        // 양수 리스트의 합 계산
        int sum = numberList.stream().mapToInt(Integer::intValue).sum();

        System.out.println("결과 : " + sum);
        Console.close();
    }
}
