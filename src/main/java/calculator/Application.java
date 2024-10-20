package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int stringCalc(String str) {
        // 문자열이 비어있거나 null이면 0을 출력
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // 기본 구분자를 ",:"d으로 정함
        String separator = "[,:]";

        // 커스텀 구분자가 있는지 확인
        if (str.startsWith("//")) {
            // "//"과 "\n" 문자열이 있는지 확인
            int separatorIndex = str.indexOf("\\n");
            if (separatorIndex != -1) {
                // "//"과 "\n" 사이의 커스텀 구분자로 구분자 변경
                separator = str.substring(2,separatorIndex);
                // 커스텀 구분자 제외한 나머지 문자열 확인
                str = str.substring(separatorIndex + 2);
            }
        }

        // 설정된 구분자로 문자열 분리
        String[] numbers = str.split(separator);

        // 숫자 합계 계산
        int result = 0;
        for (String number : numbers) {
            result += validateInput(number);
        }
        return result;
    }

    private static int validateInput(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        String str = Console.readLine();

        try {
            // 덧셈 결과 출력
            int answer = stringCalc(str);
            System.out.println("결과 : " + answer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
