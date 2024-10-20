package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    enum DelimiterType {
        DEFAULT, CUSTOM;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        // 사용자가 잘못된 값을 입력했을 경우, 음수를 입력하거나 문자를 입력했을 경우
        try {
            int answer = calculate(str);
            System.out.println("결과 : " + answer);
        } catch (IllegalArgumentException e) {
            // 잘못된 값을 입력하는 예외가 발생한 경우, 애플리케이션 종료시킴
            System.out.println("잘못된 입력 : " + e.getMessage());
        }
    }
    public static int calculate(String str) {

        DelimiterType strType = getType(str);

        int sum = 0;

        // 쉼표(,) 또는 콜론(:), 공백 등을 기준으로 문자열 분리
        String[] parts = str.split("[, :]+");
        String content;
        switch (strType) {
            case DEFAULT:
                break;

            case CUSTOM:
                // 커스텀 구분자를 지정해서 사용한 경우
                // 커스텀 구분자 추출 (//와 \n 사이)
                int endIndex = str.indexOf("\\n");

                // 커스텀 구분자 추출 (//와 \n 사이의 문자 추출)
                String sub = str.substring(2, endIndex);
                // 숫자 부분 추출 (커스텀 구분자 이후의 문자열)
                content = str.substring(endIndex+2);

                // 기본 구분자 기준 분리에 커스텀 구분자 추가
                parts = content.split(sub + "|[, :]");
                break;
        }

        for (String part: parts) {
            if (!part.isEmpty()) {
                try {
                    int positive_value = Integer.parseInt(part);
                    if (positive_value < 0) {
                        // 입력값이 양수가 아닌 경우의 예외 처리
                        throw new IllegalArgumentException("양수가 아닌 값이 입력되었습니다. " + positive_value);
                    }
                    sum += positive_value;
                } catch (NumberFormatException e){
                    throw new IllegalArgumentException("잘못된 값이 입력되었습니다. " + part);
                }
            }
        }
        return sum;
    }

    private static DelimiterType getType(String str) {
        if (str.startsWith("//")) {
            return DelimiterType.CUSTOM;
        } else {
            return DelimiterType.DEFAULT;
        }
    }
}
