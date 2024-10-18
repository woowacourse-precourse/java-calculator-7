package calculator.validator;

import calculator.validator.strategies.CustomDelimiterValidator;
import calculator.validator.strategies.DuplicateDelimiterValidator;
import calculator.validator.strategies.EmptyNumberValidator;
import calculator.validator.strategies.NegativeNumberValidator;
import calculator.validator.strategies.NumericValidator;
import calculator.validator.strategies.ValidationStrategy;
import java.util.Arrays;
import java.util.List;

public class ValidatorFactory {

    /**
     * InputValidator 객체를 생성하고 그 안에 필요한 검증 전략들을 순서대로 추가하는 팩토리 메서드 각 검증 전략은 입력값을 검증하는 역할을 하며, 순서에 따라 실행
     *
     * @return InputValidator - 검증 전략들이 포함된 InputValidator 객체
     */
    public static InputValidator createInputValidator() {
        List<ValidationStrategy> validators = Arrays.asList(

                // 1. EmptyNumberValidator : 빈 입력과 숫자가 없는 경우 검증
                new EmptyNumberValidator(),

                // 2. DuplicateDelimiterValidator: 연속된 구분자가 있는지 검증
                new DuplicateDelimiterValidator(),

                // 3. CustomDelimiterValidator: 커스텀 구분자가 올바르게 정의되었는지 검증
                new CustomDelimiterValidator(),

                // 4. NegativeNumberValidator: 음수가 포함되어 있는지 검증
                new NegativeNumberValidator(),

                // 5. NumericValidator: 숫자와 허용된 구분자만 있는지 검증
                new NumericValidator());

        return new InputValidator(validators);
    }

}