package calculator;

import calculator.dto.CalculatorResultResponse;
import calculator.dto.NumberRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {

    public CalculatorResultResponse calculateSum(NumberRequest request) {
        if (!validateNumberRequest(request)) {
            throw new IllegalArgumentException("올바른 문자를 입력하세요.");
        }

        if (request.word().isBlank()) {
            return new CalculatorResultResponse(0);
        }

        String[] numbers;
        String word = request.word();

        if (word.startsWith("//")) {
            numbers = validateRegularExpression(word);
        } else {
            numbers = validateNormalRegularExpression(word);
        }

        int sum = 0;

        for (String number : numbers) {
            sum += parseAndValidateNumber(Integer.parseInt(number));
        }

        return new CalculatorResultResponse(sum);
    }

    private String[] validateRegularExpression(String word) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n(.*)$");
        Matcher matcher = pattern.matcher(word);

        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자에는 \\n 또는 숫자는 사용 불가능합니다.");
        }

        String customDelimiter = matcher.group(1);
        String numbers = matcher.group(2);

        for (int i = 0; i < customDelimiter.length(); i++) {
            if (Character.isDigit(customDelimiter.charAt(i))) {
                throw new IllegalArgumentException("커스텀 구분자에는 \\n 또는 숫자는 사용 불가능합니다.");
            }
        }

        return numbers.split(customDelimiter);
    }

    private String[] validateNormalRegularExpression(String word) {
        try {
            return word.split("[,:]");
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 구분자를 사용해 주세요.");
        }
    }

    private boolean validateNumberRequest(NumberRequest numberRequest) {
        return numberRequest != null && numberRequest.word() != null;
    }

    private int parseAndValidateNumber(int parsedNumber) {
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
        }

        return parsedNumber;
    }
}
