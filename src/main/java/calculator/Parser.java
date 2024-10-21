package calculator;

import java.util.List;

public class Parser {

    private final Extractor extractor = new Extractor();
    private final Validator validator = new Validator();

    /**
     * 추출할 숫자들이 포함된 문자열 형식이 올바른지 판단합니다.
     *
     * @param input 사용자가 입력한 문자열
     * @return 추출한 숫자들
     */

    public List<Double> parseInput(String input) throws IllegalArgumentException {
        //커스텀 구분자 설정 영역 추출
        String optionField = extractor.extractOptionField(input);

        //커스텀 구분자 설정 영역이 있다면 검증
        if (!optionField.isEmpty() && !validator.isValidOptionField(optionField)) {
            throw new IllegalArgumentException("커스텀 구분자 설정에 대한 형식 오류가 발생하였습니다");
        }

        //커스텀 구분자 추출
        String customSeparators = "";
        if (!optionField.isEmpty()) {
            customSeparators = extractor.extractCustomSeparators(optionField);
        }

        //숫자를 추출할 영역 추출 및 검증
        String targetField = extractor.extractTargetField(input);
        if (!validator.isValidTargetField(targetField, customSeparators)) {
            throw new IllegalArgumentException("숫자를 추출하는 문자열에 대한 형식 오류가 발생하였습니다.");
        }

        // 숫자 추출
        return extractor.extractNumbersWithSeparator(customSeparators, targetField);

    }

}

