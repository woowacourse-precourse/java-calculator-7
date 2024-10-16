package calculator.service;

import calculator.model.CalculatorLogic;
import calculator.validation.InputValidator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final Pattern DANGLING_PATTERN = Pattern.compile( "[?*+()\\[\\]{}]"); //구분자 사용시 오류 발생 문자 확인 정규식
    private final CalculatorLogic calculatorLogic = new CalculatorLogic();
    private final InputValidator inputValidator = new InputValidator();

    public int calculate(String input) {
        Scanner sc = new Scanner(input);
        List<Integer> validateNumbers;
        try {
            inputValidator.inputValidate(input);
            String delimiter = calculatorLogic.extractDelimiter(sc.nextLine());
            Matcher matcher = DANGLING_PATTERN.matcher(delimiter);
            if (matcher.find()) {
                delimiter = "\\" + delimiter; //dangling 오류 발생 문자 처리
            }
            if (sc.hasNext()) {
                validateNumbers = calculatorLogic.extractNumbers(sc.nextLine(), delimiter);
            }
            else {
                validateNumbers = calculatorLogic.extractNumbers(input, delimiter);
            }
            inputValidator.numbersValidate(validateNumbers);
            return calculatorLogic.calculate(validateNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
