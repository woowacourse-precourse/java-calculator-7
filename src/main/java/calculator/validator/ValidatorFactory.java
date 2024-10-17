package calculator.validator;

import calculator.validator.strategies.CustomDelimiterValidator;
import calculator.validator.strategies.NegativeNumberValidator;
import calculator.validator.strategies.NonNumericValidator;
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
        // 검증 전략들을 리스트로 구성
        List<ValidationStrategy> validators = Arrays.asList(
                // 1. NegativeNumberValidator: 입력값에 음수가 포함되어 있는지 검증
                new NegativeNumberValidator(),

                // 2. CustomDelimiterValidator: 입력 문자열에서 커스텀 구분자가 올바르게 정의되었는지 검증
                new CustomDelimiterValidator(),

                // 3. NonNumericValidator: 입력값이 숫자와 허용된 구분자로만 이루어져 있는지 검증
                new NonNumericValidator()
        );

        // 생성된 검증 전략 리스트를 사용하여 InputValidator 객체를 반환
        return new InputValidator(validators);
    }

}