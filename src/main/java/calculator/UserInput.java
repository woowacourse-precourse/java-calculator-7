package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;

public class UserInput {

    String delimiter = "[,;]"; // 기본 구분자

    public String getInput() {

        System.out.println(
                "덧셈할 문자열을 입력해주세요. (구분자를 커스텀하려면 '//'를 입력 한 뒤, 숫자를 제외한 문자를 입력후 엔터를 누르세요.)"
        );

        String input = Console.readLine(); // 입력 받기

        // "//"으로 시작하면 커스텀구분자 입력
        if (input.startsWith("//")) {
            String customDelimiter = input.substring(2, input.indexOf("\\n"));

//            System.out.println("커스텀구분자: "+customDelimiter);

            // 커스텀 구분자는 하나의 문자로 이루어져 있어야 함
            if (customDelimiter.length() >= 2) {
                throw new IllegalArgumentException("커스텀 구분자는 하나의 문자로 입력해주세요.");
            }

            // 커스텀 구분자는 숫자가 아닌 문자여야 함.
            if (isNumeric(customDelimiter)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 문자로 입력해주세요.");
            }


            this.delimiter = "[,;" + customDelimiter + "]";

            System.out.println("덧셈할 문자열을 입력해주세요.");
            input = input.substring(input.indexOf("\\n") + 2);


        }

        return input;
    }

    public String getDelimiter() {
        return delimiter;  // 구분자 반환
    }

    private boolean isNumeric(String delimiter) {
        try {
            Double.parseDouble(delimiter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}