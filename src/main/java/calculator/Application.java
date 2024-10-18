package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        - for문을 돌려서 문자열의 type을 차례대로 int형으로 변환한다.
//        - 만약 에러가 뜬다면 문자열이므로 예외처리
//        - 반환된 값들을 sum에 축적해서 합을 구한다.
//        테스트 input : 1,2:3

//        String input = "//;\n1;2;3";
//        try {
//            int number = Integer.parseInt(x);
//            System.out.println("변환된 숫자: " + number);
//        } catch (NumberFormatException e) {
//            System.out.println("숫자가 아닌 문자열입니다.");
//        }

//        System.out.println("덧셈할 문자열을 입력해 주세요.");
//        String input = Console.readLine();
//        String numbersOnly = input.replaceAll("[^0-9]", ""); // 숫자만 남기기
//        System.out.println(numbersOnly);
//
//        int sum = 0;
//        for (int i = 0; i < numbersOnly.length(); i++) {
//            int digit = Character.getNumericValue(numbersOnly.charAt(i)); // 숫자로 변환
//            sum += digit;
//        }
//
//        System.out.println("결과 : " + sum); // 출력: 123456

//        a-1b77c-33
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            // 음수가 없으면, 숫자 추출 및 합산 로직을 수행
            // 숫자와 부호를 추출하기 위한 StringBuilder
            StringBuilder currentNumber = new StringBuilder();
            StringBuilder result = new StringBuilder();
            int sum = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                // 숫자이거나 음수 기호인 경우
                if (c == '-' && i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    throw new IllegalArgumentException("음수가 포함된 입력: " + input);
                } else if (Character.isDigit(c)) {
                    currentNumber.append(c);
                } else {
                    if (currentNumber.length() > 0) {
                        String numStr = currentNumber.toString();
                        int number = Integer.parseInt(numStr);
                        sum += number;

                        // 결과 문자열에 추가
                        if (result.length() > 0) {
                            result.append(", ");
                        }
                        result.append(numStr);

                        // StringBuilder 초기화
                        currentNumber.setLength(0);
                    }
                }
            }

            // 마지막 숫자 처리
            if (currentNumber.length() > 0) {
                String numStr = currentNumber.toString();
                int number = Integer.parseInt(numStr);
                sum += number;

                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(numStr);
            }

            System.out.println("추출된 숫자: " + result.toString()); // 출력: -1, 77, -33
            System.out.println("합계: " + sum); // 출력: 합계: 43

        } catch (IllegalArgumentException e) {
            // 예외 발생 시 메시지를 출력하고 프로그램 종료
            System.err.println(e.getMessage());
            System.exit(1); // 프로그램 강제 종료
        }
    }
}
