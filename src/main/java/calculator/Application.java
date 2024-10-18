package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void gitmain(String[] args) {
        // TODO: 프로그램 구현
        final String DELIMITER_1 = ",";
        final String DELIMITER_2 = ":";

        int[] splitNumbers = new int[]{};

        // 문자열 입력
        // - 안내문 출력
        System.out.println("덧셈할 문자열을 입력해주세요.");
        // - 입력 받기
        String numbers = Console.readLine();
        // - 예외처리

        // 숫자 추출
        // - 구분자
        if (numbers.contains(DELIMITER_1) || numbers.contains(DELIMITER_2)) {
            System.out.println(Arrays.toString(numbers.split("DELIMITER_1|DELIMITER_2")));
        }
        // - 커스텀 구분자

        // 문자 -> 숫자 형변환

        // 계산 기능 구현

        // 결과 출력
    }
}
