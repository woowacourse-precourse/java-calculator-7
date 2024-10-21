package calculator.model;

import static calculator.model.Calculator.Mode.CUSTOM;
import static calculator.model.Calculator.Mode.DEFAULT;
import static calculator.model.enums.ParsingPattern.DEFAULT_DELIMITER_PATTERN;
import static calculator.util.Tokenizer.createCustomDelimiterToken;
import static calculator.util.Tokenizer.createNumbersToken;
import static calculator.util.Tokenizer.isExistsCustomDelimiterToken;

// 계산 기능의 전반적인 로직 수행
public class Calculator {

    // enum값을 사용하여 두 가지 모드를 저장
    enum Mode {
        DEFAULT,
        CUSTOM
    }

    private Mode mode;
//    private final Tokenizer tokenizer;

    private static final int EMPTY_RESULT = 0;

    // Calculator 생성 시 tokenizer 할당 및 mode 값 초기화
    // tokenizer -> static으로 이용해도 되지 않을까??
    public Calculator() {
//        this.tokenizer = new Tokenizer();
        this.mode = DEFAULT;
    }

    // 문자열 계산 기에서 입력 값에 대한 계산 수행
    public int calculate(String input) {
        setMode(input);

        Delimiter delimiter = selectDelimiter(input);

        NumbersToken numbersToken = createNumbersToken(input);

        if (numbersToken.isEmpty()) {
            return EMPTY_RESULT;
        }

        Numbers numbers = numbersToken.convertToNumbers(delimiter);

        return sum(numbers);
    }

    private int sum(Numbers numbers) {
        return numbers.sum();
    }

    private Delimiter selectDelimiter(String input) {
        if (mode == DEFAULT) {
            return new Delimiter(DEFAULT_DELIMITER_PATTERN.getPattern());
        }

        CustomDelimiterToken customDelimiterToken = createCustomDelimiterToken(input);
        return new Delimiter(customDelimiterToken.extractDelimiter());
    }

    private void setMode(String input) {
        if (isExistsCustomDelimiterToken(input)) {
            mode = CUSTOM;
        } else {
            mode = DEFAULT;
        }
    }
}
