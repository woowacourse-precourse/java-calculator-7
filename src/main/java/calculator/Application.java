package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int result = 0;
        String customSeperator = new String();

        try {
            if (StringUtils.isNotBlank(input)) {
                // 커스텀 구분자 지정 여부 확인
                if (input.startsWith("//") && input.charAt(3) == 92 && input.charAt(4) == 'n') {
                    char customSeperatorChar = input.charAt(2);
                    customSeperator = Character.toString(customSeperatorChar);
                }

                // 커스텀 구분자가 없을 경우 계산 처리
                if (StringUtils.isBlank(customSeperator)) {
                    String[] splitedInput = input.split(",|:");
                    for (String inputNumber : splitedInput) {
                        int number = Integer.parseInt(inputNumber);

                        if (isNegative(number))
                            throw new IllegalArgumentException();

                        result += number;
                    }
                }

                // 커스텀 구분자가 있을 경우 계산 처리
                if (StringUtils.isNotBlank(customSeperator)) {
                    String subInput = input.substring(5);

                    // 커스텀 구분자만 입력됐을 경우 0을 출력하기 위한 조건문
                    if (StringUtils.isNotBlank(subInput)) {
                        String[] splitedInput = subInput.split(customSeperator);
                        for (String inputNumber : splitedInput) {
                            int number = Integer.parseInt(inputNumber);

                            if (isNegative(number))
                                throw new IllegalArgumentException();

                            result += number;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + result);
    }

    public static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }
}
