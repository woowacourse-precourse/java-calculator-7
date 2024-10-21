package calculator;

public class StringCalculator {

    public int add(String input) {

        //2. 문자열 구분
        // 빈 문자열 또는 null 입력 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 (쉼표와 콜론)
        String numbers = input;

        //커스텀 구분자가 있는 경우 처리
        if (input.startsWith("//")) {

        }

        // 구분자를 기준으로 숫자를 분리
        String[] tokens = numbers.split(delimiter);

        return 0;

    }


}
