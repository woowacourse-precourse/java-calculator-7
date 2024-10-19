package calculator;

import camp.nextstep.edu.missionutils.Console;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    enum DelimiterType {
        DEFAULT, CUSTOM;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

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

        for (int i=0; i<parts.length; i++) {
            sum += Integer.parseInt(parts[i]);
        }
        System.out.println("결과 : " + sum);
    }

    private static DelimiterType getType(String str) {
        if (str.startsWith("//")) {
            return DelimiterType.CUSTOM;
        } else {
            return DelimiterType.DEFAULT;
        }
    }
}
