package calculator.domain;

//실제 계산 로직

/**
 * 문자열로 표현된 수식을 계산하는 계산기
 */
public class StringCalculator {

    //인풋 들어감 -> 계산함 -> Number 객체 반환함
    public Number calculate(String input) {
        //만약 들어온 Input 이 없거나 히먄 그냥 0 출력
        if (input == null || input.trim().isEmpty()) {
            return new Number(0);
        }
        //들어온거 쪼개서 문자열 리스트로 만들기
        String[] numbers = parseInput(input);
        return sum(numbers);
    }

    private String[] parseInput(String input) {
        //기본 구분자 세팅
        String delimiter = "[,:]";

        //만약 문자열의 시작이 // 이면 커스텀 구분자
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n"); // /n이 나오는 인덱스 위치
            delimiter = input.substring(2, delimiterIndex);  // // 뒤부터 /n까지 자르기
            input = input.substring(delimiterIndex + 1);
        }
        return input.split((delimiter));
    }


    private Number sum(String[] numbers) {

        // 더한 결과 초기화
        Number result = new Number(0);
        for (String numberStr : numbers) {
            // 더하려면 문자열이 number 이 되어야함
            Number number = parseNumber(numberStr);
            result = result.add(number);
        }

        return result;
    }

    private Number parseNumber(String numberStr) {
        int value = Integer.parseInt(numberStr.trim());
        if (value <= 0) {
            throw new IllegalArgumentException();

        }
        return new Number(value);
    }


}
