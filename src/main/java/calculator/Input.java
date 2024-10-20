package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Input  {
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public void validateInput(String input) {
        // 커스텀 구분자가 있는 경우 숫자 부분만 추출
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                input = matcher.group(2); // 숫자 부분만 추출
            } else {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
        }

        // 숫자 포함 여부 검사
        if (!input.matches(".*\\d.*")) {
            throw new IllegalArgumentException("숫자가 포함되지 않았습니다.");
        }

        // 음수 검사
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다.");
        }
    }






    }
