package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> separators = new ArrayList<>();

        Validator validator = new Validator(Constant.CUSTOM_SEPARATOR_END_STR_APP);

        Splitter splitter = new Splitter();

        SeparatorExtractor separatorExtractor = new SeparatorExtractor(Constant.EXTRACT_REGEX_APP);

        Calculator calculator = new Calculator();

        //시작
        System.out.println(Constant.START_APP);
        String input = Console.readLine();
        Console.close();

        //문자열 유효성 검사
        validator.validate(input);

        //기본 구분자로 분리된 문자열 리스트
        List<String> stringListSplitByBasicSeparators = splitter.splitByBasicSeparator(input);

        //커스텀 구분자를 추출하고 분리된 양수 문자열을 담을 리스트
        List<String> stringNumbers = new ArrayList<>();

        for (String str : stringListSplitByBasicSeparators) {
            //커스텀 구분자를 추출하고 남은 문자열
            String extractedString = separatorExtractor.extractCustomSeparator(str, separators);

            //커스텀 구분자로 쪼갠 문자열 리스트
            List<String> stringNumberPart = splitter.splitByCustomSeparator(extractedString, separators);
            stringNumbers.addAll(stringNumberPart);
        }

        int sum = calculator.calculate(stringNumbers);

        System.out.println(Constant.RESULT + sum);
    }

}
