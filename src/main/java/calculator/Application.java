package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        - for문을 돌려서 문자열의 type을 차례대로 int형으로 변환한다.
//        - 만약 에러가 뜬다면 문자열이므로 예외처리
//        - 반환된 값들을 sum에 축적해서 합을 구한다.

//        String input = "//;\n1;2;3";
//        try {
//            int number = Integer.parseInt(x);
//            System.out.println("변환된 숫자: " + number);
//        } catch (NumberFormatException e) {
//            System.out.println("숫자가 아닌 문자열입니다.");
//        }
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String numbersOnly = input.replaceAll("[^0-9]", ""); // 숫자만 남기기

        int sum = 0;
        for (int i = 0; i < numbersOnly.length(); i++) {
            int digit = Character.getNumericValue(numbersOnly.charAt(i)); // 숫자로 변환
            sum += digit;
        }

        System.out.println("결과 : " + sum); // 출력: 123456
    }
}
