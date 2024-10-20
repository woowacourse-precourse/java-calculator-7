package calculator.service;

public class StringCalculatorServiceImpl implements StringCalculatorService {

    @Override
    public int add(String input) {
        // 입력이 null 이거나 빈 문자열인 경우, 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 쉽표(,)와 콜론(:)을 기본 구분자로 사용하여 문자열을 분리
        String[] tokens = input.split(",|:");

        int total = 0; // 덧셈한 결과를 저장하는 변수를 초기화

        for (String token : tokens) {
            total += Integer.parseInt(token);
        }

        return total;
    }
}
