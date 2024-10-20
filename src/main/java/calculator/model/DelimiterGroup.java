package calculator.model;

import static calculator.model.BasicDelimiter.BASIC_DELIMITER_COLON;
import static calculator.model.BasicDelimiter.BASIC_DELIMITER_COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterGroup {

    public static final String WHITE_SPACE = " ";

    private final List<BasicDelimiter> basicDelimiters = new ArrayList<>();

    private CustomDelimiter customDelimiters;

    public DelimiterGroup() {
        basicDelimiters.add(new BasicDelimiter(BASIC_DELIMITER_COLON));
        basicDelimiters.add(new BasicDelimiter(BASIC_DELIMITER_COMMA));
    }

    public void setCustomDelimiters(CustomDelimiter customDelimiters) {
        this.customDelimiters = customDelimiters;
        checkDuplicate();
    }

    private void checkDuplicate() {
        if (customDelimiters == null) {
            return;
        }

        basicDelimiters.forEach(basicDelimiter -> {
            if (customDelimiters.get().equals(basicDelimiter.get())) {
                throw new IllegalArgumentException();
            }
        });
    }

    public List<String> split(String input) {
        if (customDelimiters != null) {
            input = input.replace(customDelimiters.get(), WHITE_SPACE);
        }

        for (BasicDelimiter delimiter : basicDelimiters) {
            input = input.replace(delimiter.get(), WHITE_SPACE);
        }

        checkDelimiterBoundaries(input);

        return Arrays.stream(input.split(WHITE_SPACE)).toList();
    }

    private void checkDelimiterBoundaries(String input) {
        if (input.startsWith(WHITE_SPACE) || input.endsWith(WHITE_SPACE)) {
            throw new IllegalArgumentException("입력값의 시작 또는 끝에 구분자를 사용할 수 없습니다.");
        } else if (input.contains(WHITE_SPACE + WHITE_SPACE)) {
            throw new IllegalArgumentException("구분자를 연속해서 사용할 수 없습니다.");
        }
    }
}
