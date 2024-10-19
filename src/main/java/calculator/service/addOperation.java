package calculator.service;

import calculator.domain.Number;

public class addOperation {
    String input;

    public static boolean isValidFormat(String str, String delimiter) {
        // 정규 표현식 수정: 구분자 사이에 숫자가 올 수 있도록
        String regex = "(\\d+(" + delimiter + "\\d+)*)+";
        return str.matches(regex);  // 형식 확인
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) { // 빈문자열일 경우 (공백이 포함되어있을 경우)
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 쉼표와 콜론
        if (input.startsWith("//")) {
            int startIdx = input.indexOf("//");
            int endIdx = input.indexOf("\\n");

            if(startIdx + 2 == endIdx) throw new IllegalArgumentException("구분자가 정의되지 않았습니다");

            if (endIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르지 않습니다.");
            }
            delimiter = input.substring(2, endIdx);

            input = input.substring(endIdx + 2); // 구분자를 제외한 값
        }

        if(!isValidFormat(input, delimiter)) throw new IllegalArgumentException("문자열 형태가 올바르지 않습니다 (숫자 구분자 숫자)");

        String[] tokens = input.split(delimiter); // 구분자 기준으로 숫자 저장하기

        int sum = 0;
        for (String token : tokens) { // 음수처리
            Number number = new Number();
            int num = number.parseConvertInt(token);
            sum += num;
        }

        return sum;

    }

}
