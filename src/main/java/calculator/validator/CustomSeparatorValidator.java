package calculator.validator;

import calculator.exception.ValidatorException;

import java.util.List;

import static calculator.constant.ErrorMessage.PREFIX;
import static calculator.constant.Limit.CUSTOM_SEPARATOR_LIMIT;
import static calculator.constant.Message.EMPTY;
import static calculator.constant.Message.WHITE_SPACE;

public class CustomSeparatorValidator {
    public static final String BACKTICK = "\\";
    public static final String ONE_MORE_NUMBER_REGEX = "^[0-9]+$";
    public static final String WHITE_SPACE_CANNOT_USE_AS_CUSTOM = "공백은 커스텀 구분자로 사용 불가합니다.";
    public static final String BACKTICK_CANNOT_USE_AS_CUSTOM = "'\\'는 커스텀 구분자로 사용 불가합니다.";
    public static final String NUMBER_CANNOT_USE_AS_CUSTOM = "숫자는 커스텀 구분자로 사용 불가합니다.";
    public static final String CUSTOM_CANNOT_MORE_THAN_LIMIT = "커스텀 구분자는 2개 이상일 수 없습니다.";

    public void validate(List<String> customSeparator) {
        if (customSeparator.contains(EMPTY) || customSeparator.contains(WHITE_SPACE)) {
            throw new ValidatorException(PREFIX + WHITE_SPACE_CANNOT_USE_AS_CUSTOM);
        } // end if

        if (customSeparator.contains(BACKTICK)) {
            throw new ValidatorException(PREFIX + BACKTICK_CANNOT_USE_AS_CUSTOM);
        } // end if

        if (customSeparator.stream()
                .anyMatch(separator -> separator.matches(ONE_MORE_NUMBER_REGEX))) {
            throw new ValidatorException(PREFIX + NUMBER_CANNOT_USE_AS_CUSTOM);
        } // end if

        if (customSeparator.size() > CUSTOM_SEPARATOR_LIMIT) {
            throw new ValidatorException(PREFIX + CUSTOM_CANNOT_MORE_THAN_LIMIT);
        } // end if
    } // validate
} // class