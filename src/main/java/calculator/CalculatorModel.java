package calculator;

import calculator.dto.CalculatorResultResponse;
import calculator.dto.NumberRequest;

public class CalculatorModel {

    public CalculatorResultResponse calculateSum(NumberRequest request) {
        if (!validateNumberRequest(request)) {
            throw new IllegalArgumentException("올바른 문자를 입력하세요.");
        }

        String word = request.word();
        String[] numbers = word.split("[,:]");

        int sum = 0;

        try {
            for (String number : numbers) {
                sum += parseAndValidateNumber(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 구분자를 입력해주세요.");
        }

        return new CalculatorResultResponse(sum);
    }

    private boolean validateNumberRequest(NumberRequest numberRequest) {
        return numberRequest != null && numberRequest.word() != null && !numberRequest.word().isBlank();
    }

    private int parseAndValidateNumber(int parsedNumber) {
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
        }

        return parsedNumber;
    }
}
