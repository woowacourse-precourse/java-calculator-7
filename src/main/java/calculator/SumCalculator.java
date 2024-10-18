package calculator;

import java.util.List;

public class SumCalculator {
    private StringSplitter splitter;
    private StringConverter converter;
    private SeparatorManager separator;

    public SumCalculator(StringSplitter splitter, StringConverter converter, SeparatorManager separator) {
        this.splitter = splitter;
        this.converter = converter;
        this.separator = separator;
    }

    public int sum(String input){
        String processedInput = separator.addCustomSeparatorAndTrim(input);  // 커스텀 구분자 추출
        List<String> separators = separator.getSeparators();                 // 구분자 가져오기

        List<String> stringInputs = splitter.split(processedInput, separators);   // 구분자로 문자열 분리
        List<Integer> numberInputs = converter.toNumbers(stringInputs);           // 분리된 문자열 숫자로 변환

        return numberInputs.stream().mapToInt(Integer::intValue).sum();          // 숫자 합 계산
    }
}
