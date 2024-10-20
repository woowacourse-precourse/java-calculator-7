package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        int result = 0;
        String customSeperator = new String();

        // 커스텀 구분자 지정 여부 확인
        if (input.startsWith("//") && input.charAt(3) == 92 && input.charAt(4) == 'n') {
            char customSeperatorChar = input.charAt(2);

            customSeperator = Character.toString(customSeperatorChar);
        }

        try {
            if (StringUtils.isBlank(customSeperator)) {
                String[] splitedInput = input.split(",|;");
                for (String inputNumber : splitedInput) {
                    int number = Integer.parseInt(inputNumber);
                    result += number;
                }
            }

            if (!StringUtils.isBlank(customSeperator)) {
                String subInput = input.substring(5);
                String[] splitedInput = subInput.split(customSeperator);
                for (String inputNumber : splitedInput) {
                    int number = Integer.parseInt(inputNumber);
                    result += number;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + result);
    }
}
