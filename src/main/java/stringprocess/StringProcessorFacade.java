package stringprocess;

import constant.Constant;
import java.util.ArrayList;
import java.util.List;

public class StringProcessorFacade {
    private List<String> customSeparators;

    private final Validator validator;

    private final Splitter splitter;

    private final SeparatorExtractor separatorExtractor;

    public StringProcessorFacade() {
        customSeparators = new ArrayList<>();
        validator = new Validator(Constant.CUSTOM_SEPARATOR_PREFIX, Constant.CUSTOM_SEPARATOR_SUFFIX_APP);

        splitter = new Splitter(Constant.BASIC_SEPARATOR_REGEX, customSeparators);

        separatorExtractor = new SeparatorExtractor(Constant.CUSTOM_SEPARATOR_PREFIX, Constant.EXTRACT_REGEX_APP,
                customSeparators);
    }

    public List<String> process(String input) {
        validator.validate(input);

        //기본 구분자로 분리된 문자열 리스트
        List<String> stringListSplitByBasicSeparators = splitter.splitByBasicSeparator(input);

        //커스텀 구분자를 추출하고 분리된 양수 문자열을 담을 리스트
        List<String> stringNumbers = new ArrayList<>();

        for (String str : stringListSplitByBasicSeparators) {
            //커스텀 구분자를 추출하고 남은 문자열
            String extractedString = separatorExtractor.extractCustomSeparator(str);

            //커스텀 구분자로 쪼갠 문자열 리스트
            List<String> stringNumberPart = splitter.splitByCustomSeparator(extractedString);
            stringNumbers.addAll(stringNumberPart);
        }

        return stringNumbers;
    }
}
