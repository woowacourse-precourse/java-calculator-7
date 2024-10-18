package calculator;

import calculator.customSeparatorExtractor.CustomSeparatorExtractor;
import calculator.numberExtractor.NumberExtractor;
import java.util.ArrayList;
import java.util.List;

/**
 * 문자열을 통해 숫자 리스트를 분리하는 역할
 */
public class StringParser {

    private final List<Character> separators = new ArrayList<>();
    private final CustomSeparatorExtractor customSeparatorExtractor;
    private final NumberExtractor numberExtractor;

    public StringParser(
            CustomSeparatorExtractor customSeparatorExtractor,
            NumberExtractor numberExtractor
    ) {
        this.customSeparatorExtractor = customSeparatorExtractor;
        this.numberExtractor = numberExtractor;
        addDefaultSeparators();
    }

    /**
     * 구분자 문자열과 숫자 문자열을 받아 문자열을 파싱하고, 그 결과인 숫자 리스트를 반환한다.
     *
     * @param customSeparatorString 구분자 문자열, //와\n가 제외된 형태로 입력된다. (예: ^&*)
     * @param numberString          숫자 문자열, 숫자와 문자의 조합으로 입력된다. (예: 1:2,53;1)
     * @return 분리된 숫자 리스트
     */
    public List<Integer> parse(String customSeparatorString, String numberString) {
        List<Character> customSeparators = customSeparatorExtractor.extract(customSeparatorString);
        separators.addAll(customSeparators);

        return numberExtractor.extract(numberString, separators);
    }

    private void addDefaultSeparators() {
        separators.add(',');
        separators.add(':');
    }
}
