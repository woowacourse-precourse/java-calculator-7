package calculator.model.validator;

import static calculator.util.Constants.*;

public class DefaultValidator implements InputValidator {

    @Override
    public boolean validate(String input) {
        if (isBlank(input)) {
            return InputIsNull;
        }
        return !InputIsNull;
    }

    @Override
    public void validateNumbers(String[] splitStrings) {
        for (String str : splitStrings) {
            try {
                int num = Integer.parseInt(str);
                validateIsMinusNumber(num); // 음수 여부 검증
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 형식으로 입력해주세요!");
            }
        }
    }

    @Override
    public Object[] findCustomDelimiter(String input) {
        if (!input.startsWith(DelimiterPrefix)) return new Object[]{"", DelimiterNotExitsIntValue}; // 커스텀 구분자 존재 여부 확인

        int delimiterEndIndex = input.lastIndexOf(DelimiterSuffix); // 구분자 정의 끝나는 지점 찾기
        if (delimiterEndIndex == DelimiterNotExitsIntValue) {
            throw new IllegalArgumentException("커스텀 구분자를 올바르게 입력해주세요!"); // DelimiterSuffix가 없을 경우 예외 처리
        }
        String delimiter = input.substring(2, delimiterEndIndex); // 구분자 부분 추출

        return new Object[]{delimiter, delimiterEndIndex+DelimiterSuffix.length()}; // 구분자와 인덱스 반환
    }

    private boolean isBlank(String input){
        return input.equals("") ? true : false;
    }

    private void validateIsMinusNumber(int number){
        if(number<0){
            throw new IllegalArgumentException("음수를 입력하셨습니다.");
        }
    }
}
